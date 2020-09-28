import java.util.LinkedList;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.Filter;

public class Graph {
	
	private List <Edge> arcos;
	private List <Nodo> nodos;
	private static Logger Logger;
	
	public Graph() {
        nodos = new LinkedList<Nodo>();
        arcos = new LinkedList<Edge>();
        if(Logger == null) {
            Logger = Logger.getLogger(Graph.class.getName());

            Handler handler = new ConsoleHandler();
            handler.setLevel(Level.FINE);
            Logger.addHandler(handler);

            Logger.setLevel(Level.INFO);

            Logger rootLogger = Logger.getParent();
            for(Handler h : rootLogger.getHandlers()) {
                h.setLevel(Level.OFF);
            }
        }
	}
	/**
	 * Busca el nodo y si lo encuentra lo retorna, caso contrario retorna null.
	 * @param node nodo a buscar
	 * @return el nodo si lo encuentra, caso contrario retorna null.
	 */
	
	private Nodo buscarNodo(int node) {
		Nodo e=null;
		for (Nodo num: nodos) {
		    if (num.getElemento()==node)
		    	e=num;
			if (e!=null)
				break;
		}
		return e;
	}
	
	private Edge buscarArco(Nodo node1, Nodo node2) {
		Edge n=null;
		
		for (Edge arco: arcos) {
			if (arco.getDestino().getElemento()==node2.getElemento() && arco.getOrigen().getElemento()==node1.getElemento())
				n=arco;
			if (n!=null)
				break;
		}
		return n;
	}
	
	public void addNode(int node) {
		Nodo e;
		e= buscarNodo(node);
		if (e==null) {
		 nodos.add(new Nodo(node));
		 Logger.info("Nodo añadido correctamente");
		}	
		else
			Logger.warning("El nodo " + node + " no se agrego porque ya existia");
	}
	
	public void addEdge(int node1, int node2) {
		Edge n=null;
		Nodo n1=buscarNodo(node1);
		Nodo n2= buscarNodo(node2);
		
		if (n1==null || n2==null) 
			Logger.severe("Al menos uno de los nodos " + node1 +" o "+ node2 +" no pertenece a la estructura");
		else if (node1==node2) {
			Logger.warning("No se puede crear un camino entre dos nodos iguales" + node1+ " y " + node2);
		}
		else {
			if (buscarArco(n1,n2)==null) {
				n=new Edge(n1,n2);
				n1.agregarArcoEmergente(n);
				n2.agregarArcoIncidente(n);
				arcos.add(n);
				Logger.info("El arco entre " + node1 + " y " +node2 + " se añadió correctamente");
			}
			else
				Logger.warning("El arco entre " + node1 + " y " +node2 + " ya existe en el grafo");	
		}
	}
	
	public void removeNode(int node) {
		List<Edge> arcosEliminar=new LinkedList<Edge>();
		Nodo nodoEliminar= buscarNodo(node);
		//si el nodo existe
		if (nodoEliminar!=null) {
			for (Edge arco: arcos) {
				if (arco.getDestino().getElemento()==node || (arco.getOrigen().getElemento()==node))
					arcosEliminar.add(arco);
			 }
			if (!arcosEliminar.isEmpty()) 
				arcos.removeAll(arcosEliminar);
			nodoEliminar.setElement(null);
			nodos.remove(nodoEliminar);
			Logger.info("El nodo "+ node + " fue eliminado");
		}
		//si el nodo no existe	
		else
			Logger.warning("El nodo " +node + " no existe en el grafo");
	}
	
	public void removeEdge(int node1, int node2) {
		Nodo nodo1= buscarNodo(node1);
		Nodo nodo2= buscarNodo(node2); 
		Edge arcoAEliminar;
		
		if (nodo1!=null && nodo2!=null) {
			arcoAEliminar=buscarArco(nodo1,nodo2);
			if (arcoAEliminar!=null) {
				nodo1.agregarArcoEmergente(null);
				nodo2.agregarArcoIncidente(null);
				arcos.remove(arcoAEliminar);
				Logger.info("Arco entre " + node1+ " y "+ node2+ " eliminado correctamente");
			}
			else
				Logger.warning("El arco entre " + node1 + " y "+ node2 + " no existe");
		}
		else
			Logger.severe("Error al intentar remover arco entre "+ node1 + " y "+ node2 + " al menos uno de los dos, no pertenece al grafo");
		
		
	}
	
}
