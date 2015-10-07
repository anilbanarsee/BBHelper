/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package math;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Reetoo
 */
public class BigFraction {
    public BigInteger num;
    public BigInteger den;
    
    public BigFraction(long n, long d){
        num = BigInteger.valueOf(n);
        den = BigInteger.valueOf(d);
    }
     public BigFraction(BigInteger n, BigInteger d){
        num = n;
        den = d;
    }
    
    public void simplify(){
        int i  = 30;
        BigInteger n = Util.getHCF3(num, den);
        divide(n);
    }
    private void divide(BigInteger n){
        num = num.divide(n);
        den = den.divide(n);
    }
    @Override
    public String toString(){
        return num +"/"+ den;
    }
    public BigFraction add(BigFraction f){
        if(f.num.compareTo(BigInteger.ZERO) == 0)
            return this;
        if(num.compareTo(BigInteger.ZERO) == 0)
            return f;
       BigInteger[] nums = Util.getLCM(den, f.den);
       // System.out.println(Arrays.toString(nums));
      BigFraction newF = new BigFraction(num.multiply(nums[0]).add(f.num.multiply(nums[1])),nums[2]);
        
       // BigFraction newF = new BigFraction((num*f.den)+(f.num*den),f.den*den);
        newF.simplify();
        return newF;
    }
    public BigFraction sub(BigFraction f){
        BigInteger[] nums = Util.getLCM(den, f.den);
       // System.out.println(Arrays.toString(nums));
        BigFraction newF = new BigFraction(num.multiply(nums[0]).subtract(f.num.multiply(nums[1])),nums[2]);
        //newF.simplify();
        return newF;
        
    }
    public BigFraction mult(BigFraction f){
        BigFraction newF = new BigFraction(num.multiply(f.num),den.multiply(f.den));
        //newF.simplify();
        return newF;
    }
    public BigFraction reverse(){
        BigFraction one = new BigFraction(den,den);
        BigFraction test = one.sub(this);
        return one.sub(this);
    }
    public BigFraction invert(){
        return new BigFraction(den,num);
    }
    public BigFraction divide(BigFraction f){
        return mult(f.invert());
    }
    public BigInteger getDouble(){
        System.out.println(num);
        System.out.println(den);
        return num.divide(den);
    }
}

