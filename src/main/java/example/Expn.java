package example;
import util.Pair;
import util.MyString;
import primitive.Literal;
import combinator.Alt;
import combinator.XThen;
import combinator.Then;
import combinator.Using;
import function.PairPlus;
import function.PairMinus;
import java.util.ArrayList;

public class Expn<Integer, MyString, Character>
    extends Parser<Integer, MyString, Character> {

    @Override
    protected ArrayList<Pair<Integer, MyString>> parse1(MyString inp) {

        Literal plusp = new Literal('+');
	Literal minusp = new Literal('-');

	PairPlus pairPlus = new PairPlus();
	PairMinus pairMinus = new PairMinus();

	Term<Integer, MyString> term = new Term<Integer, MyString>();

	XThen<Character, ArrayList<Character>, MyString, Character> pTTerm =
	    new XThen<Character, ArrayList<Character>, MyString, Character>
	    (plusp, term);
	
	Then<ArrayList<Character>, ArrayList<Character>, MyString, Character> then1 =  new Then<ArrayList<Character>, ArrayList<Character>, MyString, Character>(term, pTTerm);

	Using<Pair<ArrayList<Character>, ArrayList<Character>>, Integer, MyString, Character> using1 = new Using<Pair<ArrayList<Character>, ArrayList<Character>>, Integer, MyString, Character>(then1, pairPlus);
	
	XThen<Character, ArrayList<Character>, MyString, Character> mTTerm =
	    new XThen<Character, ArrayList<Character>, MyString, Character>
	    (minusp, term);

	Then<ArrayList<Character>, ArrayList<Character>, MyString, Character> then2 = new Then<ArrayList<Character>, ArrayList<Character>, MyString, Character>(term, mTTerm);
	
	Using<Pair<ArrayList<Character>, ArrayList<Character>>, Integer, MyString, Character> using2 = new Using<Pair<ArrayList<Character>, ArrayList<Character>>, Integer, MyString, Character>(then2, pairMinus);

	Alt<Integer, MyString, Character> alt2 = new Alt<Integer, MyString, Character>(using2, term);
	Alt<Integer, MyString, Character> alt1 = new Alt<Integer, MyString, Character>(using1, alt2);
	return using1.parse(inp);
    }
}

