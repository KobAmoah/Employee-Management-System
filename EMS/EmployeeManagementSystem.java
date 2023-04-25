/**
*This program creates a testing class for an example employee managemenet system.
* The goal is to compare the efficiency of an Array implemented version to a Linked List
*@verion 1.0 2023-04-05
*@author Kobby Amoah
*/
import java.time.*;
import java.io.*;
import java.util.*;

public class EmployeeManagementSystem{
        
    public static void main(String[] args) throws IOException{
        
        
        int capacity = 20; // array size
        ArrayEmployee arr = new ArrayEmployee(capacity); // create the employee array
        Iterator<Employee> iterArray = arr.iterator(); 
        
        // create the following eight employees
        Employee employee_1 = new Employee("Evans Shapiro",90000, 2010, 11, 23, 50006789L,7808504867L,"e.shapiro@thiscompany.com");
        Employee employee_2 = new Employee("Anna Smith",75250, 2012, 2, 12, 50008456L,3129875663L," a.smith@thiscompany.com");
        Employee employee_3 = new Employee("Johnny Cunningham",70000, 2013, 11, 9, 50002122L,3218864867L,"j.cunningham@thiscompany.com");
        Employee employee_4 = new Employee("Scott Gordon",90250, 2011, 11, 18, 50002378L,2247804867L,"s.gordon@thiscompany.com");
        Employee employee_5 = new Employee("Michelle Porter",87000, 2012, 11, 2, 50009871L,4564234867L,"m.porter@thiscompany.com");
        Employee employee_6 = new Employee("Joshua Osborne",65000, 2010, 11, 10, 50002896L,8218984980L,"j.osborne@thiscompany.com");
        Employee employee_7 = new Employee("Jason Hayes",785000, 2015, 11, 25, 50003232L,7802334851L,"j.hayes@thiscompany.com");
        Employee employee_8 = new Employee("Audrey Harrison",120000, 2016, 9, 12, 50005431L,7807614438L,"a.harrison@thiscompany.com");
        
        // insert employees into the array
        arr.add(0,employee_1);
        arr.add(1,employee_2);
        arr.add(2,employee_3);
        arr.add(3,employee_4);
        arr.add(4,employee_5);
        arr.add(5,employee_6);
        arr.add(6,employee_7);
        arr.add(7,employee_8);
        
        LinkedList<Employee> employeeList = new LinkedList<Employee>(); // new employee list
        ListIterator<Employee> iter = employeeList.getIterator(); // new iter object       
        Object value;
        
        // insert the employees into the LinkedList
        iter.insertAfter(employee_1);
        iter.insertAfter(employee_2);
        iter.insertAfter(employee_3);
        iter.insertAfter(employee_4);
        iter.insertAfter(employee_5);
        iter.insertAfter(employee_6);
        iter.insertAfter(employee_7);
        iter.insertAfter(employee_8);
        
        boolean list_structure = true;
        boolean array_structure = true;
        boolean list_struct = false;
        boolean array_struct = false;
        while(list_structure && array_structure){
            
                System.out.println("\t\t*******************************************");
                System.out.println("\t\t\t  EMPLOYEE MANAGEMENT SYSTEM");
                System.out.println("\t\t*******************************************");
                System.out.println("\t\t\t    --------------------");
                System.out.println("\t\t\t     ~$ Kobby Amoah");
                System.out.println("\t\t\t    --------------------");
                System.out.println("\n\nEnter a : To Explore the Array Version");
                System.out.println("Enter l : To Explore the LinkedList Version ");
                System.out.println("Enter e : To Exit the EMS Portal");
                System.out.flush();
                int choice = getChar(); 
                switch(choice){
                    case 'l':
                        list_structure = false;
                        list_struct = true;
                        break;
                    case 'a':
                        array_structure = false;
                        array_struct = true;
                        break;
                    case 'e':
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid Entry.");
                }// end of switch statement
            
        } // end of while loop
        while(list_struct){
                        
                        System.out.println("\t\t**********************************");
                        System.out.println("\t\t\t  LinkedList Version");
                        System.out.println("\t\t**********************************");
                        System.out.println("\n\nEnter s : To show all employees in the list");
                        System.out.println("Enter r : To reset the pointer(Set it back to the first value)");
                        System.out.println("Enter n : To visit the next employee in the list");
                        System.out.println("Enter d : To delete the current employee in the list");
                        System.out.println("Enter i : To visit the first employee in the list");
                        System.out.println("Enter e : To exit the EMS Portal");
                        System.out.flush();
                        int choice_1 = getChar(); 
                        switch(choice_1){
                            case 'i':
                                if(!employeeList.isEmpty())
                                   System.out.println(employeeList.getFirst());
                                else
                                    System.out.println("No employees in the list");
                                break;
                            case 'e':
                                System.exit(0);
                                break;
                            case 's':
                                if(!employeeList.isEmpty())
                                    employeeList.displayList();
                                else
                                    System.out.println("No employees in the list");
                                break;
                            case 'r':
                                iter.reset();
                                break;
                            case 'n':
                                if(!employeeList.isEmpty() && !iter.atEnd()){
                                    iter.nextNode();
                                    System.out.println(iter.getCurrent().getElement()); 
                                }
                                else{System.out.println("At End. Can't go to the next Employee");}
                                break;
                            case 'd':
                                if(!employeeList.isEmpty()){
                                    value = iter.deleteCurrent();
                                    System.out.println("Removed " + value);
                                }
                                else
                                    System.out.println("Can't delete");
                                break;
                            default:
                                System.out.println("Invalid Entry");             
                            } // end of switch statement for LinkedList
        } // end of while loop for LinkedList
        while(array_struct){
                        System.out.println("\t\t**********************************");
                        System.out.println("\t\t\t  Array Version");
                        System.out.println("\t\t**********************************");
                        System.out.println("\n\nEnter s : To show all employees in the array");
                        System.out.println("Enter n : To visit the next employee in the array");
                        System.out.println("Enter d : To delete the current employee in the array");
                        System.out.println("Enter i : To visit the first employee in the array");
                        System.out.println("Enter f : To find an employee in the array");
                        System.out.println("Enter e : To exit the EMS Portal");
                        System.out.flush();
                        int choice_3 = getChar();
                        switch(choice_3){
                            case 'i':
                                if(!arr.isEmpty())
                                    System.out.print(arr.getFirst());
                                else
                                    System.out.println("No employees in the array");
                                break;
                            case 'e':
                                System.exit(0);
                            case 's':
                                if(!arr.isEmpty())
                                    arr.displayArray();
                                else
                                    System.out.println("No employees in the array");
                                break;
                            case 'n':
                                if(!arr.isEmpty() && iterArray.hasNext()){
                                    System.out.println(iterArray.next());
                                }
                                else
                                    System.out.println("Can't go to the next employee. Array is at it's end. ");
                                break;
                            case 'f':
                                 System.out.print("Enter index to search for in employee Array : ");
                                 System.out.flush();
                                 int choice_4 = getInteger();
                                 if(!arr.isEmpty()){
                                     value = arr.get(choice_4);
                                     System.out.println("Found " + value);
                                    }
                                 else
                                    System.out.println("Invalid index.");
                                 break;
                            case 'd':
                                 iterArray.remove();
                                 System.out.println("Removed " + iterArray);
                                 break;
                            default:
                                System.out.println("Invalid Entry");
            } // end of switch statement for Array
        } //end of while loop for Array Structure     
 }// end main

    public static String getString() throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static char getChar() throws IOException{
        String s = getString();
        return s.charAt(0);
    }
    
    public static int getInteger() throws IOException{
        String s = getString();
        return Integer.parseInt(s);
    }


} // End of EmployeeManagementSystem Class

