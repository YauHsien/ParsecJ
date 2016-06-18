package combinator;
import util.Pair;
import util.MyString;
import util.Cons;
import util.Parser;
import primitive.Succeed;
import java.util.ArrayList;

public class Some<T1, T2> extends Parser<ArrayList<T1>, T2> {
    private Parser<T1, T2> p;
    
    public Some(Parser<T1, T2> p) {
	this.p = p;
    }

    @Override
    public ArrayList<Pair<ArrayList<T1>, T2>> parse(T2 inp) {
	
	Many<T1, T2> mp = new Many<T1, T2>(p);
	
	Then<T1, ArrayList<T1>, T2> then =
	    new Then<T1, ArrayList<T1>, T2>(p, mp);

	Cons<T1> cons = new Cons<T1>();
	
	Using<Pair<T1, ArrayList<T1>>, ArrayList<T1>, T2> using =
	    new Using<Pair<T1, ArrayList<T1>>, ArrayList<T1>, T2>(then, cons);

	return using.parse(inp);
    }
}
