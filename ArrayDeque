import java.util.Comparator;
import java.util.Iterator;

public class ArrayDeque <T> implements Iterable<T>{
    public T[] items;
    public int size;
    public int nextFirst;
    public int nextLast;


   // add iterator method, equals method, and tostring method


    public ArrayDeque(){
        items = (T[]) new Object[16];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }


    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    //Returns the number of items in the deque.
    public int size() {
        return size;
    }

    // Adds an item of type T to the back of the deque.
    public void addLast(T item) {
        items[nextLast] = item;
        nextLast = (nextLast + 1) % items.length;
        size++;
    }

    // Adds an item of type T to the front of the deque
    public void addFirst(T item) {
        items[nextFirst] = item;
        nextFirst = (nextFirst - 1 + items.length) % items.length;
        size++;
    }

    // Removes and returns the item at the front of the deque. If no such item exists, returns null.
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        nextFirst = (nextFirst + 1) % items.length;
        T removedItem = items[nextFirst];
        items[nextFirst] = null;
        size--;
        return removedItem;
    }

    //Removes and returns the item at the back of the deque. If no such item exists, returns null
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        nextLast = (nextLast - 1 + items.length) % items.length;
        T removedItem = items[nextLast];
        items[nextLast] = null;
        size--;
        return removedItem;
    }

    public T get(int i) {
        if (i >= size){
            System.out.println("Outta bounds");
        }
        return items[i];
    }

    public T getLast() {
        return items[size-1];
    }

    //  Returns true if deque is empty, false otherwise.
    public boolean isEmpty() {
        return size == 0;
    }

    //Prints the items in the deque from first to last,
    // separated by a space. Once all the items have been printed, print out a new line.
    public void printDeque() {
        int index = (nextFirst + 1) % items.length;
        for (int i = 0; i < size; i++) {
            System.out.print(items[index] + " ");
            index = (index + 1) % items.length;
        }
        System.out.println();
    }

//        private void resize(T cap) {
//        T[] a = new Object[cap];
//        System.arraycopy(items, 0,a,0,size);
//        items = a;
//    }

    public boolean contains(T value) {
        for (int i = 0; i < size; i++) {
            if (items[i].equals(value)) {
                return true;
            }
        }
        return false;
    }


    private class ArrayDequeIterator implements Iterator<T> {
        int pos;
        public ArrayDequeIterator() {
            pos = 0;
        }
        public boolean hasNext() {
            return pos < size;
        }
        public T next() {
            T item = items[(nextFirst + 1 + pos) % items.length];
            pos ++;
            return item;
        }
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Iterator<T> iterator = iterator();
        while (iterator.hasNext()) {
            result.append(iterator.next());
            if (iterator.hasNext()) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }


    @Override
    public boolean equals(Object object) {
        if (object instanceof ArrayDeque o) {
            if (size() != o.size()) {
                return false;
            }
            for (T item : this) {
                if (!o.contains(item)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }



    public static void main(String[] args) {
        Comparator<Integer> sc = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        };

        MaxArrayDeque<Integer> deque1 = new MaxArrayDeque<>(sc);
        deque1.addFirst(3);
        deque1.addFirst(2);
//        deque1.addFirst(1);
//        deque1.addLast(4);
//        deque1.addFirst(7);
//        deque1.addFirst(1);

        ArrayDeque<Integer> deque2 = new ArrayDeque<>();
        deque2.addLast(1);
        deque2.addLast(2);
        deque2.addLast(3);

        System.out.println(deque1.equals(deque2));

        System.out.println(deque1);
    }
}
