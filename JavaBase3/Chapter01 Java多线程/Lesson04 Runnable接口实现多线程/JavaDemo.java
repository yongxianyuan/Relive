/*
	虽然可以通过Thread类的继承实现多线程的定义，但是在Java程序里面对于继承永远都是存在有单继承的局限，所有在Java里
	面有提供有第二种多线程的主体定义结构形式：  实现 java.lang.Runnable 接口

	@FunctionalInterface    //函数式接口
	public interface Runnable {
		void run();
	}
	
	通过实现Runnable接口创建一个多线程主题类

		class MyThread implements Runnable {  //实现Runnable接口创建线程主体类
			private String title;
			public MyThread(String title){
				this.title = title ;
			}
			@Override
			public void run() {            //线程的工作放在run()方法里
				for (int x = 0 ; x < 10 ; x++){
					System.out.println(this.title + "运行, x = " + x);
				}
			}
		}

	但是由于不再集成Thread父类了，那么对于此时的线程主体类不能在通过start()方法去启动线程了

	既然无法使用Thread.start()方法，那么这时候就需要观察Thead类所提供的构造方法
	      * 构造方法 public Thread​(Runnable target, String name)

	那么可以通过Thead的start方式启动多线程如下：
		MyThread mt1 = new MyThread("线程A");
		MyThread mt2 = new MyThread("线程B");
		MyThread mt3 = new MyThread("线程C");

		new Thread(mt1,"线程1").start();
		new Thread(mt2,"线程2").start();
		new Thread(mt3,"线程3").start();

		或者
		Thread threadA = new Thread(new MyThread("线程a"));
		Thread threadB = new Thread(new MyThread("线程b"));
		Thread threadC = new Thread(new MyThread("线程c"));

		threadA.start();
		threadB.start();
		threadC.start();
		
	这种方式的优点就避免了线程主体类单继承的局限，可以实现多继承。这样的设计才是要给标准的设计。
	
	由于Runnable是一个函数式接口，所以可以直接使用Lambda表达式进行线程类的实现 如下：
	for (int i= 0 ; i < 3 ; i ++) {
			String title = "线程对象-" + i ;
			Runnable run = ()->{    //用Lambda表达式进行线程类run的实现
				for (int x = 0 ; x < 10 ; x++){
			System.out.println(title + "运行, x = " + x) ;
			}};
			new Thread(run).start();
		}

	以上代码还可以优化
		for (int i= 0 ; i < 3 ; i ++) {
				String title = "线程对象-" + i ;
				new Thread(()->{        // 完全去掉了创建一个Runnable的接收对象run的过程 ^-^
					for (int x = 0 ; x < 10 ; x++){
				System.out.println(title + "运行, x = " + x) ;
				}}).start();
			}

	以后线程主体类优先考虑Runnable接口实现，并且永恒都是通过Thread类对象的start()方法启动多线程
*/
class MyThread implements Runnable {  //实现Runnable接口创建线程主体类
	private String title;
	public MyThread(String title){
		this.title = title ;
	}
	@Override
	public void run() {            //线程的工作放在run()方法里
		for (int x = 0 ; x < 10 ; x++){
			System.out.println(this.title + "运行, x = " + x);
		}
	}
}
public class JavaDemo {
	public static void main(String[] args) {
	

		for (int i= 0 ; i < 3 ; i ++) {
			String title = "线程对象-" + i ;
			new Thread(()->{    
				for (int x = 0 ; x < 10 ; x++){
			System.out.println(title + "运行, x = " + x) ;
			}}).start();
		}

	}
}