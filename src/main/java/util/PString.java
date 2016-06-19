package util;
import util.Pair;
import util.MyString;
import util.Cons;
import primitive.Literal;
import primitive.Succeed;
import combinator.Then;
import combinator.Using;
import java.util.ArrayList;

public class PString
    extends Parser<ArrayList<Character>, MyString, Character> {
    
    private MyString v;

    public PString(MyString v) {
	this.v = v;
    }

    @Override
    protected ArrayList<Pair<ArrayList<Character>, MyString>>
	parse1(MyString inp) {
	
	if (v.isEmpty())
	    return (new Succeed<ArrayList<Character>, MyString, Character>
		    (new ArrayList<Character>())).parse(inp);

	Character head = v.pollFirst();
	Literal lit = new Literal(head);
	PString str = new PString(v);
	
	Then<Character, ArrayList<Character>, MyString, Character> then =
	    new Then<Character, ArrayList<Character>,
	    MyString, Character>(lit, str);

	Using<
	    Pair<Character, ArrayList<Character>>,
	    ArrayList<Character>,
	    MyString,
	    Character> using =
	    new Using<Pair<Character, ArrayList<Character>>,
	    ArrayList<Character>,
	    MyString, Character>(then, new Cons<Character>());
	
	return using.parse(inp);
    }
}
