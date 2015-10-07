/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbowlhelper;

import java.util.List;
import math.BigFraction;
import math.Fraction;

/**
 *
 * @author User
 */
public class ChainHandler {
    public static Fraction getProbOfChain(List<Tree> chain){
        Fraction f = new Fraction(1,1);
        for(Tree t:chain){
            f = f.mult(t.localChance);
        }
        return f;
    }
     public static BigFraction getProbOfChain2(List<BigTree> chain){
        BigFraction f = new BigFraction(1,1);
        for(BigTree t:chain){
            f = f.mult(t.localChance);
        }
        return f;
    }
}
