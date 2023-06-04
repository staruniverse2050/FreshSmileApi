package com.Fresh.ProyectoFormativo.Controller;

import com.Fresh.ProyectoFormativo.Entity.Agenda;
import com.Fresh.ProyectoFormativo.Service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/FreshSmile")
public class ControladorAgenda {
    private final AgendaService agendaService;

    @Autowired
    public ControladorAgenda(AgendaService agendaService) {
        this.agendaService = agendaService;
    }

    @GetMapping("/ConsultarAgenda")
    public ResponseEntity<List<Agenda>> consultarAgendas() {
        List<Agenda> agenda = agendaService.ConsultarAgendas();
        return ResponseEntity.ok(agenda);
    }

    @PostMapping("/CrearAgenda")
    public ResponseEntity<String> crearAgenda(@RequestBody Agenda agenda) {
        Agenda nuevaAgenda = agendaService.CrearAgenda(agenda);
        String mensaje = "Agenda creada exitosamente"; // Success message
        return ResponseEntity.status(HttpStatus.CREATED).body(mensaje);
    }

    @PutMapping("/ModificarAgenda/{id}")
    public ResponseEntity<Agenda> ModificarAgenda(@PathVariable int id, @RequestBody Agenda agenda) {
        Agenda agendaExistente = agendaService.BuscarAgenda(id);
        // Update the fields of the appointment as necessary
        agendaExistente.setNumero_documento(agenda.getNumero_documento());
        // Update other fields of the appointment as necessary
        Agenda agendaActualizada = agendaService.ModificarAgenda(agendaExistente);
        return ResponseEntity.ok(agendaActualizada);
    }

    @DeleteMapping("/EliminarAgenda/{id}")
    public ResponseEntity<String> EliminarAgenda(@PathVariable int id) {
        agendaService.EliminarAgenda(id);
        String mensaje = "Agenda eliminada exitosamente"; // Success message
        return ResponseEntity.noContent().header("Message", mensaje).build();
    }
}
