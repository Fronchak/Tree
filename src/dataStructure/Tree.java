package dataStructure;

import service.CompareService;
import service.CompareServiceImpl;
import util.Node;

public class Tree {

	private Node root;
	private CompareService compareService;
	
	private static final int EQUAL = 0;
	private static final int BIGGER = 1;
	private static final int LOWER = -1;
	
	public Tree() {
		this(new CompareServiceImpl());
	}
	
	public Tree(CompareService compareService) {
		this.root = null;
		this.compareService = compareService;
	}
	
	public void insert(Integer key) {
		if(this.root == null) { this.root = new Node(key); }
		else { this.root = insertNode(this.root, key); }
	}
	
	private Node insertNode(Node node, Integer key) {
		if(node == null) { 
			node = new Node(key); 
		}
		else { 
			node = insertNodeAt(node, key); 
		}
		return node;
	}
	
	private Node insertNodeAt(Node node, Integer key) {
		int result = compareService.compare(key, node.getKey());
		if(result == BIGGER) { 
			node.setRight(insertNode(node.getRight(), key));
		}
		else if(result == LOWER) { 
			node.setLeft(insertNode(node.getLeft(), key)); 
		}
		return node;
	}
}
