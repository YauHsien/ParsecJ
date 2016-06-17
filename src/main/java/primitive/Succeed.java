package primitive;
import util.Parser;
import util.Pair;
import util.MyList;

public class Succeed<T1, T2> extends Parser<T1, T2> {

    public Succeed(T1 v) {
	super(v);
    }
    
    @Override
    public MyList<Pair<T1, T2>> parse(T2 inp) {
	MyList<Pair<T1, T2>> list = new MyList<Pair<T1, T2>>();
	list.add(new Pair<T1, T2>(getV(), inp));
	return list;
    }
}
