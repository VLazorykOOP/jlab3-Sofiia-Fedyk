import java.util.Scanner;

class Engine {
    protected String model;
    protected int power;
    protected double weight;
    
    public Engine(String model, int power, double weight) {
        this.model = model;
        this.power = power;
        this.weight = weight;
    }
    
    public void show() {
        System.out.println("=== Engine ===");
        System.out.println("Model: " + model);
        System.out.println("Power: " + power + " kW");
        System.out.println("Weight: " + weight + " kg");
    }
}

class InternalCombustionEngine extends Engine {
    protected int cylindersCount;
    protected String fuelType;
    
    public InternalCombustionEngine(String model, int power, double weight, 
                                   int cylindersCount, String fuelType) {
        super(model, power, weight);
        this.cylindersCount = cylindersCount;
        this.fuelType = fuelType;
    }
    
    public void show() {
        System.out.println("=== Internal Combustion Engine ===");
        System.out.println("Model: " + model);
        System.out.println("Power: " + power + " kW");
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Number of cylinders: " + cylindersCount);
        System.out.println("Fuel type: " + fuelType);
    }
}

class DieselEngine extends InternalCombustionEngine {
    private double torque;
    
    public DieselEngine(String model, int power, double weight, 
                       int cylindersCount, double torque) {
        super(model, power, weight, cylindersCount, "Diesel");
        this.torque = torque;
    }
    
    public void show() {
        System.out.println("=== Diesel Engine ===");
        System.out.println("Model: " + model);
        System.out.println("Power: " + power + " kW");
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Number of cylinders: " + cylindersCount);
        System.out.println("Fuel type: " + fuelType);
        System.out.println("Torque: " + torque + " Nm");
    }
}

class JetEngine extends Engine {
    private double thrust;
    private String engineType;
    
    public JetEngine(String model, int power, double weight, 
                    double thrust, String engineType) {
        super(model, power, weight);
        this.thrust = thrust;
        this.engineType = engineType;
    }
    
    public void show() {
        System.out.println("=== Jet Engine ===");
        System.out.println("Model: " + model);
        System.out.println("Power: " + power + " kW");
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Thrust: " + thrust + " kN");
        System.out.println("Type: " + engineType);
    }
}

class EngineHierarchyDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("How many engines do you want to enter? ");
        int n = scanner.nextInt();
        scanner.nextLine();
        
        Engine[] engines = new Engine[n];
        
        for (int i = 0; i < n; i++) {
            System.out.println("\nEntering Engine " + (i + 1) + " ");
            System.out.println("Choose engine type:");
            System.out.println("1 - Regular Engine");
            System.out.println("2 - Internal Combustion Engine");
            System.out.println("3 - Diesel Engine");
            System.out.println("4 - Jet Engine");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Model: ");
            String model = scanner.nextLine();
            System.out.print("Power (kW): ");
            int power = scanner.nextInt();
            System.out.print("Weight (kg): ");
            double weight = scanner.nextDouble();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    engines[i] = new Engine(model, power, weight);
                    break;
                case 2:
                    System.out.print("Number of cylinders: ");
                    int cylinders = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Fuel type: ");
                    String fuel = scanner.nextLine();
                    engines[i] = new InternalCombustionEngine(model, power, weight, 
                                                             cylinders, fuel);
                    break;
                case 3:
                    System.out.print("Number of cylinders: ");
                    int dieselCylinders = scanner.nextInt();
                    System.out.print("Torque (Nm): ");
                    double torque = scanner.nextDouble();
                    scanner.nextLine();
                    engines[i] = new DieselEngine(model, power, weight, 
                                                 dieselCylinders, torque);
                    break;
                case 4:
                    System.out.print("Thrust (kN): ");
                    double thrust = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Jet engine type: ");
                    String type = scanner.nextLine();
                    engines[i] = new JetEngine(model, power, weight, thrust, type);
                    break;
                default:
                    System.out.println("Invalid choice! Creating a regular engine.");
                    engines[i] = new Engine(model, power, weight);
            }
        }
        
        System.out.println("\n\nList of all engines\n");
        for (int i = 0; i < engines.length; i++) {
            System.out.println("Engine #" + (i + 1) + ":");
            engines[i].show();
            System.out.println();
        }
        
        scanner.close();
    }
}