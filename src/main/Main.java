package main;

import grafo.Digrafo;
import grafo.Grafo;
import grafo.GrafoSimples;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	

	public static void main(String[] args) throws FileNotFoundException {
				
		int nVertices, nArestas, v1, v2, peso;
		
		Grafo grafo;
		
		System.out.println("---------------INSTRUÇÕES---------------");
		System.out.println("Vértices começam de 1");
		System.out.println("ENTRADA:");
		System.out.println("|V| |E|");
		System.out.println("v1 v2 peso");
		System.out.println("...");
		System.out.println("");
		System.out.println("Insira os dados");
		
		//System.out.println("Digite numero de vértices e de arestas:");
		Scanner scanner = new Scanner(System.in);

		
		grafo = new Digrafo();
		
		nVertices = scanner.nextInt();
		nArestas = scanner.nextInt();
		
		grafo.setnArestas(nArestas);
		grafo.setnVertices(nVertices);
		
		grafo.inicializaGrafo(nVertices);
		
		for (int i = 0; i < nArestas; i++) {
			v1 = scanner.nextInt();
			v2 = scanner.nextInt();
			peso = scanner.nextInt();		
			
			grafo.adicionaAresta(v1, v2, peso);
		}
		
		System.out.println("Grafo original");
		
		grafo.imprime(grafo.getMatAjac());
		
		grafo.foyd_warshall();
		
		System.out.println("");
		System.out.println("Matriz de Adjacência Depois do Algoritmo");
		
		grafo.imprime(grafo.getMatAjac());
		
		System.out.println("Matriz de caminhos");
		grafo.imprime(grafo.getMatCaminhos());
		
		//imprime cada caminho 2 a 2
		for (int i = 0; i < grafo.getnVertices(); i++) {
			for (int j = 0; j < grafo.getnVertices(); j++) {
				if(i!=j){
					grafo.caminho(i, j);
				}
			}
		}
		
	}

}
