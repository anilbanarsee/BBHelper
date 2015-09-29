/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbowlhelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
       
       Fraction f = new Fraction(5,6);
       Fraction f2 = new Fraction(2,3);
       Fraction[] probs = {f,f,f2};
       TreeHandler th = new TreeHandler();
       th.generateTreeFailEndR(probs, th.tree, 0);
       ArrayList<List<Tree>> chains = th.tree.getAllSChains(new ArrayList<>());
       Fraction succeed = new Fraction(0,0);
       for(List<Tree> chain: chains){
           //if(chain!=null)
            System.out.print(th.chainToString(chain));
            Fraction fN = ChainHandler.getProbOfChain(chain);
            succeed = succeed.add(fN);
            System.out.println(" : "+fN);
       }
       System.out.println("Total Succeed : "+succeed);
       
       chains = th.tree.getAllFChains(new ArrayList<>());
       Fraction fail = new Fraction(0,0);
       for(List<Tree> chain: chains){
           //if(chain!=null)
            System.out.print(th.chainToString(chain));
            Fraction fN = ChainHandler.getProbOfChain(chain);
            fail = fail.add(fN);
            System.out.println(" : "+fN);
       }
       System.out.println("Total Fail : "+fail);
    }
    
}
