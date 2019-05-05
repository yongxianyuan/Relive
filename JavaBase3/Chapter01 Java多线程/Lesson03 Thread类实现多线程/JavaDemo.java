 /* 
	如果想在Java中实现多线程的定义，那么就需要一个专门的线程的主题类进行线程得到定义。

	继承Thread 类实现多线程：
		Java里提供有一个java.lang.Thread的程序类，那么一个类只需要继承此类就表示这个类就可以直线实现多线程处理了，因为还需覆写
	Thread类中提供的一个run()方法，  duo
	class MyThread extends Thread {   //线程的主体类，
		private String title;
		public MyThread(String title){
			this.title = title ;
		}
		@Override
		public void run() {
			for (int x = 0 ; x < 10 ; x++){
				System.out.println(this.title + "运行, x = " + x);
			}
		}

	}

	多线程要执行的功能都应该在run()方法中进行定义。需要说明的是： 在正常情况下，如果要使用一个类中的方法，需要产生一个实例化对
	象，然后再通过对象去调用； 但是run()方法是不能够被直接调用的，因为这里面牵扯到操作系统的资源调度的问题，要想启动多线程，必须
	使用start()的方法来完成 public void start​() 。

		public class JavaDemo {
			public static void main(String[] args) {
				// MyThread myThread = new MyThread("我创建的第一个线程");
				// myThread.run() ;
				/*线程按顺序执行
				//new MyThread("线程A").run();
				//new MyThread("线程B").run();
				//new MyThread("线程C").run();    
				
				new MyThread("线程A").start​();
				new MyThread("线程B").start​();
				new MyThread("线程C").start​();
				new MyThread("线程D").start​();

			}
		}

		通过此时调用你可以发现，虽然调用了是start()方法，但最终执行的是run()方法，并且所有线程是交替执行的，执行
		顺序不可控，完全有自己来决定。为什么不直接用run() 而必须使用start()方法呢？

		最好查看start()方法去观察start的实现。
		
		public synchronized void start() {
        
	        if (threadStatus != 0)  //判断线程状态 threadStatus不等于0 ，表示此线程已经启动
	            throw new IllegalThreadStateException();  //抛出异常
	        group.add(this);

	        boolean started = false;
	        try {
	            start0();     //在start()方法中调用了start0()方法， 而start0()方法是由JVM根据不同的操作系统去实现的。
	            started = true;
	        } finally {
	            try {
	                if (!started) {
	                    group.threadStartFailed(this);
	                }
	            } catch (Throwable ignore) {
	         
	            }
	        }
    	}

    	private native void start0();
	在start()的方法里面会抛出一个IllegalThreadStateException异常，但是整个的程序并没有try ... catch异常处理，
	因为该异常一定是RuntimeException的子类；每一个线程的类的对象只允许启动一次，如果重复启动，就会抛出异常。
	比如 如下代码
	MyThread mt = new MyThread("线程A");
		mt.start​();
		mt.start() ;

		则会抛出异常如下：
		java.lang.IllegalThreadStateException
			at java.lang.Thread.start(Thread.java:708)

	private native void start0();
	在java程序执行过程中考虑到对于不同层次开发的需求，所以其支持有本地的操作系统的函数调用，这种技术成为JNI技术，但
	是Java开发过程之中并不推荐这样使用。

		JNI  (Java Native Interface "java本地接口")， 利用这项技术可以使用操作系统的底层函数进行特殊处理，而在
	Thread类里面提供的start0()就表示需要将此方法依赖于不同的操作系统实现。

		start0()是有JVM去根据不同操作系统的资源调度算法去实现的。 操作系统都有提供底层的资源调度函数(Native 函数)


		任何情况下，只要定义了多线程，多线程启动永远只有一种方案， 继承Thread类的子类的start()方法。
*/
 

class MyThread extends Thread {   //线程的主体类，
	private String title;
	public MyThread(String title){
		this.title = title ;
	}
	@Override
	public void run() {
		for (int x = 0 ; x < 10 ; x++){
			System.out.println(this.title + "运行, x = " + x);
		}
	}

}
public class JavaDemo {
	public static void main(String[] args) {
		// MyThread myThread = new MyThread("我创建的第一个线程");
		// myThread.run() ;
		/*线程按顺序执行
		new MyThread("线程A").run();
		new MyThread("线程B").run();
		new MyThread("线程C").run();    
		*/
		MyThread mt = new MyThread("线程A");
		mt.start​();
		new MyThread("线程B").start​();
		new MyThread("线程C").start​();
		new MyThread("线程D").start​();
		mt.start​();

	}
}