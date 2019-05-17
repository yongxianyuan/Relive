/*
	线程的中断

		在之前发现线程的休眠里面提供有一个中断异常，实际上就证明线程的休眠是可以被打断的，而这种打断肯定是由其他线程
	完成的，在Thread类中提供有这种中断执行的处理方法：
		--- 判断线程是否被中断： public boolean isInterrupted()
		--- 中断线程的执行方法： public void interrupt​()

范例：观察线程中断的处理操作
				public class JavaDemo {
					public static void main(String[] args) {
						Thread thread = new Thread(()-> {
							System.out.println("***** 工作太累了，我想要睡觉去补充精力。");
							try {
								Thread.sleep(10000) ;
							} catch (InterruptedException e ){
								//e.printStackTrace() ;
								System.out.println("谁吵醒我了，我很生气");
							}
							System.out.println("***** 睡醒了，可以出去继续工作了。");
						}) ;

						thread.start() ;
						if (!thread.isInterrupted()) {
							thread.interrupt();
						}
					}
				}

	所有正在执行的线程都是可以被中断的，中断线程必须进行异常的处理！
*/

public class JavaDemo {
	public static void main(String[] args) {
		Thread thread = new Thread(()-> {
			System.out.println("***** 工作太累了，我想要睡觉去补充精力。");
			try {
				Thread.sleep(10000) ;
			} catch (InterruptedException e ){
				//e.printStackTrace() ;
				System.out.println("谁吵醒我了，我很生气");
			}
			System.out.println("***** 睡醒了，可以出去继续工作了。");
		}) ;

		thread.start() ;
		if (!thread.isInterrupted()) {
			thread.interrupt();
		}
	}
}