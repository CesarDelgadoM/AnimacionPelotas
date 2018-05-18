import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JFrame;


public class VentanaJuego extends JFrame implements Runnable, Serializable
{
	private static final int ANCHO = 500;
	private static final int ALTO = 500;

	private boolean GameOver = false;
	private Graphics fondo;
	private ArrayList<Pelota> pelotas;

	public VentanaJuego()
	{
		setTitle("Animacion de Pelotas");
		setLocation(400, 100);
		setSize(ANCHO, ALTO);
		setVisible(true);
		setResizable(false);
		setIgnoreRepaint(true);

		//agregamos algunos eventos de ventana y de teclado
		addWindowListener(new VentanaOyente(this));
		addKeyListener(new ControlTeclado(this));

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		//Aniadimos la clase a un hilo de ejecucion
		Thread principal = new Thread(this);
		principal.start();
	}

	//Metodo encargado de instanciar cada clase
	private void crear()
	{
		pelotas = new ArrayList<Pelota>();
	}

	public void run()
	{
		crear();

		//Ciclo de juego
		while(!GameOver)
		{
			update();
			render();

			try
			{
				//tiempo de espera en el proceso
				Thread.sleep(2);
			}
			catch(InterruptedException e)
			{
				System.out.println("Error en el tiempo de espera");
			}
		}

		liberarMemoria();
		System.exit(0);
	}

	public void setGameOver(boolean gameOver)
	{
		GameOver = gameOver;
	}

	//Metodo encargado de aniadir un pelota a la lista con diferente velocidad y color
	public void addPelota()
	{
		Pelota pelota = new Pelota();
		pelota.generarColor((int) (Math.random() * 8) + 1);
		pelota.setVelocidades((int) (Math.random() * 3) + 1, (int) (Math.random() * 2) + 1);
		pelotas.add(pelota);
	}

	//Metodo encargado de actualizar el estado del juego
	private void update()
	{
	}

	//Metodo encargado de dibujar por pantalla
	private void render()
	{
		fondo = this.getGraphics();

		if(fondo != null)
		{
			//Limpia la ventana
			fondo.setColor(Color.WHITE);
			fondo.fillRect(0, 0, ANCHO, ALTO);
			fondo.setColor(Color.BLACK);
			fondo.drawString("Oprime la tecla espacio!!!", 180, 100);

			pelotas();

			//Sincronizamos la ventana
			Toolkit.getDefaultToolkit().sync();
		}
	}

	//Metodo encargado de recorrer la lista
	public void pelotas()
	{
		for(Pelota pelota: pelotas)
		{
			//pintamos y animamos cada pelota
			pelota.draw(this);
			pelota.rebotar();
		}
	}

	//Metodo encargado de liberar memoria
	private void liberarMemoria()
	{
		for(Pelota pelota: pelotas)
		{
			//eliminamos cada pelota
			pelota.eliminar();
		}
	}

	//private void sleep(){}
}
