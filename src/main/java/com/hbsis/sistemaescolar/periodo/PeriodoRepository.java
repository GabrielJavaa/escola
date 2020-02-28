package com.hbsis.sistemaescolar.periodo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface PeriodoRepository extends JpaRepository<Periodo, Long> {
}
