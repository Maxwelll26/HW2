public class Constant extends Function {
    //private final double constant;
    private final double doubleConstant;
    private final int intConstant;
    private final boolean isDouble;

    public Constant(double constant) {
        this.doubleConstant = constant;
        this.intConstant = 0;
        this.isDouble = true;
    }

    public Constant(int constant) {
        this.doubleConstant = 0.0;
        this.intConstant = constant;
        this.isDouble = false;
    }



    /*
    public Constant(double constant) {
        this.constant = constant;
    }

     */
    /*
    @Override
    public double valueAt(double x) {
        return constant;
    }

     */

    public double valueAt(double x) {
        if (isDouble) {
            return doubleConstant;
        } else {
            return intConstant;
        }
    }
    /*
    @Override
    public String toString() {
        return "(" + constant + ")";
    }

     */

    @Override
    public String toString() {
        if (isDouble) {
            return "(" + doubleConstant + ")";
        } else {
            return "(" + intConstant + ")";
        }
    }
    /*
    @Override
    public Function derivative() {
        return new Constant(0.0);
    }

     */
    @Override
    public Function derivative() {
        if (isDouble) {
            return new Constant(0.0);
        } else {
            return new Constant(0);
        }
    }

}
