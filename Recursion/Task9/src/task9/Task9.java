/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task9;

/**
 *
 * @author Thinh
 */
public class Task9 {

    public static int f(int n){
        if (n == 0){
            return 0;
        }else if (n == 1){
            return 1;
        }else{
            return f(n - 1) + f(n - 2);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(f(19));
    }
    
}
