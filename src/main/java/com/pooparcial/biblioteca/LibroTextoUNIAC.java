package com.pooparcial.biblioteca;

public class LibroTextoUNIAC extends LibroTexto {

    private String facultad;

    public LibroTextoUNIAC() {
        super();
        this.facultad = "";
    }

    public LibroTextoUNIAC(String titulo, String autor, int numeroEjemplares,
                           int numeroEjemplaresPrestados, String curso, String facultad) {

        super(titulo, autor, numeroEjemplares, numeroEjemplaresPrestados, curso);
        this.facultad = facultad;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    @Override
    public void imprimirInformacion() {
        super.imprimirInformacion();
        System.out.println("Facultad: " + this.facultad);
    }
}