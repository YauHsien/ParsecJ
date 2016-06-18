package util;
import java.util.ArrayList;

public class Cons<T> extends Function<Pair<T, ArrayList<T>>,
					  ArrayList<T>> {
    @Override
    public ArrayList<T> apply(Pair<T, ArrayList<T>> p) {
	ArrayList<T> list = new ArrayList<T>();
	list.add(p.fst());
	list.addAll(p.snd());
	return list;
    }
}
