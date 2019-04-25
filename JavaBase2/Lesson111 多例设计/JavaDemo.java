class Color {
	private static final Color RED = new Color("红色") ;
	private static final Color GREEN = new Color("绿色") ;
	private static final Color BLUE = new Color("蓝色") ;
	private String title;
	private Color(String title) {
		this.title = title ;
	}
	public static Color getInstace(String color) {
		switch(color) {
			case "red": return RED ;
			case "green": return GREEN ;
			case "blue" : return BLUE ;
			default: return null;
		}
	}
	@Override
	public String toString() {
		return this.title ;
	}

}
public class JavaDemo {
	public static void main(String[] args) {
		Color c0 = Color.getInstace("red");
		Color c1 = Color.getInstace("green");
		Color c2 = Color.getInstace("blue");
		Color c3 = Color.getInstace("black");
		System.out.println(c0);
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);

	}
}