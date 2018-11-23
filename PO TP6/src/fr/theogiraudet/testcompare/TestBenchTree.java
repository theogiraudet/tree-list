package fr.theogiraudet.testcompare;

import fr.theogiraudet.TCTree;

public class TestBenchTree {
	
	private static TCTree tree; 
	
	public static void addTreeTest() {
		System.out.println("\n[Arbre] Test de l'ajout : ");
		int success = 0;
		int fail = 0;
		boolean temp;
		
		//Ajout à une liste vide
		tree = new TCTree();
		tree.associe("J", "10");
		temp = !tree.toString().equals("└──(J, 10)\n");
		System.out.println("\t- Test " + (temp ? ++fail + success + " échoué." : ++success + fail + " réussi."));
		
		//Ajout classique branche gauche
		tree.associe("G", "7");
		temp = !tree.toString().equals("└──(J, 10)\n     └──(G, 7)\n");
		System.out.println("\t- Test " + (temp ? ++fail + success + " échoué." : ++success + fail + " réussi."));

		//Ajout classique branche droite
		tree.associe("M", "13");
		temp = !tree.toString().equals("└──(J, 10)\n     ├──(G, 7)\n     └──(M, 13)\n");
		System.out.println("\t- Test " + (temp ? ++fail + success + " échoué." : ++success + fail + " réussi."));
		
		System.out.println("[Arbre] " + success + "/" + (fail + success) + " test" + (success > 1 ? 's' : "") + " réussi" + (success > 1 ? 's' : "") + '.');
	}
	
	public static void removeTreeTest() {
		System.out.println("\n[Arbre] Test de la suppression : ");
		int success = 0;
		int fail = 0;
		boolean temp;
		
		
		//Suppression d'une feuille dans un arbre vide
		tree = new TCTree();
		temp = !tree.toString().equals("");
		System.out.println("\t- Test " + (temp ? ++fail + success + " échoué." : ++success + fail + " réussi."));
		
		tree.associe("J", "10");
		tree.associe("G", "7");
		tree.associe("M", "13");
		tree.associe("L", "12");
		tree.associe("N", "14");
		
		//Suppression d'une feuille
		tree.supprime("N");
		temp = !tree.toString().equals("└──(J, 10)\n     ├──(G, 7)\n     └──(M, 13)\n          └──(L, 12)\n");
		System.out.println("\t- Test " + (temp ? ++fail + success + " échoué." : ++success + fail + " réussi."));
		
		//Suppression d'un noeud à une branche fils
		tree.supprime("M");
		temp = !tree.toString().equals("└──(J, 10)\n     ├──(G, 7)\n     └──(L, 12)\n");
		System.out.println("\t- Test " + (temp ? ++fail + success + " échoué." : ++success + fail + " réussi."));
		
		//Suppression d'un noeud à deux branches fils
		tree.associe("K", "11");
		tree.supprime("J");
		temp = !tree.toString().equals("└──(K, 11)\n     ├──(G, 7)\n     └──(L, 12)\n");
		System.out.println("\t- Test " + (temp ? ++fail + success + " échoué." : ++success + fail + " réussi."));

		System.out.println("[Arbre] " + success + "/" + (fail + success) + " test" + (success > 1 ? 's' : "") + " réussi" + (success > 1 ? 's' : "") + '.');
	}
	
	public static void getTreeTest() {
		System.out.println("\n[Arbre] Test de l'obtention : ");
		int success = 0;
		int fail = 0;
		boolean temp;
		tree = new TCTree();
		
		//Test de l'obtention dans un arbre vide
		temp = (tree.get("N") != null);
		System.out.println("\t- Test " + (temp ? ++fail + success + " échoué." : ++success + fail + " réussi."));

		tree.associe("J", "10");
		tree.associe("G", "7");
		tree.associe("M", "13");
		tree.associe("L", "12");
		tree.associe("N", "14");
		
		//Test de l'obtention d'une valeur
		temp = !tree.get("M").equals("13");
		System.out.println("\t- Test " + (temp ? ++fail + success + " échoué." : ++success + fail + " réussi."));
		
		//Test de l'obtention d'une valeur non présente dans l'arbre
		temp = tree.get("R") != null;
		System.out.println("\t- Test " + (temp ? ++fail + success + " échoué." : ++success + fail + " réussi."));

		System.out.println("[Arbre] " + success + "/" + (fail + success) + " test" + (success > 1 ? 's' : "") + " réussi" + (success > 1 ? 's' : "") + '.');

	}
	
}
