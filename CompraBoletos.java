import java.util.Random;
import java.util.Scanner;

public class CompraBoletos {
    private static final int NUM_LOCALIDADES = 3;
    private static final int NUM_TICKETS = 60;
    private static final int MAX_ESPACIO_LOCALIDAD = 20;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Localidad[] localidades = {
            new Localidad(MAX_ESPACIO_LOCALIDAD, 100),
            new Localidad(MAX_ESPACIO_LOCALIDAD, 500),
            new Localidad(MAX_ESPACIO_LOCALIDAD, 1000)
        };

        for (int i = 0; i < NUM_TICKETS; i++) {
            Ticket ticket = new Ticket();
            int a = ticket.getA();
            int b = ticket.getB();

            if (ticket.getNumber() >= a && ticket.getNumber() <= b) {
                int localidadIndex = new Random().nextInt(NUM_LOCALIDADES);
                Localidad localidad = localidades[localidadIndex];

                System.out.print("Nombre: ");
                String nombre = scanner.nextLine();
                System.out.print("Email: ");
                String email = scanner.nextLine();
                System.out.print("Cantidad de boletos a comprar: ");
                int cantidadBoletos = scanner.nextInt();
                System.out.print("Presupuesto máximo: ");
                int presupuestoMax = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea

                if (localidad.getPrecio() <= presupuestoMax) {
                    int boletosDisponibles = localidad.getCapacidad() - localidad.getBoletosVendidos();
                    int boletosAVender = Math.min(boletosDisponibles, cantidadBoletos);

                    if (boletosAVender > 0) {
                        boolean compraEspecial = false;
                        System.out.print("¿Tiene un código especial de Fibonacci? (S/N): ");
                        String respuesta = scanner.nextLine();
                        if (respuesta.equalsIgnoreCase("S")) {
                            System.out.print("Ingrese el código especial (número de Fibonacci): ");
                            int codigoEspecial = scanner.nextInt();
                            scanner.nextLine(); // Consumir el salto de línea

                            if (esNumeroFibonacci(codigoEspecial)) {
                                if (localidadIndex == 2) { // Solo en localidad 10
                                    localidad.venderBoletos(boletosAVender);
                                    int totalVenta = boletosAVender * 20000;
                                    System.out.println("¡Compra especial exitosa! Se han vendido " + boletosAVender + " boletos en la localidad " + localidadIndex + " por un total de $" + totalVenta + ".");
                                    compraEspecial = true;
                                } else {
                                    System.out.println("El código especial solo puede usarse en la localidad 10.");
                                }
                            } else {
                                System.out.println("El código ingresado no es un número de Fibonacci.");
                            }
                        }

                        if (!compraEspecial) {
                            localidad.venderBoletos(boletosAVender);
                            int totalVenta = boletosAVender * localidad.getPrecio();
                            System.out.println("¡Compra exitosa! Se han vendido " + boletosAVender + " boletos en la localidad " + localidadIndex + " por un total de $" + totalVenta + ".");
                        }
                    } else {
                        System.out.println("No hay boletos disponibles en la localidad.");
                    }
                } else {
                    System.out.println("El precio de la localidad es mayor al presupuesto máximo.");
                }
            }
        }
    }

    private static boolean esNumeroFibonacci(int numero) {
        int a = 0;
        int b = 1;
        while (b <= numero) {
            if (b == numero) {
                return true;
            }
            int temp = b;
            b = a + b;
            a = temp;
        }
        return false;
    }
}

class Ticket {
    private int number;
    private int a;
    private int b;

    public Ticket() {
        Random random = new Random();
        this.number = random.nextInt(15000) + 1;
        this.a = random.nextInt(15000) + 1;
        this.b = random.nextInt(15000) + 1;
    }

    public int getNumber() {
        return number;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}

class Localidad {
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
