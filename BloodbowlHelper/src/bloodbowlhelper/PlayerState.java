/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbowlhelper;

/**
 *
 * @author User
 */
public class PlayerState {
    public String name;
    public boolean hasDodge;
    public boolean hasCatch;
    public boolean hasThrow;
    public boolean hasBlock;
    
    public PlayerState(Player p){
        name = p.name;
        hasDodge = p.dodge;
        hasCatch = p.catcher;
        hasThrow = p.thrower;
        hasBlock = p.block;
    }
    public PlayerState(String s){
        name = s;
        hasDodge = false;
        hasCatch = false;
        hasThrow = false;
        hasBlock = false;
    }
    public PlayerState(String s, boolean d, boolean c, boolean t, boolean b){
        name = s;
        hasDodge = d;
        hasCatch = c;
        hasBlock = b;
        hasThrow = t;
    }
    public String toString(){
        String s =name + " has";
        boolean flag = false;
        boolean flag2 = false;
        if(hasDodge){
            flag2 = true;
            flag = true;
            s = s+" Dodge";
        }
        if(hasCatch){
            if(flag2){
                if(!hasThrow && !hasBlock)
                    s = s+" and";
                else
                 s = s+",";
            }
            flag2 = true;
            flag = true;
            s = s+" Catch";
        }
        if(hasThrow){
            if(flag2){
                if(!hasBlock)
                    s = s+" and";
                else
                    s = s+",";
            }
            flag2 = true;
            flag = true;
            s = s+" Throw";
        }
        if(hasBlock){
            if(flag2){
                s = s+" and";
            }
            flag = true;
            s = s+" Block";
        }
        if(!flag){
            s = s+" nothing";
        }
        s = s+" available.";
        return s;
        
        
    }
    public PlayerState clone(){
        return new PlayerState(name,hasDodge,hasCatch,hasBlock,hasThrow);
    }
}
