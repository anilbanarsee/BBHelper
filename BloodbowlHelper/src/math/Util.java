/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package math;

import java.util.ArrayList;

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
       
       return factors;
   }
}
