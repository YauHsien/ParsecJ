package primitive;
import util.Parser;
import util.Pair;
import java.util.ArrayList;
import java.util.LinkedList;

public class Fail<T1, T2> extends Parser<T1, T2> {

    public Fail() {
	super();
    }
    
    @Override
    public ArrayList<Pair<T1, T2>> parse(T2 inp) {
	return new ArrayList<Pair<T1, T2>>();
    }
}
