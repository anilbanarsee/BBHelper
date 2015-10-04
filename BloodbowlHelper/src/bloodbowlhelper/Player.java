/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbowlhelper;

/**
 *
 * @author Reetoo
 */
public class Player {
    public String name;
    int exp;
    int level;
    int str;
    int agi;
    int aV;
    int mA;
    public boolean dodge;
    public boolean block;
    public boolean catcher;
    public boolean thrower;
    
    
    public Player(String s){
        name = s;
        dodge = false;
        block = false;
        catcher = false;
        thrower = false;
    }
    public Player(String s, boolean d,boolean b, boolean c, boolean t){
        name = s;
        dodge = d;
        block = b;
        catcher = c;
        thrower = t;
    }
    
}
