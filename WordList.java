
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
        /* enter you code! */
    }
    
    // do not modify main
    public static void main(String[] args) {
        System.out.println("Test WordList");

        WordList L = new WordList();

        In.init();
        long startTime = System.currentTimeMillis();
        while (!In.empty()) {
            String s = In.getString();
            if (s.isEmpty()) continue;
            L.insert(s);
        }
        long endTime = System.currentTimeMillis();
        long listTime = endTime - startTime;
        System.out.println("linked list construction time = " + listTime);
        System.out.println("number of linked list nodes = " + L.nodeCount());
        System.out.println("");

        System.out.println("contains 'and' " + L.contains("and") + " times");
        System.out.println("contains 'astonished' " + L.contains("astonished") + " times");
        System.out.println("contains 'boat' " + L.contains("boat") + " times");
        System.out.println("contains 'path' " + L.contains("path") + " times");
        System.out.println("contains 'the' " + L.contains("the") + " times");
        System.out.println("contains 'train' " + L.contains("train") + " times");
        System.out.println("contains 'tom' " + L.contains("tom") + " times");
        System.out.println("contains 'wondered' " + L.contains("wondered") + " times");
        System.out.println("");

        System.out.println("\nthe 10 most frequent words are:");
        L.print(10);
        
        String s = L.select(9);
        System.out.println("deleting '" + s +"'");
        L.delete(s);
  
        s = L.select(8);
        System.out.println("deleting '" + s +"'");
        L.delete(s);
        
        s = L.select(7);
        System.out.println("deleting '" + s +"'");
        L.delete(s);
        
        System.out.println("\nthe remaining 10 most frequent words are:");
        L.print(10);
        
        System.out.println("\nsorting words in lexicographical order");
        L.lexOrder();
        System.out.println("first 10 words in lexicographical order are:");
        L.print(10);
        
        endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("\ntotal running time = " + totalTime);
    }
}
