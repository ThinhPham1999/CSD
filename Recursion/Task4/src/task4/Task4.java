/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task4;

/**
 *
 * @author Thinh
 */
public class Task4 {

    public static int ispalindrome(char a[], int n){
        char[] newc = new char[n];
        if (n < 2){
            return 1;
        }
        if (a[n - 1] != a[0]){
            return 0;
        }
        // set newc from 1 to n - 1
        System.arraycopy(a, 1, newc, 1, n - 1 - 1);
        return ispalindrome(newc, n - 2);
    }
    public static void main(String[] args) {
        char c[] = {'1','2','1', '1'};
        System.out.println(ispalindrome(c, 4));
    }
    
}
