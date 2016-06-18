package util;
import java.util.ArrayList;

public abstract class Parser<T1, T2> {
    private T1 v;
    
    public Parser(T1 v) {
	this.v = v;
    }

    public Parser() {}

    protected T1 getV() {
	return this.v;
    }
    
    public abstract ArrayList<Pair<T1, T2>> parse(T2 inp);
}
