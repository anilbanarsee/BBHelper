/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbowlhelper;

import java.math.BigInteger;
import java.util.List;
import math.BigFraction;
import math.Fraction;

/**
 *
 * @author User
 */
public class BigTreeHandler {
    BigTree tree;
    public BigTreeHandler(){
        BigFraction f = new BigFraction(1,1);
        tree = new BigTree(f,true,false,true,false);
        tree.start = true;
    }
  /*  public void generateTreeCompleteR(BigFraction[] probs, BigTree p, int i){
        if(i>=probs.length){
            return;
        }
        BigTree[] subTrees = new BigTree[2];
        BigTree tree1 = new BigTree(probs[i],true);
        BigTree tree2 = new BigTree(probs[i],false);
        i++;
        generateTreeCompleteR(probs,tree1,i);
        generateTreeCompleteR(probs,tree2,i);
        subTrees[0] = tree1;
        subTrees[1] = tree2;
        p.subChains = subTrees;
    }*/
    public void generateTreeFailEndR(BigProbabilityList pList, BigTree p, int i){
        if(i>=pList.size()){
            return;
        }
        
         
        BigTree[] subTrees = new BigTree[2];
        BigTree tree1 = new BigTree(pList.getProbability(i),true, false, p.hasReroll, false);
        BigTree tree2 = new BigTree(pList.getProbability(i).reverse(),false,false,p.hasReroll, false);
        PlayerState state = pList.getState(i);
     
        // boolean flag = false;
        
        if(p.rerolled){
            BigFraction rerollChance = new BigFraction(1,1);
            tree1 = new BigTree(rerollChance,true,false,p.hasReroll, false);
            if(rerollChance.reverse().num.compareTo(BigInteger.ZERO)==0){
                tree2 = null;
            }
               if(state!=null)
                tree1.setPState(state);     
               else
                tree1.setPState(p.pstate);
            
            
            generateTreeFailEndR(pList,tree1,i);
           
        }
        else{
            if(state!=null)
                tree1.setPState(state);     
               else
                tree1.setPState(p.pstate);
            
            generateTreeFailEndR(pList,tree1,i+1);
            
            if(p.hasReroll){
                tree2 = new BigTree(pList.getProbability(i).reverse(),false,true,false,false);
                
                if(state!=null)
                    tree2.setPState(state);     
                else
                    tree2.setPState(p.pstate);
                
                generateTreeFailEndR(pList,tree2,i);
            }
            if(p.pstate!=null){
                if(p.pstate.hasDodge){
                    
                    tree2 = new BigTree(pList.getProbability(i).reverse(),false,true,false,true);
                    PlayerState ps = p.pstate.clone();
                    ps.hasDodge = false;
                    
                    if(state!=null)
                        tree2.setPState(state);     
                    else
                        tree2.setPState(p.pstate);
                    
                    generateTreeFailEndR(pList,tree2,i);
                    
                }
            }
        }
        subTrees[0] = tree1;
        subTrees[1] = tree2;
        p.subChains = subTrees;
    }/*
     public void generateTreeFailEndR(BigFraction[] probs, BigTree p, int i){
        if(i>=probs.length){
            return;
        }
        
         
        BigTree[] subTrees = new BigTree[2];
        BigTree tree1 = new BigTree(probs[i],true, false, p.hasReroll);
        BigTree tree2 = new BigTree(probs[i].reverse(),false,false,p.hasReroll);
        // boolean flag = false;
        if(p.rerolled){
            BigFraction rerollChance = new BigFraction(1,1);
            tree1 = new BigTree(rerollChance,true,false,p.hasReroll);
            if(rerollChance.reverse().num.compareTo(BigInteger.ZERO)==0){
                tree2 = null;
            }
            generateTreeFailEndR(probs,tree1,i);
           
        }
        else{
            generateTreeFailEndR(probs,tree1,i+1);
            if(p.hasReroll){
                tree2 = new BigTree(probs[i].reverse(),false,true,false);
                generateTreeFailEndR(probs,tree2,i);
            }
            
        }
        subTrees[0] = tree1;
        subTrees[1] = tree2;
        p.subChains = subTrees;
    }*/
     public static String chainToString(List<BigTree> list){
         String s = "";
         for(BigTree t: list){
             if(!t.start){
             if(t.success){
                 s = s+">S";
             }
             else{
                 s = s+">F";
             }
             if(t.rerolled)
                 s = s+">R";
             }
         
         }
         return s;
     }
}
