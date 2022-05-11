/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.util.*;

/**
 *
 * @author kazunarikato
 */
public class SortTest {
    private static void inputArrayListFromFile(String filename, ArrayList<Integer> arrayList)
        throws FileNotFoundException, InputMismatchException, Exception{
            File inputFile = new File(filename);
            Scanner sc = new Scanner(inputFile);
            int i=0;
            while(sc.hasNext()){
                int buf = sc.nextInt();
                arrayList.add(buf);
                i++;
                if(i>10000){
                    throw new Exception("データの個数を10000以下にしてください。");
                }
            }
            sc.close();
    }
    
    private static void outputArrayListToConsole(ArrayList<Integer> arrayList){
        for(int i=0; i<arrayList.size(); i++){
            System.out.printf("%10d ", arrayList.get(i));
            if(i % 10 == 9){
                System.out.println();
            }
        }
    }
    
    public static void main(String[] arg){
        ArrayList arrayList = new ArrayList<Integer>();
        BubbleSort bs = new BubbleSort();
        
        try{
            if(arg.length == 0){
                throw new Exception("ファイル名が指定されていません。");
            }
            String fileName = arg[0];
            inputArrayListFromFile(fileName, arrayList);
            outputArrayListToConsole(arrayList);
            System.out.println();
            System.out.println("--------------");
            bs.sort(arrayList);
            outputArrayListToConsole(arrayList);
            System.out.println();
            System.out.println("--------------");
        }catch(FileNotFoundException ex){
            System.out.println("ファイルが見つかりません。");
        }catch(InputMismatchException ex){
             System.out.println("入力の値が正しくありません。");
        }catch(Exception ex){
            System.out.println(ex);
        }
        
    }
}
