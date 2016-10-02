package environnement;

public class ThreadEnvironnement implements Runnable {

	private Environnement environnement;

	public ThreadEnvironnement(Environnement environnement) {
		this.environnement = environnement;
	}

	public void run() {
		while (true) {

			// On g�n�re une valeur al�atoire pour l'axe X pour les poussi�res
			int randomPoussiereX = environnement.randomInteger(0, 4);

			// On g�n�re une valeur al�atoire pour l'axe Y pour les poussi�res
			int randomPoussiereY = environnement.randomInteger(0, 2);

			if (environnement.testerCasePossible(randomPoussiereX, randomPoussiereY)) {
				environnement.ajouterPoussiere(randomPoussiereX, randomPoussiereY);
				System.out.println("Poussi�re ajout�e en " + randomPoussiereX + ", " + randomPoussiereY);
			} else {
				System.out.println("Valeur(s) al�atoire(s) non conforme(s)");
			}

			// Timer
			long start = System.currentTimeMillis();
			while ((System.currentTimeMillis() - start) < 500)
				;

			// On g�n�re une valeur al�atoire pour l'axe X pour les bijoux
			int randomBijouX = environnement.randomInteger(0, 4);

			// On g�n�re une valeur al�atoire pour l'axe Y pour les bijoux
			int randomBijouY = environnement.randomInteger(0, 2);

			if (environnement.testerCasePossible(randomBijouX, randomBijouY)) {
				environnement.ajouterBijou(randomBijouX, randomBijouY);
				System.out.println("Bijou ajout� en " + randomBijouX + ", " + randomBijouY);

			} else {
				System.out.println("Valeur(s) al�atoire(s) non conforme(s)");
			}

			// Timer
			start = System.currentTimeMillis();
			while ((System.currentTimeMillis() - start) < 500)
				;

		}

	}

}
