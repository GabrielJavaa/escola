package com.hbsis.sistemaescolar.materia;

import com.hbsis.sistemaescolar.nota.Nota;
import com.hbsis.sistemaescolar.nota.NotaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MateriaService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MateriaService.class);

    private final MateriaRepository materiaRepository;
    private final NotaService notaService;

    public MateriaService(MateriaRepository materiaRepository, NotaService notaService) {
        this.materiaRepository = materiaRepository;
        this.notaService = notaService;
    }

    public MateriaDTO save(MateriaDTO salvaMateria){

        Nota nota = this.notaService.findById(salvaMateria.getIdNota());

        LOGGER.info("Cadastrando Materia...");
        LOGGER.debug("Materia: {}",salvaMateria);

        Materia materia = new Materia();
        materia.setIdmateria(salvaMateria.getIdMateria());
        materia.setNomeMateria(salvaMateria.getNomeMateria());
        materia.setIdNota(nota);
        materia = this.materiaRepository.save(materia);
        return MateriaDTO.of(materia);
    }
    public Materia findById(Long idMateria){
        Optional<Materia> materiaOptional = this.materiaRepository.findById(idMateria);

        if (materiaOptional.isPresent()){
           return materiaOptional.get();
        }
        throw new IllegalArgumentException(String.format("id %s não",idMateria));
    }
    public MateriaDTO update(MateriaDTO alterandoMateria,Long idMateria){
        Optional<Materia>materiaOptional = this.materiaRepository.findById(idMateria);

        if (materiaOptional.isPresent()){
            Materia materia = materiaOptional.get();

            LOGGER.info("Alterando Materias pelo id: [{}]",materia.getIdmateria());
            LOGGER.debug("Adicionando inexistente: {}",alterandoMateria);
            LOGGER.debug("Materia inexistente :{}", materia);

            materia.setNomeMateria(alterandoMateria.getNomeMateria());
            materia.setIdNota(notaService.findById(alterandoMateria.getIdNota()));
            materia = this.materiaRepository.save(materia);
            return MateriaDTO.of(materia);
        }
        throw new IllegalArgumentException(String.format("id %s nao existe",idMateria));
    }
    public void delete(Long idMateria){
        LOGGER.info("Deletando materia pelo id: [{}]", idMateria);
        this.materiaRepository.deleteById(idMateria);
    }

    public List<Materia> findAll(){
        List<Materia>listaDeMaterias = materiaRepository.findAll();
        if (!listaDeMaterias.isEmpty()){
            return listaDeMaterias;
        }
        throw new IllegalArgumentException("Não há Materias Cadastradas");
    }
}
