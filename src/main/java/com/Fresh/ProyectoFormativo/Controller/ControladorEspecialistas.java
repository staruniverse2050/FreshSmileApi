package com.Fresh.ProyectoFormativo.Controller;

import com.Fresh.ProyectoFormativo.Entity.Especialista;
import com.Fresh.ProyectoFormativo.Service.EspecialistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("FreshSmile")
public class ControladorEspecialistas {
    private EspecialistaService especialistaService;
    @Autowired
    public ControladorEspecialistas(EspecialistaService especialistaService) {
        this.especialistaService = especialistaService;
    }

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
