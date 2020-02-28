package com.hbsis.sistemaescolar.aluno;

public class AlunoDTO {

    private Long idAluno;
    private String nomeAluno;

    public AlunoDTO(Long idAluno, String nomeAluno) {
        this.idAluno = idAluno;
        this.nomeAluno = nomeAluno;
    }

    public static AlunoDTO of(Aluno aluno){
        return new AlunoDTO(
                aluno.getIdaluno(),
                aluno.getNomeAluno()
                );
    }

    public Long getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Long idAluno) {
        this.idAluno = idAluno;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    @Override
    public String toString() {
        return "AlunoDTO{" +
                "idAluno=" + idAluno +
                ", nomeAluno='" + nomeAluno + '\'' +
                '}';
    }
}
