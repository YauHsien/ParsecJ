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
import function.PairMultiply;
import function.PairDivide;
import java.util.ArrayList;

public class Term
    extends Parser<Numeral, MyString, Character> {

    @Override
    protected ArrayList<Pair<Numeral, MyString>> parse1(MyString inp) {

        Literal multiplyp = new Literal('*');
	Literal dividep = new Literal('/');
	PairMultiply pairMultiply = new PairMultiply();
	PairDivide pairDivide = new PairDivide();
	Factor factor = new Factor();

	XThen<Character, Numeral, MyString, Character> mTFactor =
	    new XThen<Character, Numeral, MyString, Character>
	    (multiplyp, factor);
	
	Then<Numeral, Numeral, MyString, Character> then1 =
	    new Then<Numeral, Numeral, MyString, Character>(factor, mTFactor);

	Using<Pair<Numeral, Numeral>, Numeral, MyString, Character> using1 =
	    new Using<Pair<Numeral, Numeral>, Numeral, MyString, Character>
	    (then1, pairMultiply);
	
	XThen<Character, Numeral, MyString, Character> dTFactor =
	    new XThen<Character, Numeral, MyString, Character>(dividep, factor);

	Then<Numeral, Numeral, MyString, Character> then2 =
	    new Then<Numeral, Numeral, MyString, Character>(factor, dTFactor);
	
	Using<Pair<Numeral, Numeral>, Numeral, MyString, Character> using2 =
	    new Using<Pair<Numeral, Numeral>, Numeral, MyString, Character>
	    (then2, pairDivide);

	Alt<Numeral, MyString, Character> alt2 =
	    new Alt<Numeral, MyString, Character>(using2, factor);
	Alt<Numeral, MyString, Character> alt1 =
	    new Alt<Numeral, MyString, Character>(using1, alt2);
	return alt1.parse(inp);
    }
}

