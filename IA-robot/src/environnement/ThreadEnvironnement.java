package environnement;

public class ThreadEnvironnement implements Runnable {

	private Environnement environnement;

	public ThreadEnvironnement(Environnement environnement) {
		this.environnement = environnement;
	}

	public void run() {
		while (true) {

			// On génère une valeur aléatoire pour l'axe X pour les poussières
			int randomPoussiereX = environnement.randomInteger(0, 4);

			// On génère une valeur aléatoire pour l'axe Y pour les poussières
			int randomPoussiereY = environnement.randomInteger(0, 2);

			if (environnement.testerCasePossible(randomPoussiereX, randomPoussiereY)) {
				environnement.ajouterPoussiere(randomPoussiereX, randomPoussiereY);
				System.out.println("Poussière ajoutée en " + randomPoussiereX + ", " + randomPoussiereY);
			} else {
				System.out.println("Valeur(s) aléatoire(s) non conforme(s)");
			}

			// Timer
			long start = System.currentTimeMillis();
			while ((System.currentTimeMillis() - start) < 500)
				;

			// On génère une valeur aléatoire pour l'axe X pour les bijoux
			int randomBijouX = environnement.randomInteger(0, 4);

			// On génère une valeur aléatoire pour l'axe Y pour les bijoux
			int randomBijouY = environnement.randomInteger(0, 2);

			if (environnement.testerCasePossible(randomBijouX, randomBijouY)) {
				environnement.ajouterBijou(randomBijouX, randomBijouY);
				System.out.println("Bijou ajouté en " + randomBijouX + ", " + randomBijouY);

			} else {
				System.out.println("Valeur(s) aléatoire(s) non conforme(s)");
			}

			// Timer
			start = System.currentTimeMillis();
			while ((System.currentTimeMillis() - start) < 500)
				;

		}

	}

}
