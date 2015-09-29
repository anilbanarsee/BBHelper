/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbowlhelper;

import java.util.ArrayList;
import java.util.List;
import math.Fraction;
import math.Util;

/**
 *
 * @author User
 */
public class Tree {
    Tree[] subChains;
    public boolean success;
    public boolean start;
    public Fraction localChance;
    public boolean rerolled;
    public boolean hasReroll;
    public Tree(Fraction f, boolean b, boolean r, boolean hasR){
        
        localChance = f;
        success = b;
        start = false;
        rerolled = r;
        hasReroll = hasR;
    }
    public ArrayList<List<Tree>> getAllChains(List<Tree> chain){
        chain.add(this);
        if(subChains!=null){
            List<Tree> list1 = Util.clone(chain);
            List<Tree> list2 = Util.clone(chain);
            
            
            if(subChains[0]==null)
                return subChains[1].getAllChains(list2);
            
            if(subChains[1]==null)
                return subChains[0].getAllChains(list1);
            
            return Util.merge(subChains[0].getAllChains(list1), subChains[1].getAllChains(list2));           
            
                    
        }
        else{
            ArrayList<List<Tree>> list = new ArrayList<>();
            list.add(chain);
            return list;
        }
    }
     public ArrayList<List<Tree>> getAllSChains(List<Tree> chain){
       
         chain.add(this);
        if(subChains!=null){
            List<Tree> list1 = Util.clone(chain);
            List<Tree> list2 = Util.clone(chain);
            
            
            if(subChains[0]==null)
                return subChains[1].getAllSChains(list2);
            
            if(subChains[1]==null)
                return subChains[0].getAllSChains(list1);
            
            return Util.merge(subChains[0].getAllSChains(list1), subChains[1].getAllSChains(list2));           
            
                    
        }
        else{
            if(success){
                ArrayList<List<Tree>> list = new ArrayList<>();
                list.add(chain);
                return list;
            }
            else{
                return null;
            }
        }
    }
    public ArrayList<List<Tree>> getAllFChains(List<Tree> chain){
       
         chain.add(this);
        if(subChains!=null){
            List<Tree> list1 = Util.clone(chain);
            List<Tree> list2 = Util.clone(chain);
            
            
            if(subChains[0]==null)
                return subChains[1].getAllFChains(list2);
            
            if(subChains[1]==null)
                return subChains[0].getAllFChains(list1);
            
            return Util.merge(subChains[0].getAllFChains(list1), subChains[1].getAllFChains(list2));           
            
                    
        }
        else{
            if(!success){
                ArrayList<List<Tree>> list = new ArrayList<>();
                list.add(chain);
                return list;
            }
            else{
                return null;
            }
        }
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
