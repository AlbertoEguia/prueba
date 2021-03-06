//AQUI ESTAMOS DECLARANDO 2 NUEVAS VARIABLES cerrojoA y cerrojoB.
class Puerta {
	public static boolean CerrojoA;
	public static boolean CerrojoB;
}

//Creamos una clase que extiende de thread y creamos un metodo run en el que decimos que mientras sea diferente de Puerta.cerrojoB 
//la puerta A cambia a true y por eso se ejecuta.
class LlaveA extends Thread {
	public void run() {
		while (!Puerta.CerrojoB)
			;
		Puerta.CerrojoA = true;
		System.out.println("LlaveA terminando");
	}
}

//Creamos una clase que extiende de thread y creamos un metodo run en el que decimos que mientras sea diferente de Puerta.cerrojoA 
//la puerta B cambia a true y por eso se ejecuta.  
class LlaveB extends Thread {
	public void run() {
		while (!Puerta.CerrojoA)
			;	
		Puerta.CerrojoB = true;
		System.out.println("LlaveB terminando");
	}
}

//Aqui es donde situamos el main para que el programa se ejecute. lo que hacemos es igualar el cerrojoA y el B a false luego creamos dos 
//llaves a y b y las iniciamos.
public class Correr {
	public static void main(String[] args) throws InterruptedException {
		Puerta.CerrojoA = false;
		Puerta.CerrojoB = false;
		Thread a = new LlaveA();
		Thread b = new LlaveB();
		a.start();
		b.start();
		System.out.println("Comienzo del hilo principal");
		a.join();
		b.join();
		System.out.println("Fin del hilo principal");
	}
}

//Este programa no ejecuta nada solo el print "Comienxo del hilo principal" ya que hemos igualado el cerrojoA y el B a false 
//si lo igualamos a true el programa se ejecuta bien.
//Otr solucion para que se ejecute bien seria quitar el punto y como de los while.