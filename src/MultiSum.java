public class MultiSum extends Sum {
    public MultiSum(Function... functions) {
        super(functions[0], functions[1]);
        for (int i = 2; i < functions.length; i++) {
            addFunction(functions[i]);
        }
    }
    private void addFunction(Function function) {
        secondFunction = new Sum(secondFunction, function);
    }
}
