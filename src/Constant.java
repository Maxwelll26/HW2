public class Constant extends Function {
        private final double constantValue;

    /**
     * constructor for constant value
     * @param constantValue double number.
     */
    public Constant(double constantValue) {
            this.constantValue = constantValue;
        }

    /**
     * In constant function, no matter what will be the X that we will put in the function,
     * we will always get the same number - the initial constant number of the function.
     * @param x - double number that we will "put" in the function
     * @return the same constant value
     */
        @Override
        public double valueAt(double x) {
            return constantValue;
        }


        @Override
        public String toString() {
            return Double.toString(constantValue);
        }

    /**
     * The derivative of a constant function is always 0
     * @return constant function that represents 0.
     */
    @Override
        public Function derivative() {
            return new Constant(0);
        }
    }

