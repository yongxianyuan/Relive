/*  【处理多个异常】
	在很多时候，程序之中可能会产生若干个异常，那么这种情况下也可以使用多个catch进行捕获

				try catch (Exception e) {
					
				} catch (Exception e) {
					
				} catch (Exception e) {
					
				} catch (Exception e) {
					
				} finally {
					
				}

	举例

	public class JavaDemo {
	public static void main(String[] args) {
		System.out.println("【1】 *******程序开始执行********");
		try {	
			int x = Integer.parseInt(args[0]);
			int y = Integer.parseInt(args[1]) ;
			System.out.println("【2】 ********数学计算: " + (x/y));
		} catch (ArithmeticException e) {
			e.printStackTrace() ;
		} finally {
			System.out.println("【F】不管是否出现异常我都会执行");
		}
		System.out.println("【3】 *******程序执行完毕********");
	}
	}

此时的程序有可能产生三类异常：
	1、程序执行时候没有输入初始化参数,y异常未处理

		java  JavaDemo
【1】 *******程序开始执行********
【F】不管是否出现异常我都会执行
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 0
	at JavaDemo.main(JavaDemo.java:44)
		**********数组越界异常ArrayIndexOutOfBoundsException********


	2、输入时的数据不是数字

【1】 *******程序开始执行********
【F】不管是否出现异常我都会执行
Exception in thread "main" java.lang.NumberFormatException: For input string: "a"
        at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        at java.lang.Integer.parseInt(Integer.java:580)
        at java.lang.Integer.parseInt(Integer.java:615)
        at JavaDemo.main(JavaDemo.java:44)

    3、除数为零异常
    Exception in thread "main" java.lang.ArithmeticException: / by zero
        at JavaDemo.main(JavaDemo.java:29)

*/

public class JavaDemo {
	public static void main(String[] args) {
		System.out.println("【1】 *******程序开始执行********");
		try {	
			int x = Integer.parseInt(args[0]);
			int y = Integer.parseInt(args[1]) ;
			System.out.println("【2】 ********数学计算: " + (x/y));
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace() ;
		} catch (ArithmeticException e) {
			e.printStackTrace() ;
		} catch (NumberFormatException e) {
			e.printStackTrace() ;
		}  finally {
			System.out.println("【F】不管是否出现异常我都会执行");
		}
		System.out.println("【3】 *******程序执行完毕********");
	}
}