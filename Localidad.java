public class Localidad {
    private int capacidad;
    private int precio;
    private int boletosVendidos;

    public Localidad(int capacidad, int precio) {
        this.capacidad = capacidad;
        this.precio = precio;
        this.boletosVendidos = 0;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getPrecio() {
        return precio;
    }

    public int getBoletosVendidos() {
        return boletosVendidos;
    }

    public void venderBoletos(int cantidad) {
        boletosVendidos += cantidad;
    }
}
