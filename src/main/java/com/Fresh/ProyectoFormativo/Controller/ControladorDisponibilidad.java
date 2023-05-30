package com.Fresh.ProyectoFormativo.Controller;

import com.Fresh.ProyectoFormativo.Entity.Disponibilidad;
import com.Fresh.ProyectoFormativo.Service.DisponibilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/FreshSmile")
public class ControladorDisponibilidad {
    private final DisponibilidadService disponibilidadService;

    @Autowired
    public ControladorDisponibilidad(DisponibilidadService disponibilidadService) {
        this.disponibilidadService = disponibilidadService;
    }

    @GetMapping("/ConsultarDisponibilidades")
    public ResponseEntity<List<Disponibilidad>> consultarDisponibilidades() {
        List<Disponibilidad> disponibilidad = disponibilidadService.ConsultarDisponibilidades();
        return ResponseEntity.ok(disponibilidad);
    }

    @PostMapping("/CrearDisponibilidad")
    public ResponseEntity<String> crearDisponibilidad(@RequestBody Disponibilidad disponibilidad) {
        Disponibilidad nuevaDisponibilidad = disponibilidadService.CrearDisponibilidad(disponibilidad);
        String mensaje = "Disponibilidad creada exitosamente";
        return ResponseEntity.status(HttpStatus.CREATED).body(mensaje);
    }

    @PutMapping("/ModificarDisponibilidad/{id}")
    public ResponseEntity<Disponibilidad> modificarDisponibilidad(@PathVariable int id, @RequestBody Disponibilidad disponibilidad) {
        Disponibilidad disponibilidadExistente = disponibilidadService.BuscarDisponibilidad(id);
        // Actualizar los campos de la disponibilidad según sea necesario
        disponibilidadExistente.setHoras_disponibles(disponibilidad.getHoras_disponibles());
        // Actualizar otros campos de la disponibilidad según sea necesario
        Disponibilidad disponibilidadActualizada = disponibilidadService.ModificarDisponibilidad(disponibilidadExistente);
        return ResponseEntity.ok(disponibilidadActualizada);
    }

    @DeleteMapping("/EliminarDisponibilidad/{id}")
    public ResponseEntity<String> eliminarDisponibilidad(@PathVariable int id) {
        disponibilidadService.EliminarDisponibilidad(id);
        String mensaje = "Disponibilidad eliminada exitosamente";
        return ResponseEntity.noContent().header("Message", mensaje).build();
    }
}
