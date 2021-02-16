/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package pruebas;


//NETBEANS
import java.util.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author USUARIO FINAL
 */
public class SortsIT {
    
    public SortsIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    public Comparable[] generateRandom(){
        Random rand = new Random();
        Comparable[] nums = new Comparable[3000];
        for(int i=0; i<3000;i++){
            nums[i] =(Integer) rand.nextInt(9000);
        }
        return nums;
    }
    public Comparable[] sortedNums(Comparable[] arr){
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
    /**
     * Test of GnomeSort method, of class Sorts.
     */
    @Test
    public void testGnomeSort() {
        
        System.out.println("GnomeSort");
        Comparable[] arr = generateRandom();
        Sorts instance = new Sorts();
        Comparable[] expResult = sortedNums(arr);
        Comparable[] result = instance.GnomeSort(arr);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of merge method, of class Sorts.
     */
   

    /**
     * Test of sort method, of class Sorts.
     */
    @Test
    public void testSort() {
        System.out.println("sort");
        Comparable[] arr = generateRandom();
        int l = 0;
        int r = arr.length-1;
        Sorts instance = new Sorts();
        Comparable[] expResult = sortedNums(arr);
        Comparable[] result = instance.sort(arr, l, r);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of partition method, of class Sorts.
     */
  

    /**
     * Test of QuickSort method, of class Sorts.
     */
    @Test
    public void testQuickSort() {
        System.out.println("QuickSort");
        Comparable[] arr = generateRandom();
        int low = 0;
        int high = arr.length-1;
        Sorts instance = new Sorts();
        Comparable[] expResult = sortedNums(arr);
        Comparable[] result = instance.QuickSort(arr, low, high);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of BubbleSort method, of class Sorts.
     */
    @Test
    public void testBubbleSort() {
        System.out.println("BubbleSort");
        Comparable[] arr = generateRandom();
        Sorts instance = new Sorts();
        Comparable[] expResult = sortedNums(arr);
        Comparable[] result = instance.BubbleSort(arr);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getMax method, of class Sorts.
     */
  

    /**
     * Test of radixsort method, of class Sorts.
     */
    @Test
    public void testRadixsort() {
        System.out.println("radixsort");
        Comparable[] arr = generateRandom();
        int n = arr.length;
        Sorts instance = new Sorts();
        Comparable[] expResult = sortedNums(arr);
        Comparable[] result = instance.radixsort(arr, n);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
