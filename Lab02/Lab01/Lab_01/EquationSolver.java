import java.util.Scanner;

public class EquationSolver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose the type of equation to solve:");
        System.out.println("1. First-degree equation with one variable (ax + b = 0)");
        System.out.println("2. System of first-degree equations with two variables");
        System.out.println("3. Second-degree equation with one variable (ax^2 + bx + c = 0)");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                solveFirstDegreeEquation(scanner);
                break;
            case 2:
                solveSystemOfFirstDegreeEquations(scanner);
                break;
            case 3:
                solveSecondDegreeEquation(scanner);
                break;
            default:
                System.out.println("Invalid choice");
        }
        scanner.close();
    }

    private static void solveFirstDegreeEquation(Scanner scanner) {
        System.out.print("Enter coefficient a: ");
        double a = scanner.nextDouble();
        System.out.print("Enter coefficient b: ");
        double b = scanner.nextDouble();

        if (a == 0) {
            System.out.println("Coefficient a cannot be 0.");
        } else {
            double x = -b / a;
            System.out.println("The solution is x = " + x);
        }
    }

    private static void solveSystemOfFirstDegreeEquations(Scanner scanner) {
        System.out.print("Enter coefficient a11: ");
        double a11 = scanner.nextDouble();
        System.out.print("Enter coefficient a12: ");
        double a12 = scanner.nextDouble();
        System.out.print("Enter coefficient b1: ");
        double b1 = scanner.nextDouble();
        System.out.print("Enter coefficient a21: ");
        double a21 = scanner.nextDouble();
        System.out.print("Enter coefficient a22: ");
        double a22 = scanner.nextDouble();
        System.out.print("Enter coefficient b2: ");
        double b2 = scanner.nextDouble();

        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        if (D == 0) {
            if (D1 == 0 && D2 == 0) {
                System.out.println("The system has infinitely many solutions.");
            } else {
                System.out.println("The system has no solution.");
            }
        } else {
            double x1 = D1 / D;
            double x2 = D2 / D;
            System.out.println("The solutions are x1 = " + x1 + ", x2 = " + x2);
        }
    }

    private static void solveSecondDegreeEquation(Scanner scanner) {
        System.out.print("Enter coefficient a: ");
        double a = scanner.nextDouble();
        System.out.print("Enter coefficient b: ");
        double b = scanner.nextDouble();
        System.out.print("Enter coefficient c: ");
        double c = scanner.nextDouble();

        if (a == 0) {
            System.out.println("Coefficient a cannot be 0.");
        } else {
            double delta = b * b - 4 * a * c;
            if (delta > 0) {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                System.out.println("The solutions are x1 = " + x1 + ", x2 = " + x2);
            } else if (delta == 0) {
                double x = -b / (2 * a);
                System.out.println("The solution is x = " + x);
            } else {
                System.out.println("The equation has no real roots.");
            }
        }
    }
}
