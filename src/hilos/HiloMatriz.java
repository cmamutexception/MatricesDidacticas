package hilos;

import interfaz.InterfazMatematicas;
import mundo.Casilla;
import mundo.Matematica;

public class HiloMatriz extends Thread{
	public final static long TIEMPO_CASILLA = 500;
	private Matematica mat;
	private InterfazMatematicas principal;
	
	public HiloMatriz(Matematica m, InterfazMatematicas ventana){
		mat = m;
		principal = ventana;
	}
	
	public void run(){
		Casilla[][] matrizDid = mat.darMatrizDidactica();
		mat.cambiarCalculando(true);
		for (int i = 0; i < matrizDid.length && mat.darCalculando(); i++) {
			for (int j = 0; j < matrizDid[i].length && mat.darCalculando(); j++) {
				if(j>0)  matrizDid[i][j-1].cambiarEstado(Casilla.ESTADO_NORMAL);
				if(i>0 && j==0) matrizDid[i-1][matrizDid[i-1].length-1].cambiarEstado(Casilla.ESTADO_NORMAL);
				matrizDid[i][j].cambiarEstado(Casilla.ESTADO_RESALTADO);
				mat.sumarAResultado(matrizDid[i][j].darValor());
				principal.refrescarMatriz();

				try {
					sleep(TIEMPO_CASILLA);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}				
			}
		}
		matrizDid[matrizDid.length-1][matrizDid[matrizDid.length-1].length-1].cambiarEstado(Casilla.ESTADO_NORMAL);
	}
}
