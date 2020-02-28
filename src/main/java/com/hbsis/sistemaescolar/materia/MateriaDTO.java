package com.hbsis.sistemaescolar.materia;

public class MateriaDTO {
    private Long idMateria;
    private String nomeMateria;
    private Long idNota;

    public MateriaDTO(Long idMateria, String nomeMateria, Long idNota) {
        this.idMateria = idMateria;
        this.nomeMateria = nomeMateria;
    }

    public static MateriaDTO of(Materia materia){
        return new MateriaDTO(
        materia.getIdmateria(),
        materia.getNomeMateria(),
        materia.getIdNota().getIdnota()
        );
    }

    public Long getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Long idMateria) {
        this.idMateria = idMateria;
    }

    public String getNomeMateria() {
        return nomeMateria;
    }

    public void setNomeMateria(String nomeMateria) {
        this.nomeMateria = nomeMateria;
    }

    public Long getIdNota() {
        return idNota;
    }

    public void setIdNota(Long idNota) {
        this.idNota = idNota;
    }

    @Override
    public String toString() {
        return "MateriaDTO{" +
                "idMateria=" + idMateria +
                ", nomeMateria='" + nomeMateria + '\'' +
                '}';
    }
}
