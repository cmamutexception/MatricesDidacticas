package interfaz;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import mundo.Casilla;

@SuppressWarnings("serial")
public class PanelMatriz extends JPanel implements MouseListener{
	public final static int TAMANO_LADO_CASILLA = 30;
	private Casilla[][] matrizDidactica;
	private InterfazMatematicas principal;
	
	public PanelMatriz(InterfazMatematicas ventana){
		principal = ventana;
		setBackground(Color.WHITE);
		addMouseListener(this);
		matrizDidactica = new Casilla[0][0];
	}
	
	public void cambiarMatriz(Casilla[][] md){
		matrizDidactica = md;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		for (int i = 0; i < matrizDidactica.length; i++) {
			for (int j = 0; j < matrizDidactica[i].length; j++) {
				int x = j*TAMANO_LADO_CASILLA;
				int y = i*TAMANO_LADO_CASILLA;
				if(matrizDidactica[i][j].darEstado()==Casilla.ESTADO_NORMAL){
					g.setColor(Color.LIGHT_GRAY);
				}else{
					g.setColor(Color.YELLOW);
				}
				g.fillRect(x, y, TAMANO_LADO_CASILLA, TAMANO_LADO_CASILLA);
				g.setColor(Color.BLUE);
				g.drawRect(x, y, TAMANO_LADO_CASILLA, TAMANO_LADO_CASILLA);
				g.drawString(matrizDidactica[i][j].darValor()+"", x+TAMANO_LADO_CASILLA/4, y+3*TAMANO_LADO_CASILLA/4);
			}
		}
	}
	
	public Color generarColorAleatorio() {
		return null;
	}
	
	public void cambiarFondo(Color nuevoColor) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		principal.sumar();
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
