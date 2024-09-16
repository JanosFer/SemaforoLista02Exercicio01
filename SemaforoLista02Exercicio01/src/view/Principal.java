package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCruzamento;

public class Principal {

	public static void main(String[] args) {
		Semaphore semaforo = new Semaphore(1);
		for(int i = 0; i < 12; i++) {
			ThreadCruzamento t = new ThreadCruzamento(semaforo);
			t.start();
		}
	}

}
