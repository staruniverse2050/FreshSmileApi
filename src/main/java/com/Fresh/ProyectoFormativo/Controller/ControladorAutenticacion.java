package com.Fresh.ProyectoFormativo.Controller;

import com.Fresh.ProyectoFormativo.Entity.Especialista;
import com.Fresh.ProyectoFormativo.Entity.Paciente;
import com.Fresh.ProyectoFormativo.Models.LoginModel;
import com.Fresh.ProyectoFormativo.Service.EspecialistaService;
import com.Fresh.ProyectoFormativo.Service.PacienteService;
import com.Fresh.ProyectoFormativo.Service.TokenService;

import jakarta.security.auth.message.AuthException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class ControladorAutenticacion {
    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private EspecialistaService especialistaService;

    private final TokenService tokenService;

    public ControladorAutenticacion(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("/paciente")
    public ResponseEntity<?> LoginPaciente(@RequestBody LoginModel user) throws UsernameNotFoundException, AuthException {
        Map<String, Object> response = new HashMap<>();
        try{
            Paciente userAuth = this.pacienteService.ConsultarPacientePorEmail(user.getEmail());
            if(userAuth == null){
                throw new UsernameNotFoundException("El usuario no existe");
            }
            else{
                if(userAuth.getContraseña().matches(user.getPassword())){
                    String token = tokenService.generateToken(userAuth.getCorreo(), userAuth.getIdentificacion_paciente());
                    response.put("token", token);
                    response.put("id", userAuth.getIdentificacion_paciente());
                    return ResponseEntity.ok(response);
                }
                else{
                    throw new AuthException("Contraseña incorrecta"); 
                }
            }
        }catch(Exception ex){
            response.put("cause", ex.getMessage());
            return ResponseEntity.status(401).body(response);
        }
    }

    @PostMapping("/especialista")
    public ResponseEntity<?> LoginEspecialista( @RequestBody LoginModel user) throws UsernameNotFoundException {
        Map<String, Object> response = new HashMap<>();
        try{
            Especialista userAuth = this.especialistaService.ConsultarEspecialistaPorEmail(user.getEmail());
            if(userAuth == null){
                throw new UsernameNotFoundException("El usuario no existe");
            }
            else{
                if(userAuth.getContraseña().matches(user.getPassword())){
                    String token = tokenService.generateToken(userAuth.getCorreo(), userAuth.getIdentificacion_especialista());
                    response.put("token", token);
                    response.put("id", userAuth.getIdentificacion_especialista());
                    return ResponseEntity.ok(response);
                }
                else{
                    throw new AuthException("Contraseña incorrecta"); 
                }
            }
        }catch(Exception ex){
            response.put("cause", ex.getMessage());
            return ResponseEntity.status(401).body(response);
        }
    }
}
