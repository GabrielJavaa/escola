package com.hbsis.sistemaescolar.nota;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NotaService {
    private static final Logger LOGGER = LoggerFactory.getLogger(NotaService.class);

    private final NotaRepository notaRepository;

    @Autowired

    public NotaService(NotaRepository notaRepository) {
        this.notaRepository = notaRepository;
    }

    public NotaDTO save(NotaDTO notaDTO) {
        LOGGER.info("Salvando Notas dos Alunos...");
        LOGGER.debug("Notas: {}", notaDTO);

        Nota nota = new Nota();

        nota.setIdnota(notaDTO.getIdNota());
        nota.setNotaPrimeiro(notaDTO.getNotaPrimeiro());
        nota.setNotaSegundo(notaDTO.getNotaSegundo());
        nota.setNotaTerceiro(notaDTO.getNotaTerceiro());
        nota.setMediaFinal(notaDTO.getMediaFinal());

        nota = this.notaRepository.save(nota);
        return NotaDTO.of(nota);

    }

    public Nota findById(Long idNota) {
        Optional<Nota> notaOptional = this.notaRepository.findById(idNota);
        if (notaOptional.isPresent()) {
            return notaOptional.get();
        }
        throw new IllegalArgumentException(String.format("id %s não encontrado", idNota));
    }

    public NotaDTO update(NotaDTO notaDTO, Long idNota) {
        Optional<Nota> notaOptional = this.notaRepository.findById(idNota);

        if (notaOptional.isPresent()) {
            Nota nota = notaOptional.get();

            LOGGER.info("Alterando Notas...id:[{}]", nota.getIdnota());
            LOGGER.debug("Notas: {}", notaDTO);
            LOGGER.debug("Nota existente : {}", nota);

            nota.setNotaPrimeiro(notaDTO.getNotaPrimeiro());
            nota.setNotaSegundo(notaDTO.getNotaSegundo());
            nota.setNotaTerceiro(notaDTO.getNotaTerceiro());
            nota.setMediaFinal(notaDTO.getMediaFinal());

            nota = this.notaRepository.save(nota);
        }
        throw new IllegalArgumentException(String.format("id %s não encontrado", idNota));
    }

    public void delete(Long idNota) {
        LOGGER.info("Deletando notas pelo id:[{}]", idNota);

        this.notaRepository.deleteById(idNota);
    }

    public List<Nota> findAll(){
        List<Nota> listaDeNotas = notaRepository.findAll();
        if (listaDeNotas.isEmpty()){
            return listaDeNotas;
        }
        throw new IllegalArgumentException("Não há notas no registro");
    }
}
