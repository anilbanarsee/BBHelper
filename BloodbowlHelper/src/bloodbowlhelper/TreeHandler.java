/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbowlhelper;

import java.util.List;
import math.Fraction;

/**
 *
 * @author User
 */
public class TreeHandler {
    Tree tree;
    public TreeHandler(){
        Fraction f = new Fraction(1,1);
        tree = new Tree(f,true,false,true);
        tree.start = true;
    }
  /*  public void generateTreeCompleteR(Fraction[] probs, Tree p, int i){
        if(i>=probs.length){
            return;
        }
        Tree[] subTrees = new Tree[2];
        Tree tree1 = new Tree(probs[i],true);
        Tree tree2 = new Tree(probs[i],false);
        i++;
        generateTreeCompleteR(probs,tree1,i);
        generateTreeCompleteR(probs,tree2,i);
        subTrees[0] = tree1;
        subTrees[1] = tree2;
        p.subChains = subTrees;
    }*/
    public void generateTreeFailEndR(ProbabilityList pList, Tree p, int i){
        if(i>=pList.size()){
            return;
        }
        
         
        Tree[] subTrees = new Tree[2];
        Tree tree1 = new Tree(pList.getProbability(i),true, false, p.hasReroll);
        Tree tree2 = new Tree(pList.getProbability(i).reverse(),false,false,p.hasReroll);
        // boolean flag = false;
        
        if(p.rerolled){
            Fraction rerollChance = new Fraction(1,1);
            tree1 = new Tree(rerollChance,true,false,p.hasReroll);
            if(rerollChance.reverse().num==0){
                tree2 = null;
            }
            generateTreeFailEndR(pList,tree1,i);
           
        }
        else{
            generateTreeFailEndR(pList,tree1,i+1);
            if(p.hasReroll){
                tree2 = new Tree(pList.getProbability(i).reverse(),false,true,false);
                generateTreeFailEndR(pList,tree2,i);
            }
        }
        subTrees[0] = tree1;
        subTrees[1] = tree2;
        p.subChains = subTrees;
    }
     public void generateTreeFailEndR(Fraction[] probs, Tree p, int i){
        if(i>=probs.length){
            return;
        }
        
         
        Tree[] subTrees = new Tree[2];
        Tree tree1 = new Tree(probs[i],true, false, p.hasReroll);
        Tree tree2 = new Tree(probs[i].reverse(),false,false,p.hasReroll);
        // boolean flag = false;
        if(p.rerolled){
            Fraction rerollChance = new Fraction(1,1);
            tree1 = new Tree(rerollChance,true,false,p.hasReroll);
            if(rerollChance.reverse().num==0){
                tree2 = null;
            }
            generateTreeFailEndR(probs,tree1,i);
           
        }
        else{
            generateTreeFailEndR(probs,tree1,i+1);
            if(p.hasReroll){
                tree2 = new Tree(probs[i].reverse(),false,true,false);
                generateTreeFailEndR(probs,tree2,i);
            }
        }
        subTrees[0] = tree1;
        subTrees[1] = tree2;
        p.subChains = subTrees;
    }
     public static String chainToString(List<Tree> list){
         String s = "";
         for(Tree t: list){
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
