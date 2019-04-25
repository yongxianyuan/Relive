/*
	外部产生内部类的实例化对象的方法：

	外部类.内部类 内部类对象 =  new 外部类().new 内部类();

	编译完成后会形成 Outer$Inner.class

	如果Inner类只允许Outer类来使用 ，使用private进行私有有定义
	private class Inner


class Outer {
	private String msg = "www.github.com" ;
	public void fun() {
		Inner in = new Inner() ;
		in.print() ;
		System.out.println(in.info);
	}
	[private] class Inner {
		private String info= "Today's Weather is very goog." ;
		public void print() {
			System.out.println(Outer.this.msg) ;
		}
	}
}
public class JavaDemo {
	public static void main(String[] args) {
		Outer out = new Outer() ;
		out.fun() ;

		Outer.Inner in  = new Outer().new Inner();
		in.print();
	}
}
	在Java之中抽象类和接口中都可以包含内部类结构

	内部接口：
	interface IChannel {
		public void send(IMessage msg) ;
		interface IMessage {
			public String getContent() ;
		}
	}

	class ChannelImpl implements IChannel {
		public void send(IMessage msg){
			System.out.println("Send message: "
				+ msg.getContent());
		}
		class MessageImpl implements IMessage{
			public String getContent() {
				return "www.github.com" ;
			}
		}
	}
	public class JavaDemo {
		public static void main(String[] args) {
			IChannel channel = new ChannelImpl();
			// channel.send(new ChannelImpl().new MessageImpl());
			channel.send(((ChannelImpl)channel).new MessageImpl());
		}
	}
*/
interface IChannel {
	public void send( ) ;
	abstract class AbstractMessage {
		public abstract String getContent() ;
	}
}

class ChannelImpl implements IChannel {
	public void send( ){
		AbstractMessage msg = new MessageImpl();
		System.out.println(msg.getContent());
	}
	class MessageImpl extends AbstractMessage{
		public String getContent() {
			return "www.github.com" ;
		}
	}
}
public class JavaDemo {
	public static void main(String[] args) {
		IChannel channel = new ChannelImpl();
		channel.send();
		// channel.send(new ChannelImpl().new MessageImpl());
		// channel.send(((ChannelImpl)channel).new MessageImpl());
	}
}