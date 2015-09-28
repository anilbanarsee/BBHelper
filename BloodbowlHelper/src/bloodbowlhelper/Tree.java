/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbowlhelper;

import java.util.ArrayList;
import math.Fraction;
import math.Util;

/**
 *
 * @author User
 */
public class Tree {
    Tree[] subChains;
    boolean success;
    boolean start;
    Fraction localChance;
    boolean rerolled;
    boolean hasReroll;
    public Tree(Fraction f, boolean b, boolean r, boolean hasR){
        
        localChance = f;
        success = b;
        start = false;
        rerolled = r;
        hasReroll = hasR;
    }
    
    public ArrayList<String>[] toStringArray(ArrayList<String> pass){
        if(rerolled){
            pass.add("R");
        }
        else{
        if(!start){
        
        if(success)
            pass.add("S");
        else
            pass.add("F");
        }
        }
      if(subChains!=null){
      ArrayList<String> list1 = Util.clone(pass);
      
      ArrayList<String> list2 = Util.clone(pass);
      
      if(subChains[1]==null)
          return subChains[0].toStringArray(list1);
          
      return Util.merge(subChains[0].toStringArray(list1), subChains[1].toStringArray(list2));
      }
      else{
          ArrayList<String>[] list = new ArrayList[1];
          list[0] = pass;
          return list;
      }
      
    }
}
