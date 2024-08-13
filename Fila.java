public class Fila<T> {
    private int top = -1;
    private int base = 0;
    private T[] data;

    public Fila(int tamanho) {
        data = (T[]) new Object[tamanho];
    }

    public void add(T item) {
        if (isFull()) {
            throw new IllegalStateException("A fila está cheia.");
        }
        data[++top] = item;
    }

    public T remove() {
        if (isEmpty()) {
            throw new IllegalStateException("A fila está vazia.");
        }
        T item = data[base];
        
        for (int i = 0; i < top; i++) {
            data[i] = data[i + 1];
        }
        data[top] = null; 
        top--;
        return item;
    }

    public void clear() {
        for (int i = 0; i <= top; i++) {
            data[i] = null;
        }
        top = -1;
    }

    public boolean isFull() {
        return top == data.length - 1;
    }

    public boolean isEmpty() {
        return top < base;
    }

    public static void main(String[] args) {
        Fila<Integer> fila = new Fila<>(5);
        fila.add(1);
        fila.add(2);
        fila.add(3);
        System.out.println(fila.remove()); 
        fila.add(4);
        fila.add(5);
        fila.add(6); 
        System.out.println(fila.isFull());
        fila.clear();
        System.out.println(fila.isEmpty()); 
    }
}
