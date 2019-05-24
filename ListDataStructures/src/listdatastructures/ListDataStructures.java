package listdatastructures;

import java.util.Scanner;

public class ListDataStructures {

    private Scanner sc = new Scanner(System.in);

    public static int menu() {
        while (true) {
            System.out.println("\n Choose your option:");
            System.out.println(" 1. Create data list");
            System.out.println(" 2. Display data list");
            System.out.println(" 3. Sort Data");
            System.out.println(" 4. Add a node with value x at the head of a list.");
            System.out.println(" 5. add a node with value x at the tail of a list.");
            System.out.println(" 6. add a node with value x after the node p.");
            System.out.println(" 7. traverse from head to tail and dislay info of all nodes in the list.");
            System.out.println(" 8. delete the head and return its info.");
            System.out.println(" 9. delete the tail and return its info.");
            System.out.println(" 10.delete the node after the node p and return its info.");
            System.out.println(" 11. delele the first node whose info is equal to x");
            System.out.println(" 12. search and return the reference to the first node having info x.");
            System.out.println(" 13. count and return number of nodes in the list.");
            System.out.println(" 14. delete an i-th node on the list. Besure that such a node exists. ");
            System.out.println(" 15. sort the list by ascending order of info.");
            System.out.println(" 16. delete node p if it exists in the list.");
            System.out.println(" 17. create and return array containing info of all nodes in the list.");
            System.out.println(" 18. add a node with value x before the node p.");
            System.out.println(" 19. find and return the maximum value in the list. ");
            System.out.println(" 20. find and return the minimum value in the list. ");
            System.out.println(" 21. return the sum of all values in the list. ");
            System.out.println(" 22. return the average of all values in the list.");
            System.out.println(" 23. check and return true if the list is sorted, return false if the list is not sorted.");
            System.out.println(" 0. Exit\n");
            System.out.print(" Your selection (0 -> 24): ");

            int choice = new ListDataStructures().checkInputRange(0, 23);
            return choice;
        }
    }

