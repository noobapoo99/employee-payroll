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
    


}
public class main {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
    
}