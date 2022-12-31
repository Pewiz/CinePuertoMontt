package Controller;

import Model.Boleta;
import Model.Sala;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.*;

public class Metodos {

    public File archivo;
    public static Sala salas[] = new Sala[3];
    public static boolean primeraVez = true;
    public static int totalBoleta = 0, totalVenta = 0, x, y, sala, horario, IdBoleta, costo, precioTotalBoletas, cantidadTotalBoleta;
    public static String asientoTotal = "", nombrePelicula = "", texto = "";
    private java.util.Date fecha = new Date();
    public static List<Boleta> boletas = new ArrayList<Boleta>();
    public static int sumaCantidad[] = new int[3];

    public Metodos() {
        if (primeraVez) {
            for (int i = 0; i < 3; i++) {
                salas[i] = new Sala(i);
                sumaCantidad[i] = 0;
            }
            primeraVez = false;
        }
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public void setTotalBoleta(int totalBoleta) {
        Metodos.totalBoleta = totalBoleta;
    }

    public int getSumaCantidad(int posicion) {
        return sumaCantidad[posicion];
    }

    public int getCantidadTotalBoleta() {
        return cantidadTotalBoleta;
    }

    public int getPrecioTotalBoletas() {
        return precioTotalBoletas;
    }

    public void salaHorarioYAsientos(int horarioId) {
        horario = horarioId;

        salas[sala].seleccionarSalaHorario(horario);

    }

    public Boleta boleta() {
        String horarios[] = {"Matine", "Vermut", "Vespentino"};
        int precioTotalBoleta;
        //ID
        int id = (int) (Math.random() * 9999 + 999);
        /*Sala
        Sala es la variable global "sala"*/
 /*Horario
         El horario lo obtengo de inmediato con el valor de la variable globlar horario*/
        //Costo
        precioTotalBoleta = totalBoleta * 3000;
        //Fecha
        DateTimeFormatter esDateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fecha = LocalDate.now();
        /*Asiento
        Asiento es la variable global "asientoTotal"*/
        switch (sala) {
            case 0:
                nombrePelicula = "Spider-Man: No Way Home (2021)";
                break;
            case 1:
                nombrePelicula = "John Wick 3: Parabellum (2019)";
                break;
            case 2:
                nombrePelicula = "Cars (2006)";
                break;
            default:
                break;
        }

        Boleta boleta = new Boleta(id, sala + 1, precioTotalBoleta, horarios[horario], fecha.format(esDateFormat), asientoTotal, nombrePelicula);
        boletas.add(boleta);
        System.out.println(boleta.toString());
        IdBoleta = boleta.getId();
        costo = boleta.getCosto();
        totalVenta += totalBoleta;
        //Reseteo de la variable asientoTotal
        asientoTotal = " ";
        //Reseteo de la variable totalBoleta
        totalBoleta = 0;
        return boleta;
    }

    public void asientosSeleccionados(int x, int y) {
        char letraAsiento[] = {'A', 'B', 'C', 'D', 'E'};
        int numeroAsiento = y + 1;

        String asiento = "" + letraAsiento[x] + numeroAsiento + " ";
        asientoTotal += asiento;

    }

    public void resumenDeVenta() {
        System.out.println("\n-- Venta total --\n");
        for (Boleta i : boletas) {
            System.out.println("ID: " + i.getId() + " Valor: $" + i.getCosto());
        }
        System.out.println("Total de venta: $" + totalVenta * 3000);
    }

    public void ventaPorSala(int opcionVentaPorSala) {
        texto = "";
        switch (opcionVentaPorSala) {
            case 1:
                texto = "\nID: " + IdBoleta + " Valor: $" + costo;
                escribirArchivoDeTexto("sala1.txt");
                escribirArchivoDeTexto("totalSala.txt");
                sumaCantidad[0] += 1;
                cantidadTotalBoleta += 1;
                break;
            case 2:
                texto = "\nID: " + IdBoleta + " Valor: $" + costo;
                escribirArchivoDeTexto("sala2.txt");
                escribirArchivoDeTexto("totalSala.txt");
                sumaCantidad[1] += 1;
                cantidadTotalBoleta += 1;
                break;
            case 3:
                texto = "\nID: " + IdBoleta + " Valor: $" + costo;
                escribirArchivoDeTexto("sala3.txt");
                escribirArchivoDeTexto("totalSala.txt");
                sumaCantidad[2] += 1;
                cantidadTotalBoleta += 1;
                break;
        }
    }

    public int costoPorSala(int opcion) {
        int suma = 0;
        switch (opcion) {
            case 0:
                IntSummaryStatistics totalValorSala1 = boletas.stream().filter(bol -> bol.getSala() == 1).collect(Collectors.summarizingInt(Boleta::getCosto));
                suma = (int) totalValorSala1.getSum();
                break;
            case 1:
                IntSummaryStatistics totalValorSala2 = boletas.stream().filter(bol -> bol.getSala() == 2).collect(Collectors.summarizingInt(Boleta::getCosto));
                suma = (int) totalValorSala2.getSum();
                break;
            case 2:
                IntSummaryStatistics totalValorSala3 = boletas.stream().filter(bol -> bol.getSala() == 3).collect(Collectors.summarizingInt(Boleta::getCosto));
                suma = (int) totalValorSala3.getSum();
                break;

        }
        return suma;
    }

    public int costoTotal() {
        IntSummaryStatistics totalValor = boletas.stream().collect(Collectors.summarizingInt(Boleta::getCosto));
        return (int) totalValor.getSum();
    }

    public void escribirArchivoDeTexto(String nombreArchivo) {
        try {
            FileWriter escritura = new FileWriter(nombreArchivo, true);
            escritura.write(texto + "\n");
            escritura.close();
            System.out.println("Texto ingresado correctamente");
        } catch (IOException e) {

        }
    }

    public void eliminarContenidoDelArchivoDeTexto(String nombreArchivo) {
        try {
            BufferedWriter borrar = new BufferedWriter(new FileWriter(nombreArchivo));
            borrar.write("");
            borrar.close();
            
        } catch (IOException e) {

        }
    }

    public String muestraContenido(String archivo) throws FileNotFoundException, IOException {
        String cadena;
        String newCadena = "";
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while ((cadena = b.readLine()) != null) {
            newCadena += cadena + "\n";
        }
        b.close();
        return newCadena;
    }
}
