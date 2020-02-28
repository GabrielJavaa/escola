package com.hbsis.sistemaescolar.turma;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/turma")
public class TurmaRest {
    private static final Logger LOGGER = LoggerFactory.getLogger(TurmaRest.class);

    private final TurmaService turmaService;

    @Autowired

    public TurmaRest(TurmaService turmaService) {
        this.turmaService = turmaService;
    }
    @PostMapping
    public TurmaDTO save(@RequestBody TurmaDTO turmaDTO){
        LOGGER.info("Salvando turmas...");
        LOGGER.debug("Turma: {}",turmaDTO);
        return this.turmaService.save(turmaDTO);
    }
    @GetMapping("/{idTurma}")
    public Turma findById(@PathVariable("id") Long idTurma){
        LOGGER.info("Buscando a turma pelo id:[{}]",idTurma);
        return this.turmaService.findById(idTurma);
    }
    @PutMapping("/{idTurma}")
    public TurmaDTO update(@PathVariable("idTurma") Long idTurma, @RequestBody TurmaDTO turmaDTO){
        LOGGER.info("Alterando turma pelo id:{}",idTurma);
        LOGGER.debug("Turma :{}",turmaDTO);
        return this.turmaService.update(turmaDTO,idTurma);
    }
    @DeleteMapping("/{idTurmas}")
    public void delete(@PathVariable("idTurma") Long idTurmas){
        LOGGER.info("Deletando turmas pelo id:{}",idTurmas);
        this.turmaService.delete(idTurmas);
    }
}
