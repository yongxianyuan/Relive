/*
	线程的强制执行

	所谓的线程的强制执行，当满足于某些条件之后，某一个线程对象将可以一直独占资源，一直到该线程的程序执行结束。


范例： 观察一个没有强制执行的线程

*/

public class JavaDemo {
	public static void main(String[] args) {
		Thread thread = new Thread(()->{
			for (int x = 0; x < 100 ; x ++) {
				System.out.println(Thread.currentThread().getName()+" 执行、 x = " + x );
			}
		},"玩耍的线程");
		try {
			thread.sleep(1000) ;
		} catch (InterruptedException e) {
			e.printStackTrace() ;
		}
		thread.start() ;

		for (int x = 0 ; x < 100 ; x ++) {
			System.out.println("[霸道的main线程] number = " + x);
		}
	}
}