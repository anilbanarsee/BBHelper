/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbowlhelper;

import java.util.ArrayList;
import math.BigFraction;
import math.Fraction;

/**
 *
 * @author User
 */
public class BigProbabilityList {
    ArrayList<BigFraction> probs;
    ArrayList<PlayerState> pStates;
    
    public BigProbabilityList(ArrayList<BigFraction> ps, ArrayList<PlayerState> pss){
        probs = ps;
        pStates = pss;
    }
    //returns null if there has been no state set before that point
    
    public int size(){
        return probs.size();
    }
    public PlayerState getState(int i){
       /* PlayerState ps = null;
        for(int j = 0; j<pStates.size(); j++){
            
            if(pStates.get(j)!=null){
                ps = pStates.get(j);
            }
            if(j==i)
                return ps;
            
            
        }
        return ps;*/
        return pStates.get(i);
    }
    public BigFraction getProbability(int i){
        return probs.get(i);
    }
    public ArrayList<BigFraction> getProbList(){
        return probs;
    }
    public ArrayList<PlayerState> getPStates(){
        return pStates;
    }
}
