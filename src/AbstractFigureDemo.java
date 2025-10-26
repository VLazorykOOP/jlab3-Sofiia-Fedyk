abstract class Figure {
    protected String color;
    
    public Figure(String color) {
        this.color = color;
    }
    
    public abstract double calculateArea();
    public abstract double calculatePerimeter();
    
    public String getColor() {
        return color;
    }
}

class Rectangle extends Figure {
    private double width;
    private double height;
    
    public Rectangle(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }
    
    public double calculateArea() {
        return width * height;
    }
    
    public double calculatePerimeter() {
        return 2 * (width + height);
    }
    
    public String toString() {
        return "Rectangle [color=" + color + ", width=" + width + 
               ", height=" + height + ", area=" + calculateArea() + 
               ", perimeter=" + calculatePerimeter() + "]";
    }
    
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Rectangle rectangle = (Rectangle) obj;
        return Double.compare(rectangle.width, width) == 0 &&
               Double.compare(rectangle.height, height) == 0 &&
               color.equals(rectangle.color);
    }
}

class Circle extends Figure {
    private double radius;
    
    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }
    
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
    
    public String toString() {
        return "Circle [color=" + color + ", radius=" + radius + 
               ", area=" + String.format("%.2f", calculateArea()) + 
               ", perimeter=" + String.format("%.2f", calculatePerimeter()) + "]";
    }
    
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Circle circle = (Circle) obj;
        return Double.compare(circle.radius, radius) == 0 &&
               color.equals(circle.color);
    }
}

class Trapezium extends Figure {
    private double base1;
    private double base2;
    private double height;
    private double side1;
    private double side2;
    
    public Trapezium(String color, double base1, double base2, double height,
                    double side1, double side2) {
        super(color);
        this.base1 = base1;
        this.base2 = base2;
        this.height = height;
        this.side1 = side1;
        this.side2 = side2;
    }
    
    public double calculateArea() {
        return ((base1 + base2) / 2) * height;
    }
    
    public double calculatePerimeter() {
        return base1 + base2 + side1 + side2;
    }
    
    public String toString() {
        return "Trapezium [color=" + color + ", base1=" + base1 + 
               ", base2=" + base2 + ", height=" + height + 
               ", area=" + String.format("%.2f", calculateArea()) + 
               ", perimeter=" + String.format("%.2f", calculatePerimeter()) + "]";
    }
    
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Trapezium trapezium = (Trapezium) obj;
        return Double.compare(trapezium.base1, base1) == 0 &&
               Double.compare(trapezium.base2, base2) == 0 &&
               Double.compare(trapezium.height, height) == 0 &&
               Double.compare(trapezium.side1, side1) == 0 &&
               Double.compare(trapezium.side2, side2) == 0 &&
               color.equals(trapezium.color);
    }
}

public class AbstractFigureDemo {
    public static void main(String[] args) {
        Figure[] figures = new Figure[5];
        
        figures[0] = new Rectangle("Red", 5.0, 3.0);
        figures[1] = new Circle("Blue", 4.0);
        figures[2] = new Trapezium("Green", 8.0, 5.0, 4.0, 5.0, 5.0);
        figures[3] = new Rectangle("Yellow", 6.0, 6.0);
        figures[4] = new Circle("Purple", 2.5);
        
        System.out.println("METHOD DEMONSTRATION\n");
        
        for (int i = 0; i < figures.length; i++) {
            System.out.println("Figure " + (i + 1) + ":");
            System.out.println(figures[i].toString());
            System.out.println("Area: " + String.format("%.2f", figures[i].calculateArea()));
            System.out.println("Perimeter: " + String.format("%.2f", figures[i].calculatePerimeter()));
            System.out.println("Color: " + figures[i].getColor());
            System.out.println();
        }
        
        System.out.println("OBJECT EQUALITY CHECK \n");
        
        Rectangle rect1 = new Rectangle("Red", 5.0, 3.0);
        Rectangle rect2 = new Rectangle("Red", 5.0, 3.0);
        Rectangle rect3 = new Rectangle("Blue", 5.0, 3.0);
        
        System.out.println("rect1: " + rect1);
        System.out.println("rect2: " + rect2);
        System.out.println("rect3: " + rect3);
        System.out.println();
        System.out.println("rect1.equals(rect2): " + rect1.equals(rect2));
        System.out.println("rect1.equals(rect3): " + rect1.equals(rect3));
        System.out.println();
        
        Circle circle1 = new Circle("Blue", 4.0);
        Circle circle2 = new Circle("Blue", 4.0);
        Circle circle3 = new Circle("Blue", 5.0);
        
        System.out.println("circle1: " + circle1);
        System.out.println("circle2: " + circle2);
        System.out.println("circle3: " + circle3);
        System.out.println();
        System.out.println("circle1.equals(circle2): " + circle1.equals(circle2));
        System.out.println("circle1.equals(circle3): " + circle1.equals(circle3));
        
        System.out.println("\nPOLYMORPHISM\n");
        System.out.println("Total area of all figures:");
        double totalArea = 0;
        for (Figure f : figures) {
            totalArea += f.calculateArea();
        }
        System.out.println(String.format("%.2f", totalArea));
    }
}