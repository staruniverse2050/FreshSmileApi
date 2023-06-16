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

    @PostMapping("/CrearProcedimiento")
    public ResponseEntity<String> crearProcedimiento(@RequestBody Procedimiento procedimiento) {
        Procedimiento nuevoProcedimiento = procedimientoService.CrearProcedimiento(procedimiento);
        String mensaje = "Procedimiento creado exitosamente. ID: " + nuevoProcedimiento.getIdentificacion_procedimientos();
        return ResponseEntity.status(HttpStatus.CREATED).body(mensaje);
    }


    @PutMapping
    @RequestMapping(value = "/ModificarProcedimiento",method = RequestMethod.PUT)
    public ResponseEntity<?>ModificarProcedimiento(@RequestBody Procedimiento procedimiento){
        Procedimiento ProcedimientoModificado=this.procedimientoService.ModificarProcedimiento(procedimiento);
        String message = "Procedimiento modificado con éxito.";
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("procedimiento", ProcedimientoModificado);
        return ResponseEntity.ok().body(response);
    }



    @DeleteMapping("/EliminarProcedimiento/{id}")
    public ResponseEntity<String> eliminarProcedimiento(@PathVariable int id) {
        procedimientoService.EliminarProcedimiento(id);
        String mensaje = "Procedimiento con ID " + id + " eliminado exitosamente";
        return ResponseEntity.noContent().header("Message", mensaje).build();
    }

}

