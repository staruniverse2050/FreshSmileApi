package com.Fresh.ProyectoFormativo.Controller;

import com.Fresh.ProyectoFormativo.Entity.Citas;
import com.Fresh.ProyectoFormativo.Entity.Codigo_administrador;
import com.Fresh.ProyectoFormativo.Service.Codigo_administradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/FreshSmile")
public class ControladorCodigo_administrador {
    private final Codigo_administradorService codigoAdministradorService;

    @Autowired
    public ControladorCodigo_administrador(Codigo_administradorService codigoAdministradorService) {
        this.codigoAdministradorService = codigoAdministradorService;
    }

    @GetMapping("/ConsultarCodigo")
    public ResponseEntity<List<Codigo_administrador>> consultarCodigo() {
        List<Codigo_administrador> codigo_administrador = codigoAdministradorService.ConsultarCodigo();
        return ResponseEntity.ok(codigo_administrador);
    }
}