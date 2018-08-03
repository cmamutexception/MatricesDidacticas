package mundo;

public class Casilla {
	public final static char ESTADO_NORMAL = 'N';
	public final static char ESTADO_RESALTADO = 'R';
	private int valor;
	private char estado;
	
	public Casilla(int v){
		valor = v;
		estado = ESTADO_NORMAL;
	}
	
	public int darValor(){
		return valor;
	}
	
	public char darEstado(){
		return estado;
	}
	
	public void cambiarEstado(char nuevoEstado){
		estado = nuevoEstado;
	}
}
