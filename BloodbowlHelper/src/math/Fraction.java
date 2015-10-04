/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package math;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Reetoo
 */
public class Fraction {
    public int num;
    public int den;
    
    public Fraction(int n, int d){
        num = n;
        den = d;
    }
    
    public void simplify(){
        int n = Util.getHCF(num, den);
        if(n==-1)
            return;
        divide(n);
    }
    private void divide(int n){
        num = num/n;
        den = den/n;
    }
    @Override
    public String toString(){
        return num +"/"+ den;
    }
    public Fraction add(Fraction f){
        if(f.num==0)
            return this;
        if(num==0)
            return f;
       // int[] nums = Util.getLCM(den, f.den);
       // System.out.println(Arrays.toString(nums));
       // Fraction newF = new Fraction(num*nums[0]+f.num*nums[1],nums[2]);
        
        Fraction newF = new Fraction((num*f.den)+(f.num*den),f.den*den);
        newF.simplify();
        return newF;
    }
    public Fraction sub(Fraction f){
        int[] nums = Util.getLCM(den, f.den);
       // System.out.println(Arrays.toString(nums));
        Fraction newF = new Fraction(num*nums[0]-f.num*nums[1],nums[2]);
        newF.simplify();
        return newF;
        
    }
    public Fraction mult(Fraction f){
        Fraction newF = new Fraction(num*f.num,den*f.den);
        newF.simplify();
        return newF;
    }
    public Fraction reverse(){
        Fraction one = new Fraction(den,den);
        return one.sub(this);
    }
    public Fraction invert(){
        return new Fraction(den,num);
    }
    public Fraction divide(Fraction f){
        return mult(f.invert());
    }
    public double getDouble(){
        return num/den;
    }
}
