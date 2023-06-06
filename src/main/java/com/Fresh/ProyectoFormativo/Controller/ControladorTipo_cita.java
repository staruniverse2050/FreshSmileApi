package com.Fresh.ProyectoFormativo.Controller;

import com.Fresh.ProyectoFormativo.Entity.Procedimiento;
import com.Fresh.ProyectoFormativo.Service.ProcedimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/FreshSmile")
public class ControladorTipo_cita {
    private final ProcedimientoService tipoCitaService;

    @Autowired
    public  ControladorTipo_cita( ProcedimientoService tipoCitaService) {
        this.tipoCitaService = tipoCitaService;
    }

    @GetMapping("/ConsultarTipos")
    public ResponseEntity<List<Procedimiento>> consultarTipo() {
        List<Procedimiento> tipoCita = tipoCitaService.ConsultarTipo_cita();
        return ResponseEntity.ok(tipoCita);
    }

    @PostMapping("/CrearTipo")
    public ResponseEntity<String> crearTipo(@RequestBody Procedimiento tipoCita) {
        Procedimiento nuevaProcedimiento = tipoCitaService.CrearTipo_cita(tipoCita);
        String mensaje = "Tipo de cita creada exitosamente";
        return ResponseEntity.status(HttpStatus.CREATED).body(mensaje);
    }

    @PutMapping("/ModificarTipo/{id}")
    public ResponseEntity<Procedimiento> modificarTipo(@PathVariable int id, @RequestBody Procedimiento tipoCita) {
        Procedimiento tipoExistente = tipoCitaService.BuscarTipo_cita(id);
        tipoExistente.setNombre(tipoCita.getNombre());
        Procedimiento tipoActualizada = tipoCitaService.ModificarTipo_cita(tipoExistente);
        return ResponseEntity.ok(tipoActualizada);
    }

    @DeleteMapping("/EliminarTipo/{id}")
    public ResponseEntity<String> eliminarTipo(@PathVariable int id) {
        tipoCitaService.EliminarTipo_cita(id);
        String mensaje = "Tipo de cita eliminada exitosamente";
        return ResponseEntity.noContent().header("Message", mensaje).build();
    }
}
