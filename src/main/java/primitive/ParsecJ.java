package primitive;
import util.MyString;
import util.Pair;
import util.MyList;
import primitive.Succeed;
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










