public class Product extends Function {
        private Function firstFunction;
        private Function secondFunction;

        /**
         * contractor for the power class. power in this case is between 2 objects.
         * @param firstFunction from the Type of function
         * @param secondFunction from the type of function
         */
        public Product (Function firstFunction, Function secondFunction) {
            this.firstFunction = firstFunction;
            this.secondFunction = secondFunction;
        }

        /**
         * The result of a power function is to take each function and calculate its value and
         * then multiply between the 2 results.
         * @param x - double For which X we calculate the value of the function.
         * @return we will get a double number.
         */
        @Override
        public double valueAt(double x) {
            return firstFunction.valueAt(x) * secondFunction.valueAt(x);
        }

        /**
         * We represent multiplication between 2 functions simply by presenting function A
         * and multiply with function B.
         * @return String in the format (Fx * Gx)
         */
        @Override
        public String toString() {
            return "(" + firstFunction.toString() + " * " + secondFunction.toString() + ")";
        }

        /**
         * The derivative of the product of 2 functions is known and is in the following format:
         * F(x)*G(x) dx = F`(x)*G(x) + F(x)*G`(x)
         * @return sum function.
         */
        @Override
        public Function derivative() {
            Function derivativeFirst = firstFunction.derivative();
            Function derivativeSecond = secondFunction.derivative();
            Product firstMulti = new Product(derivativeFirst,secondFunction);
            Product SecondMulti = new Product(firstFunction,derivativeSecond);
            return new Sum(firstMulti,SecondMulti);
        }
    }

}
