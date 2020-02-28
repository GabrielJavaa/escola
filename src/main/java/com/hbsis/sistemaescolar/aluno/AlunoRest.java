package com.hbsis.sistemaescolar.aluno;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aluno")
public class AlunoRest {
    private static final Logger LOGGER = LoggerFactory.getLogger(AlunoRest.class);

    private final AlunoService alunoService;

    @Autowired

    public AlunoRest(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    public AlunoDTO save(@RequestBody AlunoDTO alunoDTO){
        LOGGER.info("Cadastrando Aluno...");
        LOGGER.debug("Aluno {}", alunoDTO);
        return this.alunoService.save(alunoDTO);
    }
    @GetMapping("/{idAluno}")
    public Aluno findById(@PathVariable("idAluno") Long idAluno){
        LOGGER.info("Pesquisando id... id:[{}]",idAluno);
        return this.alunoService.findById(idAluno);
    }
    @PutMapping("/{idAluno}")
    public AlunoDTO update(@PathVariable("idAluno") Long idAluno, @RequestBody AlunoDTO alunoDTO){
        LOGGER.info("Alterando dados pelo id:{}",idAluno);
        LOGGER.debug("Aluno existe {}",alunoDTO);
        return this.alunoService.update(alunoDTO,idAluno);
    }
    @DeleteMapping("/{idAluno}")
    public void delete(@PathVariable("idAluno") Long idAluno){
        LOGGER.info("Deletando usuario pelo id: {}",idAluno);
        this.alunoService.delete(idAluno);
    }
}
