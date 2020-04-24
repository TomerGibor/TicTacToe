import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Main extends Applet implements MouseListener {
    private Graphics pg;
    public static final int WIDTH = 600;
    public static final int HEIGHT = 600;
    public static boolean isCircleTurn = false;
    private Board b;

    @Override
    public void init() {
        super.init();
        this.setSize(WIDTH, HEIGHT);
        this.setFocusable(true);
        this.addMouseListener(this);
        this.b = new Board();
    }

    @Override
    public void start() {
        super.start();
        pg = getGraphics();
    }

    public void drawCircle(Point p) {
        if (b.putOnBoard(p.x, p.y, TYPE.O) == true) {
            pg.drawOval(p.x * (WIDTH / 3), p.y * (HEIGHT / 3), WIDTH / 3, HEIGHT / 3);
            isCircleTurn = false;
        }
    }

    public void drawX(Point p) {
        if (b.putOnBoard(p.x, p.y, TYPE.X) == true) {
            pg.drawLine(p.x * (WIDTH / 3), p.y * (HEIGHT / 3), p.x * (WIDTH / 3) + (WIDTH / 3), p.y * (HEIGHT / 3) + (HEIGHT / 3));
            pg.drawLine(p.x * (WIDTH / 3) + (WIDTH / 3), p.y * (HEIGHT / 3), p.x * (WIDTH / 3), p.y * (HEIGHT / 3) + (HEIGHT / 3));
            isCircleTurn = true;
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawLine(0, HEIGHT / 3, WIDTH, HEIGHT / 3);
        g.drawLine(0, (HEIGHT / 3) * 2, WIDTH, (HEIGHT / 3) * 2);
        g.drawLine(WIDTH / 3, 0, WIDTH / 3, HEIGHT);
        g.drawLine((WIDTH / 3) * 2, 0, (WIDTH / 3) * 2, HEIGHT);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        if (isCircleTurn == false) {
            drawX(Utils.pixelToCordinate(x, y));
        } else {
            drawCircle(Utils.pixelToCordinate(x, y));
        }
        b.printBoard();
        if (b.isEndGame() == true) {
            System.exit(0);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }


}
