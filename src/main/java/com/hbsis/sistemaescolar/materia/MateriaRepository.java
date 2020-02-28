package com.hbsis.sistemaescolar.materia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface MateriaRepository extends JpaRepository<Materia, Long> {

}
