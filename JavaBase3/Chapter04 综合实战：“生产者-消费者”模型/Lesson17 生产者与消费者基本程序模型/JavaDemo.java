 class Producter implements Runnable {
	private Message msg ;
	public Producter(Message msg) {
		this.msg = msg ;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int x = 0 ; x < 100 ; x ++) {
			if ( x % 2 == 0) {
				this.msg.set("王键" , "宇宙大帅哥");
			} else {
				this.msg.set("小高","猥琐第一人，常态保持。");
			}
		}
	}

}

 class Consumer implements Runnable {
	private Message msg ;
	public Consumer (Message msg) {
		this.msg = msg ;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for (int x = 0 ; x < 100 ; x ++) {
			System.out.println( this.msg.get());
		}
	}

}

 class Message {
	private String title ;
	private String content ;
//	public synchronized String getTitle() {
//		return title;
//	}
//	public synchronized void setTitle(String title) {
//		this.title = title;
//	}
//	public synchronized String getContecnt() {
//		return contecnt;
//	}
//	public synchronized void setContecnt(String contecnt) {
//		this.contecnt = contecnt;
//	}
	public synchronized void set(String title,String content) {
		this.title = title ;
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.content = content ;
	}
	public synchronized String get() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this.title + " - " + this.content ;
	}
}



public class JavaDemo {
	public static void main(String[] args) {
		Message msg = new Message() ;
		new Thread(new Producter(msg)).start();
		new Thread(new Consumer(msg)).start();
	}
}