/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task8;

/**
 *
 * @author Thinh
 */
public class Task8 {

    public static long fact(int n){
        if(n < 1){
            return 1;
        }
        return n * fact(n - 1);
    }
    
    public static void main(String[] args) {
        System.out.println(fact(3));
    }
    
}
