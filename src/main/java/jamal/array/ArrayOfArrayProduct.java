package jamal.array;

import java.util.Arrays;

public class ArrayOfArrayProduct {


    public static void main(String[] args) {
        ArrayOfArrayProduct arrayOfArrayProduct = new ArrayOfArrayProduct();
        System.out.println(Arrays.toString(arrayOfArrayProduct.processProduct(new int[]{2, 3, 4})));
    }

    private int[] processProduct(int[] array) {

        int size = array.length;


        if (size == 0 || size == 1) {
            return new int[0];
        }

        int[] productArray = new int[size];
        int product = 1;


        for (int i = 0; i < productArray.length; i++) {
            productArray[i] = product;
            product = product * array[i];
        }

        product = 1;

        for (int i = 0; i < productArray.length; i++) {
            productArray[i] = productArray[i] * product;
            product = product * array[i];
        }


        return productArray;
    }


}
