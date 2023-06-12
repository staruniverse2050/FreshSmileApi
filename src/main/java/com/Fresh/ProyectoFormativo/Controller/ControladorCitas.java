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
import java.util.Optional;

@RestController
@RequestMapping("/FreshSmile")
public class ControladorCitas {
    private final CitasService citasService;

    @Autowired
    public ControladorCitas(CitasService citasService) {
        this.citasService = citasService;
    }

    @Autowired
    private CitasServiceIMPL impl;

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
        Citas citaExistente = citasService.BuscarCita(id); // Buscar la cita existente por su ID
        citaExistente.setNumero_documento(citas.getNumero_documento()); // Modificar el número de documento de la cita existente
        citaExistente.setNombre_completo(citas.getNombre_completo()); 
        citaExistente.setTipo_documento(citas.getTipo_documento());
        citaExistente.setEstado_cita(citas.getEstado_cita());
        Citas citaActualizada = citasService.ModificarCita(citaExistente); // Guardar la cita actualizada en la base de datos
        return ResponseEntity.ok(citaActualizada); // Devolver una respuesta HTTP 200 OK con la cita actualizada
    }



    @DeleteMapping("CancelarCita/{id}")
    public ResponseEntity<Map<String, Object>> desactivarCita(@PathVariable int id) {
        Citas citaDesactivada = impl.BuscarCita(id);
        citaDesactivada.setEstado(false);
        impl.ModificarCita(citaDesactivada);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Cita desactivada con éxito");
        response.put("citaDesactivada", citaDesactivada);

        return ResponseEntity.ok().body(response);
    }
}