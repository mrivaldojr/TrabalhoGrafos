package main;

import grafo.Grafo;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	

	public static void main(String[] args) throws FileNotFoundException {
		
		
		int nVertices, nArestas, v1, v2, peso;
		
		Grafo grafo = new Grafo();
	
		//System.out.println("Digite numero de vértices e de arestas:");
		Scanner scanner = new Scanner(System.in);
		nVertices = scanner.nextInt();
		nArestas = scanner.nextInt();
		
		grafo.setnArestas(nArestas);
		grafo.setnVertices(nVertices);
		
		grafo.inicializaGrafo(nVertices);
		
		//System.out.println("Digite a aresta 1 (v1, v2, peso)");
		
		for (int i = 0; i < nArestas; i++) {
			v1 = scanner.nextInt();
			v2 = scanner.nextInt();
			peso = scanner.nextInt();		
			
			grafo.adicionaAresta(v1, v2, peso);
			//System.out.println("Digite a aresta "+(i+2)+" (v1, v2, peso)");
		}
		
		System.out.println("Grafo original");
		
		grafo.imprime(grafo.getMatAjac());
		
		grafo.foyd_warshall();
		
		System.out.println("Depois do Algoritmo");
		
		grafo.imprime(grafo.getMatAjac());
		
		System.out.println("Matriz de caminhos");
		grafo.imprime(grafo.getMatCaminhos());
		
		for (int i = 0; i < grafo.getnVertices(); i++) {
			for (int j = 0; j < grafo.getnVertices(); j++) {
				if(i!=j){
					grafo.caminho(i, j);
				}
			}
		}
		
	}

	

}
