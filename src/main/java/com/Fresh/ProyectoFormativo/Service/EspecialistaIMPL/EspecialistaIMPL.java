package com.Fresh.ProyectoFormativo.Service.EspecialistaIMPL;

import com.Fresh.ProyectoFormativo.Documents.Comentarios;
import com.Fresh.ProyectoFormativo.Documents.Especialistas;
import com.Fresh.ProyectoFormativo.Repository.EspecialistaRepo;
import com.Fresh.ProyectoFormativo.Service.EspecialistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialistaIMPL implements EspecialistaService {
    private EspecialistaRepo repo;

    @Autowired
    public EspecialistaIMPL(EspecialistaRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<Especialistas> getAllEspecialist() {
        return this.repo.findAll();
    }

    @Override
    public Especialistas createEspecialst(Especialistas newEspecialist) {
        return this.repo.save(newEspecialist);
    }

    @Override
    public Especialistas updateEspecialist(Especialistas newEspecialist, String id) {
        Especialistas oldEspecialist = this.repo.findById(id).get();
        oldEspecialist.setAños_Experiencia(newEspecialist.getAños_Experiencia());
        oldEspecialist.setCorreo(newEspecialist.getCorreo());
        oldEspecialist.setNombre(newEspecialist.getNombre());
        oldEspecialist.setEdad(newEspecialist.getEdad());
        oldEspecialist.setTelefono(newEspecialist.getTelefono());
        oldEspecialist.setEspecialidad(newEspecialist.getEspecialidad());
        return this.repo.save(oldEspecialist);
    }

    @Override
    public void deleteEspecialst(String id) {
        this.repo.deleteById(id);
    }

    @Override
    public Especialistas comentEspecialist(Comentarios newComent, String id) {
        Especialistas oldEspecialist = this.repo.findById(id).get();
        List<Comentarios> oldComents = oldEspecialist.getComentarios();
        oldComents.add(newComent);
        oldEspecialist.setComentarios(oldComents);
        return this.repo.save(oldEspecialist);
    }

    @Override
    public Especialistas voteEspecialist(Number vote, String id) {
        Especialistas especialistasForVote = this.repo.findById(id).get();
        List<Number> actualVotes = especialistasForVote.getRegistroVotaciones();
        actualVotes.add(vote);
        var voteWrapper = new Object(){ Number voteCount = 0; };
        actualVotes.forEach(singleVote -> voteWrapper.voteCount = (int)singleVote + (int)voteWrapper.voteCount );
        voteWrapper.voteCount = (int)voteWrapper.voteCount / actualVotes.size();
        especialistasForVote.setRegistroVotaciones(actualVotes);
        especialistasForVote.setValoracion(voteWrapper.voteCount.doubleValue());
        return this.repo.save(especialistasForVote);
    }
}
