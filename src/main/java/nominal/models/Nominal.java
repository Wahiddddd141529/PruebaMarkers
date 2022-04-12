package nominal.models;

public class Nominal {
    String fecha, portafolio;
    int nominal;
    String precio;
    int total;


    public Nominal(String fecha, String portafolio, int nominal, String precio, int total) {
        this.fecha = fecha;
        this.portafolio = portafolio;
        this.nominal = nominal;
        this.precio = precio;
        this.total = total;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPortafolio() {
        return portafolio;
    }

    public void setPortafolio(String portafolio) {
        this.portafolio = portafolio;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
