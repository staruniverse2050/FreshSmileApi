package com.Fresh.ProyectoFormativo.Controller;

import com.Fresh.ProyectoFormativo.Entity.Paciente;
import com.Fresh.ProyectoFormativo.Entity.Procedimiento;
import com.Fresh.ProyectoFormativo.Service.ProcedimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/FreshSmile")
public class ControladorProcedimientos {

        private final ProcedimientoService procedimientoService;

        @Autowired
        public  ControladorProcedimientos( ProcedimientoService procedimientoService) {
            this.procedimientoService = procedimientoService;
        }

        @GetMapping("/ConsultarProcedimientos")
        public ResponseEntity<List<Procedimiento>> consultarCitas() {
            List<Procedimiento> procedimiento = procedimientoService.ConsultarProcedimientos();
            return ResponseEntity.ok(procedimiento);
        }

    @PostMapping("/CrearProcedimientos")
    public ResponseEntity<?> crearProcedimientos(@RequestBody Procedimiento procedimiento) {
        Procedimiento procedimientoCreado = this.procedimientoService.CrearProcedimiento(procedimiento);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Paciente creado con éxito");
        response.put("pacienteCreado", procedimientoCreado);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/ModificarProcedimiento")
    public ResponseEntity<?> modificarProcedimiento(@RequestBody Procedimiento procedimiento) {
        try {
            Procedimiento procedimientoModificado = this.procedimientoService.ModificarProcedimiento(procedimiento);
            String message = "Procedimiento modificado exitosamente.";
            Map<String, Object> response = new HashMap<>();
            response.put("message", message);
            response.put("procedimiento", procedimientoModificado);
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }



    @DeleteMapping("/EliminarProcedimiento/{id}")
        public ResponseEntity<String> eliminarProcedimiento(@PathVariable int id) {
            procedimientoService.EliminarProcedimiento(id);
            String mensaje = "Procedimiento eliminado exitosamente";
            return ResponseEntity.noContent().header("Message", mensaje).build();
        }
    }

