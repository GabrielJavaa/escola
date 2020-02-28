package com.hbsis.sistemaescolar.turma;

import com.hbsis.sistemaescolar.aluno.Aluno;
import com.hbsis.sistemaescolar.aluno.AlunoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
public class TurmaService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TurmaService.class);

    private final TurmaRepository turmaRepository;
    private final AlunoService alunoService;

    public TurmaService(TurmaRepository turmaRepository, AlunoService alunoService) {
        this.turmaRepository = turmaRepository;
        this.alunoService = alunoService;
    }

    public TurmaDTO save(TurmaDTO turmaDTO) {
        LOGGER.info("Salvando turmas...");
        LOGGER.debug("Turmas:{}", turmaDTO);

        this.validate(turmaDTO);
        Turma turma = new Turma();

        Aluno aluno = this.alunoService.findById(turmaDTO.getIdAluno());

        turma.setIdturma(turmaDTO.getIdTurma());
        turma.setNomeTurma(turmaDTO.getNomeTurma());
        turma.setIdAluno(aluno);

        turma = this.turmaRepository.save(turma);

        return TurmaDTO.of(turma);
    }

    private void validate(TurmaDTO validandoTurma) {
        LOGGER.info("Validando Usuario");

        if (validandoTurma == null) {
            throw new IllegalArgumentException("Turma não deve ser nulo");
        }

        if (StringUtils.isEmpty(validandoTurma.getNomeTurma())) {
            throw new IllegalArgumentException("Nome da turma não deve ser nula/vazia");
        }

        if (StringUtils.isEmpty(validandoTurma.getIdAluno())) {
            throw new IllegalArgumentException(" Aluno não deve ser nulo/vazio");
        }
    }

    public Turma findById(Long idTurma) {
        Optional<Turma> turmaOptional = this.turmaRepository.findById(idTurma);

        if (turmaOptional.isPresent()) {
            return turmaOptional.get();
        }
        throw new IllegalArgumentException(String.format("id %s não encontrado", idTurma));
    }
    public Turma findByNomeTurma(String NomeTurma){
        Optional<Turma> optionalTurma = this.turmaRepository.findByNomeTurma(NomeTurma);

        if (optionalTurma.isPresent()){
            return optionalTurma.get();
        }
        throw new IllegalArgumentException(String.format("nome da turma %s Não encontrado",NomeTurma));
    }

    public TurmaDTO update(TurmaDTO alterandoTurmas, Long idTurmas) {
        Optional<Turma> turmaOptional = this.turmaRepository.findById(idTurmas);

        if (turmaOptional.isPresent()) {
            Turma turma = turmaOptional.get();

            LOGGER.info("Alterando turmas...");
            LOGGER.debug("Turmas: {}", alterandoTurmas);
            LOGGER.debug("Turma existente:{}", turmaOptional);

            turma.setIdturma(alterandoTurmas.getIdTurma());
            turma.setNomeTurma(alterandoTurmas.getNomeTurma());
            turma.setIdAluno(alunoService.findById(alterandoTurmas.getIdAluno()));

            turma = this.turmaRepository.save(turma);
            return TurmaDTO.of(turma);
        }
        throw new IllegalArgumentException(String.format("id %s não encontrado", idTurmas));
    }

    public void delete(Long idTurma) {
        LOGGER.debug("Deletando turmas pelo id : [{}]", idTurma);
        this.turmaRepository.deleteById(idTurma);
    }
}
