import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VentanaOyente extends WindowAdapter
{
	private VentanaJuego frame;

	public VentanaOyente(VentanaJuego juego)
	{
		this.frame = juego;
	}

	@Override
	public void windowClosing(WindowEvent arg0)
	{
		//Finalizamos el juego
		frame.setGameOver(true);
	}


}
