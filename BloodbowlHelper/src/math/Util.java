/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package math;

import bloodbowlhelper.Tree;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.math.*;

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
   public static int[] div(int x, int y){
       int i = 0;
       while(x>=y){
           i++;
           x -= y;
       }
       int[] qr = {i,x};
       return qr;
   }
    public static long[] div(long x, long y) {
       
       long i = 0;
       //Math.floorDiv(x, y)
       /* while(x-y*500 >= y){
            
            i+=500;
            x -= y*500;
            //x -= x*50;
        }
        
        while(x-y*250 >= y){
             //System.out.println("B");
            i+=250;
            x -= y*250;
            //x -= x*50;
        }
         while(x-y*100 >= y){
             //System.out.println("B");
            i+=100;
            x -= y*100;
            //x -= x*50;
        }
         while(x-y*50 >= y){
            // System.out.println("C");
            i+=50;
            x -= y*50;
            //x -= x*50;
        }
           while(x-y*5 >= y){
            // System.out.println("C");
            i+=5;
            x -= y*5;
            //x -= x*50;
        }*/
        while (x >= y) {
            i++;
            x -= y;
        }
        long[] qr = {i, x};
        return qr;
        //long[] qr = {Math.floorDiv(x, y),Math.floorMod(x, y)};
       // return qr;
    }
    public static int getHCF3(int x, int y){
       //System.out.println(x+","+y);
       int z = x;
       int[] qr = div(z,y);
       int v = y;
       z = v;
       
       while(qr[1]!=0){
           v = qr[1];
           qr = div(z,qr[1]);
           z = v;
       }
       return v;
   }
    public static long getHCF3(long x, long y){
       //System.out.println(x+","+y);
       long z = x;
       long[] qr = div(z,y);
       long v = y;
       z = v;
       
       while(qr[1]!=0){
           v = qr[1];
           qr = div(z,qr[1]);
           z = v;
       }
       return v;
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
      public static long[] getLCM(long x, long y) throws RuntimeException{
       long iX = 1;
       long iY = 1;
       long oX = x;
       long oY = y;
       long[] nums = new long[3];
       while(true){
            if(x<y){
                if(x*1000<y){
                    x = x+1000*oX;
                    iX+=1000;
                }
                else if(x*100<y){
                    x = x+100*oX;
                    iX+=100;
                }/*
                if(x*10<y){
                    x = x+10*oX;
                    iX+=10;
                }
                */
                else{
                    x = x+oX;
                    iX++;
                }
            }
            else if(y<x){
                if(y*1000<x){
                    y = y+1000*oY;
                    iY += 1000;
                }
                else if(y*100<x){
                    y = y+100*oY;
                    iY += 100;
                }/*
                else if(y*10<x){
                    y = y+10*oY;
                    iY += 10;
                }*/
                else{
                    y = y+oY;
                    iY++;
                }
            }
            else{
                nums[0] = iX;
                nums[1] = iY;
                nums[2] = y;
                return nums;
            }
       }
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
   public static List<Tree> clone(List<Tree> list){
       List<Tree> newList = new ArrayList<>();
       for(Tree t: list){
           Tree tn = new Tree(t.localChance, t.success, t.rerolled, t.hasReroll);
           if(t.start)
               tn.start = true;
           newList.add(tn);
               
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
    public static ArrayList<List<Tree>> merge(ArrayList<List<Tree>> s1, ArrayList<List<Tree>> s2){
        if(s1==null)
            return s2;
        if(s2==null)
            return s1;
            
        ArrayList<List<Tree>> chains = new ArrayList<>();
       int i=0;
       for(;i<s1.size();i++){
           chains.add(s1.get(i));
       }
       for(int j = 0; j<s2.size(); j++){
           chains.add(s2.get(j));
       }
       return chains;
   }
}
