import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Pelota
{
	//Atributos de la pelota
	private static final int X = 30;
	private static final int Y = 30;
	private int velx = 3;
	private int vely = 3;
	private int px = 300;
	private int py = 60;

	//Atributos de la ventana
	private int anchoVent;
	private int altoVent;
	private int xVent = 0;
	private int yVent = 30;

	//Variables de Clases
	private Graphics g;
	private Graphics2D g2d;
	private Ellipse2D pelota;

	public Pelota()
	{
		pelota = new Ellipse2D.Double(px, py, X, Y);
	}

	public void draw(JFrame frame)
	{
		g = frame.getGraphics();
		g.setColor(Color.RED);
		g2d = (Graphics2D) g;
		g2d.fill(pelota);

		setPosition(px, py);

		anchoVent = frame.getWidth();
		altoVent = frame.getHeight();
	}

	public void rebotar()
	{
		px = px + velx;
		py = py + vely;

		if(px + X >= anchoVent || px < xVent)
		{
			velx *= -1;
		}

		if(py + Y >= altoVent || py < yVent)
		{
			vely *= -1;
		}
		setPosition(px, py);
	}

	public void setPosition(int x, int y)
	{
		pelota.setFrame(x, y, X, Y);
	}

	public void setVelocidades(int x, int y)
	{
		velx = x;
		vely = y;
	}

	public void eliminar()
	{
		g.dispose();
		g2d.dispose();
	}


}
