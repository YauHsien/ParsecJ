package util;
import java.util.LinkedList;

public class MyString extends LinkedList<Character> {
    private String value = "";

    public MyString(String s) {
	this.value = s;
    }

    public boolean isEmpty() {
	return "".equals(value);
    }
    
    public Character hd() {
	return value.charAt(0);
    }

    public MyString tl() {
	return new MyString(value.substring(1));
    }

    @Override
    public Character pollFirst() {
	if (isEmpty())
	    return null;
	Character head = value.charAt(0);
	value = value.substring(1);
	return head;
    }

    @Override
    public String toString() {
	return "\"" + this.value + "\"";
    }
}
