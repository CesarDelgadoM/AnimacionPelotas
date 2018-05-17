import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JFrame;


public class VentanaJuego extends JFrame implements Runnable
{
	private static final int ANCHO = 500;
	private static final int ALTO = 500;

	private boolean GameOver;
	private Pelota pelota;
	private Pelota pelota2;
	private Graphics fondo;

	public VentanaJuego()
	{
		setTitle("GameLoop");
		setLocation(400, 100);
		setSize(ANCHO, ALTO);
		this.setVisible(true);
		setResizable(false);
		this.setIgnoreRepaint(true);

		//Aniadimos la clase a un hilo de ejecucion
		Thread principal = new Thread(this);
		principal.start();

		crear();
	}

	private void crear()
	{
		pelota = new Pelota();
		pelota2 = new Pelota();

		pelota.setVelocidades(10, 2);
		pelota2.setVelocidades(5, 5);
	}

	public void run()
	{
		//Codigo GameLoop
		while(!GameOver)
		{
			update();
			render();

			try
			{
				Thread.sleep(10);
			}
			catch(InterruptedException e)
			{
				System.out.println("Error en el tiempo de espera");
			}
		}
		liberarMemoria();
	}

	//Metodo encargado de actualizar el estado del juego
	private void update()
	{
	}

	//Metodo encargado de dibujar por pantalla
	private void render()
	{
		fondo = this.getGraphics();

		//Limpia la ventana
		fondo.setColor(Color.WHITE);
		fondo.fillRect(0, 0, ANCHO, ALTO);

		pelota.draw(this);
		pelota2.draw(this);
		pelota.rebotar();
		pelota2.rebotar();

		Toolkit.getDefaultToolkit().sync();
	}

	private void liberarMemoria()
	{
		fondo.dispose();
		pelota.eliminar();
	}

	private void sleep()
	{

	}

}
