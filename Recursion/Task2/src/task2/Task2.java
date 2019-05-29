
package task2;

public class Task2 {

    public static int min(int[] arr, int n){
        if (n == 0){
            return -1;
        }
        if (n == 1){
            return arr[0];
        }else{
            if (arr[n - 1] < min(arr, n - 1)){
                return arr[n-1];
            }else{
                return min(arr, n - 1);
            }
        }
           
    }
    
    public static void main(String[] args) {
        int[] arr = {8, 9, 12, -5, 1, -3};
        System.out.println(min(arr, 6));
    }
    
}
