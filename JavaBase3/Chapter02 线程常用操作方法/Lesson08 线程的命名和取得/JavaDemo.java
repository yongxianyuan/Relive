/*
	多线程的主要操作方法都在Thread类中的定义了。

	线程的命名与取得

		多线程的运行状态是不确定的，那么在程序开发之中为了可以获取到一些需要使用的线程就只能依靠线程的名字来
	操作。所以线程的名字是一个至关重要的概念，在Thread类中就提供了线程名称的处理。
		--- 构造方法： public Thread​(Runnable target, String name)
		--- 设置名字： public final void setName​(String name)
		--- 获取名字： public final String getName​()

	对于线程对象的获得是不吭直视啊依靠一个this来完成的，因为线程的状态不可控，但是有一点是明确的，所有的线程对象
	一定要执行run()方法，那么这个时候可以考虑获取但钱线程，在Thread类里面提供有获取当前线程的方法。
		--- 获取当前线程：  public static Thread currentThread​()

		class MyRunnalbe implements Runnable {
			@Override
			public void run() {
				System.out.println(Thread.currentThread​().getName​());
			}
		}
		public class JavaDemo {
			public static void main(String[] args) {
				MyRunnalbe myRunable = new MyRunnalbe();
				new Thread(myRunable, "线程A").start() ; //设置线程名字
				new Thread(myRunable).start() ;	 //未设置线程名字 ： 结果会自动分配一个默认的名字 Thread-0
				new Thread(myRunable, "线程B").start() ; //设置线程名字
			}
		}		

	如果没有设置线程的名字，系统会自动生成一个不重复的名字，这种自动属性的命名主要依靠的是static属性完成的，
	在Thread类中定义了如下的操作：
			private static int threadInitNumber;
		    private static synchronized int nextThreadNum() {
		        return threadInitNumber++;
		    }

	当使用Runnable直接调用run()方法所获得的线程对象的名字为"main", 
		class MyRunnalbe implements Runnable {
			@Override
			public void run() {
				System.out.println(Thread.currentThread​().getName​());
			}
		}
		public class JavaDemo {
			public static void main(String[] args) {
				MyRunnalbe myRunable = new MyRunnalbe();
				new Thread(myRunable, "线程对象").start() ; //设置线程名字
				myRunable.run();   //Runnable直接调用run()方法
			}
		}
	所以可以得出一个结论：住方法也是一个线程。 那么现在的问题来了，所有的方法都是在进程上的划
	分，那么进程在哪呢？

		public class Demo {
			public static void main(String[] args) {
				for (int x = 0 ; x < Integer.MAX_VALUE ; x ++) {
					System.out.println("") ;
				}
			}
		}	
	
	通过以上代码执行时分析任务管理器进程得知， 每当使用java命令执行程序的时候就表示启动了一个JVM进程，
	一个台电脑上可以同时启动若干个JVM进程，每一个JVM进程都可以有若干个各自的线程。

	在任何开发之中，主线程可以创建若干个子线程，创建子线程的目的是可以将一些复杂的逻辑或耗时的逻辑交给
	子线程处理。

*/


public class JavaDemo {
	public static void main(String[] args) {
		System.out.println("1、执行操作任务一。");
		// int temp = 0 ;
		// for (int x = 0 ; x < Integer.MAX_VALUE ; x ++) {     //在主线程执行，会延缓后续任务的执行
		// 			temp += x ;
		// 		}

		new Thread(()-> {    //子线程负责计算，主线程正常执行。
			int temp = 0 ;
			for (int x = 0 ; x < Integer.MAX_VALUE ; x ++) {
						temp += x ;
					}
			System.out.println("子线程计算结果是: " + temp);
		}).start() ;
		System.out.println("2、执行操作任务二。");
		System.out.println("3、执行操作任务三。");
		System.out.println("4、执行操作任务四。");
		System.out.println("n、执行操作任务n。");
	}
}