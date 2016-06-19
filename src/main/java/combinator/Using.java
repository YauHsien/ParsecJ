package combinator;
import util.Parser;
import util.Pair;
import util.Function;
import java.util.ArrayList;
import java.util.LinkedList;

public class Using<T1, T2, T3 extends LinkedList<T4>, T4>
    extends Parser<T2, T3, T4> {

    private Parser<T1, T3, T4> p;
    private Function<T1, T2> f;
    
    public Using(Parser<T1, T3, T4> p, Function<T1, T2> f) {
	this.p = p;
	this.f = f;
    }

    @Override
    protected ArrayList<Pair<T2, T3>> parse1(T3 inp) {
	
	ArrayList<Pair<T1, T3>> set1 = p.parse(inp);
	ArrayList<Pair<T2, T3>> set2 = new ArrayList<Pair<T2, T3>>();
	
	for (Object o: set1) {
	    Pair<T1, T3> p1 = (Pair<T1, T3>)o;
	    T2 pf1 = f.apply(p1.fst());
	    set2.add(new Pair(pf1, p1.snd()));
	}
	
	return set2;
    }
}
