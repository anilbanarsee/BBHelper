/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbowlhelper;

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
     public void generateTreeFailEndR(Fraction[] probs, Tree p, int i){
        if(i>=probs.length){
            return;
        }
       
        Tree[] subTrees = new Tree[2];
        Tree tree1 = new Tree(probs[i],true, false, p.hasReroll);
        Tree tree2 = new Tree(probs[i],false,false,p.hasReroll);
         boolean flag = false;
        if(p.rerolled){
            Fraction rerollChance = new Fraction(1,1);
            tree1 = new Tree(rerollChance,true,false,p.hasReroll);
            if(rerollChance.reverse().num==0){
                tree2 = null;
            }
        }
         else
            i++;
         
        generateTreeFailEndR(probs,tree1,i);
        if(p.hasReroll){
            tree2 = new Tree(probs[i-1],false,true,false);
            generateTreeFailEndR(probs,tree2,i);
        }
        subTrees[0] = tree1;
        subTrees[1] = tree2;
        p.subChains = subTrees;
    }
}
