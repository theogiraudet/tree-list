package fr.theogiraudet;

import fr.theogiraudet.testcompare.Compare;
import fr.theogiraudet.testcompare.TestBenchList;
import fr.theogiraudet.testcompare.TestBenchTree;

public class Main {

	public static boolean SHOW_COMPARE = true;
	public static boolean SHOW_TEST_BENCH = true;
	
	
	public static void main(String... args) {
		
		if(SHOW_COMPARE) {
			Compare.compareAssocie(10_000);
			Compare.compareGet(10_000);
			Compare.compareSupprime(10_000);
		}
		
		if(SHOW_TEST_BENCH) {
			TestBenchList.addListTest();
			TestBenchList.getListTest();
			TestBenchList.removeListTest();
			
			TestBenchTree.addTreeTest();
			TestBenchTree.removeTreeTest();
			TestBenchTree.getTreeTest();
		}
		
		
	}
	
}
