package util;
import util.Predicate;
import primitive.Satisfy;
import combinator.Some;
import java.util.ArrayList;

public class Word
    extends Parser<ArrayList<Character>, MyString, Character> {
    
    @Override
    protected ArrayList<Pair<ArrayList<Character>, MyString>> parse1
	(MyString inp) {

	Satisfy<Character, MyString> s =
	    new Satisfy<Character, MyString>(new Letter());

	Some<Character, MyString, Character> sp =
	    new Some<Character, MyString, Character>(s);

	return sp.parse(inp);
    }
}



class Letter extends Predicate<Character> {

    @Override
    protected Boolean eval(Character c) {
	return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z');
    }
}
