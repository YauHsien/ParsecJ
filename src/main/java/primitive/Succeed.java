package primitive;
import util.Parser;
import util.Pair;
import java.util.ArrayList;
import java.util.LinkedList;

public class Succeed<T1, T2 extends LinkedList<T3>, T3>
    extends Parser<T1, T2, T3> {

    public Succeed(T1 v) {
	super(v);
    }
    
    @Override
    protected ArrayList<Pair<T1, T2>> parse1(T2 inp) {
	ArrayList<Pair<T1, T2>> list = new ArrayList<Pair<T1, T2>>();
	list.add(new Pair<T1, T2>(getV(), inp));
	return list;
    }
}
