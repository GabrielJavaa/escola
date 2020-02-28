package com.hbsis.sistemaescolar.turma;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface TurmaRepository extends JpaRepository<Turma, Long> {
    Optional<Turma> findByNomeTurma(String NomeTurma);
}
