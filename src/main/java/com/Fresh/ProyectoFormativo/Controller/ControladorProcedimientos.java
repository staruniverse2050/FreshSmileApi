package com.Fresh.ProyectoFormativo.Controller;

import com.Fresh.ProyectoFormativo.Entity.Procedimiento;
import com.Fresh.ProyectoFormativo.Service.ProcedimientoService;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/FreshSmile")
public class ControladorProcedimientos {

        private final ProcedimientoService procedimientoService;

        @Autowired
        public  ControladorProcedimientos( ProcedimientoService procedimientoService) {
            this.procedimientoService = procedimientoService;
        }

        @GetMapping("/ConsultarProcedimientos")
        public ResponseEntity<List<Procedimiento>> consultarTipo() {
            List<Procedimiento> procedimiento = procedimientoService.ConsultarProcedimientos();
            return ResponseEntity.ok(procedimiento);
        }

        @PostMapping("/CrearProcedimiento")
        public ResponseEntity<String> crearProcedimiento(@RequestBody Procedimiento procedimiento) {
            Procedimiento nuevoProcedimiento = procedimientoService.CrearProcedimiento(procedimiento);
            String mensaje = "Procedimietno creado exitosamente";
            return ResponseEntity.status(HttpStatus.CREATED).body(mensaje);
        }
    public Procedimiento BuscarProcedimientoPorNombre(String nombre) {
        // Implementa aquí la lógica para buscar el procedimiento por nombre en tu base de datos utilizando JPA y consultas SQL

        String sqlQuery = "SELECT p FROM Procedimiento p WHERE p.nombre = :nombre";
        Session entityManager = null;
        TypedQuery<Procedimiento> query = entityManager.createQuery(sqlQuery, Procedimiento.class);
        query.setParameter("nombre", nombre);

        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null; // Si no se encuentra el procedimiento con el nombre dado
        }
    }


    @PutMapping("/ModificarProcedimiento")
    public ResponseEntity<Procedimiento> modificarProcedimiento(@RequestBody Procedimiento procedimiento) {
        String nombreProcedimiento = procedimiento.getNombre();

        Procedimiento procedimientoExistente = procedimientoService.BuscarProcedimientoPorNombre(nombreProcedimiento);

        if (procedimientoExistente == null) {
            return ResponseEntity.notFound().build();
        }

        // Actualizar los campos del procedimiento según sea necesario
        procedimientoExistente.setNombre(procedimiento.getNombre());
        // Actualizar otros campos del procedimiento según sea necesario

        Procedimiento procedimientoActualizado = procedimientoService.ModificarProcedimiento(procedimientoExistente);
        return ResponseEntity.ok(procedimientoActualizado);
    }


    @DeleteMapping("/EliminarProcedimiento/{id}")
        public ResponseEntity<String> eliminarProcedimiento(@PathVariable int id) {
            procedimientoService.EliminarProcedimiento(id);
            String mensaje = "Procedimiento eliminado exitosamente";
            return ResponseEntity.noContent().header("Message", mensaje).build();
        }
    }

