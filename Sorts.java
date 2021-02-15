  
/*******************************************************************************************************************
    Universidad del Valle de Guatemala 
    Estructura de Datos 
    Moises Alonzo 
    Pablo Emanuel Escobar Sandoval 20936
    Gabriela Paola Contreras Guerra  20213 
    Guetemala: 14/02/2021
********************************************************************************************************************/
import java.util.ArrayList;
public class Sorts{
    public Sorts(){

    }
    /**
     *  Sort that shows the data using the gnomeSort
     * @param arr array that contains the numbers 
     * @return throw back the data in order
     */
    public Comparable[] GnomeSort(Comparable[] arr){
        int n = arr.length-1;
        for(int index = 1; index < n;){
            if(index == 1){
                index++;
            }
            if(arr[index].compareTo(arr[index - 1]) >= 0){
                index++;
            } else{
                Comparable temp;
                temp = arr[index];
                arr[index] = arr[index-1];
                arr[index -1] = temp;
                index--;
            }
        }
        return arr;
    }

    //Part of the mergeSort
    void merge(Comparable arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        /* Create temp arrays */
        Comparable L[] = new Comparable[n1];
        Comparable R[] = new Comparable[n2];
 
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
 
        /* Merge the temp arrays */
 
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i].compareTo(R[j])<0) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
 
    /**
     *  Sort that shows the data using the mergesort
     * @param arr array that contains the numbers 
     * @param l represent the index of the left part of the array 
     * @param r represent the index of the right part of the array
     * @return throw back the data in order
     */
    public Comparable[] sort(Comparable arr[], int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;
 
            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);
 
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
       
        return arr;
    }

    public Comparable [] QuickSort (Comparable [] arr){

        return arr;
    }
    
    public Comparable [] RadixSort (Comparable[] arr){
    
        return arr;
    }
    
    /**
     *  Sort that shows the data using the bubble sort
     * @param arr array that contains the numbers 
     * @return throw back the file data in order
     */
    public Comparable[] BubbleSort(Comparable[]arr){
        for (int i = 0; i < arr.length; i++){
            for (int j =0; j< arr.length;j++){
                if (arr[j].compareTo(arr[i])<0){
                    Comparable temp = arr[i];
                    arr[i]= arr[j];
                    arr[j] = temp;
                }
            }
    
        }
    
        return arr; 
    }

}