package util;

public class Snd<T1, T2> extends Function<Pair<T1, T2>, T2> {

    @Override
    public T2 apply(Pair<T1, T2> pair) {
	return pair.snd();
    }
}
