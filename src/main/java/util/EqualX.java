package util;

public class EqualX<T> extends Predicate<T> {

    public EqualX(T x) {
	super(x);
    }

    @Override
    protected Boolean eval(T v) {
	return v.equals(getV());
    }
}