    public int checkInputRange(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Please enter number in range.");
                System.out.print("Enter again: ");
            }
        }
    }

    public int checkInputPositiveInteger() {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine());
                if (result <= 0) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Please enter positive integer number: ");
                System.out.print("Enter again: ");
            }
        }
    }
    
    public int checkInputInteger() {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Please enter integer number: ");
                System.out.print("Enter again: ");
            }
        }
    }

    public static void main(String[] args) {
        int listC = 0;
        int choice, val, order;
        MyList manager = new MyList();
        while (true) {
            choice = menu();
            switch (choice) {
                case 0:
                    System.out.println("Exit");
                    return;
                case 1:
                    System.out.print("Enter the size of list: ");
                    listC = new ListDataStructures().checkInputInteger();
                    manager.createList(listC);
                    break;
                case 2:
                    System.out.println("Print info in the list.");
                    manager.traverse();
                    break;
                case 3:
                    System.out.println("The list is sorted: ");
                    manager.sort();
                    break;
                case 4:
                    System.out.println("Add a node with value x at the head of a list");
                    System.out.print("Value of Node: ");
                    int head = new ListDataStructures().checkInputInteger();
                    manager.addToHead(head);
                    System.out.println("The new list is: ");
                    manager.traverse();
                    break;
                case 5:
                    System.out.println("Add a node with value x at the tail of a list");
                    System.out.print("Value of Node: ");
                    int tail = new ListDataStructures().checkInputInteger();
                    manager.addToTail(tail);
                    System.out.println("The new list is: ");
                    manager.traverse();
                    break;
                case 6:
                    System.out.println("Add a node with value x after node p in the list");
                    System.out.print("Value of Node: ");
                    val = new ListDataStructures().checkInputInteger();
                    manager.addAfter(manager.head.next.next, val);
                    System.out.println("The new list is: ");
                    manager.traverse();
                    break;
                case 7:
                    System.out.println(" 7. traverse from head to tail and dislay info of all nodes in the list.");
                    System.out.println(" The list is ");
                    manager.traverse();
                case 8:
                    System.out.println(" 8. delete the head and return its info.");
                    System.out.println(" The Node detelted is " + manager.deleFromHead());
                    System.out.println(" The new list is ");
                    manager.traverse();
                    break;
                case 9:
                    System.out.println(" 9. delete the tail and return its info.");
                    System.out.println(" The Node detelted is " + manager.deleFromTail());
                    System.out.println(" The new list is ");
                    manager.traverse();
                    break;
                case 10:
                    System.out.println(" 10.delete the node after the node p and return its info.");
                    System.out.print("Enter the order of deleted Node: ");
                    order = new ListDataStructures().checkInputPositiveInteger();
                    Node q = manager.head;
                    for (int jj = 1; jj < order; jj++) {
                        q = q.next;
                    }
                    System.out.println(" The Node detelted is "+ manager.deleAfter(q));
                    System.out.println(" The new list is ");
                    manager.traverse();
                    break;
                case 11:
                    System.out.println("delele the first node whose info is equal to x"); 
                    System.out.print("Value of x: "); 
                    val = new ListDataStructures().checkInputInteger();
                    manager.dele(val);
                    System.out.println(" The new list is ");
                    manager.traverse();
                    break;
                case 12:
                    System.out.println("12. search and return the reference to the first node having info x.");
                    System.out.print("Value of x: ");
                    val = new ListDataStructures().checkInputInteger();
                    if (manager.search(val) != null){
                        System.out.println(" The data searched Node is "+ manager.search(val).info +
                                " and the address is "+ manager.search(val).next);
                    }
                    break;
                case 13:
                    System.out.print("Number of list: ");
                    System.out.println(manager.count());
                    break;
                case 14:
                    System.out.println(" 14. delete an i-th node on the list. Besure that such a node exists. ");
                    System.out.print("Value of position: ");
                    val = new ListDataStructures().checkInputPositiveInteger();
                    System.out.println(" The list is ");
                    manager.traverse();
                    manager.dele_position(val - 1);
                    System.out.println(" The new list is ");
                    manager.traverse();
                    break;
                case 15:
                    System.out.println(" 15. sort the list by ascending order of info.");
                    manager.sort();
                    System.out.println(" The new list is ");
                    manager.traverse();
                    break;
                case 16:
                    System.out.println(" 16. delete node p if it exists in the list.");
                    System.out.print("Enter the order of deleted Node: ");
                    order = new ListDataStructures().checkInputPositiveInteger();
                    Node qq = manager.head;
                    for (int j = 0; j < order; j++){
                        qq = qq.next;
                    }
                    System.out.println(" The Node detelted is "+ qq.info);
                    manager.dele(qq);
                    System.out.println(" The new list is ");
                    manager.traverse();
                    break;
                case 17:
                    System.out.println(" 17. create and return array containing info of all nodes in the list.");
                    int arr[] = manager.toArray(listC);
                    System.out.println(" The new Array is ");
                    for(int j=0; j<arr.length; j++){
                        System.out.println(" " + arr[j]);
                    }
                    System.out.println("");
                    break;
                case 18:
                    System.out.println(" 18. add a node with value x before the node p.");
                    System.out.print("Value of x: "); 
                    val = new ListDataStructures().checkInputInteger();
                    manager.addBefore(manager.head.next.next.next, val);
                    System.out.println(" The new list is ");
                    manager.traverse();
                    break;
                case 19:
                    System.out.print("Max in list: ");
                    System.out.println(manager.findMax());
                    break;
                case 20:
                    System.out.print("Min in list: ");
                    System.out.println(manager.findMin());
                    break;
                case 21:
                    System.out.print("Sum of all value in the list: ");
                    System.out.println(manager.findSum());
                    break;
                case 22:
                    System.out.print("Average of the list: ");
                    System.out.println(manager.findAvg());
                    break;
                case 23:
                    boolean checkList = manager.sorted();
                    if (checkList) {
                        System.err.println("The List is sorted.");
                    } else {
                        System.err.println("The list is unsorted.");
                    }
                    break;
            }
        }
    }

}
