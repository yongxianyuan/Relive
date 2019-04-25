//饿汉式单例设计模式
// class Singleton {    
// 	private static final Singleton INSTANCE = new Singleton();
// 	private Singleton() {	
// 	}	
// 	public void print() {
// 		System.out.println("Hungry Singleton Pattern");
// 	}
// 	public static Singleton getInstance(){
// 		return INSTANCE;
// 	}
// }

//懒汉式单例设计模式
class Singleton {
	private static Singleton instance = new Singleton();
	private Singleton(){}
	public static Singleton getInstance(){
		if(instance == null){
			new Singleton();
		}
		return instance;
	}
	public void print(){
		System.out.println("Idler Singleton Pattern");
	}
}
public class JavaDemo {
	public static void main(String[] args) {
		Singleton instanceA = null ;
		// instanceA = new Singleton();
		// Singleton instanceB = new Singleton();
		// Singleton instanceC = new Singleton();
		instanceA = Singleton.getInstance();
		Singleton instanceB = Singleton.getInstance();

		instanceA.print();
		instanceB.print();
		// instanceC.print();

	}
}