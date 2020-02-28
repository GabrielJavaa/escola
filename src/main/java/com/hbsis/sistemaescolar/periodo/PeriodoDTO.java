package com.hbsis.sistemaescolar.periodo;

import java.time.LocalDate;

public class PeriodoDTO {
    private Long idPeriodo;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Long idNota;

    public PeriodoDTO(Long idPeriodo, LocalDate dataInicio, LocalDate dataFim, Long idNota) {
        this.idPeriodo = idPeriodo;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.idNota = idNota;
    }
    public static PeriodoDTO of(Periodo periodo){
        return new PeriodoDTO(
                periodo.getIdPeriodo(),
                periodo.getPrimeiroTrimestre(),
                periodo.getSegundoTrimestre(),
                periodo.getIdNota().getIdnota()
        );
    }

    public Long getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(Long idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public Long getIdNota() {
        return idNota;
    }

    public void setIdNota(Long idNota) {
        this.idNota = idNota;
    }

    @Override
    public String toString() {
        return "PeriodoDTO{" +
                "idPeriodo=" + idPeriodo +
                ", dataInicio=" + dataInicio +
                ", dataFim=" + dataFim +
                '}';
    }
}
