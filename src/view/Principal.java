package view;

import java.util.concurrent.Semaphore;

import controller.ThreadP;

public class Principal {

	public static void main(String[] args) {
		
		int permissoes = 21;
		Semaphore semaforo = new Semaphore(permissoes);
		
		for(int idCalculo = 0; idCalculo < 21; idCalculo++) {
			Thread tCalculo = new ThreadP(idCalculo, semaforo);
			tCalculo.start();
		}
		
	}

}
