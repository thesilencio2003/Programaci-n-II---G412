package com.pooparcial.biblioteca;

public class libro {

    private String titulo;
    private String autor;
    private int numeroEjemplares;
    private int numeroEjemplaresPrestados;

    public libro(){}

    public libro(String titulo, String autor, int numeroEjemplares, int numeroEjemplaresPrestados) {
        this.titulo = titulo;
        this.autor = autor;
        this.numeroEjemplares = numeroEjemplares;
        this.numeroEjemplaresPrestados = numeroEjemplaresPrestados;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumeroEjemplares() {
        return numeroEjemplares;
    }

    public void setNumeroEjemplares(int numeroEjemplares) {
        this.numeroEjemplares = numeroEjemplares;
    }

    public int getNumeroEjemplaresPrestados() {
        return numeroEjemplaresPrestados;
    }

    public void setNumeroEjemplaresPrestados(int numeroEjemplaresPrestados) {
        this.numeroEjemplaresPrestados = numeroEjemplaresPrestados;
    }

    public boolean prestamo() {
        int disponibles = this.numeroEjemplares - this.numeroEjemplaresPrestados;

        if (disponibles > 0) {
            this.numeroEjemplaresPrestados++;
            System.out.println("Préstamo realizado con éxito. Libro: " + this.titulo);
            return true;
        } else if (disponibles == 0) {
            System.out.println("No hay ejemplares disponibles para prestar de '" + this.titulo + "'.");
            return false;
        } else {
            System.out.println("Error de consistencia: Se registran más prestados que el total de ejemplares.");
            return false;
        }
    }

    public boolean devolucion() {
        if (this.numeroEjemplaresPrestados > 0) {
            this.numeroEjemplaresPrestados--;
            System.out.println("Devolución realizada con éxito. Libro: " + this.titulo);
            return true;
        } else if (this.numeroEjemplaresPrestados == 0) {
            System.out.println("No es posible devolver: No hay ejemplares prestados actualmente de '" + this.titulo + "'.");
            return false;
        } else {
            System.out.println("Error de consistencia: El número de ejemplares prestados es negativo.");
            return false;
        }
    }

    public void imprimirInformacion() {
        System.out.println("Título: " + this.titulo);
        System.out.println("Autor: " + this.autor);
        System.out.println("Número de ejemplares: " + this.numeroEjemplares);
        System.out.println("Número de ejemplares prestados: " + this.numeroEjemplaresPrestados);
    }


}
