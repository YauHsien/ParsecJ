package util;

public abstract class Predicate<T> extends Function<T, Boolean> {
    private T v;

    public Predicate(T v) {
	this.v = v;
    }

    public Predicate() {
    }

    protected T getV() {
	return v;
    }

    @Override
    public Boolean apply(T v) {
	return eval(v);
    }
    
    protected abstract Boolean eval(T v);
}
