
import java.util.ArrayList;
import java.util.List;

abstract class ParsecJ<T1, T2> {

    public static void main(String[] args) {

	Succeed<Integer, MyString> s = new Succeed<Integer, MyString>(5);
	Fail<Integer, MyString> f = new Fail<Integer, MyString>();
	MyList<Pair<Integer, MyString>> ps = s.parse(new MyString("hello,world"));
	MyList<Pair<Integer, MyString>> ps1 = f.parse(new MyString("hello,world"));
	System.out.println(ps.toString() + "; " + ps1.toString());
    }

    abstract <T2 extends MyString> List<Pair<T1, T2>> parse(T2 inp);
}


class MyString {
    private final String value;

    MyString(String s) {
	this.value = s;
    }

    char hd() {
	return this.value.charAt(0);
    }

    String tl() {
	return this.value.substring(1);
    }
    
    @Override
    public String toString() {
	return "\"" + this.value + "\"";
    }
}

		       
class Pair<T1, T2> {
    private T1 t1;
    private T2 t2;
    
    Pair(T1 a, T2 b) {
	this.t1 = a;
	this.t2 = b;
    }

    T1 fst() {
	return this.t1;
    }

    T2 snd() {
	return this.t2;
    }

    @Override
    public String toString() {
	return "(" + this.t1 + ", " + this.t2 + ")";
    }
}


class MyList<T> extends ArrayList<T> {
    @Override
    public String toString() {
	String r = "[";
	for(T p : this) {
	    r = r + p.toString() + ", ";
	}
	if (r.length() >= 2)
	    return r.substring(0, r.length() - 2) + "]";
	else
	    return r + "]";
    }
}


class Succeed<T1, T2> extends ParsecJ<T1, T2> {
    private T1 value;

    Succeed(T1 v) {
	this.value = v;
    }

    @Override
    <T2 extends MyString> MyList<Pair<T1, T2>> parse(T2 inp) {
	MyList<Pair<T1, T2>> list = new MyList<Pair<T1, T2>>();
	list.add(new Pair<T1, T2>(this.value, inp));
	return list;
    }
}


class Fail<T1, T2> extends ParsecJ<T1, T2> {
    @Override
    <T2 extends MyString> MyList<Pair<T1, T2>> parse(T2 inp) {
	return new MyList<Pair<T1, T2>>();
    }
}


class Satisfy<T1, T2> extends ParsecJ<T1, T2> {
    private T1 p;

    Satisfy(T1 p) {
	this.p = p;
    }

    @Override
    <T2 extends MyString> MyList<Pair<T1, T2>> parse(T2 inp) {
	if ("".equals(inp))
	    return (new Fail<T1, T2>()).parse(inp);
	if (this.p(inp.hd()))
	    return (new Succeed<T1, T2>(inp.hd())).parse(inp.tl());
	return (new Fail<T1, T2>()).parse(inp.tl());
	
    }
}
