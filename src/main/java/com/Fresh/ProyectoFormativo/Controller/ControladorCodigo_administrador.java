package com.Fresh.ProyectoFormativo.Controller;

import com.Fresh.ProyectoFormativo.Entity.Agenda;
import com.Fresh.ProyectoFormativo.Entity.Codigo_administrador;
import com.Fresh.ProyectoFormativo.Service.AgendaService;
import com.Fresh.ProyectoFormativo.Service.Codigo_administradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/FreshSmile")
public class ControladorCodigo_administrador {
    private final Codigo_administradorService codigoService;

    @Autowired
    public ControladorCodigo_administrador(Codigo_administradorService codigoService) {
        this.codigoService = codigoService;
    }

    @GetMapping("/ConsultarCodigo")
    public ResponseEntity<List<Codigo_administrador>> ConsultarCodigo() {
        List<Codigo_administrador> codigoAdministradors = codigoService.ConsultarCodigo();
        return ResponseEntity.ok(codigoAdministradors);
    }

    @PutMapping("/ModificarCodigo/{id}")
    public ResponseEntity<Codigo_administrador> ModificarCodigo(@PathVariable int id, @RequestBody Codigo_administrador codigo_administrador) {
        Codigo_administrador codigoExistente = codigoService.BuscarCodigo(id);
        // Update the fields of the appointment as necessary
        codigoExistente.setCodigo(Codigo_administrador.getCodigo());
        // Update other fields of the appointment as necessary
        Codigo_administrador codigoActualizado = codigoService.ModificarCodigo(codigoExistente);
        return ResponseEntity.ok(codigoActualizado);
    }

}