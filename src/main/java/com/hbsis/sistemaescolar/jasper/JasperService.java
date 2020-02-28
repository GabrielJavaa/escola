package com.hbsis.sistemaescolar.jasper;

import com.hbsis.sistemaescolar.aluno.Aluno;
import com.hbsis.sistemaescolar.aluno.AlunoService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JasperService {

    @Autowired

    private AlunoService alunoService;

    public String exportarReporte(String reporteFormat) throws FileNotFoundException, JRException {
        String path = "C:\\Users\\gabriel.pereira\\Desktop\\pastaJasper";
        List<Aluno> alunos = alunoService.findAll();

        File file = ResourceUtils.getFile("src\\main\\resources\\boleta.jrxml");
        JasperReport jasperRepor = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(alunos);
        Map<String,Object> parametros = new HashMap<>();
        parametros.put("boletim", "nvx");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperRepor,parametros, dataSource);
        if (reporteFormat.equalsIgnoreCase("html")){
        JasperExportManager.exportReportToHtmlFile(jasperPrint,path+"\\boleta.html");
        }
        if (reporteFormat.equalsIgnoreCase("pdf")){
            JasperExportManager.exportReportToPdfFile(jasperPrint,path+"\\boleta.pdf");
        }
        return "report gerando path:"+path;
    }
}
