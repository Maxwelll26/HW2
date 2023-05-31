public abstract class Function {

    public abstract double valueAt(double x);
    @Override
    public abstract String toString();
    public abstract Function derivative();


    /* creating a code for Taylor Polynomial calculation */

    /**
     * The Taylor polynomial is a scheme of members, each part is divided by a factorial.
     * In this function we calculate what is the factorial of a certain number.
     * @param n the number to calculate the factorial.
     * @return the factorial number
     */
    public int calculateFactorial(int n) {
        if (n==1 || n==0)
            return 1;
        else {
            int factorial = 2;

            for (int i = 2; i <= n; i++) {
                factorial *= i;
            }
            return factorial;
        }
    }

    /**
     * calculates the derivative of a function at a specified order.
     * If the order is greater than 0, it calculates the derivative of the derivative function
     * and assigns it back to the derivative
     * @param order the order for the current function we cant to do derivative
     * @return Function`s derivative.
     */
    public Function derivativeAtOrder(int order) {
        if (order == 0) {
            return this;
        }
        else {
            Function derivative = this;
            for (int i = 0; i < order; i++) {
                derivative = derivative.derivative();
            }
            return derivative;
        }
    }



    public double taylorPolynomial(double x, int order) {
        double result = 0.0;
        for (int i = 0; i <= order; i++) {
            double coefficient = derivativeAtOrder(i).valueAt(x) / calculateFactorial(i);
            double term = coefficient * Math.pow(x, i);
            result += term;
        }
        return result;
    }


}
