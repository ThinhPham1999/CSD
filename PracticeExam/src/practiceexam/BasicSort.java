/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practiceexam;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Thinh
 */
public class BasicSort {

    public static void insertionSort(ArrayList<Product> list) {
        int i, j;
        Product x = null;
        for (i = 1; i < list.size(); i++) {
            x = list.get(i);
            j = i;
            while (j > 0 && x.compareTo(list.get(j - 1)) < 0) {
                list.set(j, list.get(j - 1));
                j--;
            }
            list.set(j, x);
        }
    }

    public static void bubbleSort(ArrayList<Product> list) {
        int i, j;
        boolean swapped;
        do {
            swapped = false;
            for (i = 0; i < list.size() - 1; i++) {
                if (list.get(i).compareTo(list.get(i + 1)) > 0) {
                    Collections.swap(list, i, i + 1);
                    swapped = true;
                }
            }
        } while (swapped);
    }

    public static void selectSort(ArrayList<Product> list) {
        int i, j, k;
        Product min = null;
        for (i = 0; i < list.size() - 1; i++) {
            min = list.get(i);
            k = i;
            for (j = i + 1; j < list.size(); j++) {
                if (min.compareTo(list.get(j)) > 0) {
                    min = list.get(j);
                    k = j;
                }
            }
            if (k != i) {
                Collections.swap(list, i, k);
            }
        }
    }
}
