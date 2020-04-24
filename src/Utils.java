
public class Utils {
	public static Point pixelToCordinate(int x, int y) {
		x=x/(Main.WIDTH/3);
		y=y/(Main.HEIGHT/3);
		Point p=new Point(x,y);
		return p;
	}	
}
