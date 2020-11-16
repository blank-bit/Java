package test;

class A {
	public A() {
		System.out.println("He A");
	}

	{
		System.out.println("I'm A");
	}
	static {
		System.out.println("sta A");
	}
}

class B extends A {
	public B() {
		System.out.println("He B");
	}

	{
		System.out.println("I'm B");
	}
	static {
		System.out.println("sta B");
	}
}

class C {
	static int a = 2;
	static int b = 3;

	static void call() {
		System.out.println(a + "\n" + b);
	}

	void g(int i, int j) {
		a += i;
		b += j;
	}

}

public class test {
	public static void main(String[] agrs) {
		C t = new C();
		C s = new C();
		t.g(4, 5);
		s.g(2, 3);
		System.out.println(t.a + "\n " + t.b);
		System.out.println(s.a + "\n " + s.b);
		C.call();

	}
}
