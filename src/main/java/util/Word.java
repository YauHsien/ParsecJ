package util;
import primitive.Satisfy;
import combinator.Some;
import java.util.ArrayList;

public class Word extends Parser<ArrayList<Character>, MyString> {
    @Override
    public ArrayList<Pair<ArrayList<Character>, MyString>> parse(MyString inp) {

	Satisfy<Character, MyString> s =
	    new Satisfy<Character, MyString>(new Letter());

	Some<Character, MyString> sp =
	    new Some<Character, MyString>(s);

	return sp.parse(inp);
    }
}

class Letter extends Predicate<Character> {
    public boolean eval(Character c) {
	return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z');
    }
}
