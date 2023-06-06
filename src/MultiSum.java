
/**
 * The MultiSum class represents a function that is a sum of multiple functions.
 * It extends the Function class and provides functionality for handling multiple functions.
 */
public class MultiSum extends Function {
    private  Function[] functions;

    /**
     * Constructs a MultiSum function with the given functions.
     * To make sure that in order to use this class, at least 2 functions are needed, we created our constructor
     * accordingly so that it receives the first and second function, and if there are more, then that's fine.
     * the 2 first given function they will be in the array in the first 2 places and all the other
     * function in the places afterwards.
     * @param functions The functions to be summed.
     * @param f1 the first function that must be added - for compilation
     * @param f2 the second function that must be added - for compilation
     */
    public MultiSum(Function f1, Function f2,Function... functions) {
        this.functions = new Function[functions.length + 2];
        this.functions[0] = f1;
        this.functions[1] = f2;

        for (int i = 0; i < functions.length; i++) {
            this.functions[i + 2] = functions[i];
        }
    }


    /**
     * Calculates the value of the MultiSum function at the given x value.
     * @param x The x value at which to calculate the function's value.
     * @return The value of the MultiSum function at the given x value.
     */
    @Override
    public double valueAt(double x) {
        double sum = 0.0;
        for (Function function : functions) {
            sum += function.valueAt(x);
            }
            return sum;
        }

    /**
     * Returns a string representation of the MultiSum function using string builder - loop that adding sub string.
     * @return The string representation of the MultiSum function.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (int i = 0; i < functions.length; i++) {
            sb.append(functions[i].toString());
            if (i < functions.length - 1) {
                sb.append(" + ");
            }
        }
        sb.append(")");
        return sb.toString();
        }

    /**
     * Calculates the derivative of the MultiSum function using derivative method of function .
     * every function in the array will be calculated her derivative.
     * @return The derivative of the MultiSum function - the first 2 arguments are thr derivative of the first 2
     * functions, and the rest will be the derivative of the other functions.
     */
    @Override
    public Function derivative() {
        Function[] derivatives = new Function[functions.length - 2];
        for (int i = 2; i < functions.length; i++) {
            derivatives[i - 2] = functions[i].derivative();
        }
        return new MultiSum(functions[0].derivative(),functions[1].derivative(), derivatives);
    }


}




