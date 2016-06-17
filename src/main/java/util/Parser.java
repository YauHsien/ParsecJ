package util;

public abstract class Parser<T1, T2> {
    private T1 v;
    
    public Parser(T1 v) {
	this.v = v;
    }

    public Parser() {}

    protected T1 getV() {
	return this.v;
    }
    
    public abstract MyList<Pair<T1, T2>> parse(T2 inp);
}



