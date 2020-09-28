import java.util.LinkedList;
import java.util.List;

public class Nodo {
	private List<Edge> emergentes; //que sale
	private List <Edge> incidentes; // que viene
	private Integer elemento;
	
	public Nodo(Integer elemento) {
		this.elemento=elemento;
		emergentes= new LinkedList<Edge>();
		incidentes= new LinkedList<Edge>();
	}
	
	public int getElemento() {
		return elemento;
	}
	
	public void setElement(Integer elemento) {
		this.elemento=elemento;
	}
	
	public void agregarArcoIncidente(Edge arco) {
		incidentes.add(arco);
	}
	
	public void agregarArcoEmergente(Edge arco) {
		emergentes.add(arco);
	}
	
}
