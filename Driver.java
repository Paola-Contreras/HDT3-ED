  
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
        GenerateFile();
        
        ArrayList<Integer> original = getNumbersArray();
        Sorts sorts = new Sorts();
        //Ordenamiento con GnomeSort
        ArrayList<Integer> gnomeSort =new ArrayList<Integer>(sorts.GnomeSort(original));
        
        
        //Ordenamiento con mergeSort
        int[] arr = new int[original.size()];
        for(int i =0 ; i<original.size();i++){
            arr[i] = original.get(i);
        }
        ArrayList<Integer> mergeSort = new ArrayList<Integer>(sorts.sort(arr,0,arr.length-1));

        
        //Muestra el array ya ordenado
        System.out.print(printArray(mergeSort));

        
    }
    
}