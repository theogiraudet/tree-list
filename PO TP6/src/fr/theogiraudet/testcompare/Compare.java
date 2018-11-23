package fr.theogiraudet.testcompare;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Random;

import fr.theogiraudet.TCList;
import fr.theogiraudet.TCTree;

public class Compare {
	
	private static DecimalFormatSymbols sfs = new DecimalFormatSymbols(Locale.ENGLISH);
	private static DecimalFormat f = new DecimalFormat("##0.0000000", sfs);
	static TCList list = new TCList();
	static TCTree tree = new TCTree();
	
	
	public static void compareAssocie(int nbrLoop) {
		System.out.println("\nDémarrage de la comparaison de associe");
		double timeList = getExecutionTimeAssocieList(nbrLoop);
		double timeTree = getExecutionTimeAssocieTree(nbrLoop);
		System.out.println("L'arbre binaire de recherche va " + f.format(((double)(timeList / timeTree))) + " fois plus vite que la liste pour ajouter.");
	}
	
	public static void compareSupprime(int nbrLoop) {
		System.out.println("\nDémarrage de la comparaison de supprime");
		double timeList = getExecutionTimeSupprimeList(nbrLoop);
		double timeTree = getExecutionTimeSupprimeTree(nbrLoop);
		System.out.println("L'arbre binaire de recherche va " + f.format(((double)(timeList / timeTree))) + " fois plus vite que la liste pour supprimer.");
	}
	
	public static void compareGet(int nbrLoop) {
		System.out.println("\nDémarrage de la comparaison de get");
		double timeList = getExecutionTimeGetList(nbrLoop);
		double timeTree = getExecutionTimeGetTree(nbrLoop);
		System.out.println("L'arbre binaire de recherche va " + f.format(((double)(timeList / timeTree))) + " fois plus vite que la liste pour obtenir.");
	}

	private static long getExecutionTimeAssocieList(int nbrLoop) {
		Random r = new Random();
		long timer = System.nanoTime();
		for(int i = 0; i < nbrLoop; i++) {
			list.associe(Integer.toString(r.nextInt(nbrLoop)), Integer.toString(r.nextInt(nbrLoop)));
		}
		System.out.println("Temps total ajout dans une liste : " + f.format((double)(System.nanoTime() - timer) / Math.pow(10, 9)) + " secondes");
		return System.nanoTime() - timer;
	}
	
	private static double getExecutionTimeAssocieTree(int nbrLoop) {
		Random r = new Random();
		long timer = System.nanoTime();
		for(int i = 0; i < nbrLoop; i++) {
			tree.associe(Integer.toString(r.nextInt(nbrLoop)), Integer.toString(r.nextInt(nbrLoop)));
		}
		
		System.out.println("Temps total ajout dans un arbre binaire de recherche : " + f.format((double)(System.nanoTime() - timer) / Math.pow(10, 9)) + " secondes");
		return System.nanoTime() - timer;
	}
	
	private static double getExecutionTimeGetList(int nbrLoop) {
		Random r = new Random();
		long timer = System.nanoTime();
		for(int i = 0; i < nbrLoop; i++) {
			list.get(Integer.toString(r.nextInt(nbrLoop)));
		}
		System.out.println("Temps total get dans une liste : " + f.format((double)(System.nanoTime() - timer) / Math.pow(10, 9)) + " secondes");
		return System.nanoTime() - timer;
	}
	
	private static double getExecutionTimeGetTree(int nbrLoop) {
		Random r = new Random();
		long timer = System.nanoTime();
		for(int i = 0; i < nbrLoop; i++) {
			tree.get(Integer.toString(r.nextInt(nbrLoop)));
		}
		
		System.out.println("Temps total get dans un arbre binaire de recherche : " + f.format((double)(System.nanoTime() - timer) / Math.pow(10, 9)) + " secondes");
		return System.nanoTime() - timer;
	}
	
	private static double getExecutionTimeSupprimeList(int nbrLoop) {
		Random r = new Random();
		long timer = System.nanoTime();
		for(int i = 0; i < nbrLoop; i++) {
			list.supprime(Integer.toString(r.nextInt(nbrLoop)));
		}
		System.out.println("Temps total supprime dans une liste : " + f.format((double)(System.nanoTime() - timer) / Math.pow(10, 9)) + " secondes");
		return System.nanoTime() - timer;
	}	
	
	private static double getExecutionTimeSupprimeTree(int nbrLoop) {
		Random r = new Random();
		long timer = System.nanoTime();
		for(int i = 0; i < nbrLoop; i++) {
			tree.supprime(Integer.toString(r.nextInt(nbrLoop)));
		}
		
		System.out.println("Temps total supprime dans un arbre binaire de recherche : " + f.format((double)(System.nanoTime() - timer) / Math.pow(10, 9)) + " secondes");
		return System.nanoTime() - timer;
	}
}
