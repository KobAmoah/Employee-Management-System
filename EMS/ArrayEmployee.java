/**
* This program creates a class for storing the Array Implemented version of the Employee Object.
* The work derives from initial work by Mark GoodRich(Data Structures & Algorithms in Java) Chap 7.
* There are notable differences between my work and his work however. For example, his work is designed to work for array lists
* which are unbounded. Mine is bounded.(Number of elements)
* @verion 1.0 2023-04-05
* @author Kobby Amoah
*/

import java.time.*;
import java.util.*;

public class ArrayEmployee{
    
     // nested Iterator Class
    private class ArrayEmployeeIterator implements Iterator<Employee>{
        private int j = 0;
        private boolean removable = false;


        /**Tests whether the iterator has a next object*/
        public boolean hasNext(){return j<size;}

        /**Returns the next object in the iterator*/
        public Employee next() throws NoSuchElementException{
            if(j == size) throw new NoSuchElementException("No next employee");
            removable = true;
            return allEmployees[j++];
        }
  
        /**Removes the employee returned by the most recent call to next*/
        public void remove() throws IllegalStateException{
            if(!removable) throw new IllegalStateException("No employee to remove");
            ArrayEmployee.this.remove(j-1);
            j--;
            removable = false;
        }
    } // end of nested class
    
    /** Returns an iterator of the employees stored in the array*/
    public Iterator<Employee> iterator(){return new ArrayEmployeeIterator();}
    
    private int k = 0;
    private int size = 0;
    private Employee[] allEmployees;
    
    // constructor
    /** Constructs an empty Employee array with a given capacity for storing entries */
    public ArrayEmployee(int capacity){
        allEmployees = new Employee[capacity];
    }

     /** Returns number of elements in array*/
    public int size(){return size;}
    
     /** Returns(but) does not remove the employee at index i*/
    public Employee get(int i) throws IndexOutOfBoundsException{
        checkIndex(i, size);
        return allEmployees[i]; 
    }
    
    /** Checks whether a given index is in the range [0,n-1]*/
    protected void checkIndex(int i, int n) throws IndexOutOfBoundsException{
        if(i<0|| i>=n)
            throw new IndexOutOfBoundsException("Illegal Index: " + i);
    }
    
    // update method
    /** Inserts a new Employee to be an index i, shifting all subsequent employees later. */
    public void add(int i, Employee e) throws IndexOutOfBoundsException, IllegalStateException{
        checkIndex(i,size+1);
        if (size == allEmployees.length)
            throw new IllegalStateException("Array is full");
        for(int k = size-1; k>=i;k--)
            allEmployees[k+1]= allEmployees[k];
         allEmployees[i] = e;
         size++;
    }
    
    // remove method    
    /** Remove Employee at int i*/
    public Employee remove(int i) throws IndexOutOfBoundsException{
        checkIndex(i, size);
        Employee temp = allEmployees[i];
        for(int k=i; k<size-1;k++)
            allEmployees[k]=allEmployees[k+1];
        allEmployees[size-1] = null;
        size--;
        return temp;
    }
    
    /** Display content of the Employee Array*/
    public void displayArray(){
        for (int j=0; j< size; j++)
            System.out.print(allEmployees[j]);
            System.out.print("\n");
        System.out.println("");
    }
    
     /** Returns(but does not remove) first element of the ArrayEmployee.*/ 
    public Employee getFirst(){
        if(isEmpty()) return null;
        return allEmployees[0];
    }
    
    public boolean isEmpty(){return size==0;}
    
} // end of Array List employee
