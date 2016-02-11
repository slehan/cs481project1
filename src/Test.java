

public class Test{
	public static void main(String[] args){
		System.out.println(args[0] + " " + args[1] + " " + args[2]);
		System.out.println(f(5));
	}
	private static int f(int n){
		if(n <= 0) return 1;
		else return n * f(n-1);
	}
}
