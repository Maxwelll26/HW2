/**
 The Polynomial class represents a polynomial function with variable coefficients.
 It extends the Function class and provides methods for calculating the value, obtaining a string representation,
 and computing the derivative of the polynomial function.
 */
public class Polynomial extends Function {
    private final double[] coefficients;
    /**
     Constructs a Polynomial function with the given coefficients.
     The coefficients are specified in increasing order of degree.
     @param coefficients The coefficients of the polynomial function.
     */
    public Polynomial(double... coefficients) {
        this.coefficients = coefficients;
    }
    /**
     Calculates the value of the Polynomial function at the given x value.
     It evaluates the polynomial by summing up the product of each coefficient and the corresponding power of x.
     @param x The x value at which to calculate the function's value.
     @return The value of the Polynomial function at the given x value.
     */
    @Override
    public double valueAt(double x) {
        double result = 0.0;
        for (int i = 0; i < coefficients.length; i++) {
            result += coefficients[i] * Math.pow(x, i);
        }
        return result;
    }
    /**
     Returns a string representation of the Polynomial function.
     It represents the polynomial as a sum of its terms with proper formatting.
     @return The string representation of the Polynomial function.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        boolean isFirstTerm = true;

        for (int i = 0; i < coefficients.length; i++) {
            double coefficient = coefficients[i];

            if (coefficient == 0) {
                continue;
            }

            if (!isFirstTerm) {
                sb.append(coefficient >= 0 ? " + " : " - ");
                coefficient = Math.abs(coefficient);
            } else {
                isFirstTerm = false;
                if (coefficient < 0) {
                    sb.append("-");
                    coefficient = Math.abs(coefficient);
                }
            }

            if (i == 0 || coefficient != 1) {
                if (coefficient == (int) coefficient) {
                    sb.append((int) coefficient);
                } else {
                    sb.append(coefficient);
                }
            }

            if (i > 0) {
                sb.append("x");
                if (i > 1) {
                    sb.append("^").append(i);
                }
            }
        }

        if (sb.length() == 0) {
            sb.append("0"); // zero polynomial
        }

        return "(" + sb.toString() + ")";
    }
    /**
     Calculates the derivative of the Polynomial function.
     It computes the derivative of the polynomial by multiplying each coefficient by its corresponding power of x
     and reducing the degree of the polynomial by 1.
     @return The derivative of the Polynomial function as a new Polynomial function.
     */
    @Override
    public Function derivative() {
        int degree = coefficients.length - 1;
        if (degree <= 0) {
            // Handle the case where the polynomial is a constant (degree 0)
            return new Polynomial(0);
        }
        double[] derivativeCoefficients = new double[degree];
        for (int i = 0; i < degree; i++) {
            derivativeCoefficients[i] = coefficients[i + 1] * (i + 1);
        }
        return new Polynomial(derivativeCoefficients);
    }
}
