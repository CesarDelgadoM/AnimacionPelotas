import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ControlTeclado extends KeyAdapter
{
	private VentanaJuego juego;

	public ControlTeclado(VentanaJuego juego)
	{
		this.juego = juego;
	}

	@Override
	public void keyPressed(KeyEvent t)
	{
		//si el codigo es igual a la tecla espacio
		if(t.getKeyCode() == KeyEvent.VK_SPACE)
		{
			//aniadimos una pelota
			juego.addPelota();
		}

	}
}
