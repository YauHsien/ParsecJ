package combinator;
import util.Parser;
import util.Pair;
import java.util.ArrayList;
import java.util.LinkedList;

public class
    Then<T1, T2, T3 extends LinkedList<T4>, T4>
    extends Parser<Pair<T1, T2>, T3> {

    private Parser<T1, T3> fst;
    private Parser<T2, T3> snd;

    public Then(Parser<T1, T3> p1, Parser<T2, T3> p2) {
	fst = p1;
	snd = p2;
    }

    @Override
    public ArrayList<Pair<Pair<T1, T2>, T3>> parse(T3 inp) {
	T3 inp1 = (T3) inp.clone();
	
	ArrayList<Pair<T1, T3>> set1 = fst.parse(inp1);
	ArrayList<Pair<Pair<T1, T2>, T3>> set2 =
	    new ArrayList<Pair<Pair<T1, T2>, T3>>();
	
	for (Object o: set1) {
	    Pair<T1, T3> p = (Pair<T1, T3>)o;
	    // the abobe line uses unchecked or unsafe operations.
	    ArrayList<Pair<T2, T3>> set3 = snd.parse(p.snd());
	    for (Object o1: set3) {
		Pair<T2, T3> p1 = (Pair<T2, T3>)o1;
		Pair<Pair<T1, T2>, T3> pn =
		    new Pair(new Pair(p.fst(), p1.fst()), p1.snd());
		set2.add(pn);
	    }
	}
	
	return set2;
    }
}
