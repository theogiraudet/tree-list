package fr.theogiraudet.testcompare;

import fr.theogiraudet.TCList;

public class TestBenchList {
	
	private static TCList list;
	
	private static void initList() {
		list = new TCList();
		list.associe("Tintin", "Milou");
		list.associe("Tom", "Jerry");
	}
	
	public static void addListTest() {
		System.out.println("\n[Liste] Test de l'ajout : ");
		int success = 0;
		int fail = 0;
		boolean temp;
		
		//Ajout à une liste vide
		list = new TCList();
		list.associe("Tintin", "Milou");
		temp = !list.toString().equals("{(Tintin, Milou)}");
		System.out.println("\t- Test " + (temp ? ++fail + success + " échoué." : ++success + fail + " réussi."));
		
		initList();
		
		//Test de l'initialisation
		temp = !list.toString().equals("{(Tom, Jerry), (Tintin, Milou)}");
		System.out.println("\t- Test " + (temp ? ++fail + success + " échoué." : ++success + fail + " réussi."));

		//Test de l'ajout d'une clé si cette dernière existe déjà dans le liste
		list.associe("Tintin", "Grominet");
		temp = !list.toString().equals("{(Tom, Jerry), (Tintin, Grominet)}");
		System.out.println("\t- Test " + (temp ? ++fail + success + " échoué." : ++success + fail + " réussi."));
		
		System.out.println("[Liste] " + success + "/" + (fail + success) + " test" + (success > 1 ? 's' : "") + " réussi" + (success > 1 ? 's' : "") + '.');
	}
	
	public static void removeListTest() {
		System.out.println("\n[Liste] Test de la suppression : ");
		int success = 0;
		int fail = 0;
		boolean temp;
		
		initList();
		
		//Test de suppression d'un élément
		list.supprime("Tintin");
		temp = !list.toString().equals("{(Tom, Jerry)}");
		System.out.println("\t- Test " + (temp ? ++fail + success + " échoué." : ++success + fail + " réussi."));
		
		//Test de suppression d'un élément non existant
		list.supprime("Titi");
		temp = !list.toString().equals("{(Tom, Jerry)}");
		System.out.println("\t- Test " + (temp ? ++fail + success + " échoué." : ++success + fail + " réussi."));
		
		//Test de suppression d'un élément menant à la liste vide
		list.supprime("Tom");
		temp = !list.toString().equals("{}");
		System.out.println("\t- Test " + (temp ? ++fail + success + " échoué." : ++success + fail + " réussi."));
		
		//Test de suppression d'un élément dans une liste vide
		list.supprime("Tom");
		temp = !list.toString().equals("{}");
		System.out.println("\t- Test " + (temp ? ++fail + success + " échoué." : ++success + fail + " réussi."));
		
		System.out.println("[Liste] " + success + "/" + (fail + success) + " test" + (success > 1 ? 's' : "") + " réussi" + (success > 1 ? 's' : "") + '.');
	}
	
	public static void getListTest() {
		System.out.println("\n[Liste] Test de l'obtention : ");
		int success = 0;
		int fail = 0;
		boolean temp;
		
		initList();
		
		//Test de l'obtention d'une valeur
		temp = !list.get("Tom").equals("Jerry");
		System.out.println("\t- Test " + (temp ? ++fail + success + " échoué." : ++success + fail + " réussi."));
		
		//Test de l'obtention d'une valeur inexistance
		temp = list.get("Titi") != null;
		System.out.println("\t- Test " + (temp ? ++fail + success + " échoué." : ++success + fail + " réussi."));
		
		//Test de l'obtention d'une valeur après changement
		list.associe("Tom", "Titi");
		temp = !list.get("Tom").equals("Titi");
		System.out.println("\t- Test " + (temp ? ++fail + success + " échoué." : ++success + fail + " réussi."));
		
		//Test de l'obtention d'une valeur dans une liste vide
		list.supprime("Tom");
		list.supprime("Tintin");
		temp = list.get("Tintin") != null;
		System.out.println("\t- Test " + (temp ? ++fail + success + " échoué." : ++success + fail + " réussi."));
		
		System.out.println("[Liste] " + success + "/" + (fail + success) + " test" + (success > 1 ? 's' : "") + " réussi" + (success > 1 ? 's' : "") + '.');
	}

}
