/*
	传统的多线程开发一般是靠实现Runnable接口进行的，但是Runnable接口有一个缺点：就是当
	线程执行完毕之后无法获取一个返回值， 所以从JDK1.5之后就提出了一个新的线程实现接口：
	java.util.concurrent.Callable接口


	@FunctionalInterface
	public interface Callable<V>{
		public V call​() throws Exception ;
	}
	
	可以发现Callable定义的时候可以设置一个泛型，此泛型的类型就是返回数据的类型，这样的好处
	是可以避免向下转型的安全隐患。

	Class FutureTask<V> 间接实现 Runnable, Future<V>, RunnableFuture<V>接口

	其构造方法 FutureTask​(Callable<V> callable)	能通过获取一个Callable对象去构造
		Creates a FutureTask that will, upon running, execute the given Callable.
	因为FutureTask<V>的实例对象，本身也是一个Runnable类型的对象， 所以通过 new Thread(task)去
	构造一个Thread类的对象，然后再去调用start()方法。

面试题：  请解释Runnable 与 Callable 的区别？
	--- Runnable 是在JDK1.0的时候提出的多线程的实现接口，而Callable是在JDK1.5之后提出的
	--- java.lang.Runnable接口之中值提供一个run()方法，并且没有返回值
	--- java.util.concurrent.Callable接口提供有call()方法， 可以有返回值；


*/
import java.util.concurrent.*;
class MyThread implements Callable <String> {
	@Override
	public String call (){     //线程主体
		for (int x = 0 ; x < 10 ; x ++) {
			System.out.println("******** 线程执行 、 x = " + x);
		}
		return "线程执行完毕";
	}
}

public class JavaDemo {
	public static void main(String[] args) {
		FutureTask<String> task = new FutureTask<>(new MyThread()) ;
		new Thread(task).start();
		
		try {
			System.out.println("【线程返回数据】 " + task.get());
			System.out.println(task.isDone());
		} catch (Exception e) {
			e.printStackTrace() ;
		}



	}
}