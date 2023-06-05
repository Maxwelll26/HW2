public abstract class Function {

    public abstract double valueAt(double x);

    @Override
    public abstract String toString();

    public abstract Function derivative();


    /* creating a code for Taylor Polynomial calculation */

    /**
     * The Taylor polynomial is a scheme of members, each part is divided by a factorial.
     * In this function we calculate what is the factorial of a certain number.
     *
     * @param n the number to calculate the factorial.
     * @return the factorial number in double according to the instructions.
     */
    public double calculateFactorial(int n) {
        if (n == 1 || n == 0)
            return 1;
        else {
            double factorial = 1;
            for (int i = 1; i <= n; i++) {
                factorial *= i;
            }
            return factorial;
        }
    }

    /**
     * Calculates the Taylor polynomial of the current polynomial function up to a specified order when X=0.
     *
     * @param order the order of the Taylor polynomial
     * @return the Taylor polynomial of the specified order
     */
    public Polynomial taylorPolynomial(int order) {
        double[] numbers = new double[order + 1];
        Function derivative = this;
        for (int index = 0; index <= order; index++) {
            // for each index it will calculate its value and will divide in the current factorial.
            numbers[index] = derivative.valueAt(0) / calculateFactorial(index);
            derivative = derivative.derivative();

        }
        return new Polynomial(numbers);
    }

    public double bisectionMethod(double a, double b) {
        double epsilon = 1e-5; // Default error value
        double left = a;
        double right = b;
        while (epsilon < right - left) {
            double mid = (left + right) / 2;
            if (valueAt(left) * valueAt(mid) > 0) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return (right + left) / 2;
    }
    public double bisectionMethod(double a, double b, double epsilon) {
        double left = a;
        double right = b;
        while (epsilon < right - left) {
            double mid = (left + right) / 2;
            if (valueAt(left) * valueAt(mid) > 0) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return (right + left) / 2;
    }
    public double newtonRaphsonMethod(double a, double epsilon) {
        double x = a;
        double f = valueAt(x);
        double fPrime = derivative().valueAt(x);
        while (Math.abs(f) >= epsilon) {
            x = x - (f / fPrime);
            f = valueAt(x);
            fPrime = derivative().valueAt(x);
        }
        return x;
    }
    public double newtonRaphsonMethod(double a) {
        double epsilon = 1e-5; //error value
        double x = a;
        double f = valueAt(x);
        double fPrime = derivative().valueAt(x);
        while (Math.abs(f) >= epsilon) {
            x = x - (f / fPrime);
            f = valueAt(x);
            fPrime = derivative().valueAt(x);
        }
        return x;
    }

}




