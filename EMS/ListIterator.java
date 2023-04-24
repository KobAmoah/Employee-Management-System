/**
* This program creates  an Iterator class for the SinglyLinkedList.
* The work derives from initial work by Robert Lafore(Data Structures & Algorithms in Java) Chap 5.9 .
* There are notable differences between my work and his work however. For example, I define the class to be a generic class.
* @verion 1.0 2023-04-05
* @author Kobby Amoah
*/

import java.util.*;
public class ListIterator<E>{
    private Node<E> current; 
    private Node<E> previous;
    private LinkedList<E> myList;
    
    /**Constructor*/
    public ListIterator(LinkedList<E> list){
        myList = list;
        reset();
    }
    
    /**Start at first*/
    public void reset(){
        current =   myList.getHeader();
        previous =  null;
    }
    
    /**Equivalent of hasNext() method */
    public boolean atEnd(){ return(current.getNext() == null);}
    
    public void nextNode(){
        previous = current;
        current = current.getNext();
    }
    
    
    public Node<E> getPrevious(){return previous;}
    
    public Node<E> getCurrent(){return current;}
    
    //update methods
    /** Inserts element after current link */
    public void insertAfter(E e){ 
        Node<E> newNode = new Node<>(e);
        if(myList.isEmpty()){ // if empty
            myList.setFirst(newNode);
            current = newNode;
        }else{  // not empty
            newNode.setNext(current.getNext());
            current.setNext(newNode);
            nextNode();
        }
    }
    
    /** Inserts element before current link */
    public void insertBefore(E e){
        Node<E> newNode = new Node<>(e);
        if(previous == null){ // beginning of list
            newNode.setNext(myList.getHeader());
            myList.setFirst(newNode);
            reset();
        }else{ // not beginning
            newNode.setNext(previous.getNext());
            previous.setNext(newNode);
            current = newNode;
        }
        
    } 
    
    // removal
    /** Delete item at current link*/
    public E deleteCurrent(){
        E value = current.getElement();
        if(previous == null){  //beginning of list
            myList.setFirst(current.getNext());
            reset();
        }else{
            previous.setNext(current.getNext());
            if(atEnd())
                reset();
            else
                current = current.getNext();
        }
        return value;
    }
    
} // end of ListIterator class
