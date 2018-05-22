package t01;

public class SimpleOperation {
    public static double mul(double a1, double a2) throws SimpleOperationException {
        if (a1 == Double.MAX_VALUE ||
                a1 == Double.MIN_VALUE ||
                a2 == Double.MAX_VALUE ||
                a2 == Double.MIN_VALUE)
            throw new SimpleOperationException();
            return a1 * a2;
    }
}
