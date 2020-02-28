package com.hbsis.sistemaescolar.materia;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/materia")
public class MateriaRest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MateriaRest.class);

    private final MateriaService materiaService;

    @Autowired
    public MateriaRest(MateriaService materiaService) {
        this.materiaService = materiaService;
    }
    @PostMapping
    public MateriaDTO save(@RequestBody MateriaDTO salvaMateria){
        LOGGER.info("Salvando Materias...");
        LOGGER.debug("Salvando materias : {}",salvaMateria);
        return this.materiaService.save(salvaMateria);
    }
    @GetMapping("/{idMateria}")
    public Materia findById(@PathVariable("idMateria") Long idMateria){
        LOGGER.info("Buscando materia pelo id: [{}]", idMateria);
        return this.materiaService.findById(idMateria);
    }
    @PutMapping("/{idMateria}")
    public MateriaDTO update(@PathVariable("idMateria") Long idMateria,@RequestBody MateriaDTO alterandoMateria){
        LOGGER.info("Alterando Materia pelo id: {}",alterandoMateria);
        LOGGER.debug("Adicionando Materias: {}",alterandoMateria);
        return this.materiaService.update(alterandoMateria, idMateria);
    }
    @DeleteMapping("/{idMateria}")
    public void delete(@PathVariable("idMateria") Long idMateria){
        LOGGER.info("Deletando materia pelo id : {}",idMateria);
        this.materiaService.delete(idMateria);
    }
}
