package util;

public class MyString implements Cloneable {
    private final String value;

    public MyString(String s) {
	this.value = s;
    }

    public Character hd() {
	return this.value.charAt(0);
    }

    public MyString tl() {
	return new MyString(this.value.substring(1));
    }
    
    @Override
    public String toString() {
	return "\"" + this.value + "\"";
    }
}
