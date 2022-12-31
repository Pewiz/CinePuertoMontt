package Model;

public class Boleta {

    private int id;
    private int sala;
    private String horario;
    private int costo;
    private String fecha;
    private String asiento;
    private String nombrePelicula;

    public Boleta(int id, int sala, int costo, String horario, String fecha, String asiento, String nombrePelicula) {
        this.id = id;
        this.sala = sala;
        this.costo = costo;
        this.horario = horario;
        this.fecha = fecha;
        this.asiento = asiento;
        this.nombrePelicula = nombrePelicula;

    }

    public int getSala() {
        return sala;
    }

    public int getId() {
        return id;
    }

    public int getCosto() {
        return costo;
    }

    public String getHorario() {
        return horario;
    }

    public String getFecha() {
        return fecha;
    }

    public String getAsiento() {
        return asiento;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

  

}
