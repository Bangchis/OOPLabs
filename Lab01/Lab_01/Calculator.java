import javax.swing.JOptionPane;

/**
 * Calculator
 */
public class Calculator {

    public static void main(String[] args) {
        double num1, num2;
        String string_num1, string_num2;

        string_num1 = JOptionPane.showInputDialog(null,"Please enter the first number: ", "Input the first number:", JOptionPane.INFORMATION_MESSAGE);

        string_num2 = JOptionPane.showInputDialog(null,"Please enter the second number: ", "Input the second number:", JOptionPane.INFORMATION_MESSAGE);

        num1 = Double.parseDouble(string_num1);

        num2 = Double.parseDouble(string_num2);

        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;
        double quotient = num1 / num2;

        if (num2 == 0) {
            JOptionPane.showMessageDialog(null, "Division by zero is not allowed.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            quotient = num1 / num2;
            String message = String.format("Sum: %.2f\nDifference: %.2f\nProduct: %.2f\nQuotient: %.2f", sum, difference, product, quotient);
            JOptionPane.showMessageDialog(null, message, "Results", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}