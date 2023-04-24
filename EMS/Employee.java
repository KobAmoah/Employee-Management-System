/**
*This program creates an employee object
*@verion 1.0 2023-04-05
*@author Kobby Amoah
*/
import java.time.*;

public class Employee{
    private String name;
    private double salary;
    private LocalDate hireDay;
    private long id_number;
    private long contact_no;
    private String email;
    
    // Constructor
    /** Constructor for the Employee class
    * @param name  = employee name
    * @param salary = employee salary
    * @param year = employee hiring year
    * @param month = employee hiring month
    * @param day = = employee hiring day
    * @param id_number = employee id
    * @param contact_no = employee contact number
    * @param email = employee email
    */
    public Employee(String name,double salary, int year, int month, int day , long id_number, long contact_no, String email){
        this.name = name;
        this.salary = salary;
        hireDay = LocalDate.of(year,month,day);
        this.id_number = id_number;
        this.contact_no = contact_no;
        this.email = email;
    }
    
    /** methods to access employee attributes*/
    public String getName(){return name;}
    public double getSalary(){return salary;}
    public long getId(){return id_number;}
    public long getContact(){return contact_no;}
    public String getEmail(){return email;}
    public LocalDate getHireDay(){return hireDay;}
    
    /** compares an Employee object to another */
    public boolean equals(Employee other){
        return id_number == other.id_number; 
    }
    
    public String toString(){
        return getClass().getName()
            + "[name : " + name
            + " ,salary : " + salary
            + " ,hired on : " + hireDay
            +  " ,id_number : " + id_number
            +  " ,email : " + email
            + "]";
    }
    
} // end of Employee Object class