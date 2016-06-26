package function;
import util.Pair;
import util.Function;
import util.Numeral;

public class PairMinus
    extends Function<Pair<Numeral, Numeral>, Numeral> {

    @Override
    public Numeral apply(Pair<Numeral, Numeral> pair) {
	return pair.fst().subtract(pair.snd());
    }
}
