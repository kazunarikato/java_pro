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

public class InsertSort {
    public void sort(LinkedList<Integer> linkedList){
        for(int i=0; i<linkedList.size(); i++){
            int j=0;
            for(j=0; j<i; j++){
                if(linkedList.get(i)<linkedList.get(j)){
                    int buf = linkedList.get(i);
                    linkedList.remove(i);
                    linkedList.add(j, buf);
                    break;
                }
            }
            //System.out.println("j="+j);
        }
    }
    public void sortArray(ArrayList<Integer> linkedList){
        for(int i=0; i<linkedList.size(); i++){
            int j=0;
            for(j=0; j<i; j++){
                if(linkedList.get(i)<linkedList.get(j)){
                    int buf = linkedList.get(i);
                    linkedList.remove(i);
                    linkedList.add(j, buf);
                    break;
                }
            }
            //System.out.println("j="+j);
        }
    }
}
