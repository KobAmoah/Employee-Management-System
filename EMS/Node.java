/**
* This program creates node objects for the SinglyLinkedList.
* The work derives from initial work by Mark GoodRich(Data Structures & Algorithms in Java) Chap 3.1 .
* There are notable differences between my work and his work however. For example, mine contains a displayNode method.
*@verion 1.0 2023-04-05
*@author Kobby Amoah
*/

import java.util.*;

public class Node<E>{
            private E element;  // element stored at this node
            private Node<E> next; // next element stored in the list

            // constructor
            public Node(E e){
                element = e;
            }
            public E getElement(){return element;}
            public Node<E> getNext(){return next;}
            public void setNext(Node<E> n){next = n;}
            public void setElement(E e){element = e;}
            public void displayNode(){
                System.out.print(element);
                System.out.print("\n");
            }

} // end of Node Class
