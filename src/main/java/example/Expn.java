package example;
import util.Pair;
import util.MyString;
import util.Numeral;
import util.Parser;
import primitive.Literal;
import combinator.Alt;
import combinator.XThen;
import combinator.Then;
import combinator.Using;
import function.PairPlus;
import function.PairMinus;
import java.util.ArrayList;

public class Expn
    extends Parser<Numeral, MyString, Character> {

    @Override
    protected ArrayList<Pair<Numeral, MyString>> parse1(MyString inp) {

        Literal plusp = new Literal('+');
	Literal minusp = new Literal('-');
	PairPlus pairPlus = new PairPlus();
	PairMinus pairMinus = new PairMinus();
	Term term = new Term();

	XThen<Character, Numeral, MyString, Character> pTTerm =
	    new XThen<Character, Numeral, MyString, Character>(plusp, term);
	
	Then<Numeral, Numeral, MyString, Character> then1 =
	    new Then<Numeral, Numeral, MyString, Character>(term, pTTerm);

	Using<Pair<Numeral, Numeral>, Numeral, MyString, Character> using1 =
	    new Using<Pair<Numeral, Numeral>, Numeral, MyString, Character>
	    (then1, pairPlus);
	
	XThen<Character, Numeral, MyString, Character> mTTerm =
	    new XThen<Character, Numeral, MyString, Character>(minusp, term);

	Then<Numeral, Numeral, MyString, Character> then2 =
	    new Then<Numeral, Numeral, MyString, Character>(term, mTTerm);
	
	Using<Pair<Numeral, Numeral>, Numeral, MyString, Character> using2 =
	    new Using<Pair<Numeral, Numeral>, Numeral, MyString, Character>
	    (then2, pairMinus);

	Alt<Numeral, MyString, Character> alt2 =
	    new Alt<Numeral, MyString, Character>(using2, term);
	Alt<Numeral, MyString, Character> alt1 =
	    new Alt<Numeral, MyString, Character>(using1, alt2);
	return alt1.parse(inp);
    }
}

