package util;

public class Fst<T1, T2> extends Function<Pair<T1, T2>, T1> {

    @Override
    public T1 apply(Pair<T1, T2> pair) {
	return pair.fst();
    }
}
