import java.util.ArrayList;

abstract class Employee{
    private String name;
    private int id;
    // constructors
    public Employee(String name, int id){
        this.name = name;
        this.id = id;
    }
    // getter and setter method
    // this shows encasuplation bcoz we are securing name , nobody can access name and can be accessed only using this method
    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    // abstract function
    // abstract has a major feature that you dont have to declare the body of the task , just declare it and leave it to be used later
    public abstract double calculateSalary();

    @Override// we are overriding the default(built-in function) to string method
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

    public PartTimeEmployee(String name,int id, int hoursWorked, double hourlyRate){
        super(name,id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary(){
        return hoursWorked * hourlyRate;
    }
}

class PayrollSystem{
    private ArrayList<Employee>employeeList;

    public PayrollSystem(){
        employeeList = new ArrayList<>();
    }
    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }
    public void removeEmployee(int id){
        Employee employeeToRemove = null;
        for(Employee employee : employeeList){
            if(employee.getId() == id){
                employeeToRemove = employee;
                break;
            }
        }
        if(employeeToRemove!=null){
            employeeList.remove(employeeToRemove);
        }
    }
    public void displayEmployees(){
        for(Employee employee: employeeList){
            System.out.println(employee);
        }
    }
}
public class main {
    public static void main(String[] args) {
       PayrollSystem payrollSystem = new PayrollSystem();
       FullTimeEmployee emp1 = new FullTimeEmployee("John Doe", 101, 5000.0);
        PartTimeEmployee emp2 = new PartTimeEmployee("Jane Smith", 102, 30, 15.0);

        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);

        System.out.println("Initial Employee Details:");
        payrollSystem.displayEmployees();

        System.out.println("\nRemoving Employee...");
        payrollSystem.removeEmployee(101);

        System.out.println("\nRemaining Employee Details:");
        payrollSystem.displayEmployees();
    }
    
}