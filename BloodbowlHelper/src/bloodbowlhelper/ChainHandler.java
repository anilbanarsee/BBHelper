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
public class ChainHandler {
    public static Fraction getProbOfChain(List<Tree> chain){
        Fraction f = new Fraction(1,1);
        for(Tree t:chain){
            f = f.mult(t.localChance);
        }
        return f;
    }
}
