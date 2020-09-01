package check2;
class b{
	static int a;
	static {
		a=10;
	}
	int get() {
		return a;
	}
}
public class mute {

	public static void main(String[] args) {
		b o=new b();
		System.out.println(b.a);
		System.out.println(o);
		b.a=12;
		System.out.println(b.a);
		System.out.println(o);
	}

}
