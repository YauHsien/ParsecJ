package example;
import util.MyString;
import util.Numeral;
import util.Pair;
import util.Parser;
import util.NumberParser;
import primitive.Literal;
import combinator.Alt;
import combinator.Then;
import combinator.XThen;
import combinator.ThenX;
import combinator.Using;
import java.util.ArrayList;

public class Factor
    extends Parser<Numeral, MyString, Character> {

    @Override
    protected ArrayList<Pair<Numeral, MyString>> parse1(MyString inp) {

	NumberParser number = new NumberParser();
	Value value = new Value();
	Literal lit1 = new Literal('(');
	Literal lit2 = new Literal(')');
	Expn expn = new Expn();

	Using<ArrayList<Character>, Numeral, MyString, Character> using =
	    new Using<ArrayList<Character>, Numeral, MyString, Character>
	    (number, value);

	ThenX<Numeral, Character, MyString, Character> thenX =
	    new ThenX<Numeral, Character, MyString, Character>(expn, lit2);
	XThen<Character, Numeral, MyString, Character> xThen =
	    new XThen<Character, Numeral, MyString, Character>(lit1, thenX);

	Alt<Numeral, MyString, Character> alt =
	    new Alt<Numeral, MyString, Character>(using, xThen);
	return alt.parse(inp);
    }
}
