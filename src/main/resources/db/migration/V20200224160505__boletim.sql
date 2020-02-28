create table boletim
(
    id_boletim BIGINT IDENTITY (1,1) PRIMARY KEY NOT NULL,
    alunos BIGINT NOT NULL,
    materias BIGINT NOT NULL,
    periodos BIGINT NOT NULL,
    notas BIGINT NOT NULL,
    CONSTRAINT fk_alunos FOREIGN KEY (alunos) REFERENCES aluno (id_aluno),
    CONSTRAINT fk_materias FOREIGN KEY (materias) REFERENCES nome_materia (id_materia),
    CONSTRAINT fk_periodos FOREIGN KEY (periodos) REFERENCES periodo (id_periodo),
    CONSTRAINT fk_notas FOREIGN KEY (notas) REFERENCES nota (id_nota)
    );