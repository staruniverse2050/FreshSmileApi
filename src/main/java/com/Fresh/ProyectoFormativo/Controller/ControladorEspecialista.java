package com.Fresh.ProyectoFormativo.Controller;

import com.Fresh.ProyectoFormativo.Documents.Comentarios;
import com.Fresh.ProyectoFormativo.Documents.Especialistas;
import com.Fresh.ProyectoFormativo.Service.EspecialistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("FreshSmile/Especialistas")
public class ControladorEspecialista {
    private EspecialistaService especialistaService;

    @Autowired
    public ControladorEspecialista(EspecialistaService especialistaService) {
        this.especialistaService = especialistaService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Especialistas>> GetAllEspecialist(){
        return ResponseEntity.ok(this.especialistaService.getAllEspecialist());
    }

    @PostMapping("/create")
    public ResponseEntity<Especialistas> PostNewEspecialist(@RequestBody Especialistas newEspecialist){
        Especialistas createdEspecialist = this.especialistaService.createEspecialst(newEspecialist);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEspecialist);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Especialistas> PutChangedEspecialist(@RequestBody Especialistas changedEspecialist, @PathVariable String id){
        Especialistas updatedEspecialist = this.especialistaService.updateEspecialist(changedEspecialist, id);
        return ResponseEntity.status(HttpStatus.OK).body(updatedEspecialist);
    }

    @PatchMapping("/comment/{id}")
    public ResponseEntity<Especialistas> PatchCommentEspecialist(@RequestBody Comentarios newComent, @PathVariable String id){
        Especialistas commentedEspecialist = this.especialistaService.comentEspecialist(newComent, id);
        return ResponseEntity.status(HttpStatus.OK).body(commentedEspecialist);
    }

    @PatchMapping("/vote/{id}")
    public ResponseEntity<Especialistas> PatchVoteEspecialist(@RequestParam String vote, @PathVariable String id){
        Especialistas votedEspecialist = this.especialistaService.voteEspecialist(Integer.parseInt(vote), id);
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
        this.especialistaService.deleteEspecialst(id);
        return ResponseEntity.ok(new DeleteResult("Especialista eliminado correctamente"));
    }

}
