package combinator;
import util.Parser;
import util.Pair;
import java.util.ArrayList;
import java.util.LinkedList;

public class Alt<T1, T2 extends LinkedList<T3>, T3> extends Parser<T1, T2> {
    private Parser<T1, T2> fst;
    private Parser<T1, T2> snd;

    public Alt(Parser<T1, T2> p1, Parser<T1, T2> p2) {
	fst = p1;
	snd = p2;
    }

    public ArrayList<Pair<T1, T2>> parse(T2 inp) {
	T2 inp1 = (T2) inp.clone();
	T2 inp2 = (T2) inp.clone();
	
	ArrayList<Pair<T1, T2>> set = fst.parse(inp1);
	set.addAll(snd.parse(inp2));
	return set;
    }
}
