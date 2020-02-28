package com.hbsis.sistemaescolar.jasper;

import com.hbsis.sistemaescolar.aluno.AlunoService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("/jasper")
public class JasperRest {
    @Autowired
    private AlunoService alunoService;
    @Autowired
    private JasperService jasperService;


    @GetMapping("/imprimir/{format}")
    public String generateReport( @PathVariable String format) throws FileNotFoundException, JRException {
        return jasperService.exportarReporte(format);
    }

}
