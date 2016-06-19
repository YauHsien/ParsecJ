package primitive;
import util.Parser;
import util.Predicate;
import util.MyString;
import util.Pair;
import java.util.ArrayList;
import java.util.LinkedList;

public class Satisfy<T1, T2 extends LinkedList<T1>>
    extends Parser<T1, T2, T1> {
    
    private Predicate<T1> p;

    public Satisfy(Predicate<T1> p) {
	this.p = p;
    }

    @Override
    protected ArrayList<Pair<T1, T2>> parse1(T2 inp) {
	T1 head = inp.pollFirst();

	if (head == null)
	    return (new Fail<T1, T2, T1>()).parse(inp);
	
	if (p.apply(head))
	    return (new Succeed<T1, T2, T1>(head)).parse(inp);
	
	return (new Fail<T1, T2, T1>()).parse(inp);
    }
}
