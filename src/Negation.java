/**
 The Negation class represents a function that negates the value of another function.
 It extends the Function class and provides functionality for handling the negation operation.
 */
public class Negation extends Function {
    private Function function;
    /**
     Constructs a Negation function with the given function to be negated.
     @param function The function to be negated.
     */
    public Negation(Function function) {
        this.function = function;
    }
    /**
     Calculates the value of the Negation function at the given x value.
     It negates the value of the underlying function by multiplying it by -1.
     @param x The x value at which to calculate the function's value.
     @return The negated value of the underlying function at the given x value.
     */
    @Override
    public double valueAt(double x) {
        return -function.valueAt(x);
    }
    /**
     Returns a string representation of the Negation function.
     It represents the negation of the underlying function.
     @return The string representation of the Negation function in the format (-function).
     */
    @Override
    public String toString() {
        return "(-" + function.toString() + ")";
    }
    /**
     Calculates the derivative of the Negation function.
     It computes the derivative of the underlying function and returns a new Negation function
     with the derivative of the underlying function.
     @return The derivative of the Negation function as a new Negation function.
     */
    @Override
    public Function derivative() {
        return new Negation(function.derivative());
    }
}
