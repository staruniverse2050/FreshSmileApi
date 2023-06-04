package com.Fresh.ProyectoFormativo.Controller;

import com.Fresh.ProyectoFormativo.Entity.Tipo_cita;
import com.Fresh.ProyectoFormativo.Service.Tipo_citaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/FreshSmile")
public class ControladorTipo_cita {
    private final Tipo_citaService tipoCitaService;

    @Autowired
    public  ControladorTipo_cita( Tipo_citaService tipoCitaService) {
        this.tipoCitaService = tipoCitaService;
    }

    @GetMapping("/ConsultarTipos")
    public ResponseEntity<List<Tipo_cita>> consultarTipo() {
        List<Tipo_cita> tipoCita = tipoCitaService.ConsultarTipo_cita();
        return ResponseEntity.ok(tipoCita);
    }

    @PostMapping("/CrearTipo")
    public ResponseEntity<String> crearTipo(@RequestBody Tipo_cita tipoCita) {
        Tipo_cita nuevaTipo_cita = tipoCitaService.CrearTipo_cita(tipoCita);
        String mensaje = "Tipo de cita creada exitosamente";
        return ResponseEntity.status(HttpStatus.CREATED).body(mensaje);
    }

    @PutMapping("/ModificarTipo/{id}")
    public ResponseEntity<Tipo_cita> modificarTipo(@PathVariable int id, @RequestBody Tipo_cita tipoCita) {
        Tipo_cita tipoExistente = tipoCitaService.BuscarTipo_cita(id);
        tipoExistente.setNombre(tipoCita.getNombre());
        Tipo_cita tipoActualizada = tipoCitaService.ModificarTipo_cita(tipoExistente);
        return ResponseEntity.ok(tipoActualizada);
    }

    @DeleteMapping("/EliminarTipo/{id}")
    public ResponseEntity<String> eliminarTipo(@PathVariable int id) {
        tipoCitaService.EliminarTipo_cita(id);
        String mensaje = "Tipo de cita eliminada exitosamente";
        return ResponseEntity.noContent().header("Message", mensaje).build();
    }
}
