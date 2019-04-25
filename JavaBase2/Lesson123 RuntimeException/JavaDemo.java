/* RuntimeException 

   是Excepiton 的子类
      RuntimeException 标注的异常不需要强制处理
      而其他Exception异常需要强制处理  

      比如 NumberFormatException 就是一个RuntimeException  子类
*/

public class JavaDemo {
	public static void main(String[] args) {
		int num = Integer.parseInt("123");
		

		assert num == 124  : "x  is not equal 100 " ;
		System.out.println(num);
	}
}