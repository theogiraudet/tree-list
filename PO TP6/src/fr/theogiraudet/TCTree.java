
package fr.theogiraudet;

import javafx.util.Pair;

public class TCTree extends TableCorrespondance {
	
	private class Node {
		
		private Pair<String, String> value;
		private Node leftChild;
		private Node rightChild;
		
		public Node(String key, String value) {
			this.value = new Pair<>(key, value);
		}
		
		public String toString() {
			return '(' + value.getKey() + ", " + value.getValue() + ')';
		}
	}
	
	private Node root;

	@Override
	public void supprime(String cle) {
		delete(cle, root);
	}
	
	private Node delete(String cle, Node n) {
		if(n == null)
			return n;
		if(cle.compareTo(n.value.getKey()) < 0)
			n.leftChild = delete(cle, n.leftChild);
		else if(cle.compareTo(n.value.getKey()) > 0)
			n.rightChild = delete(cle, n.rightChild);
		else {
			if(n.leftChild == null)
				return n.rightChild;
			if(n.rightChild == null)
				return n.leftChild;
			n.value = getMinValue(n.rightChild);
			n.rightChild = delete(n.value.getKey(), n.rightChild);
		}
		return n;
	}
	
	private Pair<String, String> getMinValue(Node n) {
		return (n.leftChild == null) ? n.value : getMinValue(n.leftChild);
	}

	@Override
	public String get(String cle) {
		Node n = get(root, cle);
		return (n != null) ? n.value.getValue() : null;
	}
	
	private Node get(Node n, String s) {
		if(n == null)
			return null;
		else {
			if(n.value.getKey().equals(s))
				return n;
			else if(s.compareTo(n.value.getKey()) < 0)
				return get(n.leftChild, s);
			else
				return get(n.rightChild, s);
		}
	}
	
	@Override
	public void associe(String cle, String valeur) {
		if(root == null)
			root = new Node(cle, valeur);
		else
			addElement(root, cle, valeur);
	}
	
	private Node addElement(Node n, String key, String value) {
		if(n != null) {
			if(!n.value.getKey().equals(key)) {
				if(key.compareTo(n.value.getKey()) < 0)
					n.leftChild = addElement(n.leftChild, key, value);
				else
					n.rightChild = addElement(n.rightChild, key, value);
			} else
				n.value = new Pair<>(key, value);
			return n;
		} else
			return new Node(key, value);
	}
	
	public String toString() {
		return toString(root, "", true);
	}
	
	private String toString(Node n, String prefix, boolean extrem) {
		if(n == null)
			return "";
		String angle = (extrem) ? "└──" : "├──";
		String pipe = prefix + (extrem ? "" : "│") + "     ";
		return prefix + angle +  n.toString() + '\n' + toString(n.leftChild, pipe, false || n.rightChild == null) + toString(n.rightChild, pipe, true);
	}
}
