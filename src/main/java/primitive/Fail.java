package primitive;
import util.Parser;
import util.Pair;
import util.MyList;

public class Fail<T1, T2> extends Parser<T1, T2> {

    public Fail() {
	super();
    }
    
    @Override
    public MyList<Pair<T1, T2>> parse(T2 inp) {
	return new MyList<Pair<T1, T2>>();
    }
}
