package bp;

public interface INode<T> {
	public INode<T> getLeftChild();

	public void setLeftChild(INode<T> leftChild);

	public INode<T> getRightChild();

	public void setRightChild(INode<T> rightChild);
	
	public INode<T> getParent();

	public void setParent(INode<T> parent);

	public T getValue();

	public void setValue(T t);
}