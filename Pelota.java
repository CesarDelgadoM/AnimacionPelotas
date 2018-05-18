import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Pelota
{
	//Atributos de la pelota
	private static final int X = 40;
	private static final int Y = 40;
	private int velx = 3;
	private int vely = 3;
	private int px = 0;
	private int py = 30;

	//Atributos de la ventana
	private int anchoVent;
	private int altoVent;
	private int xVent = 0;
	private int yVent = 30;

	//Variables de Clases
	private Graphics g;
	private Graphics2D g2d;
	private Ellipse2D pelota;
	private Color color;

	public Pelota()
	{
		pelota = new Ellipse2D.Double(px, py, X, Y);
	}

	//Dibuja la pelota
	public void draw(JFrame frame)
	{
		g = frame.getGraphics();
		g2d = (Graphics2D) g;
		g.setColor(getColor());
		g2d.fill(pelota);

		anchoVent = frame.getWidth();
		altoVent = frame.getHeight();
	}

	//Anima la pelota
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

	//Actualiza la posicion
	public void setPosition(int x, int y)
	{
		pelota.setFrame(x, y, X, Y);
	}

	//Modifica las velocidades
	public void setVelocidades(int x, int y)
	{
		velx = x;
		vely = y;
	}

	//Retorna el ultimo color
	public Color getColor()
	{
		return color;
	}

	//Genera colores
	public void generarColor(int num)
	{
		switch(num)
		{
		case 1:
			color = Color.RED;
			break;
		case 2:
			color = Color.GREEN;
			break;
		case 3:
			color = Color.BLUE;
			break;
		case 4:
			color = Color.BLACK;
			break;
		case 5:
			color = Color.CYAN;
			break;
		case 6:
			color = Color.MAGENTA;
			break;
		case 7:
			color = Color.ORANGE;
			break;
		default:
			color = Color.GRAY;
			break;
		}
	}

	//Elimina el grafico
	public void eliminar()
	{
		g.dispose();
		g2d.dispose();
	}


}
