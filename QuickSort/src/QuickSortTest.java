
import java.util.InputMismatchException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kazunarikato
 */
import java.util.*;
import java.io.*;

public class QuickSortTest {
    public static void inputArrayListFromFile(String filename, ArrayList<Integer> arrayList) throws InputMismatchException, FileNotFoundException, Exception{
        File inputFileName = new File(filename);
        Scanner sc = new Scanner(inputFileName);
        int i = 0;
        while(sc.hasNext()){
            int num = sc.nextInt();
            arrayList.add(num);
            i++;
            if(i > 10000){
                throw new Exception("入力の数が10000を超えました");
            }
        }
        sc.close();
    }
    
    public static void outputArrayListConsole(ArrayList<Integer> arrayList){
        for(int i=0; i<arrayList.size(); i++){
            System.out.printf("%10d ", arrayList.get(i));
            if(i % 10 == 9){
                System.out.println();
            }
        }
        System.out.println();
    }
    
    public static void main(String[] args){
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        QuickSort qs = new QuickSort();
        try{
            if(args.length == 0){
                throw new Exception("コマンドライン引数が指定されていません。");
            }
            String filename = args[0];
            inputArrayListFromFile(filename, arrayList);
            outputArrayListConsole(arrayList);
            long start = System.currentTimeMillis();
            qs.sort(arrayList);
            long end = System.currentTimeMillis();
            System.out.println("================");
            outputArrayListConsole(arrayList);
            System.out.println("================");
            System.out.println("time="+(end-start)+"ms");
            
        }catch(FileNotFoundException ex){
            System.out.println("File is not found");
        }catch(InputMismatchException ex){
            System.out.println("Input is not mismatch");
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}
