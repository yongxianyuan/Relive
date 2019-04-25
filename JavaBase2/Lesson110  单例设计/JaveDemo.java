class Singleton {
	public void print() {
		System.out.println("Singleton Pattern)");
	}
}
public class JavaDemo {
	public static void main(String[] args) {
		Singleton instanceA = new Singleton();
		Singleton instanceB = new Singleton();
		Singleton instanceC = new Singleton();

		instanceA.print();
		instanceB.print();
		instanceC.print();

	}
}