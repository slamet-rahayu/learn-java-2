package doc;

import doc.models.CalculatorInterface;

public class Calculator implements CalculatorInterface {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int res = calculator.add(1,2);
        System.out.println(res);
    }


    /**
     * <p>this method is used to add two number</p>
     * @param num1 number 1
     * @param num2 number 2
     * @return result of num1 + num2
     */
    public int add(int num1, int num2) {
        return num1 + num2;
    }
}
