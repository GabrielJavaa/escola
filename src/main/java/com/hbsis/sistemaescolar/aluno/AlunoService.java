package com.hbsis.sistemaescolar.aluno;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;


@Service
public class AlunoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AlunoService.class);
    private final AlunoRepository alunoRepository;


    public AlunoService(AlunoRepository alunoRepository) {

        this.alunoRepository = alunoRepository;
    }

    public AlunoDTO save(AlunoDTO alunoDTO) {

        this.validate(alunoDTO);
        LOGGER.info("Cadastro feito com sucesso...");
        LOGGER.debug("Turma : {}", alunoDTO);

        Aluno aluno = new Aluno();

        aluno.setIdaluno(alunoDTO.getIdAluno());
        aluno.setNomeAluno(alunoDTO.getNomeAluno());

        aluno = this.alunoRepository.save(aluno);
        return AlunoDTO.of(aluno);
    }

//    public void ligacoes(Aluno aluno) {
//        HashMap<String, List> map = new HashMap<>();
//
//        int n = 1;
//        for (int i = 0; i < n; i++) {
//            String nome = aluno.getNomeAluno();
//            List list = this.listarMateriasENotas(aluno);
//            map.put(nome,list);
//        }
//        String nomeAluno = aluno.getNomeAluno();
//        if (map.containsKey(nomeAluno)){
//            System.out.println(nomeAluno + map.get(nomeAluno));
//        }else {
//            System.out.println("chave sem valor");
//        }
//    }

    private void validate(AlunoDTO validandoAluno) {
        LOGGER.info("Validando Aluno");

        if (validandoAluno == null) {
            throw new IllegalArgumentException("Aluno não deve ser nulo");
        }

        if (StringUtils.isEmpty(validandoAluno.getNomeAluno())) {
            throw new IllegalArgumentException("Nome do Aluno não deve ser nula/vazia");
        }
    }

    public Aluno findById(Long idAluno) {
        Optional<Aluno> alunoOptional = this.alunoRepository.findById(idAluno);
        if (alunoOptional.isPresent()) {
            return alunoOptional.get();
        }
        throw new IllegalArgumentException(String.format("id %s nao informado", idAluno));
    }

    public List<Aluno> findAll(){
        return this.alunoRepository.findAll();
    }

    public AlunoDTO update(AlunoDTO alunoDTO, Long idAluno) {
        Optional<Aluno> alunoOptional = this.alunoRepository.findById(idAluno);

        this.validate(alunoDTO);

        if (alunoOptional.isPresent()) {
            Aluno aluno = alunoOptional.get();

            LOGGER.info("Atualizando aluno... id: [{}]", aluno.getIdaluno());
            LOGGER.debug("Aluno: {}", alunoDTO);
            LOGGER.debug("Aluno existente: {}", alunoOptional);

            aluno.setNomeAluno(alunoDTO.getNomeAluno());

            aluno = this.alunoRepository.save(aluno);

            return AlunoDTO.of(aluno);
        }
        throw new IllegalArgumentException(String.format("id %s não existente", idAluno));
    }

    public void delete(Long idAluno) {
        LOGGER.info("Executando delete para alunos de ID: [{}]", idAluno);

        this.alunoRepository.deleteById(idAluno);
    }


}
