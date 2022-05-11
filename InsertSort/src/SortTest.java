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

public class SortTest {
    
    public static void inputLinkedListFromFile(String filename, LinkedList<Integer> linkedList) throws FileNotFoundException, Exception{
        int i=0;
        File inputFile = new File(filename);
        Scanner sc = new Scanner(inputFile);
        while(sc.hasNext()){
            int num = sc.nextInt();
            linkedList.add(num);
            i++;
            if(i>10000){
                throw new Exception("入力の数が10000を超えました");
            }
        }
        sc.close();
    }
    
    public static void inputArrayListFromFile(String filename, ArrayList<Integer> linkedList) throws FileNotFoundException, Exception{
        int i=0;
        File inputFile = new File(filename);
        Scanner sc = new Scanner(inputFile);
        while(sc.hasNext()){
            int num = sc.nextInt();
            linkedList.add(num);
            i++;
            if(i>10000){
                throw new Exception("入力の数が10000を超えました");
            }
        }
        sc.close();
    }
    
    
    
    public static void outputLinkedListtoConsole(List<Integer> linkedList){
        for(int i=0; i<linkedList.size(); i++){
            System.out.printf("%10d ", linkedList.get(i));
            if(i%10 == 9){
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("===================");
    }
    
    public static void main(String[] args){
        try{
            if(args.length == 0){
                throw new Exception("コマンドライン引数が設定されていません");
            }
            String filename = args[0];
            ArrayList<Integer> linkeList = new ArrayList<Integer>();
            InsertSort is = new InsertSort();
            inputArrayListFromFile(filename, linkeList);
            outputLinkedListtoConsole(linkeList);
            is.sortArray(linkeList);
            outputLinkedListtoConsole(linkeList);
            
            
        }catch(FileNotFoundException ex){
            System.out.println("そのようなファイルはありません");
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}
