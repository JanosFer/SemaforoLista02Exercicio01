package controller;

import java.util.concurrent.Semaphore;

public class ThreadCruzamento extends Thread{
	private final int TID = (int) getId();
	private Semaphore semaforo;
	
	public ThreadCruzamento(Semaphore semaforo) {
		this.semaforo = semaforo;
	}
	
	public void run() {
		try {
			semaforo.acquire();
			cruzamento();
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		} finally {
			semaforo.release();
		}
	}
	
	private void cruzamento() {
		String[] sentidos = {"de cima", "de baixo", "da esquerda", "da direita"};
		int sentido = (int) (Math.random() * 4);
		
		try {
			Thread.sleep(2000);
			System.out.println(TID + "# Carro fez o cruzamento vindo da rua " + sentidos[sentido] + ".");
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
	}
}
