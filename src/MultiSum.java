
/**
 * The MultiSum class represents a function that is a sum of multiple functions.
 * It extends the Function class and provides functionality for handling multiple functions.
 */
public class MultiSum extends Function {
    // max code
    /*
    public MultiSum(Function... functions) {
        super(functions[0], functions[1]);
        for (int i = 2; i < functions.length; i++) {
            addFunction(functions[i]);
        }
    }
    private void addFunction(Function function) {
        secondFunction = new Sum(secondFunction, function);
    }

    @Override
    public String toString() {
            return "(" + firstFunction.toString() + " + " + secondFunction.toString() + ")";
        }

     */
    private  Function[] functions;

    /**
     * Constructs a MultiSum function with the given functions.
     * @param functions The functions to be summed.
     */
    public MultiSum(Function f1, Function f2, Function... functions) {
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
     * @return The derivative of the MultiSum function.
     */
    @Override
    public Function derivative() {
        Function[] derivatives = new Function[functions.length - 2];
        for (int i = 2; i < functions.length; i++) {
            derivatives[i - 2] = functions[i].derivative();
        }
        return new MultiSum(functions[0].derivative(), functions[1].derivative(), derivatives);
    }


}




