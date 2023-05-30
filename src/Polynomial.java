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
        for (int i = coefficients.length - 1; i >= 0; i--) {
            double coefficient = coefficients[i];
            if (coefficient == 0) {
                continue;
            }
            if (sb.length() > 0) {
                sb.append(coefficient >= 0 ? " + " : " - ");
            } else if (coefficient < 0) {
                sb.append("-");
            }
            coefficient = Math.abs(coefficient);
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
            sb.append("0"); //zero polynomial
        }
        return "(" + sb.toString() + ")";
    }

}
