package com.example.mypackage;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    int[] newArray = {13, -2, 3, 4, 7, 8, 9, 11};
	    int[] newArray2 = {8, 9, 11, 13, -2, 3, 4, 7};
        int target = 11;
        for (int i = 1; i <= newArray2.length; i++) {
            int[] array2 = shiftArray(i, newArray2);
            boolean binarySearchResult =  binarySearch(array2, target);
            if (binarySearchResult) {
                System.out.println(Arrays.toString(array2));
                break;
            }
        }
    }

    public static int[] shiftArray(int number, int[] array) {
        int shifts = 0;
        while (shifts < number) {
            int first = array[0]; // Store first index
            int i = 1;
            for(; i < array.length; i++){
                array[i-1]=array[i];
            }
            array[i-1] = first;
            shifts++;
        }
        return array;
    }

    public static boolean binarySearch(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;
        int middle = end / 2;
        while (start <= end) {
            middle = (start + end) / 2;
            if (array[middle] > target) {
                end = middle - 1;
            } else if (array[middle] < target) {
                start = middle + 1;
            } else {
                System.out.println("The number was found, position=" + middle);
                return true;
            }
        }
        return false;
    }
}
