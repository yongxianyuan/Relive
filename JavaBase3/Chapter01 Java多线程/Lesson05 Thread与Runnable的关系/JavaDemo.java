/*
	Thread类  与  Runnable 接口的关系

	class Thread implements Runnable    

	Thread类也是Runnable接口的子类，继承Thread类的时候实际覆写的还是Runnable接口的run()方法

	通过分析Thread 负责线程相关的资源调度处理， 而MyThread（线程实现子类）继承自Runnable主要负责核心业务。

	Thread其实是一个代理类，而MyThread是真实业务处理类。 与代理类的区别，客户端调用的不是MyThread类的run()方法
而是调用的Thread类的start()的方法，而后找到的是run()方法，当通过Thread类的构造方法传递了一个Runable接口对象的时候，
那么该接口对象将被Thread类中的target属性字段保存。
	在start()方法执行的是偶会调用Thread类的run()方法，而这个run()方法去调用Runnalbe接口子类被覆写过的run()方法。


	多线程开发的本质是在与多个线程可以进行同一资源的抢占，Thread主要描述的是线程，而Runnable主要描述的是资源。


	Thread类会产生若干线程对象（描述的是一个个用户）

	线程实现子类是描述的是资源

	线程类对象去操作访问同一个资源


	利用一个买票程序是先多线程资源的并发访问

*/

class MyThread implements Runnable {  //实现Runnable接口创建线程主体类
	private int ticket = 100;
	@Override
	public void run() {            //线程的工作放在run()方法里
		for (int x = 0 ; x < 100 ; x++){
			if (this.ticket > 0){
				System.out.println("卖票  票数 ticket = " + this.ticket --);
			}
			
		}
	}
}

public class JavaDemo {
	public static void main(String[] args) {
		MyThread mt = new MyThread();
		new Thread(mt).start();   //第一个线程启动
		new Thread(mt).start();   //第二个线程启动
		new Thread(mt).start();   //第三个线程启动
	}
}