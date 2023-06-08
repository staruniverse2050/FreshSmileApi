package com.Fresh.ProyectoFormativo.Controller;

import com.Fresh.ProyectoFormativo.Documents.Comentarios;
import com.Fresh.ProyectoFormativo.Documents.Especialistas;
import com.Fresh.ProyectoFormativo.Entity.Especialista;
import com.Fresh.ProyectoFormativo.Service.EspecialistaService;
import com.Fresh.ProyectoFormativo.Service.EspecialistaVCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("FreshSmile")
public class ControladorEspecialista {
    private EspecialistaService especialistaService;

    private EspecialistaVCService especialistaVCService;

    @Autowired
    public ControladorEspecialista(EspecialistaVCService especialistaVCService, EspecialistaService especialistaService) {
        this.especialistaVCService = especialistaVCService;
        this.especialistaService = especialistaService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Especialistas>> GetAllEspecialist(){
        return ResponseEntity.ok(this.especialistaVCService.getAllEspecialist());
    }

    @PostMapping("/create")
    public ResponseEntity<Especialistas> PostNewEspecialist(@RequestBody Especialistas newEspecialist){
        Especialistas createdEspecialist = this.especialistaVCService.createEspecialst(newEspecialist);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEspecialist);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Especialistas> PutChangedEspecialist(@RequestBody Especialistas changedEspecialist, @PathVariable String id){
        Especialistas updatedEspecialist = this.especialistaVCService.updateEspecialist(changedEspecialist, id);
        return ResponseEntity.status(HttpStatus.OK).body(updatedEspecialist);
    }

    @PatchMapping("/comment/{id}")
    public ResponseEntity<Especialistas> PatchCommentEspecialist(@RequestBody Comentarios newComent, @PathVariable String id){
        Especialistas commentedEspecialist = this.especialistaVCService.comentEspecialist(newComent, id);
        return ResponseEntity.status(HttpStatus.OK).body(commentedEspecialist);
    }

    @PatchMapping("/vote/{id}")
    public ResponseEntity<Especialistas> PatchVoteEspecialist(@RequestParam String vote, @PathVariable String id){
        Especialistas votedEspecialist = this.especialistaVCService.voteEspecialist(Integer.parseInt(vote), id);
        return ResponseEntity.status(HttpStatus.OK).body(votedEspecialist);
    }

    private class DeleteResult{
        public String Message;
        public DeleteResult(String message){
            this.Message = message;
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<DeleteResult> DeleteEspecialist(@PathVariable String id){
        this.especialistaVCService.deleteEspecialst(id);
        return ResponseEntity.ok(new DeleteResult("Especialista eliminado correctamente"));
    }

    //Especialista principal//
    @GetMapping("/ConsultarEspecialistas")
    public ResponseEntity<List<Especialista>> consultarEspecialista() {
        List<Especialista> especialista = especialistaService.ConsultarEspecialistas();
        return ResponseEntity.ok(especialista);
    }

    @PostMapping("/CrearEspecialista")
    public ResponseEntity<String> crearEspecialista(@RequestBody Especialista especialista) {
        String nuevoespecialista = especialistaService.CrearEspecialista(especialista);
        String mensaje = "Especialista creado exitosamente"; // Success message
        return ResponseEntity.status(HttpStatus.CREATED).body(mensaje);
    }

    @PutMapping("/ModificarEspecialista/{id}")
    public ResponseEntity<String> modificarEspecialista(@PathVariable int id, @RequestBody Especialista especialista) {
        Especialista especialistaExistente = especialistaService.BuscarEspecialista(id);
        // Update the fields of the appointment as necessary
        especialistaExistente.setEspecialidad(especialista.getEspecialidad());
        // Update other fields of the appointment as necessary
        String especialistaActualizado = especialistaService.ModificarEspecialista(especialistaExistente);
        return ResponseEntity.ok(especialistaActualizado);
    }

    @DeleteMapping("/EliminarEspecialista/{id}")
    public ResponseEntity<String> eliminarEspecialista(@PathVariable int id) {
        especialistaService.EliminarEspecialista(id);
        String mensaje = "Especialsita eliminado exitosamente"; // Success message
        return ResponseEntity.noContent().header("Message", mensaje).build();
    }
}
