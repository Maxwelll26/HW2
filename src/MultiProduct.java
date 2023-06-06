/**
 * The MultiProduct class represents a function that is a product of multiple functions.
 * It extends the Function class and provides functionality for handling multiple functions.
 */
public class MultiProduct extends Function {
    private Function[] functions;

    /**
     * Constructs a MultiProduct function with the given functions.
     * To make sure that in order to use this class, at least 2 functions are needed, we created our constructor
     * accordingly so that it receives the first and second function, and if there are more, then that's fine.
     * the 2 first given function they will be in the array in the first 2 places and all the other
     * function in the places afterward.
     *
     * @param functions The functions to be summed.
     */
    public MultiProduct(Function f1, Function f2, Function... functions) {
        this.functions = new Function[functions.length + 2];
        this.functions[0] = f1;
        this.functions[1] = f2;
        for (int i = 2; i < this.functions.length; i++) {
            this.functions[i] = functions[i - 2];
        }
    }

    public MultiProduct(Function func1, Function func2) {
        this.functions = new Function[2];
        this.functions[0] = func1;
        this.functions[1] = func2;
    }

    /**
     * Calculates the value of the MultiSum function at the given x value.
     *
     * @param x The x value at which to calculate the function's value.
     * @return The value of the MultiSum function at the given x value.
     */
    @Override
    public double valueAt(double x) {
        double product = 1.0;
        for (Function function : functions) {
            product *= function.valueAt(x);
        }
        return product;
    }

    /**
     * Returns a string representation of the MultiSum function using string builder - loop that adding sub string.
     *
     * @return The string representation of the MultiSum function.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (int i = 0; i < functions.length; i++) {
            sb.append(functions[i].toString());
            if (i < functions.length - 1) {
                sb.append(" * ");
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /**
     * Calculates the derivative of the MultiProduct function using derivative method of function .
     *
     * @return The derivative of the MultiProduct function using the multiSum function.
     */
    @Override
    public Function derivative() {
        Function[] derivatives = new Function[functions.length - 2];
        for (int i = 0; i < functions.length - 2; i++) {
            derivatives[i] = functions[i + 2];
        }

        MultiProduct f1 = new MultiProduct(functions[0].derivative(), functions[1], derivatives);
        MultiProduct f2 = new MultiProduct(functions[1].derivative(), functions[0], derivatives);

        MultiProduct[] m = new MultiProduct[functions.length - 2];

        for (int i = 0; i < functions.length - 2; ++i) {
            m[i] = new MultiProduct(functions[i + 2].derivative(), functions[0]);
            for (int j = 0; j < functions.length; ++j) {
                if ((i + 2 != j) && (j != 0))
                    m[i].addFunction(functions[j]);
            }
        }

        return new MultiSum(f1, f2, m);
    }

    private void addFunction(Function function) {
        Function[] newFunctions = new Function[this.functions.length + 1];
        int i = 0;
        for (;i < this.functions.length; ++i) {
            newFunctions[i] = this.functions[i];
        }
        newFunctions[i] = function;
        this.functions = newFunctions;
    }
}





