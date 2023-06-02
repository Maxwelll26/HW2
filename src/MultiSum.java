public class MultiSum extends Sum {
    public MultiSum(Function function1, Function function2, Function... functions) {
        super(function1, function2);
        for (Function function : functions) {
            secondFunction = new Sum(secondFunction, function);
        }
    }
}
