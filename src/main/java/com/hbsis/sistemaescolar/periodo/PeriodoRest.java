package com.hbsis.sistemaescolar.periodo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/periodo")
public class PeriodoRest {
    private static final Logger LOGGER = LoggerFactory.getLogger(PeriodoRest.class);

    private final PeriodoService periodoService;

    @Autowired
    public PeriodoRest(PeriodoService periodoService) {
        this.periodoService = periodoService;
    }
    @PostMapping
    public PeriodoDTO save(@RequestBody PeriodoDTO periodoDTO){
        LOGGER.info("Salvando periodos...");
        LOGGER.debug("Periodo:{}",periodoDTO);
        return this.periodoService.save(periodoDTO);
    }
    @GetMapping("/(idPeriodo")
    public Periodo findById(@PathVariable("idPeriodo") Long idPeriodo){
        LOGGER.info("Buscando periodos pelo id:[{}]",idPeriodo);
        return this.periodoService.findById(idPeriodo);
    }
}
