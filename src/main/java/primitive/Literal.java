package primitive;
import util.Pair;
import util.Parser;
import util.MyString;
import util.EqualX;
import primitive.Satisfy;
import java.util.ArrayList;

public class Literal extends Parser<Character, MyString> {
    public Literal(Character v) {
	super(v);
    }

    public ArrayList<Pair<Character, MyString>> parse(MyString inp) {
	
	Satisfy<Character, MyString> s =
	    new Satisfy<Character, MyString>(new EqualX<Character>(getV()));

	return s.parse(inp.clone());
    }
}
