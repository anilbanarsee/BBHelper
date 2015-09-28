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
        tree = new Tree(f,true);
    }
    public void generateTreeR(Fraction[] probs, Tree p, int i){
        
        Tree[] subTrees = new Tree[2];
        Tree tree1 = new Tree(probs[i],true);
        Tree tree2 = new Tree(probs[i],false);
      
    }
}
