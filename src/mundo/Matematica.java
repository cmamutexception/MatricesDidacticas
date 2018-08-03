package mundo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Matematica {
	public final static String NOMBRE_ULTIMA_MATRIZ = "datos/UltimaMatrizGuardada.txt";
	private final static int MAXIMO_VALOR = 100;
	private Casilla[][] matrizDidactica;
	private int resultadoParcial;
	private boolean calculando;
	
	public Matematica(){
		matrizDidactica = new Casilla[0][0];
		resultadoParcial = 0;
		calculando = false;
	}
	
	public Matematica(int filas, int cols){
		matrizDidactica = new Casilla[filas][cols];
		generarMatriz();
	}
	
	//pre: matrizDidactica!=null
	public void generarMatriz(){
		for (int i = 0; i < matrizDidactica.length; i++) {
			for (int j = 0; j < matrizDidactica[i].length; j++) {
				matrizDidactica[i][j] = new Casilla((int)(Math.random()*MAXIMO_VALOR));
			}
		}
	}
	
	public Casilla[][] darMatrizDidactica(){
		return matrizDidactica;
	}
	
	public void sumarAResultado(int valor){
		resultadoParcial += valor;
	}
	
	public int darResultadoParcial(){
		return resultadoParcial;
	}
	
	public boolean darCalculando(){
		return calculando;
	}
	
	public void cambiarCalculando(boolean calc){
		calculando = calc;
	}
	
	public void guardar() throws IOException{
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(NOMBRE_ULTIMA_MATRIZ));
		
		bw.write(matrizDidactica.length+" "+matrizDidactica[0].length+"\n");;
		for( int i=0; i< matrizDidactica.length;i++)
		{
			for(int j=0; j<matrizDidactica[i].length;j++)
			{
				bw.write(matrizDidactica[i][j].darValor()+" ");
				
			}
			 bw.write("\n");
		}
		
		bw.close();
	}
	
	public void cargar(){
	}
}
