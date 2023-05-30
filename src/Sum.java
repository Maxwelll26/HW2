public class Sum {
    private Function f1;
    private Function f2;

    public Sum(Function f1, Function f2) {
        this.f1 = f1;
        this.f2 = f2;

        if (f1.getClass()==f2.getClass()){
          if (f1.getClass() == Constant.class) {
               return ((Constant) f1).getNumber() + ((Constant) f2).getNumber();
                }
          else if (f1.getClass() == Polynomial.class) {
        }
    }

}
