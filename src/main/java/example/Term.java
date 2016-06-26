package example;
import util.Pair;
import util.MyString;
import primitive.Literal;
import combinator.Alt;
import combinator.XThen;
import combinator.Then;
import combinator.Using;
import function.PairMultiply;
import function.PairDivide;
import java.util.ArrayList;

public class Term<Integer, MyString, Character>
    extends Parser<Integer, MyString, Character> {

    @Override
    protected ArrayList<Pair<Integer, MyString>> parse1(MyString inp) {

        Literal multiplyp = new Literal('*');
	Literal dividep = new Literal('/');

	PairMultiply pairMultiply = new PairMultiply();
	PairDivide pairDivide = new PairDivide();

	Factor<Integer, MyString> factor = new Factor<Integer, MyString>();

	XThen<Character, ArrayList<Character>, MyString, Character> mTFactor =
	    new XThen<Character, ArrayList<Character>, MyString, Character>
	    (multiplyp, factor);
	
	Then<ArrayList<Character>, ArrayList<Character>, MyString, Character> then1 =  new Then<ArrayList<Character>, ArrayList<Character>, MyString, Character>(factor, mTFactor);

	Using<Pair<ArrayList<Character>, ArrayList<Character>>, Integer, MyString, Character> using1 = new Using<Pair<ArrayList<Character>, ArrayList<Character>>, Integer, MyString, Character>(then1, pairMultiply);
	
	XThen<Character, ArrayList<Character>, MyString, Character> dTFactor =
	    new XThen<Character, ArrayList<Character>, MyString, Character>
	    (dividep, factor);

	Then<ArrayList<Character>, ArrayList<Character>, MyString, Character> then2 = new Then<ArrayList<Character>, ArrayList<Character>, MyString, Character>(factor, dTFactor);
	
	Using<Pair<ArrayList<Character>, ArrayList<Character>>, Integer, MyString, Character> using2 = new Using<Pair<ArrayList<Character>, ArrayList<Character>>, Integer, MyString, Character>(then2, pairDivide);

	Alt<Integer, MyString, Character> alt2 = new Alt<Integer, MyString, Character>(using2, factor);
	Alt<Integer, MyString, Character> alt1 = new Alt<Integer, MyString, Character>(using1, alt2);
	return using1.parse(inp);
    }
}

