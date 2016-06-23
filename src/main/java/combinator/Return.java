package combinator;
import util.Parser;
import util.Function;
import util.Pair;
import util.Const;
import combinator.Using;
import java.util.ArrayList;
import java.util.LinkedList;

public class Return<T1, T2, T3 extends LinkedList<T4>, T4>
    extends Parser<T2, T3, T4> {

    private Parser<T1, T3, T4> p;
    private T2 v;

    public Return(Parser<T1, T3, T4> p, T2 v) {
	this.p = p;
	this.v = v;
    }

    @Override
    protected ArrayList<Pair<T2, T3>> parse1(T3 inp) {

	Const<T1, T2> f = new Const<T1, T2>(v);
	Using<T1, T2, T3, T4> using = new Using<T1, T2, T3, T4>(p, f);
	return using.parse(inp);
    }
}
