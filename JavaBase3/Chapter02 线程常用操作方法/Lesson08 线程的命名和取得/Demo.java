public class Demo {
	public static void main(String[] args) {
		System.out.println("1、执行操作任务一。");

		// int temp = 0 ;
		// for (int x = 0 ; x < Integer.MAX_VALUE ; x ++) {     //在主线程执行，会延缓后续任务的执行
		// 			temp += x ;
		// 		}
		// System.out.println("主线程的计算结果是: " + temp );

		new Thread(()-> {    //子线程负责计算，主线程正常执行。
			int temp = 0 ;
			for (int x = 0 ; x < Integer.MAX_VALUE ; x ++) {
						temp += x ;
					}
			System.out.println("子线程计算结果是: " + temp);
		}).start() ;
		
		System.out.println("2、执行操作任务二。");
		System.out.println("3、执行操作任务三。");
		System.out.println("4、执行操作任务四。");
		System.out.println("n、执行操作任务n。");
	}
}