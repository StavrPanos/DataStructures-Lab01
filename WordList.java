
import java.io.*;

import javax.swing.event.SwingPropertyChangeSupport;

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
        
        //Sort if needed
        if(!isSorted){
            while(currentNode.previous != null && currentNode.count > currentNode.previous.count){
                System.out.println("The current Node is: " + currentNode.str);
                System.out.println();
                System.out.println("The previous Node is " + currentNode.previous.str);
                Node tempNode = currentNode.previous;
                currentNode.previous = tempNode.previous;
                tempNode.next = currentNode.next;
                //If currentNode is not the tail
                if(currentNode.next != null){
                    currentNode.next.previous = tempNode;
                }
                tempNode.next = currentNode;
                currentNode.next = tempNode;
                //If currentNode is not the head
                if(tempNode.previous != null){
                    tempNode.previous.next = currentNode;
                }else{
                    first = currentNode; //Update the head
                }

                if(currentNode.next == null){
                    currentNode.next = tempNode;
                }
                currentNode = tempNode;
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
        L.insert("the");
        L.insert("adventures");
        L.insert("of");
        L.insert("of");
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