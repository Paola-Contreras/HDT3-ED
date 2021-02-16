  
/*******************************************************************************************************************
    Universidad del Valle de Guatemala 
    Estructura de Datos 
    Moises Alonzo 
    @author Pablo Emanuel Escobar Sandoval 20936
    @author Gabriela Paola Contreras Guerra  20213 
    Guetemala: 14/02/2021
********************************************************************************************************************/
import java.util.ArrayList;
import java.util.*; 
public class Sorts{
    public Sorts(){

    }

//                                                  GNOMESORT
    /********************************************************************************************************************/
    /**
     *  Sort that shows the data using the gnomeSort
     * @param arr array that contains the numbers 
     * @return throw back the data in order
     * 
     * Reference: https://www.geeksforgeeks.org/gnome-sort-a-stupid-one/
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
    /********************************************************************************************************************/



//                                                  MERGESORT
    /********************************************************************************************************************/
    /**
     *  Part of the mergeSort
     * @param arr array that contains the numbers 
     * @param l int to identify the left index 
     * @param m int to identify the middle of the index
     * @param r int to identify the right index 
     * @return throw back the data in order
     **/
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
     * 
     * Reference: https://www.geeksforgeeks.org/merge-sort/
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
    /********************************************************************************************************************/



//                                                  QUICKSORT
    /********************************************************************************************************************/
      /**
     *  Part of the quicksort
     * @param arr array that contains the numbers 
     * @param low identify the starting index
     * @param high identify the ending index
     * @return throw back the the index of the middle element
     **/
    public int partition(Integer arr[], int low, int high) 
    { 
        Integer pivot = arr[high];  
        int i = (low-1); // index of smaller element 
        for (int j=low; j<high; j++) 
        { 
            // If current element is smaller than or 
            // equal to pivot 
            if (arr[j].compareTo(pivot)<0) 
            { 
                i++; 
  
                // swap arr[i] and arr[j] 
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
  
        // swap arr[i+1] and arr[high] (or pivot) 
        int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1; 
    } 
  
  
    /* The main function that implements QuickSort() 
      arr[] --> Array to be sorted, 
      low  --> Starting index, 
      high  --> Ending index */
    /**
     *  The main function that implements QuickSort() 
     * @param arr Array to be sorted
     * @param low Starting index
     * @param high Ending index
     * @return throw back the the index of the middle element
     * 
     * reference: https://www.geeksforgeeks.org/java-program-for-quicksort/
     **/  
    public Comparable[] QuickSort(Comparable arr[], int low, int high) 
    {
        Integer[] nums = new Integer[arr.length];
        int cont =0;
        for(Comparable a : arr){
            nums[cont++] = (Integer) a;
        } 
        if (low < high) 
        { 
            /* pi is partitioning index, arr[pi] is  
              now at right place */
            int pi = partition(nums, low, high); 
  
            // Recursively sort elements before 
            // partition and after partition 
            QuickSort(arr, low, pi-1); 
            QuickSort(arr, pi+1, high); 
        }
        return arr; 
    }
    
    /********************************************************************************************************************/
    
//                                                  BUBBLESORT
    /********************************************************************************************************************/
    /**
     *  Sort that shows the data using the bubble sort
     * @param arr array that contains the numbers 
     * @return throw back the file data in order
     * 
     * reference: https://www.geeksforgeeks.org/bubble-sort/
     */
    public Comparable[] BubbleSort(Comparable[]arr){
        for (int i = 0; i < arr.length; i++){
            for (int j =0; j< arr.length;j++){
                if (arr[j].compareTo(arr[i])>0){
                    Comparable temp = arr[i];
                    arr[i]= arr[j];
                    arr[j] = temp;
                }
            }
    
        }
    
        return arr; 
    }
    /********************************************************************************************************************/

//                                                  RADIXSORT
    /********************************************************************************************************************/
    /**
     *  
     * @param arr array that contains the numbers 
     * @param n size of the array
     * @return throw back the maximum number to know number of digits
     */
    public int getMax(Integer arr[], int n) 
    { 
        int mx = arr[0]; 
        for (int i = 1; i < n; i++) 
            if (arr[i].compareTo(mx)>0) 
                mx = arr[i]; 
        return mx; 
    } 
  
    // 
     /**
     *  A function to do counting sort of arr[] according to the digit represented by exp. 
     * @param arr array that contains the numbers 
     * @param n size of the array
     * @param exp digit to sort of arr[] according to his value
     */
    public void countSort(Integer arr[], int n, int exp) 
    { 
        Integer output[] = new Integer[n]; // output array 
        Integer i; 
        Integer count[] = new Integer[10]; 
        Arrays.fill(count, 0); 
  
        // Store count of occurrences in count[] 
        for (i = 0; i < n; i++) 
            count[(arr[i] / exp) % 10]++; 
  
        // Change count[i] so that count[i] now contains 
        // actual position of this digit in output[] 
        for (i = 1; i < 10; i++) 
            count[i] += count[i - 1]; 
  
        // Build the output array 
        for (i = n - 1; i >= 0; i--) { 
            output[count[(arr[i] / exp) % 10] - 1] = arr[i]; 
            count[(arr[i] / exp) % 10]--; 
        } 
  
        // Copy the output array to arr[], so that arr[] now 
        // contains sorted numbers according to curent digit 
        for (i = 0; i < n; i++) 
            arr[i] = output[i]; 
    } 
  
    // The main function to that sorts arr[] of size n using 
    // Radix Sort 
    /**
     * @param arr array of numbers
     * @param n size of the array
     * @return array sorted
     *Reference:  https://www.geeksforgeeks.org/radix-sort/
     */
    public Comparable[] radixsort(Comparable arr[], int n) 
    { 
        Integer[] nums = new Integer[n];
        int cont =0;
        for(Comparable a : arr){
            nums[cont++] = (Integer) a;
        }
        // Find the maximum number to know number of digits 
        int m = getMax(nums, n); 
  
        // Do counting sort for every digit. Note that 
        // instead of passing digit number, exp is passed. 
        // exp is 10^i where i is current digit number 
        for (int exp = 1; m / exp > 0; exp *= 10) 
            countSort(nums, n, exp); 
        return arr;
    }
    /********************************************************************************************************************/





}