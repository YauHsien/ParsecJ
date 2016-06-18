package combinator;
import util.Parser;
import util.Pair;
import java.util.ArrayList;

public class Alt<T1, T2> extends Parser<T1, T2> {
    private Parser<T1, T2> fst;
    private Parser<T1, T2> snd;

    public Alt(Parser<T1, T2> p1, Parser<T1, T2> p2) {
	fst = p1;
	snd = p2;
    }

    public ArrayList<Pair<T1, T2>> parse(T2 inp) {
	ArrayList<Pair<T1, T2>> set = fst.parse(inp);
	set.addAll(snd.parse(inp));
	return set;
    }
}
