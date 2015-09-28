/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbowlhelper;

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
        System.out.println(Util.getMultiple(5,25));
        System.out.println(Util.getMultiple(36,6));
        System.out.println(Util.getFactors(4));
        System.out.println(Util.getFactors(10));
        System.out.println(Util.getFactors(21));
        System.out.println(Util.getFactors(23));
    }
    
}
