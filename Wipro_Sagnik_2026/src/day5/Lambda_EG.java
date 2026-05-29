package day5;


interface Add{
	int add(int a, int b);
}
interface Mul{
	int mul(int a,int b);
}
interface Math{
	static int sub(int a,int b){
		return a-b;
	}
}
public class Lambda_EG{
	public static void main(String[] args) {
		Add obj =(a,b)->(a+b);
		System.out.println(obj.add(10, 20));
		Mul m = (a,b)->(a*b);
		System.out.println(m.mul(10, 11));
		int res = Math.sub(20,10);
		System.out.println(res);
	}
}
