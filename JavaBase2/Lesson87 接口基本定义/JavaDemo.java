/*	接口的基本定义
	
	抽象类与普通类相比的最大优势在于： 可以实现对子类覆写方法的控制，但是在抽象类里面而普通方法里面可能会涉及
一些安全或者营私的操作问题，在进行开发的过程中，如果要向外部隐藏全部实现的细节，则就可以通过接口来进行描述。
	
	接口可以理解为一个纯粹的抽象类，原始定义接口中只包含抽象方法和全局常量。 从JDK1.8开始，由于引入了Lambda表达式
	的概念， 所以接口的定义也得到了加强，除了抽象方法与全局常量之外，还可以定义普通方法和静态方法。 如果从设计本身角度来讲，接口之中的组成还是应该
	以抽象方法和全局常量为主。

	在Java中接口主要是interface关键字
		interface IMessage {
			public static final String INFO = "www.github.com" ; //全局常量
			public abstract String getInfo() ;		//抽象方法
		}
  
  但是现在很明显的问题出现了，此时的接口肯定无法直接产生实例化对象,所以对于接口
  	×接口需要被子类实现(implements) ,一个子类可以实现多个接口
  	×子类（如果不是抽象类） 那么一定要覆写接口之中的全部抽象方法
	×接口对象可以利用子类对象的向上转型进行实例化


	interface IMessage {
	public static final String INFO = "www.github.com" ; //全局常量
	public abstract String getInfo() ;		//抽象方法
}
接口实现用的是implements关键字
class MessageImpl implements IMessage{
	public String getInfo(){
		return "得到一个消息，秘密的消息，有人胖了（不是我）";
	}
}
public class JavaDemo {
	public static void main(String []args) {
		IMessage msg = new MessageImpl() ;
		System.out.println(msg.getInfo());
		System.out.println(IMessage.INFO);
	}
}

以上是接口的基本使用，在Java里使用接口的主要目的是一个子类可以实现多个继承的概念。

interface IMessage {
	public static final String INFO = "www.github.com" ; //全局常量
	public abstract String getInfo() ;		//抽象方法
}
interface IChannel {
	public abstract boolean connect();
}
class MessageImpl implements IMessage{
	public String getInfo(){
		if (this.connect()){
			return "得到一个消息，秘密的消息，有人胖了（不是我）";
		}
		return "通道创建失败，无法获取消息。";
	}
	public boolean connect() {
		System.out.println("消息发送通道已经成功建立。");
		return true ;
	}
}
public class JavaDemo {
	public static void main(String []args) {
		IMessage msg = new MessageImpl() ;
		System.out.println(msg.getInfo());
	}
}

	Object 类对象可以接受所有数据类型，包括基本数据类型、类对象、接口对象、数组。

	由于接口描述的一个公共定义标准，所有抽象方法访问权限都是public的 。
*/

interface IMessage {
	String INFO = "www.github.com" ; //全局常量  public static final 都可以省略
	abstract String getInfo() ;		//抽象方法  public abstract 可以省略 ，即使public 省略也不代表是default,仍然需要public去覆写
}
interface IChannel {
	public  boolean connect();    //abstract 可以省略
}
class MessageImpl implements IMessage, IChannel{
	public String getInfo(){
		if (this.connect()){
			return "得到一个消息，秘密的消息，有人胖了（不是我）";
		}
		return "通道创建失败，无法获取消息。";
	}
	public boolean connect() {
		System.out.println("消息发送通道已经成功建立。");
		return true ;
	}
}
public class JavaDemo {
	public static void main(String []args) {
		IMessage msg = new MessageImpl() ;
		Object obj = msg;
		// IChannel chl = (IChannel)msg;
		IChannel chl = (IChannel)obj;
		// System.out.println(chl.getInfo());
		// System.out.println(chl.getInfo());
		
		System.out.println(IMessage.INFO);
		System.out.println(chl.connect());

	}
}