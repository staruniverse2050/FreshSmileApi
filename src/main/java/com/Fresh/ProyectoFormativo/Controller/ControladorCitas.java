package com.Fresh.ProyectoFormativo.Controller;

import com.Fresh.ProyectoFormativo.Entity.Citas;
import com.Fresh.ProyectoFormativo.Service.CitasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("FreshSmile")
public class ControladorCitas {
    private final CitasService citasService;

    @Autowired
    public ControladorCitas(CitasService citasService) {
        this.citasService = citasService;
    }

    @GetMapping("/ConsultarCitas")
    public ResponseEntity<List<Citas>> consultarCitas() {
        List<Citas> citas = citasService.ConsultarCitas();
        return ResponseEntity.ok(citas);
    }

    @PostMapping("/CrearCita")
    public ResponseEntity<String> crearCita(@RequestBody Citas citas) {
        Citas nuevaCita = citasService.CrearCita(citas);
        String mensaje = "Cita creada exitosamente"; // Success message
        return ResponseEntity.status(HttpStatus.CREATED).body(mensaje);
    }

    @PutMapping("/ModificarCita/{id}")
    public ResponseEntity<Citas> modificarCita(@PathVariable int id, @RequestBody Citas citas) {
        Citas citaExistente = citasService.BuscarCita(id);
        // Update the fields of the appointment as necessary
        citaExistente.setFecha_cita(citas.getFecha_cita());
        citaExistente.setHora_cita(citas.getHora_cita());
        // Update other fields of the appointment as necessary
        Citas citaActualizada = citasService.ModificarCita(citaExistente);
        return ResponseEntity.ok(citaActualizada);
    }

    @DeleteMapping("/EliminarCita/{id}")
    public ResponseEntity<String> eliminarCita(@PathVariable int id) {
        citasService.CancelarCita(id);
        String mensaje = "Cita eliminada exitosamente"; // Success message
        return ResponseEntity.noContent().header("Message", mensaje).build();
    }
}