package example;
import util.Function;

public class AlwaysOne<T> extends Function<T, Integer> {
    @Override
    public Integer apply(T t) {
	return 1;
    }
}
