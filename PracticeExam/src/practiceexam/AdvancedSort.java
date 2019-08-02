
package practiceexam;

import java.util.ArrayList;
import java.util.Collections;


public class AdvancedSort {    
    // print the list
    public static void print(ArrayList<Product> list){
        System.out.printf("%-10s%-20s%-10s\n", "ID", "Name", "Level");
        list.forEach((em) -> {
            System.out.print(em);
        });
    }
    
    // Heap Sort
    public static void heapSort(ArrayList<Product> list){
        int n = list.size();
        
        // Build heap (rearrange array) 
        for (int i = n / 2 - 1; i >= 0; i--) 
            heapify(list, n, i); 
        
        // One by one extract an element from heap 
        for (int i=n-1; i>=0; i--) 
        { 
            // Move current root to end 
            Collections.swap(list, 0, i);
  
            // call max heapify on the reduced heap 
            heapify(list, i, 0); 
        } 
    }
    
    private static void heapify(ArrayList<Product> list, int n, int i){
        int largest = i; // largest root
        int l = 2*i + 1; // left = 2*i + 1
        int r = 2*i + 2; // left = 2*i + 2;
        
        // if left child is larger than root
        if (l < n && list.get(l).compareTo(list.get(largest)) > 0){
            largest = l;
        }
        
        // if right child is larger than root
        if (r < n && list.get(r).compareTo(list.get(largest)) > 0){
            largest = r;
        }
        
        // if largest is not root
        if (largest != i){
            Collections.swap(list, i, largest);
            heapify(list, n, largest);
        }
    }
    
    // Quick Sort
    public static void quickSort(ArrayList<Product> list, int n, int low, int up){
        int pivot;
        if (low >= up){
            return;
        }
        pivot = partition(list, n, low, up);
        quickSort(list, n, low, pivot - 1);
        quickSort(list, n, pivot + 1, up);
    }
    
    private static int partition(ArrayList<Product> list, int n, int low, int up){
        int pivot;
        Product pivotval;
        pivotval = list.get(low);
        int i = low, j = up;
        
        while (i<j){
            while (list.get(i).compareTo(pivotval) <= 0 && i < up) i++; //list[i] > pivotal
            while (list.get(j).compareTo(pivotval) > 0) j--;   // list[i] < pivotal
            if (i < j){
                Collections.swap(list, i, j);
            }
            
        }
        Collections.swap(list, low, j);
        pivot = j;
        return pivot;
    } 
    
    // Merge Sort
    private static void merge(ArrayList<Product> list, int l, int m, int r) 
    { 
        // Find sizes of two subLists to be merged 
        int n1 = m - l + 1; // size of List1(L)
        int n2 = r - m; // size of List2(R)
  
        /* Create temp List */
        ArrayList<Product> L = new ArrayList<>(); 
        ArrayList<Product> R = new ArrayList<>(); 
  
        // Set list for avoiding null pointer
        for (int i=0; i<n1; ++i) 
            L.add(i, new Product()); 
        for (int j=0; j<n2; ++j) 
            R.add(j, new Product()); 
        
        /*Copy data to temp List L and R*/
        for (int i=0; i<n1; ++i) 
            L.set(i, list.get(l+ i)); 
        for (int j=0; j<n2; ++j) 
            R.set(j, list.get(m + 1 + j)); 
  
  
        /* Merge the temp List */
  
        // Initial indexes of first and second subList
        int i = 0, j = 0; 
  
        // Initial index of merged subList
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L.get(i).compareTo(R.get(j)) <= 0) 
            { 
                list.set(k, L.get(i)); 
                i++; 
            } 
            else
            { 
                list.set(k, R.get(j)); 
                j++; 
            } 
            k++; 
        } 
  
        /* Copy remaining elements of L if any */
        while (i < n1) 
        { 
            list.set(k, L.get(i)); 
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R if any */
        while (j < n2) 
        { 
            list.set(k, R.get(j)); 
            j++; 
            k++; 
        } 
    } 
    
    public static void mergerSort(ArrayList<Product> list, int l, int r) 
    { 
        if (l < r) 
        { 
            // Find the middle point 
            int m = (l+r)/2; 
  
            // Sort first and second halves 
            mergerSort(list, l, m); 
            mergerSort(list , m+1, r); 
  
            // Merge the sorted halves 
            merge(list, l, m, r); 
        } 
    } 
}

