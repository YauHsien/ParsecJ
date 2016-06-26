package example;
import util.Function;
import java.util.ArrayList;

public class Value
    extends Function<ArrayList<Character>, Integer> {

    @Override
    public Integer apply(ArrayList<Character> list) {

	int value = 0;

	for (Object o: list) {
	    Character c = (Object)o;
	    value = value * 10 + to_number(c);
	}
	return new Number(value);
    }

    private int to_number(Character c) {
	if (c.equals('0'))
	    return 0;
	else if (c.equals('1'))
	    return 1;
	else if (c.equals('2'))
	    return 2;
	else if (c.equals('3'))
	    return 3;
	else if (c.equals('4'))
	    return 4;
	else if (c.equals('5'))
	    return 5;
	else if (c.equals('6'))
	    return 6;
	else if (c.equals('7'))
	    return 7;
	else if (c.equals('8'))
	    return 8;
	else if (c.equals('9'))
	    return 9;
	return null;
    }
}
