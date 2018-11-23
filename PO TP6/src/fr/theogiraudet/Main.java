package fr.theogiraudet;

import fr.theogiraudet.testcompare.Compare;
import fr.theogiraudet.testcompare.TestBenchList;
import fr.theogiraudet.testcompare.TestBenchTree;

public class Main {

	public static void main(String... args) {
		
		Compare.compareAssocie(100_000);
		Compare.compareGet(100_000);
		Compare.compareSupprime(100_000);
		
		TestBenchList.addListTest();
		TestBenchList.getListTest();
		TestBenchList.removeListTest();
		
		TestBenchTree.addTreeTest();
		TestBenchTree.removeTreeTest();
		TestBenchTree.getTreeTest();
		
		
	}
	
}
