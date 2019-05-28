
package queues;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Queues {

    public static void main(String[] args) {
        /*try {
            demo();
        } catch (Exception ex) {
            Logger.getLogger(Queues.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
        convertRealToBin(0.986, 5);
    }
    
    public static void demo() throws Exception{
       MyQueue list = new MyQueue();
       //list.enqueue(0);
       //list.enqueue(1);
       System.out.println(list.dequeue());
       list.traverse();
    }
    
    public static void convertRealToBin(double d, int k){
        if (d == (double)0){
            System.out.println(0);
            return;
        }
        MyQueue listBin = new MyQueue();
        while (k-- > 0){
            d *= 2;
            int naturalPart = (int)d;
            listBin.enqueue(naturalPart);
            d = d - naturalPart;
        }
        System.out.print("0.");
        while (!listBin.isEmpty()){
            try {
                System.out.print(listBin.dequeue());
            } catch (Exception ex) {
                Logger.getLogger(Queues.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
