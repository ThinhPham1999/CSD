
package stacks;
import java.util.*;

public class Stacks {
    
    public static void decToBin(int dec){
        MyStack bin = new MyStack();
        System.out.print(dec + "in binary system is: ");
        while (dec > 0){
            bin.push(dec % 2);
            dec = dec / 2;
        }
        bin.traverse();
    }
    
    public static void stackByNode(){
        MyStack my = new MyStack();    
        my.push(0);
        my.push(2);
        my.push(3);
        my.traverse();
        my.pop();
        my.traverse();
    }

    public static void main(String[] args) {
        stackByNode();
        decToBin(8);
    }
    
}
