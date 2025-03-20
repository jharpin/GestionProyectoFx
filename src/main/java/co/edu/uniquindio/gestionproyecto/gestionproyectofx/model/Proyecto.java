package co.edu.uniquindio.gestionproyecto.gestionproyectofx.model;

public class Proyecto {
    private String nombreProyecto;
    private String codigoProyecto;
    private float costeProyecto;
    public Proyecto(String nombreProyecto, String codigoProyecto, float costeProyecto) {
        this.nombreProyecto = nombreProyecto;
        this.codigoProyecto = codigoProyecto;
        this.costeProyecto = costeProyecto;
    }
    public Proyecto() {}
    public String getNombreProyecto() {
        return nombreProyecto;
    }
    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }
    public String getCodigoProyecto() {
        return codigoProyecto;
    }
    public void setCodigoProyecto(String codigoProyecto) {
        this.codigoProyecto = codigoProyecto;
    }
    public float getCosteProyecto() {
        return costeProyecto;
    }
    public void setCosteProyecto(float costeProyecto) {
        this.costeProyecto = costeProyecto;
    }

    @Override
    public String toString() {
        return "Proyecto{" +
                "nombreProyecto='" + nombreProyecto + '\'' +
                ", codigoProyecto='" + codigoProyecto + '\'' +
                ", costeProyecto=" + costeProyecto +
                '}';
    }
}
