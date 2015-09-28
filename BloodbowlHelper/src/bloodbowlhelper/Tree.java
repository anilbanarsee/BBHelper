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
    Fraction localChance;
    public Tree(Fraction f, boolean b){
        
        localChance = f;
        success = b;
    }
    
    public ArrayList<String>[] toStringArray(ArrayList<String> pass){
      
      if(success)
          pass.add("S");
      else
          pass.add("F");
      
      ArrayList<String> list1 = Util.clone(pass);
      ArrayList<String> list2 = Util.clone(pass);
     
      return Util.merge(subChains[0].toStringArray(list1), subChains[1].toStringArray(list2));
    }
}
