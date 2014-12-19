package grafo;

public abstract class Grafo {

	//representar infinito
	protected static int MAX = Integer.MAX_VALUE - 500;
	
	protected int[][] matAjac;
	protected int[][] matCaminhos;
	protected int nArestas;
	protected int nVertices;
	
	//setters e getters
	public int[][] getMatCaminhos() {
		return matCaminhos;
	}
	public int[][] getMatAjac() {
		return matAjac;
	}
	public void setMatAjac(int[][] matAjac) {
		this.matAjac = matAjac;
	}
	public int getnArestas() {
		return nArestas;
	}
	public void setnArestas(int nArestas) {
		this.nArestas = nArestas;
	}
	public int getnVertices() {
		return nVertices;
	}
	public void setnVertices(int nVertices) {
		this.nVertices = nVertices;
	}
	
	//inicializa grafo com 0 se for a diagonal principal e infinito cc 
	public void inicializaGrafo(int nVertices) {
		this.matAjac = new int[nVertices][nVertices];
		for (int i = 0; i < nVertices; i++) {
			for (int j = 0; j < nVertices; j++) {
				if (i == j) {
					this.matAjac[i][j] = 0;
				} else {
					this.matAjac[i][j] = MAX;
				}

			}
		}
	}
	
	//método abstrato que cada tipo de grafo implementa
	public abstract void adicionaAresta(int v1, int v2, int peso);

	public void imprime(int[][] matriz) {
		for (int i = 0; i < this.nVertices; i++) {
			for (int j = 0; j < this.nVertices; j++) {

				if (matriz[i][j] == MAX) {
					System.out.print("inf     ");
				} else {
					System.out.print(matriz[i][j] + "       ");
				}
			}
			System.out.println();
		}
	}

	
	public abstract void foyd_warshall();
	
	//mostra caminho construido em floyd warshall na matriz matCaminhos
	public void caminho(int in, int jn){
		String caminho = String.valueOf(jn+1);
		int aux = jn;	
		
		if(this.matCaminhos[in][jn]==0){
			System.out.println("Caminho "+ (in+1)+" a "+(aux+1)+": X");
			return;
		}
		
		while( this.matCaminhos[in][jn] != (in+1) ){
			caminho = caminho+" "+(this.matCaminhos[in][jn]);
			jn=matCaminhos[in][jn]-1;
		}
		
		caminho = caminho+" "+(in+1);
		
		StringBuffer s = new StringBuffer(caminho);
		
		System.out.println("Caminho "+ (in+1)+" a "+(aux+1)+": " + s.reverse().toString());	
	}

}
