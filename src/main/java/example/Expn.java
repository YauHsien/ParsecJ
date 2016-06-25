package example;
import util.Pair;
import util.MyString;
import primitive.Literal;
import combinator.Alt;
import combinator.XThen;
import combinator.Then;
import combinator.Using;
import java.util.ArrayList;
import java.util.LinkedList;

public class Expn<Integer, MyString, Character>
    extends Parser<Integer, MyString, Character> {

    @Override
    protected ArrayList<Pair<ArrayList<T1>, T2>> parse1(T2 inp) {

        Literal plusp = new Literal('+');
	Literal minusp = new Literal('-');

	PairPlus pairPlus = new PairPlus();
	PairMinus pairMinus = new PairMinus();

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

	Alt<T1, T2, T3> alt2 = new Alt<T1, T2, T3>(using2, term);
	Alt<T1, T2, T3> alt1 = new Alt<T1, T2, T3>(using1, alt2);
	return using1.parse(inp);
    }
}

