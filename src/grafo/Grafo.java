package grafo;

public class Grafo {

	
	private static int MAX = Integer.MAX_VALUE - 500;
	private int[][] matAjac;
	private int[][] matCaminhos;
	public int[][] getMatCaminhos() {
		return matCaminhos;
	}

	private int nArestas;
	private int nVertices;

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

	public void adicionaAresta(int v1, int v2, int peso) {
		matAjac[v1 - 1][v2 - 1] = peso;
	}

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

	public void foyd_warshall() {
		
		this.matCaminhos = new int [this.nVertices][this.nVertices];

		
		//inicializa as matriz de caminhos com os vértices vi
		for(int i=0;i<this.nVertices;i++){
			for (int j = 0; j < this.nVertices; j++) {
			
				
				if(this.matAjac[i][j]<MAX){
					this.matCaminhos[i][j] = i+1;
				}

				if(j == i){
					this.matCaminhos[i][j] = 0;
				}
			}
		}
		

		// comparações com vértice intermediário
		for (int k = 0; k < this.nVertices; k++) {
			for (int i = 0; i < this.nVertices; i++) {
				for (int j = 0; j < this.nVertices; j++) { 
					int t1 = this.matAjac[i][j];
					int t2 = this.matAjac[i][k];
					int t3 = this.matAjac[k][j];
					
					if ( (this.matAjac[i][j] > this.matAjac[i][k] + this.matAjac[k][j]) 
							&& (t2!=2147483147 && t3!=2147483147)) {
						this.matAjac[i][j] = this.matAjac[i][k] + this.matAjac[k][j];
						this.matCaminhos[i][j] = this.matCaminhos[k][j];
					}
				}
			}
		}
	}
	
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
