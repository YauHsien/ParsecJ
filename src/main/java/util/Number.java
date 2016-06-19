package util;
import primitive.Satisfy;
import combinator.Some;
import java.util.ArrayList;

public class Number extends Parser<ArrayList<Character>, MyString> {
    @Override
    public ArrayList<Pair<ArrayList<Character>, MyString>> parse(MyString inp) {
	
	Satisfy<Character, MyString> p =
	    new Satisfy<Character, MyString>(new Digit());
					    
	Some<Character, MyString, Character> sp =
	    new Some<Character, MyString, Character>(p);

	return sp.parse(inp.clone());
    }
}

class Digit extends Predicate<Character> {
    public boolean eval(Character c) {
	return '0' <= c && c <= '9';
    }
}
