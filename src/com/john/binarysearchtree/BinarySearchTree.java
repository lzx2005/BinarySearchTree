package com.john.binarysearchtree;



public class BinarySearchTree<AnyType extends Comparable<? super AnyType>>{
	private static class BinaryNode<AnyType> {
		AnyType element;
		BinaryNode<AnyType> left;
		BinaryNode<AnyType> right;
		public BinaryNode(AnyType element, BinaryNode<AnyType> left,	BinaryNode<AnyType> right) {
			super();
			this.element = element;
			this.left = left;
			this.right = right;
		}
		public BinaryNode(AnyType element) {
			this(element,null,null);
		}
	}
	
	private BinaryNode<AnyType> root;

	public BinarySearchTree() {
		super();
		root=null;
	}

	public void makeEmpty(){
		root=null;
	}
	
	public boolean isEmpty(){
		return root==null;
	}
	
	public boolean contains(AnyType x){
		return contains(x,root);
	}
	
	public AnyType findMin() throws UnderflowException{
		if(isEmpty()){
			throw new UnderflowException("数据溢出");
		}
		return findMin(root).element;
	}
	
	public AnyType findMax() throws UnderflowException{
		if(isEmpty()){
			throw new UnderflowException("数据溢出");
		}
		return findMax(root).element;
	}
	
	public void insert(AnyType x){
		root = insert(x,root);
	}
	
	public void remove(AnyType x){
		root=remove(x,root);
	}

	private boolean contains(AnyType x, BinaryNode<AnyType> t) {
		if(t==null){
			return false;
		}
		
		int compareResult = x.compareTo(t.element);
		
		if(compareResult<0){
			return contains(x,t.left);
		}else if(compareResult>0){
			return contains(x,t.right);
		}else{
			return true; //Match
		}
	}

	private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t) {
		if(t==null){
			return null;
		}else if(t.left == null){
			return t;
		}else{
			return findMin(t.left);
		}
	}

	private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t) {
		if(t!=null)
			while(t.right!=null)
				t=t.right;
		return t;
	}

	private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t) {
		if(t==null){
			return new BinaryNode<AnyType>(x, null, null);
		}
		
		int conpareResult = x.compareTo(t.element);
		
		if(conpareResult<0){
			t.left = insert(x, t.left);
		}else if(conpareResult>0){
			t.right = insert(x, t.right);
		}
		return t;
	}

	private BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> t) {
		if(t==null){
			return t;
		}

		int conpareResult = x.compareTo(t.element);
		
		if(conpareResult<0){
			t.left = remove(x, t.left);
		}else if(conpareResult>0){
			t.right = remove(x, t.right);
		}else if(t.left!=null && t.right != null){
			t.element = findMin(t.right).element;
			t.right = remove(t.element, t.right);
		}else{
			t = (t.left != null) ? t.left : t.right;
		}
		return t;
	}
}