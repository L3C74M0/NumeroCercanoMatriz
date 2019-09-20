package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumeroMasCercanoMatriz {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line = br.readLine();
		String[] lineItems = line.split(" ");

		int numeroFilas = Integer.parseInt(lineItems[0]);
		int numeroColumnas = Integer.parseInt(lineItems[1]);

		int[][] matrix = new int[numeroFilas][numeroColumnas];

		line = br.readLine();

		int toSearch = Integer.parseInt(line);

		String[] filas = new String[numeroFilas];

		for (int i = 0; i < numeroFilas; i++) {
			line = br.readLine();
			filas[i] = line;
		}

		String[] columnas = new String[numeroColumnas];
		for (int I = 0; I < filas.length; I++) {
			columnas = filas[I].split(" ");
			for (int j = 0; j < numeroColumnas; j++) {
				matrix[I][j] = Integer.parseInt(columnas[j]);
			}
		}
		System.out.println(valorMasCercano(matrix, toSearch));
	}

	public static int valorMasCercano(int[][] matrix, int toSearch) {
		return valorMasCercano(matrix, 0, matrix.length - 1, toSearch);
	}

	private static int valorMasCercano(int[][] matrix, int i, int j, int toSearch) {
		int izq;
		int der;
		int m = (i + j) / 2;

		if (i == j) {
			return valorCercano(matrix[i], toSearch);
		} else {
			izq = valorMasCercano(matrix, i, m, toSearch);

			der = valorMasCercano(matrix, m + 1, j, toSearch);

			if (Math.abs(toSearch - izq) < Math.abs(toSearch - der)) {
				return izq;
			} else if (Math.abs(toSearch - izq) > Math.abs(toSearch - der)) {
				return der;
			} else {
				if (izq < der) {
					return der;
				} else if (izq > der) {
					return der;
				} else {
					return izq;
				}
			}
		}
	}

	public static int valorCercano(int[] vector, int toSearch) {
		return valorCercano(vector, 0, vector.length-1, toSearch);
	}

	private static int valorCercano(int[] vector, int i, int j, int toSearch) {
		int izq = 0;
		int der = 0;
		int m = (i + j) / 2;

		if (i == j) {
			return vector[i];
		} else {
			izq = valorCercano(vector, i, m, toSearch);

			der = valorCercano(vector, m + 1, j, toSearch);

			if (Math.abs(toSearch - izq) < Math.abs(toSearch - der)) {
				return izq;
			} else if (Math.abs(toSearch - izq) > Math.abs(toSearch - der)) {
				return der;
			} else {
				if (izq < der) {
					return der;
				} else if (izq > der) {
					return der;
				} else {
					return izq;
				}
			}
		}
	}
}
