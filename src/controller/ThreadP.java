package controller;

import java.util.concurrent.Semaphore;

public class ThreadP extends Thread{

	private int idCalculo;
	private static int posCalculo;
	private static int posFim;
	private Semaphore semaforo;
	
	public int resto;
	
	public ThreadP(int idCalculo, Semaphore semaforo) {
		this.idCalculo = idCalculo;
		this.semaforo = semaforo;
	}

	public void run() {
		
		
		calculoCalculando();
		try {
			semaforo.acquire();
			calculoTransacao();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			semaforo.release();
			calculoFim();
		}
		
	}

	private void calculoFim() {
		
		posFim++;
		System.out.println("#" + idCalculo + " foi o " + posFim + " a finalizar");
		
	}

	private void calculoTransacao() {
		
		System.out.println("#" + idCalculo + "efetuara a transação");
		if(resto == 1) {
			int tempo = 1000;
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(resto == 2 || resto == 0) {
			int tempo1 = 1500;
			try {
				sleep(tempo1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

	private void calculoCalculando() {
		resto = idCalculo % 3;
		if(resto == 1) {
			int tempo = (int)((Math.random() * 801) + 200);
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(resto == 2) {
			int tempo1 = (int)((Math.random() * 1001) + 500);
			try {
				sleep(tempo1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(resto == 0) {
			int tempo2 = (int)((Math.random() * 1001) + 1000);
			try {
				sleep(tempo2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		posCalculo++;
		System.out.println("#" + idCalculo + " foi o " + posCalculo + " o. a terminar de calcular");
		
	}
	
}
