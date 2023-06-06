/**
 The Constant class represents a function that is a constant value.
 It extends the Function class and provides functionality for handling constant values.
 */
public class Constant extends Function {
    private final double doubleConstant;
    private final int intConstant;
    private final boolean isDouble;
    /**
     Constructs a Constant function with the given double constant value.
     @param constant The double constant value.
     */
    public Constant(double constant) {
        this.doubleConstant = constant;
        this.intConstant = 0;
        this.isDouble = true;
    }
    /**
     Constructs a Constant function with the given integer constant value.
     @param constant The integer constant value.
     */
    public Constant(int constant) {
        this.doubleConstant = 0.0;
        this.intConstant = constant;
        this.isDouble = false;
    }
    /**
     Calculates the value of the Constant function at the given x value.
     @param x The x value at which to calculate the function's value.
     @return The value of the Constant function.
     */
    public double valueAt(double x) {
        if (isDouble) {
            return doubleConstant;
        } else {
            return intConstant;
        }
    }
    /**
     Returns a string representation of the Constant function.
     @return The string representation of the Constant function.
     */
    @Override
    public String toString() {
        if (isDouble) {
            return "(" + doubleConstant + ")";
        } else {
            return "(" + intConstant + ")";
        }
    }
    /**
     Calculates the derivative of the Constant function.
     @return The derivative of the Constant function, which is always a Constant with the value of 0.
     */
    @Override
    public Function derivative() {
        return new Constant(0);
    }

}
