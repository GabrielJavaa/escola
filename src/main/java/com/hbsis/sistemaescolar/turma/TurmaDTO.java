package com.hbsis.sistemaescolar.turma;

import com.hbsis.sistemaescolar.aluno.Aluno;

public class TurmaDTO {
    private Long idTurma;
    private String nomeTurma;
    private Long idAluno;

    public TurmaDTO(Long idTurma, String nomeTurma, Long idAluno) {
        this.idTurma = idTurma;
        this.nomeTurma = nomeTurma;
        this.idAluno = idAluno;
    }
    public static TurmaDTO of(Turma turma){
        return new TurmaDTO(
                turma.getIdturma(),
                turma.getNomeTurma(),
                turma.getIdAluno().getIdaluno()
        );
    }

    public Long getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(Long idTurma) {
        this.idTurma = idTurma;
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public Long getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Long idAluno) {
        this.idAluno = idAluno;
    }

    @Override
    public String toString() {
        return "TurmaDTO{" +
                "idTurma=" + idTurma +
                ", nomeTurma='" + nomeTurma + '\'' +
                ", idAluno=" + idAluno +
                '}';
    }
}
