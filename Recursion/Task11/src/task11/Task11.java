/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task11;

/**
 *
 * @author Thinh
 */
public class Task11 {

    public static int stirlingNumber(int n, int k){
        if (n < k) return -1;
        if (n == k){
            return 1;
        }else if (k == 0){
            return 0;
        }else{
            return stirlingNumber(n - 1, k - 1) - (n - 1)*stirlingNumber(n - 1, k);
        }
    }
    
    public static void main(String[] args) {
        int result = (stirlingNumber(4, 3));
        System.out.println(result);
    } 
    
}
