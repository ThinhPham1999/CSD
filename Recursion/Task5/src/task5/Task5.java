/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task5;

/**
 *
 * @author Thinh
 */
public class Task5 {

    public static int binarySearch(int arr[], int b, int e, int target) {
        if (b <= e) {
            int mid = (b + e) / 2;
            if (target == arr[mid]) {
                return mid;
            }
            if (target > arr[mid]) {
                return binarySearch(arr, mid + 1, e, target);
            } else {
                return binarySearch(arr, 0, mid - 1, target);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {1, 8, 20, 55, 100};
        int result = binarySearch(arr, 0, arr.length - 1, 55);
        System.out.println(result);
    }

}
