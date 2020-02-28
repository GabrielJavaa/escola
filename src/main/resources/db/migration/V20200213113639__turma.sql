create table turma
(
    id_turma BIGINT IDENTITY(1,1) PRIMARY KEY NOT NULL,
    nome_turma VARCHAR (10) NOT NULL,
    id_aluno BIGINT NOT NULL,
    CONSTRAINT fk_alu FOREIGN KEY (id_aluno) REFERENCES aluno (id_aluno)
);
