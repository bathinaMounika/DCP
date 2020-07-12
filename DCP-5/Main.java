
public class Main{
	public static void main(String[] args){

		Main obj = new Main();
		//Function MyPairInterface = obj.cons(1, 2);
		System.out.println(obj.car(obj.cons(1, 2)));

	}

	interface MyPairInterface{
			Integer MyPairInterface(MyCarParamInterface f);
	}

	interface MyCarParamInterface{
		int carParam(int a, int b);
	}

	public MyPairInterface cons(int a1, int b1){
		final int a = a1;
		//MyPairInterface p = new MyPairInterface(a, b);
		
	    MyPairInterface MyPairInterface = (MyCarParamInterface f)-> f.carParam(a1, b1);
		return MyPairInterface;
	}

	public int car(MyPairInterface p){
		MyCarParamInterface f = (a, b) -> a;
		return p.MyPairInterface(f);
	}
}
