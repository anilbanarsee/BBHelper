/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package math;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Reetoo
 */
public class Util {
    public static int getMultiple(int x, int y){
        int mult = 1;
        
        if(x==y)
            return 1;
        if(x>y){
            int z = x;
            x = y;
            y = z;    
        }
        int oX = x;
        while(x<=y){
            
            if(x==y)
                return mult;
            mult++;
            x = x + oX;
        }
        return -1;
    }
   public static ArrayList<Integer> getFactors(int x){
       int i = 2;
       ArrayList<Integer> factors = new ArrayList<>();
       while(i*2<=x){
           if(getMultiple(i,x)!=-1){
               factors.add(i);
           }
           i++;
       }
       factors.add(x);
       return factors;
   }
   public static int getHCF(int x, int y){
       ArrayList<Integer> xFactors = getFactors(x);
       //System.out.println(xFactors);
       ArrayList<Integer> yFactors = getFactors(y);
       //System.out.println(yFactors);
       
       for(int i = xFactors.size()-1; i>=0; i--){
          // System.out.println(xFactors.get(i));
           for(Integer j: yFactors){
               if(Objects.equals(j, xFactors.get(i))){
                   return j;
               }
           }
       }
       return -1;
   }
   public static int[] getLCM(int x, int y) throws RuntimeException{
       int iX = 1;
       int iY = 1;
       int oX = x;
       int oY = y;
       int[] nums = new int[3];
       while(true){
            if(x<y){
                x = x+oX;
                iX++;
            }
            else if(y<x){
                y = y+oY;
                iY++;
            }
            else{
                nums[0] = iX;
                nums[1] = iY;
                nums[2] = y;
                return nums;
            }
       }
   }
   public static ArrayList<String> clone(ArrayList<String> list){
       ArrayList<String> newList = new ArrayList<>();
       for(String s: list){
           newList.add(s);
       }
       return newList;
   }
   public static ArrayList<String>[] merge(ArrayList<String>[] s1, ArrayList<String>[] s2){
       ArrayList<String>[] newS = new ArrayList[s1.length+s2.length];
       int i=0;
       for(;i<s1.length;i++){
           newS[i]=s1[i];
       }
       for(int j = 0; j<s2.length; j++){
           newS[i] = s2[j];
           i++;
       }
       return newS;
   }
}
