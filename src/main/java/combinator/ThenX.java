package combinator;
import util.Pair;
import util.MyString;
import util.Parser;
import util.Fst;
import java.util.ArrayList;
import java.util.LinkedList;

public class ThenX<T1, T2, T3 extends LinkedList<T4>, T4>
    extends Parser<T1, T3, T4> {

    private Parser<T1, T3, T4> fst;
    private Parser<T2, T3, T4> snd;

    public ThenX(Parser<T1, T3, T4> p1, Parser<T2, T3, T4> p2) {
	fst = p1;
	snd = p2;
    }

    @Override
    protected ArrayList<Pair<T1, T3>> parse1(T3 inp) {

	Then<T1, T2, T3, T4> then = new Then<T1, T2, T3, T4>(fst, snd);
	Fst<T1, T2> fst1 = new Fst<T1, T2>();
	Using<Pair<T1, T2>, T1, T3, T4> using =
	    new Using<Pair<T1, T2>, T1, T3, T4>(then, fst1);
	return using.parse(inp);
    }
}
