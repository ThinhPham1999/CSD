/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task6;

/**
 *
 * @author Thinh
 */
public class Task6 {

    // thuat toan Euclid
    // 
    public static int gcd(int a, int b){
        if (b == 0){
            return a;
        }
        return gcd(b, a % b);
    }
    
    public static void main(String[] args) {
        System.out.println(gcd(20, 8));
    }
    
}
