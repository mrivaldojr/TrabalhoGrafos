package grafo;

public class Digrafo extends Grafo {

	@Override
	public void adicionaAresta(int v1, int v2, int peso) {
		matAjac[v1 - 1][v2 - 1] = peso;
	}

	@Override
	public void foyd_warshall() {

		this.matCaminhos = new int[this.nVertices][this.nVertices];

		// inicializa as matriz de caminhos com os vértices vi
		for (int i = 0; i < this.nVertices; i++) {
			for (int j = 0; j < this.nVertices; j++) {

				if (this.matAjac[i][j] < MAX) {
					this.matCaminhos[i][j] = i + 1;
				}

				if (j == i) {
					this.matCaminhos[i][j] = 0;
				}
			}
		}

		//comparações com vértice intermediário k
		for (int k = 0; k < this.nVertices; k++) {
			for (int i = 0; i < this.nVertices; i++) {
				for (int j = 0; j < this.nVertices; j++) {
					int t2 = this.matAjac[i][k];
					int t3 = this.matAjac[k][j];

					if ((this.matAjac[i][j] > this.matAjac[i][k] + this.matAjac[k][j])
							&& (t2 != 2147483147 && t3 != 2147483147)) {
						
						this.matAjac[i][j] = this.matAjac[i][k] + this.matAjac[k][j];
						
						//caso um menor caminho seh=ja encontrado
						this.matCaminhos[i][j] = this.matCaminhos[k][j];
					}
				}
			}
		}
	}
	

}
