/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task10;

/**
 *
 * @author Thinh
 */
public class Task10 {

    public static double addReciprocals(int n){
        if (n == 1){
            return 1;
        }
        return 1.0/n + addReciprocals(n - 1);
    }
    
    public static void main(String[] args) {
        System.out.println(addReciprocals(5));
    }
    
}
