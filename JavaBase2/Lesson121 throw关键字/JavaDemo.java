
public class JavaDemo {
	public static void main(String[] args) {
		try {
			throw new Exception("自己抛着玩的对象。") ;
		} catch (Exception e){
				e.printStackTrace() ;
		}
	}
}