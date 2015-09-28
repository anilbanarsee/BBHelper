/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbowlhelper;

import java.util.ArrayList;
import java.util.Arrays;
import math.Fraction;
import math.Util;

/**
 *
 * @author Reetoo
 */
public class BloodbowlHelper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Fraction f = new Fraction(1,2);
       Fraction[] probs = {f,f,f};
       TreeHandler th = new TreeHandler();
       th.generateTreeFailEndR(probs, th.tree, 0);
       System.out.println(Arrays.toString(th.tree.toStringArray(new ArrayList<>())));
    }
    
}
