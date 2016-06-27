
import util.MyString;
import util.Pair;
import util.EqualX;
import util.NumberParser;
import util.Word;
import util.PString;
import util.Numeral;
import primitive.Succeed;
import primitive.Fail;
import primitive.Satisfy;
import primitive.Literal;
import combinator.Alt;
import combinator.Then;
import combinator.Using;
import combinator.Many;
import combinator.Some;
import combinator.XThen;
import combinator.ThenX;
import combinator.Return;
import example.AlwaysOne;
import example.Expn;
import java.util.ArrayList;
import java.util.List;

abstract class ParsecJ<T1, T2> {

    public static void main(String[] args) {

	Succeed<Integer, MyString, Character> s =
	    new Succeed<Integer, MyString, Character>(5);
	Fail<Integer, MyString, Character> f =
	    new Fail<Integer, MyString, Character>();
	/*
	EqualX<Character> eqx =
	    new EqualX<Character>('h');
	Satisfy<Character, MyString> st =
	    new Satisfy<Character, MyString>(eqx);
	*/
	Literal li = new Literal('a');
	Using<Character, Integer, MyString, Character> ch_using_num =
	    new Using(li, new AlwaysOne());
	Many<Character, MyString, Character> mli =
	    new Many<Character, MyString, Character>(li);
	Some<Character, MyString, Character> sli =
	    new Some<Character, MyString, Character>(li);
	NumberParser np = new NumberParser();
	Word wp = new Word();
	PString stringp = new PString(new MyString("hello"));
	XThen<ArrayList<Character>, ArrayList<Character>, MyString, Character>
	    xthen = new XThen<ArrayList<Character>, ArrayList<Character>,
	    MyString, Character>(np, wp);
	ThenX<ArrayList<Character>, ArrayList<Character>, MyString, Character>
	    thenx = new ThenX<ArrayList<Character>, ArrayList<Character>,
	    MyString, Character>(np, wp);
	Return<Character, Integer, MyString, Character> ret1 =
	    new Return<Character, Integer, MyString, Character>(li, 1);
	Return<ArrayList<Character>, Integer, MyString, Character> ret2 =
	    new Return<ArrayList<Character>, Integer, MyString, Character>
	    (sli, 1);
	Expn expn = new Expn();

	MyString inp = new MyString("hello,world");
	MyString inp1 = new MyString("aaab");
	MyString inp2 = new MyString("123abc");
	MyString inp3 = new MyString("2+(4-1)*3");
	
	ArrayList<Pair<Integer, MyString>> s1 = s.parse(inp.clone());
	ArrayList<Pair<Integer, MyString>> f1 = f.parse(inp.clone());
	//ArrayList<Pair<Character, MyString>> p1 = st.parse(inp.clone());
	ArrayList<Pair<Character, MyString>> li1 = li.parse(inp1.clone());
	ArrayList<Pair<Integer, MyString>> cn =
	    ch_using_num.parse(inp1.clone());
	ArrayList<Pair<ArrayList<Character>, MyString>> mli1 =
	    mli.parse(inp1.clone());
	ArrayList<Pair<ArrayList<Character>, MyString>> sli1 =
	    sli.parse(inp1.clone());
	ArrayList<Pair<ArrayList<Character>, MyString>> np1 =
	    np.parse(inp3);
	ArrayList<Pair<ArrayList<Character>, MyString>> wp1 =
	    wp.parse(inp);
	ArrayList<Pair<ArrayList<Character>, MyString>> stringp1 =
	    stringp.parse(inp);
	ArrayList<Pair<ArrayList<Character>, MyString>> xthen1 =
	    xthen.parse(inp2);
	ArrayList<Pair<ArrayList<Character>, MyString>> thenx1 =
	    thenx.parse(inp2);
	ArrayList<Pair<Integer, MyString>> ret1r =
	    ret1.parse(inp1);
	ArrayList<Pair<Integer, MyString>> ret2r =
	    ret2.parse(inp1);
	ArrayList<Pair<Numeral, MyString>> expn1 =
	    expn.parse(inp3);

	print(s1);
	print(f1);
	//print(p1);
	print(li1);
	print(cn);
	print(mli1);
	print(sli1);
	print(np1);
	print(wp1);
	print(stringp1);
	print(xthen1);
	print(thenx1);
	print(ret1r);
	print(ret2r);
	print(expn1);
    }

    private static void print(ArrayList a) {
	boolean x = false;
	System.out.print("[");
	for(Object a1 : a) {
	    Pair p = (Pair)a1;
	    if (!x) {
		x = true;
		System.out.print(p);
	    } else {
		System.out.print(", " + p);
	    }
	}
	System.out.println("]");
    }

    abstract <T2 extends MyString> List<Pair<T1, T2>> parse(T2 inp);
}










