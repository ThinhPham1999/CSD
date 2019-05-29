
package task3;


public class Task3 {

    public static int sumArray(int[] arr, int n){
        if (n < 0){
            return 0;
        }
        return arr[n] + sumArray(arr, n - 1);
    }
    
    public static void main(String[] args) {
        int[] arr = {5, 6, 10, 20, 30};
        System.out.println(sumArray(arr, arr.length - 1));
    }
    
}
