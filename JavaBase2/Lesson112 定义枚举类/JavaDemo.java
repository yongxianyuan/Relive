enum Color {
	RED, GREE, BLUE ;
}

// enum 颜色 {
// 	红色, 绿色, 蓝色 ;
// }
public class JavaDemo {
	public static void main(String[] args) {
		Color c = Color.GREE;
		// System.out.println(c);
		// switch(c){
		// 	case RED:
		// 		System.out.println("红色");
		// 		break;
		// 	case GREE:
		// 		System.out.println("绿色");
		// 		break;
		// 	case BLUE:
		// 		System.out.println("蓝色");
		// 		break;
		// }

		for (Color x : Color.values()){
			System.out.println(x.ordinal() + " - " + x.name());
		}
	}
}