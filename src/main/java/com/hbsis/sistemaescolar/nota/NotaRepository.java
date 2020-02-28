package com.hbsis.sistemaescolar.nota;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface NotaRepository extends JpaRepository<Nota, Long> {
}
