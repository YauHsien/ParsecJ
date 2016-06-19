package primitive;
import util.Pair;
import util.Parser;
import util.MyString;
import util.EqualX;
import primitive.Satisfy;
import java.util.ArrayList;

public class Literal extends Parser<Character, MyString, Character> {
    
    public Literal(Character v) {
	super(v);
    }

    @Override
    protected ArrayList<Pair<Character, MyString>> parse1(MyString inp) {
	EqualX<Character> eq = new EqualX<Character>(getV());
	Satisfy<Character, MyString> s = new Satisfy<Character, MyString>(eq);
	return s.parse(inp);
    }
}
