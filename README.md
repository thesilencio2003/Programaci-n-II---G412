# Integrantes 
### William Villa
### Alejandro Ibarra
### Juan Pablo Rubiano
---

# Diagrama de clase Mermaid

```mermaid
classDiagram
    class libro {
        -String titulo
        -String autor
        -int numeroEjemplares
        -int numeroEjemplaresPrestados
        +libro()
        +libro(String titulo, String autor, int numeroEjemplares, int numeroEjemplaresPrestados)
        +String getTitulo()
        +void setTitulo(String titulo)
        +String getAutor()
        +void setAutor(String autor)
        +int getNumeroEjemplares()
        +void setNumeroEjemplares(int numeroEjemplares)
        +int getNumeroEjemplaresPrestados()
        +void setNumeroEjemplaresPrestados(int numeroEjemplaresPrestados)
        +boolean prestamo()
        +boolean devolucion()
        +void imprimirInformacion()
    }

    class LibroTexto {
        -String curso
        +LibroTexto()
        +LibroTexto(String titulo, String autor, int numeroEjemplares, int numeroEjemplaresPrestados, String curso)
        +String getCurso()
        +void setCurso(String curso)
        +void imprimirInformacion()
    }

    class LibroTextoUNIAC {
        -String facultad
        +LibroTextoUNIAC()
        +LibroTextoUNIAC(String titulo, String autor, int numeroEjemplares, int numeroEjemplaresPrestados, String curso, String facultad)
        +String getFacultad()
        +void setFacultad(String facultad)
        +void imprimirInformacion()
    }

    class Novela {
        -String tipo
        +Novela()
        +Novela(String titulo, String autor, int numeroEjemplares, int numeroEjemplaresPrestados, String tipo)
        +String getTipo()
        +void setTipo(String tipo)
        +void imprimirInformacion()
    }

    libro <|-- LibroTexto
    LibroTexto <|-- LibroTextoUNIAC
    libro <|-- Novela
```

---

## Situaciones en las que NO se podría realizar la herencia

### Situación 1 — Clase `libro` declarada como `final`

Si la clase `libro` fuera declarada con el modificador `final`, ninguna otra clase podría extenderla. Esto afectaría directamente a `LibroTexto` y `Novela`, que heredan de ella.

```java
public class libro {
    private String titulo;
    private String autor;
    // ...
}

// Si se declarara así, la herencia FALLARÍA:
public final class libro {  // ← modificador final impide ser extendida
    private String titulo;
    private String autor;
    // ...
}

// Error en tiempo de compilación:
public class LibroTexto extends libro { ... }
// ❌ Cannot inherit from final 'com.pooparcial.biblioteca.libro'
```

### Situación 2 — Constructor de `libro` con modificador de acceso `private`

Si el constructor de `libro` fuera `private`, las subclases como `LibroTexto` no podrían invocar `super(...)` para inicializar los atributos heredados, rompiendo la cadena de herencia.

```java
// Fragmento actual en LibroTexto que FUNCIONA:
public LibroTexto(String titulo, String autor, int numeroEjemplares,
                  int numeroEjemplaresPrestados, String curso) {
    super(titulo, autor, numeroEjemplares, numeroEjemplaresPrestados); // ✅ funciona
    this.curso = curso;
}

// Si el constructor de libro fuera privado:
private libro(String titulo, String autor, int numeroEjemplares,
              int numeroEjemplaresPrestados) { ... }

// La llamada super(...) en LibroTexto FALLARÍA:
// ❌ 'libro(String, String, int, int)' has private access in 'libro'
```

---

## Nuevos atributos y método adicional propuestos

### Dos nuevos atributos

| Atributo | Tipo | Descripción |
|---|---|---|
| `isbn` | `String` | Código ISBN único que identifica cada libro a nivel internacional. Tiene sentido en cualquier sistema de biblioteca real. |
| `anioPublicacion` | `int` | Año en que fue publicado el libro. Permite ordenar, filtrar y validar la vigencia del material. |

### Método adicional: `estaDisponible()`

Método que retorna `true` si hay al menos un ejemplar disponible para préstamo (es decir, si `numeroEjemplares - numeroEjemplaresPrestados > 0`).

```java
public boolean estaDisponible() {
    return (this.numeroEjemplares - this.numeroEjemplaresPrestados) > 0;
}
```

**Uso en `Main.java`:**
```java
if (libro1.estaDisponible()) {
    System.out.println("El libro está disponible para préstamo.");
} else {
    System.out.println("No hay ejemplares disponibles.");
}
```

Este método tiene sentido porque centraliza la lógica de disponibilidad en la propia clase, siguiendo el principio de encapsulamiento, y podría ser reutilizado por todas las subclases (`LibroTexto`, `LibroTextoUNIAC`, `Novela`) sin necesidad de sobreescribirlo.
