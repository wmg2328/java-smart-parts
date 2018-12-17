package com.wmg.smartjava.misc;

public class SubsetSum {

    public static void main(String[] args) {

        int[] array = new int[]{71, 2, 5, 6, 3, 8};
        int sum = 911;

        boolean validity = checkValidity(array, array.length, sum);
        System.out.println(validity);
    }

    private static boolean checkValidity(int[] array, int n, int sum) {

        if (sum == 0) {
            return true;
        }

        if (n == 0) {
            return false;
        }

        if (array[n - 1] > sum) {
            return checkValidity(array, n - 1, sum);
        }

        boolean a = checkValidity(array, n - 1, sum);
        boolean b = checkValidity(array, n - 1, sum - array[n - 1]);

        return a || b;
    }
}
