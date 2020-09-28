
public class Edge  {
	private Nodo n1;
	private Nodo n2;
	
	public Edge (Nodo n1, Nodo n2) {
		this.n1=n1;
		this.n2=n2;
	}
	
	public Nodo getOrigen() {
		return n1;
	}
	public Nodo getDestino() {
		return n2;
	}
	
}
