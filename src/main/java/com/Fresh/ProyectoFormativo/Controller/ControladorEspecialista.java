package com.Fresh.ProyectoFormativo.Controller;

import com.Fresh.ProyectoFormativo.Documents.Comentarios;
import com.Fresh.ProyectoFormativo.Documents.EspecialistaVC;
import com.Fresh.ProyectoFormativo.Documents.Voto;
import com.Fresh.ProyectoFormativo.Entity.Especialista;
import com.Fresh.ProyectoFormativo.Entity.Paciente;
import com.Fresh.ProyectoFormativo.Models.ReqCommentModel;
import com.Fresh.ProyectoFormativo.Service.EspecialistaService;
import com.Fresh.ProyectoFormativo.Service.EspecialistaServiceIMPL.EspecialistaServiceIMPL;
import com.Fresh.ProyectoFormativo.utils.JWTUtils;

import io.jsonwebtoken.Claims;

import com.Fresh.ProyectoFormativo.Service.EspecialistaVCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("FreshSmile/Especialistas")
public class ControladorEspecialista {
    private EspecialistaService especialistaService;

    private EspecialistaVCService especialistaVCService;

    private JWTUtils jwtUtils = new JWTUtils();

    @Autowired
    public ControladorEspecialista(EspecialistaVCService especialistaVCService, EspecialistaService especialistaService) {
        this.especialistaVCService = especialistaVCService;
        this.especialistaService = especialistaService;
    }

    @PostMapping("/crearRating/{id}")
    public ResponseEntity<?> CrearRatingEspecialista(@PathVariable String id){
        Map<String, Object> response = new HashMap<>();
        try{
            EspecialistaVC creado = this.especialistaVCService.createEspecialst(new EspecialistaVC(Integer.parseInt(id)));
            response.put("message", "Creado correctamente");
            response.put("error", false);
            response.put("creado", creado);
            return ResponseEntity.ok(response);
        }
        catch(Exception err){
            response.put("error", true);
            response.put("message", err.getMessage());
            return ResponseEntity.internalServerError().body(response);
        }
    }

    //Especialista principal//
    @GetMapping("/ConsultarEspecialista")
    public ResponseEntity<List<Especialista>> consultarEspecialista() {
        List<Especialista> especialista = especialistaService.ConsultarEspecialistas();
        return ResponseEntity.ok(especialista);
    }

    @GetMapping("/ConsultarRating")
    public ResponseEntity<?> GetRatingEspecialists(){
        List<EspecialistaVC> especialistaVCs = especialistaVCService.getAllEspecialist();
        return ResponseEntity.ok(especialistaVCs);
    }

    @PatchMapping("/comentar/{especialistId}")
    public ResponseEntity<?> CommentEspecialist(@RequestBody Comentarios newComment, @PathVariable String especialistId){
        Map<String, Object> response = new HashMap<>();
        try{
            Claims claims = jwtUtils.getTokenClaims(((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization").replace("Bearer ", ""));
            newComment.setUserId(claims.get("userId").toString());
            EspecialistaVC commentedEspecialistaVC = this.especialistaVCService.comentEspecialist(newComment, especialistId);
            return ResponseEntity.ok(commentedEspecialistaVC);
        }
        catch(Exception ex){
            response.put("cause",ex.getCause());
            response.put("message", ex.getMessage());
            return ResponseEntity.internalServerError().body(response);
        }
    }

    @PatchMapping("/añadirVoto/{especialistId}")
    public ResponseEntity<?> VoteEspecialist(@PathVariable String especialistId, @RequestParam String vote){
        Map<String, Object> response = new HashMap<>();
        try{
            int Vote = Integer.parseInt(vote);
            Claims claims = jwtUtils.getTokenClaims(((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization").replace("Bearer ", ""));
            Voto newVote = new Voto(Vote, claims.get("userId").toString());
            EspecialistaVC vottedEspecialistaVC = this.especialistaVCService.voteEspecialist(newVote, especialistId);
            return ResponseEntity.ok(vottedEspecialistaVC);
        }
        catch(Exception ex){
            response.put("cause",ex.getCause());
            response.put("message", ex.getMessage());
            return ResponseEntity.internalServerError().body(response);
        }
    }

    @PostMapping("/CrearEspecialista")
    public ResponseEntity<?> crearEspecialista(@RequestBody Especialista especialista) {
        Especialista especialistaCreado = this.especialistaService.CrearEspecialista(especialista);
        EspecialistaVC createdEspecialistaVC = this.especialistaVCService.createEspecialst(new EspecialistaVC(especialistaCreado.getIdentificacion_especialista()));

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Especialista creado con éxito");

        Map<String, Object> data = new HashMap<>();
        data.put("especialista", especialistaCreado);
        data.put("rating", createdEspecialistaVC);

        response.put("especialistaCreado", data);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping
    @RequestMapping(value = "/ModificarEspecialista",method = RequestMethod.PUT)
    public ResponseEntity<?>ModificarEspecialista(@RequestBody Especialista especialista){
        Especialista EspecialistaModificado=this.especialistaService.ModificarEspecialista(especialista);
        String message = "Administrador modificado con éxito.";
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("especialista", EspecialistaModificado);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/ConsultarEspecialistasOff")
    public ResponseEntity<List<Especialista>> listarEspecialistaDesactivados() {
        List<Especialista> especialistasDesactivados = especialistaService.ConsultarEspecialistas().stream()
                .filter(especialista -> especialista.getEstado().equalsIgnoreCase("Desactivo"))
                .collect(Collectors.toList());
        return ResponseEntity.ok(especialistasDesactivados);
    }


    @GetMapping("/BuscarEspecialista/{id}")
    public ResponseEntity<?> buscarEspecialista(@PathVariable int id) {
        Especialista especialista = especialistaService.BuscarEspecialista(id);
        if (especialista == null) {
            return ResponseEntity.notFound().build();
        }
        if (!especialista.getEstado().equalsIgnoreCase("Activo")) {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Este especialista se encuentra innactivo");
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.ok(especialista);
    }


    @DeleteMapping("/EliminarEspecialista/{id}")
    public ResponseEntity<Map<String, Object>> desactivarEspecialista(@PathVariable int id) {
        Especialista especialistaDesactivado = especialistaService.BuscarEspecialista(id);
        especialistaDesactivado.setEstado(false); // Establecer el estado del paciente como inactivo
        especialistaService.ModificarEspecialista(especialistaDesactivado); // Actualizar el registro del paciente en la base de datos

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Paciente desactivado con éxito");
        response.put("pacienteDesactivado", especialistaDesactivado);

        return ResponseEntity.ok().body(response);
    }
    @PutMapping("/ActivarEspecialista/{id}")
    public ResponseEntity<Map<String, Object>> activarEspecialista(@PathVariable int id) {
        Especialista especialistaActivado = especialistaService.BuscarEspecialista(id);
        especialistaActivado.setEstado(true); // Establecer el estado del paciente como activo
        especialistaService.actualizarEstadoEspecialista(especialistaActivado); // Actualizar el registro del paciente en la base de datos

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Especialista activado con éxito");
        response.put("especialistaActivado", especialistaActivado);

        return ResponseEntity.ok().body(response);
    }

}

