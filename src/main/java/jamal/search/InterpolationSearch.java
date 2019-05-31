package jamal.search;

import java.util.concurrent.ThreadLocalRandom;

public class InterpolationSearch {

    static int constant = 1000000;
    private int[] array;

    public InterpolationSearch(int capacity) {
        this.array = new int[capacity];
    }

    public static void main(String[] args) {
        InterpolationSearch interpolationSearch = new InterpolationSearch(constant);
        for (int i = 0; i < constant; i++) {
            interpolationSearch.array[i] = i;
        }

        for (int i = 0; i < constant; i++) {
            int value = interpolationSearch.usingThreadLocalClass();
            System.out.println(interpolationSearch.interpolationSearch(value));
        }

    }

    public int usingThreadLocalClass() {
        return ThreadLocalRandom.current().nextInt(0, constant);
    }

    public int interpolationSearch(int num) {
        int low = 0;
        int high = array.length - 1;
        int pivot;

        int counter = 0;

        while (array[low] != array[high] && num >= array[low] && num <= array[high]) {
//            counter++;

            int a = (num - array[low]);
            int b = high - low;
            int c = a * b;
            int d = array[high] - array[low];
            pivot = low + (c / d);

            if (array[pivot] < num) {
                low = pivot + 1;
            } else if (num < array[pivot]) {
                high = pivot - 1;
            } else {
                return pivot;
            }


//            System.out.println("Number of comparision " + counter);
        }
        if (array[low] == num) {
            return low;
        }

        return -1;
    }

}
