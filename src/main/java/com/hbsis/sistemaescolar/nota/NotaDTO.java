package com.hbsis.sistemaescolar.nota;

public class NotaDTO {
    private Long idNota;
    private Double notaPrimeiro;
    private Double notaSegundo;
    private Double notaTerceiro;
    private Double mediaFinal;

    public NotaDTO(Long idNota, Double notaPrimeiro, Double notaSegundo, Double notaTerceiro, Double mediaFinal) {
        this.idNota = idNota;
        this.notaPrimeiro = notaPrimeiro;
        this.notaSegundo = notaSegundo;
        this.notaTerceiro = notaTerceiro;
        this.mediaFinal = mediaFinal;
    }
    public static NotaDTO of(Nota nota){
        return new NotaDTO(
                nota.getIdnota(),
                nota.getNotaPrimeiro(),
                nota.getNotaSegundo(),
                nota.getNotaTerceiro(),
                nota.getMediaFinal()
        );
    }

    public Long getIdNota() {
        return idNota;
    }

    public void setIdNota(Long idNota) {
        this.idNota = idNota;
    }

    public Double getNotaPrimeiro() {
        return notaPrimeiro;
    }

    public void setNotaPrimeiro(Double notaPrimeiro) {
        this.notaPrimeiro = notaPrimeiro;
    }

    public Double getNotaSegundo() {
        return notaSegundo;
    }

    public void setNotaSegundo(Double notaSegundo) {
        this.notaSegundo = notaSegundo;
    }

    public Double getNotaTerceiro() {
        return notaTerceiro;
    }

    public void setNotaTerceiro(Double notaTerceiro) {
        this.notaTerceiro = notaTerceiro;
    }

    public Double getMediaFinal() {
        return mediaFinal;
    }

    public void setMediaFinal(Double mediaFinal) {
        this.mediaFinal = mediaFinal;
    }

    @Override
    public String toString() {
        return "NotaDTO{" +
                "idNota=" + idNota +
                ", notaPrimeiro=" + notaPrimeiro +
                ", notaSegundo=" + notaSegundo +
                ", notaTerceiro=" + notaTerceiro +
                ", mediaFinal=" + mediaFinal +
                '}';
    }
}
