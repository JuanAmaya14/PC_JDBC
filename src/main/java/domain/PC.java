package domain;

public class PC {

    private int idPC;
    private String procesador;
    private String RAM;
    private String targetaVideo;

    public PC(int idPC) {
        this.idPC = idPC;
    }

    public PC(String procesador, String RAM, String targetaVideo) {
        this.procesador = procesador;
        this.RAM = RAM;
        this.targetaVideo = targetaVideo;
    }

    public PC(int idPC, String procesador, String RAM, String targetaVideo) {
        this.idPC = idPC;
        this.procesador = procesador;
        this.RAM = RAM;
        this.targetaVideo = targetaVideo;
    }

    public int getIdPC() {
        return idPC;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public String getRAM() {
        return RAM;
    }

    public void setRAM(String RAM) {
        this.RAM = RAM;
    }

    public String getTargetaVideo() {
        return targetaVideo;
    }

    public void setTargetaVideo(String targetaVideo) {
        this.targetaVideo = targetaVideo;
    }

    @Override
    public String toString() {
        return "PC{" +
                "idPC=" + idPC +
                ", procesador='" + procesador + '\'' +
                ", RAM='" + RAM + '\'' +
                ", targetaVideo='" + targetaVideo + '\'' +
                '}';
    }
}
