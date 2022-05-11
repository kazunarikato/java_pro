/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kazunarikato
 */
import java.io.*;
import java.util.*;

public class QuickSort {
   public int pivot(){
       int p=0;
       return p;
   }
   
   public void quickSort(ArrayList<Integer> arrayList, int left, int right){
       
       if(left >= right){
           return;
       }
       int l = left;
       int r = right;
       int p = left;
       
       int buf = arrayList.get(p);
       arrayList.set(p, arrayList.get(left));
       arrayList.set(left, buf);
       l++;
       
       while(l <= r){//左端からピボットより大きい値、右端からピボットより小さい値を探す。
           while((l <= right) && (arrayList.get(left) > arrayList.get(l))){//lが右限を超えてない and ピボットよりも小さい値ならスキップ
               l++;
           }
           while((r > left) && (arrayList.get(left) <= arrayList.get(r))){//rが左限より大きい and ピボット以上の値ならスキップ
               r--;
           }
           if(l<=r){//l <= rの間でそれが見つかればスワップ
               buf = arrayList.get(r);
               arrayList.set(r, arrayList.get(l));
               arrayList.set(l, buf);
           }
       }
       
       //ピボットの位置を戻す
       buf = arrayList.get(left);
       arrayList.set(left, arrayList.get(l-1));
       arrayList.set(l-1, buf);
       quickSort(arrayList, left, l-1);
       quickSort(arrayList, l, right);
   }
   
   public void sort(ArrayList<Integer> arrayList){
       quickSort(arrayList, 0, arrayList.size()-1);
   }
}
