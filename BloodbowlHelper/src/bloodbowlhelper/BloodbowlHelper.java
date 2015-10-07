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
        
      /*  Fraction f = new Fraction(101,400);
        Fraction f2 = new Fraction(198,800);
        System.out.println(f.add(f2));*/
     
       // System.out.println(Util.getHCF3(48,18));
       // System.out.println(Math.floorMod(48, 18));
        
      // System.out.println(Arrays.toString(Util.getLCM2(12, 6)));
       
       Fraction f = new Fraction(5,6);
       Fraction f2 = new Fraction(2,3);
       Fraction[] probs = {f,f,f2};
       ArrayList<Fraction> prs = new ArrayList<>();
        prs.add(f2);
        prs.add(f2);


       //prs.add(f);
        
        
        
        
       
        
        
        ArrayList<PlayerState> pStates = new ArrayList<>();
        pStates.add(null);
        Player p = new Player("Jeff", true, true, true, true);
        pStates.add(new PlayerState(p));
        
        
        ProbabilityList ps = new ProbabilityList(prs,pStates);
       TreeHandler th = new TreeHandler();
       th.generateTreeFailEndR(ps, th.tree, 0);
       ArrayList<List<Tree>> chains = th.tree.getAllSChains(new ArrayList<>());
       Fraction succeed = new Fraction(0,0);
       for(List<Tree> chain: chains){
           //if(chain!=null)
            System.out.print(TreeHandler.chainToString(chain));
            Fraction fN = ChainHandler.getProbOfChain(chain);
            succeed = succeed.add(fN);
            System.out.println(" : "+fN);
       }
       succeed.simplify();
       System.out.println("Total Succeed : "+succeed+" ("+succeed.getDouble()+"%).");
       
       chains = th.tree.getAllFChains(new ArrayList<>());
       Fraction fail = new Fraction(0,0);
       for(List<Tree> chain: chains){
           //if(chain!=null)
            System.out.print(th.chainToString(chain));
            Fraction fN = ChainHandler.getProbOfChain(chain);
            fail = fail.add(fN);
            System.out.println(" : "+fN);
       }
       fail.simplify();
       System.out.println("Total Fail : "+fail+" ("+fail.getDouble()+"%).");
             
       /* Player p = new Player("Jeff", true, true, true, true);
        Player p2 = new Player("Simon", false, true, false, true);
        Fraction f = new Fraction(5,6);
        
        ArrayList<Fraction> probs = new ArrayList<>();
        probs.add(f);
        probs.add(f);
        probs.add(f);
        
        
        ArrayList<PlayerState> pStates = new ArrayList<>();
        pStates.add(null);
        pStates.add(new PlayerState(p));
        
        ProbabilityList ps = new ProbabilityList(probs,pStates);
        
        System.out.println(ps.getStateAtIndex(1).name);*/
    }
    
}
