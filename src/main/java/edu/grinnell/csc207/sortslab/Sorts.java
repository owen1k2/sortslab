package edu.grinnell.csc207.sortslab;
import java.util.*;
/**
 * A collection of sorting algorithms over generic arrays.
 */
public class Sorts {

    public static int binarySearch(int value, int[] arr, int lo, int hi) {
        int i = lo + (hi - lo) / 2;
        while(arr[i] != value) {
            if(hi <= lo) {
                return -1;
            } else if(arr[i] > value) {
                lo = i;
                i = (hi - i) / 2;
            } else if(arr[i] < value) {
                hi = i;
                i = (i - lo) / 2;
            }
        }
        return i;
    }
    /**
     * Swaps indices <code>i</code> and <code>j</code> of array <code>arr</code>.
     * @param <T> the carrier type of the array
     * @param arr the array to swap
     * @param i the first index to swap
     * @param j the second index to swap
     */
    public static <T> void swap(T[] arr, int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * Sorts the array according to the bubble sort algorithm:
     * <pre>
     * [ unprocessed | i largest elements in order ]
     * </pre>
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     */
    public static <T extends Comparable<? super T>> void bubbleSort(T[] arr) {
        for(int i = arr.length - 1; i > 0; i--) {
            for(int j = arr.length - 1; j > 0; j--) {
               if(arr[j].compareTo(arr[j-1]) < 0) {
                swap(arr, j-1, j);
               } 
            }
        }
    }

    /**
     * Sorts the array according to the selection sort algorithm:
     * <pre>
     * [ i smallest elements in order | unprocessed ]
     * </pre>
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     */
    public static <T extends Comparable<? super T>> void selectionSort(T[] arr) {
        for(int i = 0; i < arr.length; i++){
            T min = arr[i];
            int index = i;
            for(int j = i; j < arr.length; j++){
                if(min.compareTo(arr[j]) > 0){
                    min = arr[j];
                    index = j;
                }
            }
            swap(arr, i, index);
        }
    }

    /**
     * Sorts the array according to the insertion sort algorithm:
     * <pre>
     * [ i elements in order | unprocessed ] 
     * </pre>
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     */
    public static <T extends Comparable<? super T>> void insertionSort(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int j = i + 1;
            while (j > 0 && arr[j].compareTo(arr[j - 1]) < 0) {
                swap(arr, j, j - 1);
                j--;
            }
        }
    }

    public static <T extends Comparable<? super T>> void mergeSortHelper(T[] arr, int lo, int hi) {
        int mid = lo + (hi - lo) / 2;
        if(lo < hi - 1) {
            mergeSortHelper(arr, lo, mid);
            mergeSortHelper(arr, mid, hi);
        }
        for(int i = lo; i < hi; i++) {
            for(int j = lo; j < hi; j++) {
               if(arr[j].compareTo(arr[j+1]) < 0) {
                swap(arr, j, j + 1);
                System.out.println(arr[i]);
                System.out.println(arr[j]);
               } 
            }
        }
    }
     /**
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     */
    public static <T extends Comparable<? super T>> void mergeSort(T[] arr) {
        int lo = 0;
        int hi = arr.length - 1;
        mergeSortHelper(arr, lo, hi);
    }

    /**
     * Sorts the array according to the quick sort algorithm:
     * <pre>
     * []
     * </pre>
     * @param <T>
     * @param arr
     */
    public static <T extends Comparable<? super T>> void quickSort(T[] arr) {
        T pivot = arr[arr.length - 1];
        for(int i = 0; i < arr.length - 1; i++) {
          //  if(arr[i] < pivot) {

          //  }
        }
    }
}
