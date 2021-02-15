  
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
public class Driver{
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
    public static void main(String[] args){
        GenerateFile();
        
    }
}