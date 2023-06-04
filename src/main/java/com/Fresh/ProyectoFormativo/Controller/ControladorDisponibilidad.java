package com.Fresh.ProyectoFormativo.Controller;

import com.Fresh.ProyectoFormativo.Entity.Disponibilidad;
import com.Fresh.ProyectoFormativo.Entity.Tipo_cita;
import com.Fresh.ProyectoFormativo.Service.DisponibilidadService;
import com.Fresh.ProyectoFormativo.Service.Tipo_citaService;
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
    public  ControladorDisponibilidad (DisponibilidadService disponibilidadService) {
        this.disponibilidadService = disponibilidadService;
    }
    @GetMapping("/Consultardisponibilidades")
    public ResponseEntity<List<Disponibilidad>> consultardisponibilidades() {
        List<Disponibilidad> disponibilidades = disponibilidadService.ConsultarDisponibilidades();
        return ResponseEntity.ok(disponibilidades);
    }

    @PostMapping("/CrearDisponibilidad")
    public ResponseEntity<String> crearDisponibilidad(@RequestBody Disponibilidad disponibilidad) {
        Disponibilidad nuevaDisponibilidad = disponibilidadService.CrearDisponibilidad(disponibilidad);
        String mensaje = "Disponibilidad creada exitosamente";
        return ResponseEntity.status(HttpStatus.CREATED).body(mensaje);
    }

    @PutMapping("/ModificarDisponibilidad/{id}")
    public ResponseEntity<Disponibilidad> modificarDisponbilidad(@PathVariable int id, @RequestBody Disponibilidad disponibilidad) {
        Disponibilidad disponibilidadExistente = disponibilidadService.BuscarDisponibilidad(id);
        disponibilidadExistente.setHoras_disponibles(disponibilidad.getHoras_disponibles());
        Disponibilidad disponibilidadActualizada = disponibilidadService.ModificarDisponibilidad(disponibilidadExistente);
        return ResponseEntity.ok(disponibilidadActualizada);
    }

    @DeleteMapping("/EliminarDisponbilidad/{id}")
    public ResponseEntity<String> eliminarDisponibilidad(@PathVariable int id) {
        disponibilidadService.EliminarDisponibilidad(id);
        String mensaje = "Disponibilidad eliminada exitosamente";
        return ResponseEntity.noContent().header("Message", mensaje).build();
    }
}
