package combinator;
import util.Pair;
import util.MyString;
import util.Parser;
import util.Snd;
import java.util.ArrayList;
import java.util.LinkedList;

public class XThen<T1, T2, T3 extends LinkedList<T4>, T4>
    extends Parser<T2, T3> {

    private Parser<T1, T3> fst;
    private Parser<T2, T3> snd;

    public XThen(Parser<T1, T3> p1, Parser<T2, T3> p2) {
	fst = p1;
	snd = p2;
    }

    @Override
    public ArrayList<Pair<T2, T3>> parse(T3 inp) {
	T3 inp1 = (T3) inp.clone();

	Then<T1, T2, T3, T4> then = new Then<T1, T2, T3, T4>(fst, snd);
	Snd<T1, T2> snd1 = new Snd<T1, T2>();
	Using<Pair<T1, T2>, T2, T3, T4> using =
	    new Using<Pair<T1, T2>, T2, T3, T4>(then, snd1);
	return using.parse(inp1);
    }
}
