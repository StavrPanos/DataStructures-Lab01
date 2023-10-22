import java.io.*;

public class WordList {

    private class Node {
        String str;
        int count;      // occurrences of str in input file
        Node next;      // next node in doubly linked list
        Node previous;  // previsou node in doubly linked list

        Node(String str) {
            this.str = str;
            this.next = null;
            this.previous = null;
            this.count = 1;
        }
    }

    private Node first;     // first node of the doubly linked list
    private int nodeCount;  // number of nodes

    public WordList() {
        this.nodeCount = 0;
    }

    int nodeCount() {
        return nodeCount;
    }


    // return the number of occurrences of word s in the input file
    public int contains(String s) {
        Node temp = first;
        while(temp.next != null){
            if(temp.str.equals(s)){
                return temp.count;
            }
            temp = temp.next;
        }
        // s not found
        return 0;
    }

    // add one more occurrence of word s; insert new node if s is not in the doubly linked list
    // the list should be adjusted so that the words appear in decreasing number of occurrences 
    public void insert(String s) {
        Node newNode = new Node(s);
        boolean isSorted = true;

        //Insert the first element
        if(first == null){
            first = newNode;
            isSorted = true;//It has onl 1 element
            return;
        }
        //Insert other elements
        Node currentNode = first;
        while(currentNode != null){
            //If String exists in list
            if(currentNode.str.equals(s)){
                currentNode.count++;
                if(currentNode == first){
                    return;
                }
                if(currentNode.count > currentNode.previous.count){
                    isSorted = false;
                    break;
                }
            }
            //If its not then move to the next Node
            if (currentNode.next != null) {
                currentNode = currentNode.next;
            } else {
                // At the end of the list, add the new element
                newNode.previous = currentNode;
                currentNode.next = newNode;
                return;
            }
        }
        
        // Sort if needed
        if(!isSorted){
            while(currentNode.previous != null && currentNode.count > currentNode.previous.count){
                if (currentNode.previous == null) {
                    System.out.println("Entered 1st if");
                    Node temp = currentNode.next;
                
                    if (temp != null) {
                        temp.previous = null;
                    } else {
                        // currentNode was the last element, update the tail
                        tail = null;
                    }
                
                    first = temp;
                    if (temp != null) {
                        temp.next = currentNode;
                    }
                
                    currentNode.previous = null;
                
                    continue;
                }
                
                
                

                if (currentNode.next == null) {
                    System.out.println("Entered 2nd if");
                    System.out.println();
                    Node temp = currentNode.previous;
                    System.out.println("Current node is: " + currentNode.str);
                    System.out.println("Previous Node is " + currentNode.previous.str);
                    System.out.println();
                
                    // Swap the pointers
                    temp.next = currentNode.next;
                    currentNode.previous = temp.previous;
                
                    if (temp.previous != null) {
                        temp.previous.next = currentNode;
                    }
                
                    currentNode.next = temp;
                    
                    // Update the next node's previous pointer
                    if (currentNode.next != null) {
                        currentNode.next.previous = currentNode;
                    }
                
                    System.out.println("Current node after swapping is: " + currentNode.str);
                    System.out.println("Previous node after swapping is " + currentNode.previous.str);
                    System.out.println(currentNode.next.str);
                    System.out.println();
                    continue;
                }
                
    
                if(currentNode.previous.previous == null){
                    currentNode.previous.next = currentNode.next;
                    currentNode.next = currentNode.previous;
                    currentNode.next.next.previous = currentNode.next;
                    currentNode.previous.previous = currentNode;
                    currentNode = currentNode.previous;
                    currentNode.previous = null;
                    continue;
                }
    
                currentNode.previous.previous.next = currentNode;
                currentNode.previous.next = currentNode.next;
                currentNode.next = currentNode.previous;
                currentNode.previous = currentNode.next.previous;
                currentNode.next.previous = currentNode;
                currentNode.next.next.previous = currentNode.next;
            }
        }
    }   
    // delete word s from the doubly linked list
    public void delete(String s) {
        /* enter you code! */
    }
 
    // sort doubly linked list in lexicographic order of words 
    public void lexOrder() {
        /* enter you code! */
    }
    
    // find the k-th word in the doubly linked list
    public String select(int k) {
        /* enter you code! */
        return null; // change appropriately
    }
    
    // print first k strings of the doubly linked list
    public void print(int k) {
        Node temp = first;
        while(temp != null){
            System.out.println(temp.str + "    " + temp.count);
            temp = temp.next;
        }
    }
    
    // do not modify main
    public static void main(String[] args) {
        // System.out.println("Test WordList");

          WordList L = new WordList();

        // In.init();
        // long startTime = System.currentTimeMillis();
        // while (!In.empty()) {
        //     String s = In.getString();
        //     if (s.isEmpty()) continue;
        //     L.insert(s);
        // }
        L.insert("Hello");
        L.insert("Kouki");
        L.insert("im");
        L.insert("im");

        L.print(3);
        // long endTime = System.currentTimeMillis();
        // long listTime = endTime - startTime;
        // System.out.println("linked list construction time = " + listTime);
        // System.out.println("number of linked list nodes = " + L.nodeCount());
        // System.out.println("");

        // System.out.println("contains 'and' " + L.contains("and") + " times");
        // System.out.println("contains 'astonished' " + L.contains("astonished") + " times");
        // System.out.println("contains 'boat' " + L.contains("boat") + " times");
        // System.out.println("contains 'path' " + L.contains("path") + " times");
        // System.out.println("contains 'the' " + L.contains("the") + " times");
        // System.out.println("contains 'train' " + L.contains("train") + " times");
        // System.out.println("contains 'tom' " + L.contains("tom") + " times");
        // System.out.println("contains 'wondered' " + L.contains("wondered") + " times");
        // System.out.println("");

        // System.out.println("\nthe 10 most frequent words are:");
        // L.print(10);
        
        // String s = L.select(9);
        // System.out.println("deleting '" + s +"'");
        // L.delete(s);
  
        // s = L.select(8);
        // System.out.println("deleting '" + s +"'");
        // L.delete(s);
        
        // s = L.select(7);
        // System.out.println("deleting '" + s +"'");
        // L.delete(s);
        
        // System.out.println("\nthe remaining 10 most frequent words are:");
        // L.print(10);
        
        // System.out.println("\nsorting words in lexicographical order");
        // L.lexOrder();
        // System.out.println("first 10 words in lexicographical order are:");
        // L.print(10);
        
        // endTime = System.currentTimeMillis();
        // long totalTime = endTime - startTime;
        // System.out.println("\ntotal running time = " + totalTime);
    }
}