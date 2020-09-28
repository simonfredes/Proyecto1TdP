
public class TestGrafo {
	
	public static void main (String [] args) {
		Graph grafo= new Graph();
		for (int i=0; i<5; i++) {
			grafo.addNode(i+1);
			System.out.print(i+1+ " ");
		}
		
		grafo.addEdge(1, 2);
		grafo.addEdge(2, 3);
		grafo.addEdge(2, 5);
		grafo.addEdge(3, 1);
		grafo.addEdge(3, 5);
		grafo.addEdge(3, 4);
		grafo.addEdge(4, 1);
		grafo.addEdge(4, 5);

		//Tester de métodos...
		
		grafo.addNode(1);  //1 ya se encuentra en el grafo.
		
		grafo.addNode(6);  //añadido, funciona correctamente
		
		grafo.addNode(7);  //añadido, funciona correctamente
		
		grafo.addEdge(6, 7); //arco creado entre 6 y 7, funciona correctamente
		
		grafo.addEdge(1, 1); // no funciona, no se puede crear arco entre 1 y 1.
		
		grafo.addEdge(5,10); // uno de los dos nodos no pertenece a la estructura.
		
		grafo.removeEdge(8, 15); // no se puede remover un arco si los nodos no existen.
		
		grafo.removeEdge(1,2); //arco removido, funciona correctamente
		
		grafo.removeEdge(1, 5); // el arco no existe
		
		grafo.removeNode(6); //Removido correctamente
		
		grafo.removeNode(70); // no pertenece.
		
		
	
		
	}
}
