/**
 The Sum class represents the sum of two functions. It extends the MultiSum class and provides a constructor
 to create a sum of two functions.
 */
public class Sum extends MultiSum {
    /**
     * Constructs a Sum function with the given functions.
     *
     * @param firstFunction  The first function to be summed.
     * @param secondFunction The second function to be summed.
     */
    public Sum(Function firstFunction, Function secondFunction) {
        super(firstFunction, secondFunction);
    }
}