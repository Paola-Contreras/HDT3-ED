  
/*******************************************************************************************************************
    Universidad del Valle de Guatemala 
    Estructura de Datos 
    Moises Alonzo 
    Pablo Emanuel Escobar Sandoval 20936
    Gabriela Paola Contreras Guerra  20213 
    Guetemala: 14/02/2021
********************************************************************************************************************/
public class Sorts{
    public Comparable[] GnomeSort(Comparable[] arr){
        int index = 0; 
  
        while (index < arr.length) { 
            if (index == 0) 
                index++; 
            if (arr[index].compareTo(arr[index - 1])==1) 
                index++; 
            else { 
                Comparable temp = 0; 
                temp = arr[index]; 
                arr[index] = arr[index - 1]; 
                arr[index - 1] = temp; 
                index--; 
            } 
        }
        return arr;
    }

    /*public Comparable[] mergeSort(Comparable[] array){
        if (array.length < 2) {
            return;
        }
        int mid = array.length / 2;
        int[] l = new int[mid];
        int[] r = new int[array.length - mid];
    
        for (int i = 0; i < mid; i++) {
            l[i] = array[i];
        }
        for (int i = mid; i < array.length; i++) {
            r[i - mid] = array[i];
        }
        mergeSort(l, mid);
        mergeSort(r, array.length - mid);
        merge(array, l, r, mid, array.length - mid);
    }
    public static void merge(Comparable[] a, Comparable[] l, Comparable[] r, int left, int right) {
 
    int i = 0, j = 0, k = 0;
    while (i < left && j < right) {
        if (l[i] <= r[j]) {
            a[k++] = l[i++];
        }
        else {
            a[k++] = r[j++];
        }
    }
    while (i < left) {
        a[k++] = l[i++];
    }
    while (j < right) {
        a[k++] = r[j++];
    }
} */

}