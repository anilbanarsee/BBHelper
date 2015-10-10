/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbowlhelper;

import java.util.ArrayList;
import java.util.List;
import math.BigFraction;
import math.BigFraction;
import math.Util;

/**
 *
 * @author User
 */
public class BigTree {
    BigTree[] subChains;
    public PlayerState pstate;
    public boolean success;
    public boolean start;
    public BigFraction localChance;
    public boolean rerolled;
    public boolean dodged;
    public boolean hasReroll;
    public BigTree(BigFraction probability, boolean success, boolean rerolled, boolean hasReroll, boolean dodged){
        
        localChance = probability;
        success = success;
        start = false;
        rerolled = rerolled;
        hasReroll = hasReroll;
    }
    public BigTree(BigFraction f, boolean b, boolean r, boolean hasR, boolean d, PlayerState ps){
        
        this(f,b,r,hasR,d);
        setPState(ps);
    }
    public void setPState(PlayerState ps){
        pstate = ps;
    }
    public ArrayList<List<BigTree>> getAllChains(List<BigTree> chain){
        chain.add(this);
        if(subChains!=null){
            List<BigTree> list1 = Util.clone2(chain);
            List<BigTree> list2 = Util.clone2(chain);
            
            
            if(subChains[0]==null)
                return subChains[1].getAllChains(list2);
            
            if(subChains[1]==null)
                return subChains[0].getAllChains(list1);
            
            return Util.merge2(subChains[0].getAllChains(list1), subChains[1].getAllChains(list2));           
            
                    
        }
        else{
            ArrayList<List<BigTree>> list = new ArrayList<>();
            list.add(chain);
            return list;
        }
    }
     public ArrayList<List<BigTree>> getAllSChains(List<BigTree> chain){
       
         chain.add(this);
        if(subChains!=null){
            List<BigTree> list1 = Util.clone2(chain);
            List<BigTree> list2 = Util.clone2(chain);
            
            
            if(subChains[0]==null)
                return subChains[1].getAllSChains(list2);
            
            if(subChains[1]==null)
                return subChains[0].getAllSChains(list1);
            
            return Util.merge2(subChains[0].getAllSChains(list1), subChains[1].getAllSChains(list2));           
            
                    
        }
        else{
            if(success){
                ArrayList<List<BigTree>> list = new ArrayList<>();
                list.add(chain);
                return list;
            }
            else{
                return null;
            }
        }
    }
    public ArrayList<List<BigTree>> getAllFChains(List<BigTree> chain){
       
         chain.add(this);
        if(subChains!=null){
            List<BigTree> list1 = Util.clone2(chain);
            List<BigTree> list2 = Util.clone2(chain);
            
            
            if(subChains[0]==null)
                return subChains[1].getAllFChains(list2);
            
            if(subChains[1]==null)
                return subChains[0].getAllFChains(list1);
            
            return Util.merge2(subChains[0].getAllFChains(list1), subChains[1].getAllFChains(list2));           
            
                    
        }
        else{
            if(!success){
                ArrayList<List<BigTree>> list = new ArrayList<>();
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
