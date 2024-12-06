abstract class Employee{
    private String name;
    private int id;
    // constructors
    public Employee(String name, int id){
        this.name = name;
        this.id = id;
    }
    // getter and setter method

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    // abstract
    public abstract double calculateSalary();

    @Override
    public String toString(){
        return "Employee [name="+name+" , id = "+id+" , salary = "+calculateSalary()+" ]";
    }
}

class FullTimeEmployee extends Employee{// as we are extinding an abstract class we were getting this error bcoz no body was provided for that abstract class
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary){
        super(name, id); // taken from the parent class
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary(){
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee{
    
    private int hoursWorked;

    private double hourlyRate;

    public PartTimeEmployee(string name,int id, int hoursWorked, double hourlyRate){
        super(name,id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary(){
        return hoursWorked * hourlyRate;
    }
}
public class main {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
    
}