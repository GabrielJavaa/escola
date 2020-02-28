package com.hbsis.sistemaescolar.periodo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PeriodoService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PeriodoService.class);

    private final PeriodoRepository periodoRepository;

    public PeriodoService(PeriodoRepository periodoRepository) {
        this.periodoRepository = periodoRepository;
    }
    public PeriodoDTO save(PeriodoDTO salvandoPeriodo){
        LOGGER.info("Salvando periodos");
        LOGGER.debug("Periodo: {}",salvandoPeriodo);

        Periodo periodo = new Periodo();

        periodo.setIdPeriodo(salvandoPeriodo.getIdPeriodo());
        periodo.setPrimeiroTrimestre(salvandoPeriodo.getDataInicio());
        periodo.setSegundoTrimestre(salvandoPeriodo.getDataFim());
        periodo.setTerceiroTrimestre(salvandoPeriodo.getDataFim());

        periodo = this.periodoRepository.save(periodo);
        return PeriodoDTO.of(periodo);
    }
    public Periodo findById(Long idPeriodo){
        Optional<Periodo>periodoOptional = this.periodoRepository.findById(idPeriodo);

        if (periodoOptional.isPresent()){
            return periodoOptional.get();
        }
        throw new IllegalArgumentException(String.format("id %s não existente",idPeriodo));
    }

}
