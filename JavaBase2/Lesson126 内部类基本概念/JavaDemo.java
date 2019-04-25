/*
	在一个类内部定义其他类，叫内部类。

	内部类也是独立完善的类结构

	内部类的缺陷破坏了程序的结构
		优势是轻松访问外部类的私有成员。

	目的是用内部类轻松访问外部类的私有属性。

*/

class Outer {
	private String msg = "www.github.com" ;  //私有成员属性
	public void fun() {			//普通方法			
		Inner in = new Inner() ;
		in.print();
		System.out.println(in.msg);
	}		
	private void speak(){
		System.out.println("outer is speaking .");
	}
	class Inner {	//在Outer类的内部定义了Inner这个内部类
		private String msg = "my.github.com" ;
		public void print() {
			// System.out.println(msg);
			System.out.println(Outer.this.msg);
			Outer.this.speak();
		}

	}

}

public class JavaDemo {
	public static void main(String [] args){
		Outer ou = new Outer();
		//outer.Inner.print();
		ou.fun();
	}
}