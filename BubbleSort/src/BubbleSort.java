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
public class BubbleSort {
    
    public static void sort(ArrayList<Integer> arrayList){
        for(int i=0; i<arrayList.size(); i++){
            for(int j=0; j<arrayList.size()-i-1; j++){
                if(arrayList.get(j) > arrayList.get(j+1)){
                    int buf = arrayList.get(j);
                    arrayList.set(j, arrayList.get(j+1));
                    arrayList.set(j+1, buf);
                }
            }
        }
    }
}
