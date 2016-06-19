package primitive;
import util.Parser;
import util.Pair;
import java.util.ArrayList;
import java.util.LinkedList;

public class Fail<T1, T2 extends LinkedList<T3>, T3>
    extends Parser<T1, T2, T3> {

    public Fail() {
	super();
    }
    
    @Override
    protected ArrayList<Pair<T1, T2>> parse1(T2 inp) {
	return new ArrayList<Pair<T1, T2>>();
    }
}
