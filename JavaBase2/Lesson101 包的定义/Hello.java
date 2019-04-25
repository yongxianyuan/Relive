//-- 包的定义与使用
/**现代软件开发不可能一个人完成，多人开发有可能产生重复的类名。 

在操作系统中，同一个目录是不允许有相同名字的文件。
在java开发中为了避免类的重名，可以将类放在不同的目录，在java中这种目录我们称为包 package。

*/

package Com.utest.www.demo ;

public class Hello {
	public static void main(String[] args) {
		System.out.println("Hello World!");
	}
}