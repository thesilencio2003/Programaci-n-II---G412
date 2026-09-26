package com.pooparcial;

import java.util.Scanner;

import com.pooparcial.biblioteca.libro;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Creando libro1 con constructor con parámetros ===");
        libro libro1 = new libro("Lobo estepario", "Hermann Hesse", 5, 2);
        
        libro1.imprimirInformacion();
        System.out.println();

        System.out.println("=== Creando libro2 con constructor por defecto ===");
        libro libro2 = new libro();

        System.out.print("Ingrese el título del libro: ");
        String titulo = scanner.nextLine();
        libro2.setTitulo(titulo);

        System.out.print("Ingrese el autor del libro: ");
        String autor = scanner.nextLine();
        libro2.setAutor(autor);

        System.out.print("Ingrese el numero total de ejemplares: ");
        int numeroEjemplares = scanner.nextInt();
        libro2.setNumeroEjemplares(numeroEjemplares);

        System.out.print("Ingrese el numero de ejemplares prestados: ");
        int numeroEjemplaresPrestados = scanner.nextInt();
        libro2.setNumeroEjemplaresPrestados(numeroEjemplaresPrestados);

        System.out.println("\n=== Informacion registrada para libro2 ===");
        libro2.imprimirInformacion();

        System.out.println("\n=== Probando operaciones en libro2 ===");
        libro2.prestamo();
        libro2.devolucion();
    }
}