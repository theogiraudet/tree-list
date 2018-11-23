package fr.theogiraudet;

import javafx.util.Pair;

public class TCList extends TableCorrespondance {
	
	private class Element {
		private Element next;
		private Pair<String, String> value;

		public Element(Pair<String, String> i) {
			value = i;
		}
		
		public String toString() {
			return '(' + value.getKey() + ", " + value.getValue() + ')';
		}
	}

	
	private Element head;
	
	@Override
	public void associe(String cle, String valeur) {
		if(head == null)
			head = new Element(new Pair<>(cle, valeur));
		else
			addElement(cle, valeur);
	}
	
	public void addElement(String cle, String valeur) {
		Element e = head;
		boolean b = false;
		while(e != null && !b) {
			if(e.value.getKey().equals(cle)) {
				e.value = new Pair<>(cle, valeur);
				b = true;
			} else
				e = e.next;
		}
		if(!b) {
			Element el = new Element(new Pair<>(cle, valeur));
			el.next = head;
			head = el;
		}
	}
	
	@Override
	public void supprime(String s) {
		if(head == null || (head.next == null && !head.value.getKey().equals(s)))
				return;
		else if(head.value.getKey().equals(s))
			head = head.next;
		Element e = head;
		 while(e != null && e.next != null) {
			if(e.next.value.getKey().equals(s))
				e.next = e.next.next;
			e = e.next;
		}
	}

	@Override
	public String get(String s) {
		Element e = head;
		while(e != null) {
			if(e.value.getKey().equals(s))
				return e.value.getValue();
			e = e.next;
		}
		return null;
	}
		
	public String toString() {
		return '{' + toString(head).replaceFirst(", ", "") + '}';
	}
	
	private String toString(Element e) {
		if(e == null)
			return "";
		return ", " + e + toString(e.next); 
	}
}