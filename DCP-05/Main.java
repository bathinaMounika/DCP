
public class Main{
	public static void main(String[] args){

		System.out.println("car(cons(3, 4)): " + car(cons(3, 4)));
		System.out.println("cdr(cons(3, 4)): " + cdr(cons(3, 4)));

	}

	interface MyPairInterface{
			Integer MyPairInterface(MyParamInterface f);
	}

	interface MyParamInterface{
		int carParam(int a, int b);
	}

	public static MyPairInterface cons(int a1, int b1){
		final int a = a1;	
	    MyPairInterface MyPairInterface = (MyParamInterface f)-> f.carParam(a1, b1);
		return MyPairInterface;
	}

	public static int car(MyPairInterface p){
		MyParamInterface f = (a, b) -> a;
		return p.MyPairInterface(f);
	}

	public static int cdr(MyPairInterface p){
		MyParamInterface f = (a, b) -> b;
		return p.MyPairInterface(f);
	}
}
