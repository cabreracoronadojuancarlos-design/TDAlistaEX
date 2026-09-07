import java.util.Objects;

public class ListaEnlazada<T> implements Lista<T> {

    private static class Nodo<T> {
        T dato;
        Nodo<T> siguiente;

        Nodo(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    private Nodo<T> cabeza;
    private int tamano;

    public ListaEnlazada() {
        this.cabeza = null;
        this.tamano = 0;
    }

    @Override
    public void agregar(T elemento) {
        insertar(tamano, elemento);
    }

    @Override
    public void insertar(int indice, T elemento) {
        validarIndiceInsercion(indice);

        Nodo<T> nuevo = new Nodo<>(elemento);

        if (indice == 0) {
            nuevo.siguiente = cabeza;
            cabeza = nuevo;
        } else {
            Nodo<T> anterior = obtenerNodo(indice - 1);
            nuevo.siguiente = anterior.siguiente;
            anterior.siguiente = nuevo;
        }
        tamano++;
    }

    @Override
    public T obtener(int indice) {
        validarIndiceAcceso(indice);
        return obtenerNodo(indice).dato;
    }

    @Override
    public T eliminar(int indice) {
        validarIndiceAcceso(indice);

        T datoEliminado;
        if (indice == 0) {
            datoEliminado = cabeza.dato;
            cabeza = cabeza.siguiente;
        } else {
            Nodo<T> anterior = obtenerNodo(indice - 1);
            Nodo<T> objetivo = anterior.siguiente;
            datoEliminado = objetivo.dato;
            anterior.siguiente = objetivo.siguiente;
        }
        tamano--;
        return datoEliminado;
    }

    @Override
    public boolean eliminarElemento(T elemento) {
        if (estaVacia()) {
            return false;
        }

        if (Objects.equals(cabeza.dato, elemento)) {
            cabeza = cabeza.siguiente;
            tamano--;
            return true;
        }

        Nodo<T> actual = cabeza;
        while (actual.siguiente != null && !Objects.equals(actual.siguiente.dato, elemento)) {
            actual = actual.siguiente;
        }

        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
            tamano--;
            return true;
        }
        return false;
    }

    @Override
    public boolean contiene(T elemento) {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            if (Objects.equals(actual.dato, elemento)) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    @Override
    public int tamano() {
        return tamano;
    }

    @Override
    public boolean estaVacia() {
        return tamano == 0;
    }

    @Override
    public void limpiar() {
        cabeza = null;
        tamano = 0;
    }

    @Override
    public String toString() {
        if (estaVacia()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        Nodo<T> actual = cabeza;
        while (actual != null) {
            sb.append(actual.dato);
            if (actual.siguiente != null) {
                sb.append(" -> ");
            }
            actual = actual.siguiente;
        }
        sb.append("]");
        return sb.toString();
    }

    private Nodo<T> obtenerNodo(int indice) {
        Nodo<T> actual = cabeza;
        for (int i = 0; i < indice; i++) {
            actual = actual.siguiente;
        }
        return actual;
    }

    private void validarIndiceAcceso(int indice) {
        if (indice < 0 || indice >= tamano) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + indice + " (Tamaño: " + tamano + ")");
        }
    }

    private void validarIndiceInsercion(int indice) {
        if (indice < 0 || indice > tamano) {
            throw new IndexOutOfBoundsException("Índice de inserción inválido: " + indice + " (Tamaño: " + tamano + ")");
        }
    }
}