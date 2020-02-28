package com.hbsis.sistemaescolar.aluno;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
