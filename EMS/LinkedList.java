/**
* This program creates  a class for the SinglyLinkedList. Note this is without a tail.
* The work derives from initial work by Mark GoodRich(Data Structures & Algorithms in Java) Chap 3.2.
* There are notable differences between my work and his work however. For example, my work instantiates the list as iterable.
* @verion 1.0 2023-04-05
* @author Kobby Amoah
*/
import java.util.*;

public class LinkedList<E>{ 
        
    private Node<E> header = null;
    private int size = 0;
    
    // Construct a new empty list
    public LinkedList(){}
    
    public int size(){return size;}
    
    public boolean isEmpty(){return size==0;}
    
    /** Returns(but does not remove) first element of the list.*/ 
    public E getFirst(){
        if(isEmpty()) return null;
        return header.getElement();
    }
    
    public Node<E> getHeader(){return header;}
    public void setFirst(Node<E> e){
        header = e;
        size++;
    }
    // find method 
    
    /** Returns element if contained in list*/
    public E find(E element) throws NoSuchElementException{
        ListIterator<E> iter = getIterator();    
        iter.reset();// start at the beginning
        while(!iter.atEnd()){ // until end
            if(iter.getCurrent().getElement()== element)
               return element;
            iter.nextNode();
        }  
        throw new NoSuchElementException("Employee " + element + " does not exist.");
    } 
    
    /** Returns iterator.*/
    public ListIterator<E> getIterator(){return new ListIterator<E>(this);}
    
    /** Display the list from first to last*/
    public void displayList(){
        Node<E> current = header;
        while(current != null){
            current.displayNode();
            current = current.getNext();
        }
    }
} // end of LinkedList class
