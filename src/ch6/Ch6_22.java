package ch6;

import java.util.concurrent.Callable;
import java.util.function.Function;

public class Ch6_22 {
    public static void main(String[] args) {

    }

    public static <V, T extends Throwable> V doWork(Callable<V> c, Function<Exception, T> constr) throws T {
        try {
            return c.call();
        } catch (Exception ex) {
            throw constr.apply(ex);
        }
    }
}
