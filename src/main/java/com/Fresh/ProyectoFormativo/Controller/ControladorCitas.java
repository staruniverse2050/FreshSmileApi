package com.Fresh.ProyectoFormativo.Controller;

import com.Fresh.ProyectoFormativo.Entity.Citas;
import com.Fresh.ProyectoFormativo.Entity.Paciente;
import com.Fresh.ProyectoFormativo.Entity.Procedimiento;
import com.Fresh.ProyectoFormativo.Service.CitasService;
import com.Fresh.ProyectoFormativo.Service.CitasServiceIMPL.CitasServiceIMPL;
import com.Fresh.ProyectoFormativo.Service.PacienteServiceIMPL.PacienteServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/FreshSmile")
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

    @PutMapping("/ModificarCita")
    public ResponseEntity<?> modificarCitas(@RequestBody Citas citas) {
        Citas citaModificada = citasService.ModificarCita(citas);
        String message = "Cita modificada con éxito.";
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("cita", citaModificada);
        return ResponseEntity.ok().body(response);
    }




    @DeleteMapping("CancelarCita/{id}")
    public ResponseEntity<Map<String, Object>> desactivarCita(@PathVariable int id) {
        Citas citaDesactivada = citasService.BuscarCita(id);
        citaDesactivada.setEstado(false);
        citasService.ModificarCita(citaDesactivada);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Cita desactivada con éxito");
        response.put("citaDesactivada", citaDesactivada);

        return ResponseEntity.ok().body(response);
    }
}