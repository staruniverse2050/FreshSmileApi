package com.Fresh.ProyectoFormativo.Controller;

import com.Fresh.ProyectoFormativo.Documents.Comentarios;
import com.Fresh.ProyectoFormativo.Documents.EspecialistaVC;
import com.Fresh.ProyectoFormativo.Entity.Especialista;
import com.Fresh.ProyectoFormativo.Models.EspecialistaModel;
import com.Fresh.ProyectoFormativo.Service.EspecialistaService;
import com.Fresh.ProyectoFormativo.Service.EspecialistaServiceIMPL.EspecialistaServiceIMPL;
import com.Fresh.ProyectoFormativo.Service.EspecialistaVCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("FreshSmile/Especialistas")
public class ControladorEspecialista {
    private EspecialistaService especialistaService;

    private EspecialistaVCService especialistaVCService;
    @Autowired
    private EspecialistaServiceIMPL impl;

    @Autowired
    public ControladorEspecialista(EspecialistaVCService especialistaVCService, EspecialistaService especialistaService) {
        this.especialistaVCService = especialistaVCService;
        this.especialistaService = especialistaService;
    }

    @GetMapping("/")
    public ResponseEntity<List<EspecialistaModel>> GetAllEspecialist(){
        List<EspecialistaVC> especialistaVCS = this.especialistaVCService.getAllEspecialist();
        List<Especialista> especialistas = this.especialistaService.ConsultarEspecialistas();
        List<EspecialistaModel> models = new ArrayList<EspecialistaModel>();
        especialistas.stream().forEach(especialista -> {
            models.add(new EspecialistaModel(especialistaVCS.stream().filter(especialistaVC -> especialistaVC.getIdentificacion_especialista() != especialista.getIdentificacion_especialista()).toList().stream().findFirst().get(), especialista));
        });
        return ResponseEntity.ok(models);
    }

    @PostMapping("/create")
    public ResponseEntity<EspecialistaModel> PostNewEspecialist(@RequestBody Especialista newEspecialist){
        String createdEspecialist = this.especialistaService.CrearEspecialista(newEspecialist);
        EspecialistaVC createdEspecialistaVC = this.especialistaVCService.createEspecialst(new EspecialistaVC(newEspecialist.getIdentificacion_especialista()));
        return ResponseEntity.status(HttpStatus.CREATED).body(new EspecialistaModel(createdEspecialistaVC, newEspecialist));
    }

    @PutMapping("/update")
    public ResponseEntity<Especialista> PutChangedEspecialist(@RequestBody Especialista changedEspecialist){
        String updatedEspecialist = this.especialistaService.ModificarEspecialista(changedEspecialist);
        return ResponseEntity.status(HttpStatus.OK).body(this.especialistaService.BuscarEspecialista(changedEspecialist.getIdentificacion_especialista()));
    }

    @PatchMapping("/comment/{id}")
    public ResponseEntity<EspecialistaVC> PatchCommentEspecialist(@RequestBody Comentarios newComent, @PathVariable String id){
        EspecialistaVC commentedEspecialist = this.especialistaVCService.comentEspecialist(newComent, id);
        return ResponseEntity.status(HttpStatus.OK).body(commentedEspecialist);
    }

    @PatchMapping("/vote/{id}")
    public ResponseEntity<EspecialistaVC> PatchVoteEspecialist(@RequestParam String vote, @PathVariable String id){
        EspecialistaVC votedEspecialist = this.especialistaVCService.voteEspecialist(Integer.parseInt(vote), id);
        return ResponseEntity.status(HttpStatus.OK).body(votedEspecialist);
    }

    private class DeleteResult {
        public String Message;

        public DeleteResult(String message) {
            this.Message = message;
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<DeleteResult> DeleteEspecialist(@PathVariable String id) {
        this.especialistaVCService.deleteEspecialst(id);
        return ResponseEntity.ok(new DeleteResult("Especialista eliminado correctamente"));
    }

    //Especialista principal//
    @GetMapping("/ConsultarEspecialista")
    public ResponseEntity<List<Especialista>> consultarEspecialista() {
        List<Especialista> especialista = especialistaService.ConsultarEspecialistas();
        return ResponseEntity.ok(especialista);
    }

    @PostMapping
    @RequestMapping(value = "/CrearEspecialista",method = RequestMethod.POST)
    public ResponseEntity<?>CrearEspecialista(@RequestBody Especialista especialista){
        Especialista EspecialistaCreado=this.impl.CrearEspecialista(especialista);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Administrador creado con éxito");
        response.put("especialistaCreado", EspecialistaCreado);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @PutMapping
    @RequestMapping(value = "/ModificarEspecialista",method = RequestMethod.PUT)
    public ResponseEntity<?>ModificarEspecialista(@RequestBody Especialista especialista){
        Especialista EspecialistaModificado=this.impl.ModificarEspecialista(especialista);
        String message = "Administrador modificado con éxito.";
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("especialista", EspecialistaModificado);
        return ResponseEntity.ok().body(response);
    }


    @GetMapping("/BuscarEspecialista/{id}")
    public ResponseEntity<?> buscarEspecialista ( @PathVariable int id){
        Especialista especialista = impl.BuscarEspecialista(id);
        return ResponseEntity.ok(especialista);
    }

    @DeleteMapping("/EliminarEspecialista/{id}")
    public ResponseEntity<String> eliminarEspecialista ( @PathVariable int id){
        especialistaService.EliminarEspecialista(id);
        String mensaje = "Especialsita eliminado exitosamente"; // Success message
        return ResponseEntity.noContent().header("Message", mensaje).build();
    }
}

