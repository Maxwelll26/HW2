public class Polynomial extends Function {
    private final double[] coefficients;

    public Polynomial(double... coefficients) {
        this.coefficients = coefficients;
    }
    @Override
    public double valueAt(double x) {
        double result = 0.0;
        for (int i = 0; i < coefficients.length; i++) {
            result += coefficients[i] * Math.pow(x, i);
        }
        return result;
    }

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
    @Override
    public Function derivative() {
        int degree = coefficients.length - 1;
        double[] derivativeCoefficients = new double[degree];
        for (int i = 0; i < degree; i++) {
            derivativeCoefficients[i] = coefficients[i + 1] * (i + 1);
        }
        return new Polynomial(derivativeCoefficients);
    }
}
