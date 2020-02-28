package com.hbsis.sistemaescolar.nota;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/nota")
public class NotaRest {
    private static final Logger LOGGER = LoggerFactory.getLogger(NotaRest.class);

    private final NotaService notaService;

    @Autowired
    public NotaRest(NotaService notaService) {
        this.notaService = notaService;
    }

    @PostMapping
    public NotaDTO save(@RequestBody NotaDTO notaDTO) {
        LOGGER.debug("Notas : {}", notaDTO);
        return this.notaService.save(notaDTO);
    }

    @GetMapping("/{idNota}")
    public Nota findById(@PathVariable("idNota") Long idNota) {
        LOGGER.info("Buscando Notas pelo id:[{}]", idNota);

        return this.notaService.findById(idNota);
    }

    @PutMapping("/{idNota}")
    public NotaDTO update(@PathVariable("idNota") Long idNota, NotaDTO notaDTO) {
        LOGGER.info("Alterando notas pelo id:{}", idNota);
        LOGGER.debug("Notas:{}", notaDTO);
        return this.notaService.update(notaDTO, idNota);
    }

    @DeleteMapping("/{idNota}")
    public void delete(@PathVariable("idNota") Long idNota) {
        LOGGER.info("Deletando Notas pelo id:{}", idNota);
    }

}
