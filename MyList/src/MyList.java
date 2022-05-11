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

public class MyList {
    public void insert(int x, LinkedList<Integer> linkedList){
        int i=0;
        for(i=0;i<linkedList.size();i++){
            if(x < linkedList.get(i)){
                break;
            }
        }
        linkedList.add(i, x);
    }
    public void delete(int x, LinkedList<Integer> linkedList){
        for(int i=0;i<linkedList.size();i++){
            if(x == linkedList.get(i)){
                linkedList.remove(i);
                i--;
            }
        }
        
    }
    public void output(LinkedList<Integer> linkedList){
        for(int i=0; i<linkedList.size(); i++){
            System.out.print(linkedList.get(i)+ " ");
        }
        System.out.println();
    }
}
