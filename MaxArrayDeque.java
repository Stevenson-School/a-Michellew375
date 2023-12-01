import java.util.Comparator;
import java.util.Iterator;

public class MaxArrayDeque <T> extends ArrayDeque<T>{
    private Comparator<T> comparator;

    public MaxArrayDeque() {
        super();
    }

    public MaxArrayDeque(Comparator<T> c) {
        comparator = c;
    }
    // returns the maximum element in the deque as governed by the previously given Comparator. If the MaxArrayDeque is empty, simply return null.

    public T max() {
        T max = items[nextFirst + 1];
        for (int i = 0; i < size(); i++) {
            if (comparator.compare(get(i), max) > 0) {
                max = get(i);
            }
        }
        return max;
    }


    // returns the maximum element in the deque as governed by the parameter Comparator c. If the MaxArrayDeque is empty, simply return null.
    public T max(Comparator<T> c) {
        T max = items[nextFirst + 1];
        for (int i = 0; i < size(); i++) {
            if (c.compare(get(i), max) > 0) {
                max = get(i);
            }
        }
        return max;
    }



    public static void main(String[] args) {

        Comparator <String> sc = new Comparator<String>() {
            public int compare (String o1, String o2) {
                return (o1.length() - o2.length());
            }
        };


        MaxArrayDeque<Integer> deque1 = new MaxArrayDeque<>();
        deque1.addFirst(3);
        deque1.addFirst(2);
//        deque1.addFirst(1);
//        deque1.addLast(4//);
//        deque1.addFirst(7);
//        deque1.addFirst(1);

        MaxArrayDeque<Integer> deque2 = new MaxArrayDeque<>();
        deque2.addLast(1);
        deque2.addLast(2);
        deque2.addLast(3);

        System.out.println(deque1.equals(deque2));
        System.out.println(deque1);
        System.out.println(deque1.max());
    }
}



