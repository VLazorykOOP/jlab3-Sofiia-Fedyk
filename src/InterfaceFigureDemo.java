interface IFigure {
    double calculateArea();
    double calculatePerimeter();
    String getColor();
}

class MyRectangle implements IFigure {
    private String color;
    private double width;
    private double height;
    
    public MyRectangle(String color, double width, double height) {
        this.color = color;
        this.width = width;
        this.height = height;
    }
    
    public double calculateArea() {
        return width * height;
    }
    
    public double calculatePerimeter() {
        return 2 * (width + height);
    }
    
    public String getColor() {
        return color;
    }
    
    public String toString() {
        return "Rectangle [color=" + color + ", width=" + width + 
               ", height=" + height + ", area=" + calculateArea() + 
               ", perimeter=" + calculatePerimeter() + "]";
    }
    
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MyRectangle rectangle = (MyRectangle) obj;
        return Double.compare(rectangle.width, width) == 0 &&
               Double.compare(rectangle.height, height) == 0 &&
               color.equals(rectangle.color);
    }
}

class MyCircle implements IFigure {
    private String color;
    private double radius;
    
    public MyCircle(String color, double radius) {
        this.color = color;
        this.radius = radius;
    }
    
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
    
    public String getColor() {
        return color;
    }
    
    public String toString() {
        return "Circle [color=" + color + ", radius=" + radius + 
               ", area=" + String.format("%.2f", calculateArea()) + 
               ", perimeter=" + String.format("%.2f", calculatePerimeter()) + "]";
    }
    
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MyCircle circle = (MyCircle) obj;
        return Double.compare(circle.radius, radius) == 0 &&
               color.equals(circle.color);
    }
}

class MyTrapezium implements IFigure {
    private String color;
    private double base1;
    private double base2;
    private double height;
    private double side1;
    private double side2;
    
    public MyTrapezium(String color, double base1, double base2, double height,
                    double side1, double side2) {
        this.color = color;
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
    
    public String getColor() {
        return color;
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
        MyTrapezium trapezium = (MyTrapezium) obj;
        return Double.compare(trapezium.base1, base1) == 0 &&
               Double.compare(trapezium.base2, base2) == 0 &&
               Double.compare(trapezium.height, height) == 0 &&
               Double.compare(trapezium.side1, side1) == 0 &&
               Double.compare(trapezium.side2, side2) == 0 &&
               color.equals(trapezium.color);
    }
}

class InterfaceFigureDemo {
    public static void main(String[] args) {
        IFigure[] figures = new IFigure[5];
        
        figures[0] = new MyRectangle("Red", 5.0, 3.0);
        figures[1] = new MyCircle("Blue", 4.0);
        figures[2] = new MyTrapezium("Green", 8.0, 5.0, 4.0, 5.0, 5.0);
        figures[3] = new MyRectangle("Yellow", 6.0, 6.0);
        figures[4] = new MyCircle("Purple", 2.5);
        
        System.out.println(" METHOD DEMONSTRATION (with Interface)  \n");
        
        for (int i = 0; i < figures.length; i++) {
            System.out.println("Figure " + (i + 1) + ":");
            System.out.println(figures[i].toString());
            System.out.println("Area: " + String.format("%.2f", figures[i].calculateArea()));
            System.out.println("Perimeter: " + String.format("%.2f", figures[i].calculatePerimeter()));
            System.out.println("Color: " + figures[i].getColor());
            System.out.println();
        }
        
        System.out.println(" OBJECT EQUALITY CHECK  \n");
        
        MyRectangle rect1 = new MyRectangle("Red", 5.0, 3.0);
        MyRectangle rect2 = new MyRectangle("Red", 5.0, 3.0);
        MyRectangle rect3 = new MyRectangle("Blue", 5.0, 3.0);
        
        System.out.println("rect1: " + rect1);
        System.out.println("rect2: " + rect2);
        System.out.println("rect3: " + rect3);
        System.out.println();
        System.out.println("rect1.equals(rect2): " + rect1.equals(rect2));
        System.out.println("rect1.equals(rect3): " + rect1.equals(rect3));
        System.out.println();
        
        MyCircle circle1 = new MyCircle("Blue", 4.0);
        MyCircle circle2 = new MyCircle("Blue", 4.0);
        MyCircle circle3 = new MyCircle("Blue", 5.0);
        
        System.out.println("circle1: " + circle1);
        System.out.println("circle2: " + circle2);
        System.out.println("circle3: " + circle3);
        System.out.println();
        System.out.println("circle1.equals(circle2): " + circle1.equals(circle2));
        System.out.println("circle1.equals(circle3): " + circle1.equals(circle3));
        
        System.out.println("\n POLYMORPHISM WITH INTERFACE  \n");
        System.out.println("Total area of all figures:");
        double totalArea = 0;
        for (IFigure f : figures) {
            totalArea += f.calculateArea();
        }
        System.out.println(String.format("%.2f", totalArea));
        
        System.out.println("\nTotal perimeter of all figures:");
        double totalPerimeter = 0;
        for (IFigure f : figures) {
            totalPerimeter += f.calculatePerimeter();
        }
        System.out.println(String.format("%.2f", totalPerimeter));
        
        System.out.println("\n WORKING WITH SPECIFIC TYPES  \n");
        for (IFigure f : figures) {
            if (f instanceof MyRectangle) {
                System.out.println("Found rectangle: " + f);
            } else if (f instanceof MyCircle) {
                System.out.println("Found circle: " + f);
            } else if (f instanceof MyTrapezium) {
                System.out.println("Found trapezium: " + f);
            }
        }
    }
}