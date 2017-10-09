package bp;

import java.util.Optional;

public class BinaryTree<T extends Comparable<T>> implements IBinaryTree<T> {

	private INode<T> root;
	private int size = 0;

	@Override
	public T showMinimumValue() {
		INode<T> nodeToCompare, minimum = null;
		nodeToCompare = root;

		if (isEmpty()) {
			return null;
		} else {
			while (nodeToCompare != null) {
				minimum = nodeToCompare;
				nodeToCompare = nodeToCompare.getLeftChild();
			}
			return minimum.getValue();
		}
	}

	public INode<T> getMinimumValue(INode<T> minValue) {
		INode<T> nodeToCompare, minimum = null;
		nodeToCompare = minValue;

		if (isEmpty()) {
			return null;
		} else {
			while (nodeToCompare != null) {
				minimum = nodeToCompare;
				nodeToCompare = nodeToCompare.getLeftChild();
			}
			return minimum;
		}
	}

	@Override
	public T showMaximumValue() {
		INode<T> nodeToCompare, maximum = null;
		nodeToCompare = root;

		if (isEmpty()) {
			return null;
		} else {
			while (nodeToCompare != null) {
				maximum = nodeToCompare;
				nodeToCompare = nodeToCompare.getRightChild();
			}
			return maximum.getValue();
		}
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public void clear() {
		root = null;
		size = 0;
	}

	@Override
	public void insert(T valueToInsert) {

		INode<T> nodeToInsert = new Node<>(valueToInsert);
		INode<T> nodeToCompare = root;

		if (nodeToCompare == null) {
			root = nodeToInsert;
			nodeToInsert = null;
			size++;
		}

		while (nodeToInsert != null) {
			// if value is less than node
			if (valueToInsert.compareTo(nodeToCompare.getValue()) < 0) {
				// go left
				if (nodeToCompare.getLeftChild() == null) {
					nodeToCompare.setLeftChild(nodeToInsert);
					nodeToInsert.setParent(nodeToCompare);
					nodeToInsert = null;
					size++;
				} else {
					nodeToCompare = nodeToCompare.getLeftChild();
				}
				// if value is greater than, or equal to node
			} else if (valueToInsert.compareTo(nodeToCompare.getValue()) >= 0) {
				// go right
				if (nodeToCompare.getRightChild() == null) {
					nodeToCompare.setRightChild(nodeToInsert);
					nodeToInsert.setParent(nodeToCompare);
					nodeToInsert = null;
					size++;
				} else {
					nodeToCompare = nodeToCompare.getRightChild();
				}
			} else {
				nodeToInsert = null;
			}
		}

	}

	@Override
	public void delete(T valueToDelete) {

		if (!find(valueToDelete).isPresent()) {

		} else {
			INode<T> nodeToDelete = find(valueToDelete).get();
			INode<T> sub = null;
			INode<T> parent = nodeToDelete.getParent();
			if (nodeToDelete.getLeftChild() == null && nodeToDelete.getRightChild() == null) {

				if (nodeToDelete == root) {
					root = null;
				} else if (valueToDelete.compareTo(parent.getValue()) > 0) {
					parent.setRightChild(null);
				} else if (valueToDelete.compareTo(parent.getValue()) < 0) {
					parent.setLeftChild(null);
				} else {
					parent.setRightChild(null);
				}
			} else if (nodeToDelete.getRightChild() != null && nodeToDelete.getLeftChild() == null) {

				if (nodeToDelete == root) {
					root.setValue(null);
					root = nodeToDelete.getRightChild();

				} else if (nodeToDelete.getValue().compareTo(parent.getValue()) > 0) {
					parent.setRightChild(nodeToDelete.getRightChild());
					nodeToDelete.getRightChild().setParent(parent);
				} else if (nodeToDelete.getValue().compareTo(parent.getValue()) < 0) {
					parent.setLeftChild(nodeToDelete.getRightChild());
					nodeToDelete.getRightChild().setParent(parent);
				} else {

				}
			} else if (nodeToDelete.getRightChild() == null && nodeToDelete.getLeftChild() != null) {

				if (nodeToDelete == root) {

					root.setValue(null);
					root = nodeToDelete.getLeftChild();

				} else if (nodeToDelete.getValue().compareTo(parent.getValue()) > 0) {
					parent.setRightChild(nodeToDelete.getLeftChild());
					nodeToDelete.getLeftChild().setParent(parent);
					// nodeToDelete.setLeftChild(null);
				} else if (nodeToDelete.getValue().compareTo(parent.getValue()) < 0) {
					parent.setLeftChild(nodeToDelete.getLeftChild());
					nodeToDelete.getLeftChild().setParent(parent);
					// nodeToDelete.setLeftChild(null);
				} else {

				}
			} else if (nodeToDelete.getRightChild() != null && nodeToDelete.getLeftChild() != null) {
				// right child of value to delete
				sub = nodeToDelete.getRightChild();
				// min value of right subtree
				INode<T> valueToReplaceWith = getMinimumValue(sub);

				if (nodeToDelete == root) {
					if (valueToReplaceWith != sub) {
						if (valueToReplaceWith.getRightChild() == null) {
							root.setValue(valueToReplaceWith.getValue());
							valueToReplaceWith.getParent().setLeftChild(null);
						} else if (valueToReplaceWith.getRightChild() != null) {
							root.setValue(valueToReplaceWith.getValue());
							valueToReplaceWith.getParent().setLeftChild(valueToReplaceWith.getRightChild());
							valueToReplaceWith.getRightChild().setParent(valueToReplaceWith.getParent());
						}
					} else if (valueToReplaceWith == sub) {
						if (valueToReplaceWith.getRightChild() == null) {
							root.setValue(sub.getValue());
							valueToReplaceWith.getParent().setRightChild(null);
						} else if (valueToReplaceWith.getRightChild() != null) {
							root.setValue(sub.getValue());
							valueToReplaceWith.getParent().setRightChild(valueToReplaceWith.getRightChild());
							valueToReplaceWith.getRightChild().setParent(valueToReplaceWith.getParent());
						}
					}
				} else if (valueToReplaceWith != sub) {
					if (valueToReplaceWith.getRightChild() == null) {
						if (valueToReplaceWith.getValue().compareTo(parent.getValue()) > 0) {
							nodeToDelete.getParent().getRightChild().setValue(valueToReplaceWith.getValue());
							valueToReplaceWith.getParent().setLeftChild(null);
						} else if (valueToReplaceWith.getValue().compareTo(parent.getValue()) < 0) {
							nodeToDelete.getParent().getLeftChild().setValue(valueToReplaceWith.getValue());
							valueToReplaceWith.getParent().setLeftChild(null);
						}
					} else if (valueToReplaceWith.getRightChild() != null) {
						if (valueToReplaceWith.getValue().compareTo(parent.getValue()) > 0) {
							nodeToDelete.getParent().getRightChild().setValue(valueToReplaceWith.getValue());
							valueToReplaceWith.getParent().setLeftChild(valueToReplaceWith.getRightChild());
							valueToReplaceWith.getRightChild().setParent(valueToReplaceWith.getParent());
						} else if (valueToReplaceWith.getValue().compareTo(parent.getValue()) < 0) {
							nodeToDelete.getParent().getLeftChild().setValue(valueToReplaceWith.getValue());
							valueToReplaceWith.getParent().setLeftChild(valueToReplaceWith.getRightChild());
							valueToReplaceWith.getRightChild().setParent(nodeToDelete.getParent());
						}
					}
				}
				if (valueToReplaceWith == sub) {
					if (valueToReplaceWith.getRightChild() == null) {
						if (valueToReplaceWith.getValue().compareTo(parent.getValue()) > 0) {
							nodeToDelete.getParent().getRightChild().setValue(sub.getValue());
							valueToReplaceWith.getParent().setRightChild(null);
						} else if (valueToReplaceWith.getValue().compareTo(parent.getValue()) < 0) {
							nodeToDelete.getParent().getLeftChild().setValue(sub.getValue());
							valueToReplaceWith.getParent().setRightChild(null);
						}
					} else if (valueToReplaceWith.getRightChild() != null) {
						if (valueToReplaceWith.getValue().compareTo(parent.getValue()) > 0) {
							nodeToDelete.getParent().getRightChild().setValue(sub.getValue());
							valueToReplaceWith.getParent().setRightChild(valueToReplaceWith.getRightChild());
							valueToReplaceWith.getRightChild().setParent(nodeToDelete.getParent());
						} else if (valueToReplaceWith.getValue().compareTo(parent.getValue()) < 0) {
							nodeToDelete.getParent().getLeftChild().setValue(sub.getValue());
							valueToReplaceWith.getParent().setRightChild(valueToReplaceWith.getRightChild());
							valueToReplaceWith.getRightChild().setParent(nodeToDelete.getParent());
						}
					}
				}
			}
			size--;
		}
	}

	@Override
	public Optional<INode<T>> find(T valueToFind) {

		INode<T> nodeToFind = new Node<>(valueToFind);
		INode<T> nodeToCompare = root;
		INode<T> temp = root;
		if (nodeToCompare == null) {
			return Optional.empty();
		}

		while (nodeToFind != null) {
			// if value is less than node
			if (valueToFind.compareTo(nodeToCompare.getValue()) < 0) {
				// go left
				if (nodeToCompare.getLeftChild() == null) {
					temp = null;
					nodeToFind = null;
				} else {
					nodeToCompare = nodeToCompare.getLeftChild();
				}
				// if value is greater than, or equal to node
			} else if (valueToFind.compareTo(nodeToCompare.getValue()) > 0) {
				// go right
				if (nodeToCompare.getRightChild() == null) {
					temp = null;
					nodeToFind = null;
				} else {
					nodeToCompare = nodeToCompare.getRightChild();
				}
			} else {
				temp = nodeToCompare;
				nodeToFind = null;
			}
		}
		return Optional.ofNullable(temp);
	}

	@Override
	public String toString() {
		StringBuilder strBuilder = new StringBuilder();

		strBuilder.append(toString(root));

		return "[" + strBuilder.toString().replaceAll(", $", "") + "]";

	}

	private String toString(INode<T> nodeForToString) {
		if (nodeForToString == null) {
			return "";
		} else {
			return toString(nodeForToString.getLeftChild()) + nodeForToString.getValue() + ", "
					+ toString(nodeForToString.getRightChild());
		}
	}

}
