package ui;

import bp.BinaryTree;

public class Main {

	public static void main(String[] args) {
		
		BinaryTree<Integer> myTree = new BinaryTree<>();
        
        myTree.insert(7);
        myTree.insert(11);
        myTree.insert(3);
        myTree.insert(22);
        myTree.insert(23);
        myTree.insert(18);
        myTree.insert(17);
        myTree.insert(16);
        myTree.insert(12);
        myTree.insert(14);
        myTree.insert(15);
        myTree.insert(9);
        myTree.insert(10);
        myTree.insert(8);
        myTree.insert(1);
        myTree.insert(2);
        myTree.insert(5);
        myTree.insert(4);
        System.out.println(myTree);

        System.out.println(myTree.find(5));
        
        System.out.println(myTree.find(2));
        
        System.out.println(myTree.find(10));
        System.out.println(myTree.find(96));
        myTree.delete(12);
        System.out.println(myTree + " delete 12");
        myTree.delete(11);
        System.out.println(myTree + " delete 11");
        myTree.delete(23);
        System.out.println(myTree + " delete 23");
        myTree.delete(2);
        System.out.println(myTree + " delete 2");
        myTree.delete(9);
        System.out.println(myTree + " delete 9");
        myTree.delete(18);
        System.out.println(myTree + " delete 18");
        myTree.delete(15);
        System.out.println(myTree + " delete 15");
        myTree.delete(17);
        System.out.println(myTree + " delete 17");
        myTree.delete(16);
        System.out.println(myTree + " delete 16");
        myTree.delete(4);
        System.out.println(myTree + " delete 4");
        myTree.delete(1);
        System.out.println(myTree + " delete 1");
        myTree.delete(3);
        System.out.println(myTree + " delete 3");
        myTree.delete(5);
        System.out.println(myTree + " delete 5");
        myTree.delete(10);
        System.out.println(myTree + " delete 10");
        myTree.delete(14);
        System.out.println(myTree + " delete 14");
        myTree.delete(7);
        System.out.println(myTree + " delete 7");
        myTree.delete(22);
        System.out.println(myTree + " delete 22");
        myTree.delete(8);
        System.out.println(myTree + " delete 8");
		
        
      
        
        System.out.println(myTree.getSize());
	}

}
