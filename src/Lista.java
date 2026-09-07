public interface Lista<T> {
    void agregar(T elemento);
    void insertar(int indice, T elemento);
    T obtener(int indice);
    T eliminar(int indice);
    boolean eliminarElemento(T elemento);
    boolean contiene(T elemento);
    int tamano();
    boolean estaVacia();
    void limpiar();
}