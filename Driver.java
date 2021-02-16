  
/*******************************************************************************************************************
    Universidad del Valle de Guatemala 
    Estructura de Datos 
    Moises Alonzo 
    Pablo Emanuel Escobar Sandoval 20936
    Gabriela Paola Contreras Guerra  20213 
    Guetemala: 14/02/2021
********************************************************************************************************************/
import java.util.*;
import java.io.*;   
import java.util.ArrayList;

public class Driver{
     /**
     * Random number generation 
     * @return String of numbers 
     */

    public static String generateNumbers(){
        String result="";
        Random rand = new Random();
        int cant = rand.nextInt((3000 - 10) + 1) + 10;
        for(int i = 0; i<cant; i++){
            result+=rand.nextInt(9000)+",";
        }
        result = result.substring(0,result.length()-1);
        return result;
    }

    /**
     * This method creates a new file and writes the random numbers generated previously 
     * @throws Exception If issue occuer
     */
    public static void GenerateFile(){
        File archivo= new File("Numbers.txt");
        FileWriter fw;
        PrintWriter pr;
        if(!archivo.exists()){
            try {
                fw = new FileWriter(archivo,true);
                pr = new PrintWriter(fw);
                pr.write(generateNumbers());
                pr.close();
                fw.close();
            } catch (Exception e) {
                //TODO: handle exception
                System.out.println(e.getMessage());
            }
        }else{
            try{
                fw = new FileWriter(archivo,false);
                pr = new PrintWriter(fw);
                pr.write(generateNumbers());
                pr.close();
                fw.close();
             }
             catch(Exception e){
                 System.out.println(e.getMessage());
                 
             }
        }
    }
/**
     * This method format the numbers of the txt file to an ArrayList
     * @return array of numbers
     * @throws Exception If issue occuer
     */
    public static ArrayList<Integer> getNumbersArray(){
        ArrayList<Integer> array = new ArrayList<Integer>();
        try {
            File myObj = new File("Numbers.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              String[] nums = data.split(",");
              for(String num : nums){
                array.add(Integer.parseInt(num));
              }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return array;
    }
/**
     * This method format an array into a String
     * @param a arrayList of the numbers
     * @return the array as string
     */
    public static String printArray(ArrayList<Integer> a){
      String result = "";
        for(Integer num : a){
            result += num+", ";
      }
      return result;
    }
    public static void main(String[] args){
        //Generate the file with the random numbers 
        GenerateFile();
        
        //get the numbers and format them to an Integer array
        ArrayList<Integer> original = getNumbersArray();
        Sorts sorts = new Sorts();
        Integer[] arr = new Integer[original.size()];
        for(int i =0 ; i<original.size();i++){
            arr[i] = new Integer(original.get(i));
        }
        
        
       //Sorting using gnomeSort
        ArrayList<Integer> gnomeSort =new ArrayList<Integer>();
        Comparable[] a = sorts.GnomeSort(arr);
        for(Comparable num: a){
            gnomeSort.add((Integer) num);
        }
        //Show the array sorted
        //System.out.print(printArray(gnomeSort));
        


        //Sorting using mergeSort
        Comparable[] numeros = sorts.sort(arr,0,arr.length-1);
        ArrayList<Integer> mergeSort = new ArrayList<Integer>();
        for(Comparable num2: numeros){
            mergeSort.add((Integer) num2);
        }
        //Show the array sorted
        //System.out.print(printArray(mergeSort));
        
        
        //Sorting using bubbleSort
        Comparable[] b = sorts.BubbleSort(arr);
        ArrayList<Integer> bubbleSort = new ArrayList<Integer>();
        for(Comparable num2: b){
            bubbleSort.add((Integer) num2);
        }
        //Show the array sorted
        //System.out.print(printArray(bubbleSort));
        

        //Sorting using bubbleSort
        Comparable[] c = sorts.QuickSort(arr,0,arr.length-1);
        ArrayList<Integer> quickSort = new ArrayList<Integer>();
        for(Comparable num3: c){
            quickSort.add((Integer) num3);
        }
        //Show the array sorted
        System.out.print(printArray(quickSort));


        Comparable[] r = sorts.RadixSort(arr);
        ArrayList<Integer> radixSort = new ArrayList<Integer>();
        for(Comparable num2: r){
            radixSort.add((Integer) num2);
        }

        //System.out.print(printArray(radixSort));
    }
    
}