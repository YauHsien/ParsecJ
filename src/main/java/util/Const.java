package util;

public class Const<T1, T2> extends Function<T1, T2> {

    private T2 v;
    
    public Const(T2 x) {
	this.v = x;
    }

    @Override
    public T2 apply(T1 y) {
	return this.v;
    }
}
