package util;

public class EqualX<T> extends Predicate<T> {
    private T x;

    public EqualX(T x) {
	this.x = x;
    }
    
    public boolean eval(T v) {
	return x.equals(v);
    }
}
