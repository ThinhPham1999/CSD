/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task7;

/**
 *
 * @author Thinh
 */
public class Task7 {

    public static int power(int n, int p){
        if (p == 0){
            return 1;
        }
        return n * power(n, p - 1);
    }
    
    public static void main(String[] args) {
        System.out.println(power(2,0));
    }
    
}
