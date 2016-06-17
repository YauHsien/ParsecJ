package util;
import util.Pair;
import java.util.LinkedList;

public class MyList<T extends MyList<T>> extends LinkedList<T> {

    protected abstract MyList<T> cons(T head, MyList<T> tail) {
	MyList<T> list = tail.clone();
	list.addFirst(head);
	return list;
    }

    public Pair<T, MyList<T>> depart() {
	T head = this.poll();
	return new Pair(head.clone(), this.clone());
    }
    
    @Override
    public String toString() {
	String r = "[";
	for(T p : this) {
	    r = r + p.toString() + ", ";
	}
	if (r.length() >= 2)
	    return r.substring(0, r.length() - 2) + "]";
	else
	    return r + "]";
    }
}
