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

public class MyListTest {
    public static void main(String[] args){
        MyList ml = new MyList();
        LinkedList<Integer> linkedList = new LinkedList<>();
        int n=0;
        Scanner sc = new Scanner(System.in);
        
        
        try{
            System.out.println("10個の自然数を入力してください。");
        
            while(n<10){
                String line = sc.nextLine();
                String[] words = line.split("\\s+", 0);
                int[] nums = new int[words.length];
                for(int i=0;i<words.length;i++){
                    nums[i] = Integer.parseInt(words[i]);
                    linkedList.add(nums[i]);
                    n++;
                    if(n >= 10){
                        System.out.println("入力の数が10個を超えました。");
                        break;
                    }
                }
            }
            ml.output(linkedList);
            
            n=0;
            System.out.println("リストにinsertする自然数を10個入力してください。");
            while(n<10){
                String line = sc.nextLine();
                String[] words = line.split("\\s+", 0);
                int[] nums = new int[words.length];
                for(int i=0;i<words.length;i++){
                    nums[i] = Integer.parseInt(words[i]);
                    ml.insert(nums[i], linkedList);
                    ml.output(linkedList);
                    n++;
                    if(n>=10){
                        break;
                    }
                }
            }
            ml.output(linkedList);
            
            n=0;
            System.out.println("リストからdeleteする自然数を10個入力してください。");
            while(n<10){
                String line = sc.nextLine();
                String[] words = line.split("\\s+", 0);
                int[] nums = new int[words.length];
                for(int i=0;i<words.length;i++){
                    nums[i] = Integer.parseInt(words[i]);
                    ml.delete(nums[i], linkedList);
                    ml.output(linkedList);
                    n++;
                    if(n>=10){
                        break;
                    }
                }
            }
            ml.output(linkedList);
        }catch(InputMismatchException e){
            System.out.println("Input is mismatch");
        }catch(NumberFormatException e){
            System.out.println("Number format is worng");
        }
        /*
        ml.output(linkedList);
        
        n=0;
        System.out.println("リストにinsertする自然数を10個入力してください。");
        try{
            while(n<10){
                String line = sc.nextLine();
                String[] words = line.split("\\s+", 0);
                int[] nums = new int[words.length];
                for(int i=0;i<words.length;i++){
                    nums[i] = Integer.parseInt(words[i]);
                    ml.insert(nums[i], linkedList);
                    ml.output(linkedList);
                    n++;
                    if(n>=10){
                        break;
                    }
                }
            }
        }catch(InputMismatchException e){
            System.out.println("Input is mismatch");
        }catch(NumberFormatException e){
            System.out.println("Number format is worng");
        }
        ml.output(linkedList);
        
        n=0;
        System.out.println("リストからdeleteする自然数を10個入力してください。");
        try{
            while(n<10){
                String line = sc.nextLine();
                String[] words = line.split("\\s+", 0);
                int[] nums = new int[words.length];
                for(int i=0;i<words.length;i++){
                    nums[i] = Integer.parseInt(words[i]);
                    ml.delete(nums[i], linkedList);
                    ml.output(linkedList);
                    n++;
                    if(n>=10){
                        break;
                    }
                }
            }
        }catch(InputMismatchException e){
            System.out.println("Input is mismatch");
        }catch(NumberFormatException e){
            System.out.println("Number format is worng");
        }
        ml.output(linkedList);
        */
    }
}
