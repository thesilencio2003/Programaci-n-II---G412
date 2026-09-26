package com.pooparcial.biblioteca;

public class LibroTexto extends libro {
    private String curso;

    public LibroTexto() {
        super();
        this.curso = "";
    }

    public LibroTexto(String titulo, String autor, int numeroEjemplares, int numeroEjemplaresPrestados, String curso) {
        super(titulo, autor, numeroEjemplares, numeroEjemplaresPrestados);
        this.curso = curso;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public void imprimirInformacion() {
        super.imprimirInformacion();
        System.out.println("Curso: " + this.curso);
    }
}