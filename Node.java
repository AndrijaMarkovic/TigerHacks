package bp;

public class Node<T> implements INode<T> {

	Node(T pKey) {
		key = pKey;
	}

	private T key;
	private INode<T> leftChild;
	private INode<T> rightChild;
	private INode<T> parent;

	@Override
	public INode<T> getLeftChild() {
		return leftChild;
	}

	@Override
	public void setLeftChild(INode<T> pLeftChild) {
		leftChild = pLeftChild;
	}

	@Override
	public INode<T> getRightChild() {
		return rightChild;
	}

	@Override
	public void setRightChild(INode<T> pRightChild) {
		rightChild = pRightChild;
	}

	@Override
	public T getValue() {
		return key;
	}

	@Override
	public void setValue(T pKey) {
		key = pKey;

	}

	@Override
	public INode<T> getParent() {
		return parent;
	}

	@Override
	public void setParent(INode<T> pParent) {
		parent = pParent;
	}

	public String toString() {
		return getValue().toString();
	}

}
