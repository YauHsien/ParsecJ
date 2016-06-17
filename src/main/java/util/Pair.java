package util;

public class Pair<T1, T2> {
    private T1 t1;
    private T2 t2;
    
    public Pair(T1 a, T2 b) {
	this.t1 = a;
	this.t2 = b;
    }

    public T1 fst() {
	return this.t1;
    }

    public T2 snd() {
	return this.t2;
    }

    @Override
    public String toString() {
	return "(" + this.t1 + ", " + this.t2 + ")";
    }
}
