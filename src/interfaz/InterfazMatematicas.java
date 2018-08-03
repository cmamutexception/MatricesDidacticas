package interfaz;

import java.awt.BorderLayout;
import java.io.BufferedWriter;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import hilos.HiloMatriz;
import mundo.Matematica;

@SuppressWarnings("serial")
public class InterfazMatematicas extends JFrame{
	private Matematica mat;
	private PanelInformacion panelInformacion;
	private PanelMatriz panelMatriz;
	private HiloMatriz hiloM;
	
	public InterfazMatematicas(){
		setLayout(new BorderLayout());
		setTitle("Matemáticas Didacticas");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		mat = new Matematica();
		panelInformacion = new PanelInformacion(this);
		panelMatriz = new PanelMatriz(this);
		
		add(panelInformacion, BorderLayout.NORTH);
		add(panelMatriz, BorderLayout.CENTER);
		pack();
	}
	
	private void redimensionarVentana(int f, int c){

	}
	
	private void mostrarNuevaMatriz(){
		panelMatriz.cambiarMatriz(mat.darMatrizDidactica());
		redimensionarVentana(mat.darMatrizDidactica().length, mat.darMatrizDidactica()[0].length);
		panelMatriz.repaint();		
	}
	
	public void generarMatriz(){
		try{
			int f = panelInformacion.darFilas();
			int c = panelInformacion.darCols();
			
			mat = new Matematica(f,c);
			mostrarNuevaMatriz();
			
		}catch(NumberFormatException nfexc){
			JOptionPane.showMessageDialog(this, "El # de Filas y # de Columnas deben\nser valores enteros positivos.");
		}
	}
	
	public void sumar(){
		if(hiloM==null || !hiloM.isAlive()) {
			hiloM = new HiloMatriz(mat, this);
			hiloM.start();
		}
	}
	
	public void cambiarColor() {
		
	}
	
	public void refrescarMatriz(){
		panelMatriz.repaint();
		panelInformacion.cambiarResultado(mat.darResultadoParcial());
	}
	
	public void cambiarCalculando(boolean calculando){
		mat.cambiarCalculando(calculando);
	}
	
	public void cargar(){
	}
	
	public void guardar() {
		
		
	}
	
	public static void main(String[] args){
		InterfazMatematicas ventana;
		ventana = new InterfazMatematicas();
		ventana.setVisible(true);
	}
}
