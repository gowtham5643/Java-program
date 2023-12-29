
package placement_training;
class employee {
    private String name;
    private int employeeID;
    public employee(String name, int employeeID) {
        this.name = name;
        this.employeeID = employeeID;
    }
    public double calculateSalary() {
        return 50000; 
    }
    public String getName() {
        return name;
    }

    public int getEmployeeID() {
        return employeeID;
    }
}

class manager1 extends employee {
    private double bonusPercentage;

    public manager1(String name, int employeeID, double bonusPercentage) {
        super(name, employeeID);
        this.bonusPercentage = bonusPercentage;
    }

    @Override
    public double calculateSalary() {
        return super.calculateSalary() + (super.calculateSalary() * bonusPercentage / 100);
    }

    public double getBonusPercentage() {
        return bonusPercentage;
    }
}

class Developer extends employee {
    private String programmingLanguage;

    public Developer(String name, int employeeID, String programmingLanguage) {
        super(name, employeeID);
        this.programmingLanguage = programmingLanguage;
    }
    @Override
    public double calculateSalary() {
        return super.calculateSalary() + 10000; 
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }
}

public class Company {
    public static void main(String[] args) {
        manager1 manager = new manager1("Jaikyy", 101, 15.0);
        Developer developer = new Developer("Ramky", 201, "Java");
        System.out.println("Manager Details:");
        System.out.println("Name: " + manager.getName());
        System.out.println("Employee ID: " + manager.getEmployeeID());
        System.out.println("Bonus Percentage: " + manager.getBonusPercentage() + "%");
        System.out.println("Calculated Salary: $" + manager.calculateSalary());
        System.out.println("\nDeveloper Details:");
        System.out.println("Name: " + developer.getName());
        System.out.println("Employee ID: " + developer.getEmployeeID());
        System.out.println("Programming Language: " + developer.getProgrammingLanguage());
        System.out.println("Calculated Salary: $" + developer.calculateSalary());
    }
}
