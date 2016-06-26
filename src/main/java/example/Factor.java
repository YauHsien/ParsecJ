package example;
import util.MyString;
import util.Pair;
import util.Parser;
import primitive.Literal;
import combinator.Alt;
import combinator.Then;
import combinator.XThen;
import combinator.ThenX;
import java.util.ArrayList;

public class Factor<Integer, MyString, Character>
    extends Parser<Integer, MyString, Character> {

    @Override
    protected ArrayList<Pair<Integer, MyString>> parse1(MyString inp) {

	Number number = new Number();
	Value value = new Value();
	Literal lit1 = new Literal('(');
	Literal lit2 = new Literal(')');
	Expn expn = new Expn();

	Using<ArrayList<Character>, Integer, MyString, Character> using = new Using<ArrayList<Character>, Integer, MyString, Character>(number, value);

	ThenX<Integer, Character, MyString, Character> thenX = new ThenX<Integer, Character, MyString, Character>(expn, lit2);
	XThen<Integer, Character, MyString, Character> xThen = new XThen<Integer, Character, MyString, Character>(lit1, thenX);

	Alt<Integer, Character, MyString, Character> alt = new Alt<Integer, Character, MyString, Character>(using, xThen);
	
	return alt.parse(inp);
    }
}
