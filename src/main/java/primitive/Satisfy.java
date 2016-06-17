package primitive;
import util.Parser;
import util.Predicate;
import util.MyString;
import util.Pair;
import util.MyList;

public class Satisfy<T1, T2> extends Parser<T1, T2> {
    private Predicate<?> p;

    public Satisfy(Predicate<?> p) {
	this.p = p;
    }

    @Override
    public MyList<Pair<T1, T2>> parse(T2 inp) {
	if ("".equals(inp))
	    return (new Fail<T1, T2>()).parse(inp);

	MyString s = (MyString)inp;
	
	if (p.eval(s.hd()))
	    return (new Succeed<T1, T2>(s.hd())).parse(s.tl());
	
	return (new Fail<T1, T2>()).parse(s.tl());
    }
}
