/* 异常的定义：

 异常指的是导致程序中断执行的一种指令流


例如：

public class JavaDemo {
	public static void main(String[] args) {
		System.out.println("【1】 *******程序开始执行********");
		System.out.println("【2】 ********数学计算: " + (10/0));
		System.out.println("【3】 *******程序执行完毕********");
	}
}

javac JavaDemo.java
java  JavaDemo
【1】 *******程序开始执行********
Exception in thread "main" java.lang.ArithmeticException: / by zero
	at JavaDemo.main(JavaDemo.java:12)
[Finished in 2.3s]
	在出现错误之后，整个的程序将不会按照既定的方式执行，而是中断了执行。

为了保证程序出现非致命错误之后，程序依然可以正常完成，所以需要一个完善的异常处理机制，以保证程序的顺利执行。
*/
public class JavaDemo {
	public static void main(String[] args) {
		System.out.println("【1】 *******程序开始执行********");
		System.out.println("【2】 ********数学计算: " + (10/0));
		System.out.println("【3】 *******程序执行完毕********");
	}
}
