
class Producter implements Runnable {
	private Message msg;

	public Producter(Message msg) {
		this.msg = msg;
	}

	@Override
	public void run() {
		for (int x = 0; x < 100; x++) {
			if (x % 2 == 0) {
				this.msg.set("王键", "宇宙大帅哥");
			} else {
				this.msg.set("小高", "猥琐第一人，常态保持。");
			}

		}
	}

}


class Consumer implements Runnable {
	private Message msg;

	public Consumer(Message msg) {
		this.msg = msg;
	}

	@Override
	public void run() {
		for (int x = 0; x < 100; x++) {
			System.out.println(this.msg.get());
		}
	}

}

class Message {
	private String title;
	private String content;
	private boolean flag = true;
	// flag = true 允许生产，但是不允许消费
	// flag = false 允许消费，但不允许生产

	public synchronized void set(String title, String content) {
		if (!this.flag) {
			try {
				super.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.title = title;
		this.content = content;
		this.flag = false; // 已经生产，等待消费
		super.notify(); // 唤醒等待的线程
	}

	public synchronized String get() {
		if (this.flag) {
			try {
				super.wait();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
		try {
			return this.title + " - " + this.content;
		} finally {
			this.flag = true;
			super.notify();
		}

	}
}

public class JavaDemo {
	public static void main(String[] args) {
		Message msg = new Message() ;
		new Thread(new Producter(msg)).start();
		new Thread(new Consumer(msg)).start();
	}
}