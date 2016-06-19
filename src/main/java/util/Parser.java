package util;
import java.util.ArrayList;
import java.util.LinkedList;

public abstract class Parser<T1, T2 extends LinkedList<T3>, T3> {
    private T1 v;
    
    public Parser(T1 v) {
	this.v = v;
    }

    public Parser() {}

    protected T1 getV() {
	return this.v;
    }

    public ArrayList<Pair<T1, T2>> parse(T2 inp) {
	T2 inp1 = (T2) inp.clone();
	return parse1(inp1);
    }
    
    protected abstract ArrayList<Pair<T1, T2>> parse1(T2 inp);
}
