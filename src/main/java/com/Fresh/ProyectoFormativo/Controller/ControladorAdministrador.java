package com.Fresh.ProyectoFormativo.Controller;

import com.Fresh.ProyectoFormativo.Entity.Administrador;
import com.Fresh.ProyectoFormativo.Entity.Paciente;
import com.Fresh.ProyectoFormativo.Repository.AdministradorRepo;
import com.Fresh.ProyectoFormativo.Repository.PacienteRepo;
import com.Fresh.ProyectoFormativo.Service.AdministradorService;
import com.Fresh.ProyectoFormativo.Service.AdministradorServiceIMPL.AdministradorServiceIMPL;
import com.Fresh.ProyectoFormativo.Service.PacienteService;
import com.Fresh.ProyectoFormativo.Service.PacienteServiceIMPL.PacienteServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/FreshSmile")
public class ControladorAdministrador {

    AdministradorService administradorService = new AdministradorServiceIMPL(); // Crea una instancia de PacienteService

    @Autowired
    private AdministradorRepo administradorRepo;

    @Autowired
    private AdministradorServiceIMPL impl;

    @GetMapping("/ConsultarAdministradores")
    public ResponseEntity<List<Administrador>> consultarAdministradoresActivos() {
        List<Administrador> administradoresActivos = this.impl.ConsultarAdministrador()
                .stream()
                .filter(administrador -> "Activo".equalsIgnoreCase(administrador.getEstado()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(administradoresActivos);
    }



    @PostMapping
    @RequestMapping(value = "/CrearAdministradores",method = RequestMethod.POST)
    public ResponseEntity<?>CrearAdministradores(@RequestBody Administrador administrador){
        boolean valid = validarCredenciales(administrador.getCorreo(), administrador.getContraseña());
        if (!valid) {
            return ResponseEntity.badRequest().body("Correo o contraseña inválidos");
        }

        // Verificar si el correo y la contraseña coinciden con los datos almacenados en la base de datos
        Administrador administradorEncontrado = administradorRepo.findByCorreoAndContraseña(administrador.getCorreo(), administrador.getContraseña());
        if (administradorEncontrado == null) {
            return ResponseEntity.badRequest().body("Correo o contraseña incorrectos");
        }
        Administrador AdministradorCreado=this.impl.CrearAdministrador(administrador);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Administrador creado con éxito");
        response.put("administradorCreado", AdministradorCreado);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @PostMapping("/loginAdministrador")
    public ResponseEntity<String> iniciarSesion(@RequestParam("correo") String correo, @RequestParam("contraseña") String contraseña) {
        // Verificar si las credenciales son válidas
        boolean valid = validarCredenciales(correo, contraseña);
        if (valid) {
            // Las credenciales son válidas
            return ResponseEntity.ok("Inicio de sesión exitoso");
        } else {
            // Las credenciales son incorrectas
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Correo o contraseña incorrectos");
        }
    }


    private boolean validarCredenciales(String correo, String contraseña) {
        // Buscar el paciente por correo y contraseña en el repositorio
        Administrador administrador = administradorRepo.findByCorreoAndContraseña(correo, contraseña);
        return administrador != null;
    }


    @PutMapping
    @RequestMapping(value = "/ModificarAdministradores",method = RequestMethod.PUT)
    public ResponseEntity<?>ModificarAdministradores(@RequestBody Administrador administrador){
        Administrador AdministradorModificado=this.impl.ModificarAdministrador(administrador);
        String message = "Administrador modificado con éxito.";
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("administrador", AdministradorModificado);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/ConsultarAdministradoresOff")
    public ResponseEntity<List<Administrador>> listarAdministradoresDesactivados() {
        List<Administrador> pacientesDesactivados = impl.ConsultarAdministrador().stream()
                .filter(administrador -> administrador.getEstado().equalsIgnoreCase("Desactivo"))
                .collect(Collectors.toList());
        return ResponseEntity.ok                                                                                                                                                              (pacientesDesactivados);
    }


    @GetMapping("/BuscarAdministradores/{id}")
    public ResponseEntity<?> buscarAdministradores(@PathVariable int id) {
        Administrador administrador = impl.BuscarAdministrador(id);
        if (administrador == null) {
            return ResponseEntity.notFound().build();
        }
        if (!administrador.getEstado().equalsIgnoreCase("Activo")) {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Este administrador se encuentra innactivo");
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.ok(administrador);
    }


    @DeleteMapping("/EliminarAdministradores/{id}")
    public ResponseEntity<Map<String, Object>> desactivarAdministrador(@PathVariable int id) {
        Administrador administradorDesactivado = impl.BuscarAdministrador(id);
        administradorDesactivado.setEstado(false); // Establecer el estado del paciente como inactivo
        impl.ModificarAdministrador(administradorDesactivado); // Actualizar el registro del paciente en la base de datos

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Administrador desactivado con éxito");
        response.put("administradorDesactivado", administradorDesactivado);

        return ResponseEntity.ok().body(response);
    }
    @PutMapping("/ActivarAdministrador/{id}")
    public ResponseEntity<Map<String, Object>> activarAdministrador(@PathVariable int id) {
        Administrador administradorActivado = impl.BuscarAdministrador(id);
        administradorActivado.setEstado(true); // Establecer el estado del paciente como activo
        impl.actualizarEstadoAdministrador(administradorActivado); // Actualizar el registro del paciente en la base de datos

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Paciente activado con éxito");
        response.put("pacienteActivado", administradorActivado);

        return ResponseEntity.ok().body(response);
    }

}
