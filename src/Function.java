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
     * @return the factorial number in double according to the instructions.
     */
    public double calculateFactorial(int n) {
        if (n==1 || n==0)
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
     * @param order the order of the Taylor polynomial
     * @return the Taylor polynomial of the specified order
     */
    public Polynomial  taylorPolynomial(int order) {
        double[] numbers = new double[order+1];
        Function derivative = this ;
        for (int index=0; index<=order; index++){
            // for each index it will calculate its value and will divide in the current factorial.
            numbers[index] = derivative.valueAt(0) / calculateFactorial(index);
            derivative = derivative.derivative();

        }
         return new Polynomial(numbers);
         }


    }




