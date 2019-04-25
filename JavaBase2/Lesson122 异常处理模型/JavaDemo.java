/* 异常处理的标准格式
   try  , catch, finally, throw, throws 

class MyMath {
	public static int div(int x, int y) throws Exception {
		int temp = 0 ;
		System.out.println("*******[Start] div is Starting");
		try {
			temp = x / y;
		}  catch (Exception e) {
			throw e;   //向上抛出异常对象
		} finally {
			System.out.println("*******[End] div is Ending");
		}
		
		return  temp ;
	}
}

public class JavaDemo {
	public static void main(String[] args) {
		try {

			System.out.println(MyMath.div(10, 0));
		} catch (Exception e) {
			e.printStackTrace() ;
		}
	}
}
*/
class MyMath {
	public static int div(int x, int y) throws Exception {
		int temp = 0 ;
		System.out.println("*******[Start] div is Starting");
		try {
			temp = x / y;
		}  
		finally {
			System.out.println("*******[End] div is Ending");
		}
		
		return  temp ;
	}
}

public class JavaDemo {
	public static void main(String[] args) {
		try {

			System.out.println(MyMath.div(10, 0));
		} catch (Exception e) {
			e.printStackTrace() ;
		}
	}
}