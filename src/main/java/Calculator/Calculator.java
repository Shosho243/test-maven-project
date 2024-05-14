package Calculator;

public class Calculator {
    public static void main(String[] args) {
        Circle circle = new Circle(5, "Red", "Black");
        Rectangle rectangle = new Rectangle(4, 6, "Blue", "Green");
        Triangle triangle = new Triangle(3, 4, 5, "Yellow", "Purple");

        System.out.println("Периметр Круга: " + circle.calculatePerimeter() + " Площадь: " + circle.calculateArea()
                + " Цвет фона: " + circle.getFillColor() + " Цвет границ: " + circle.getBorderColor());
        System.out.println("Периметр Круга: " + rectangle.calculatePerimeter() + " Площадь: " + rectangle.calculateArea()
                + " Цвет фона: " + rectangle.getFillColor() + " Цвет границ: " + rectangle.getBorderColor());
        System.out.println("Периметр Круга: " + triangle.calculatePerimeter() + " Площадь: " + triangle.calculateArea()
                + " Цвет фона: " + triangle.getFillColor() + " Цвет границ: " + triangle.getBorderColor());
    }
}

