package bp;

import java.util.Optional;

public interface IBinaryTree<T> {
	/**
	 * 
	 * @return The minimum value of the tree.
	 */
	T showMinimumValue();

	/**
	 * 
	 * @return The maximum value of the tree.
	 */
	T showMaximumValue();

	/**
	 * 
	 * @return True if there is nothing on the tree. False otherwise.
	 */
	boolean isEmpty();

	/**
	 * 
	 * @return The number of nodes in the tree. Returns zero if the tree is
	 *         empty.
	 */
	int getSize();

	/**
	 * Clears the tree by (effectively) removing all nodes.
	 */
	void clear();

	/**
	 * Inserts a value onto the tree in a new node.
	 * 
	 * @param valueToInsert
	 *            The value to insert in the tree.
	 */
	void insert(T valueToInsert);

	/**
	 * Finds and deletes a value from the tree. If the value does not exist on
	 * the tree, no changes are made. If the value is found, the value is
	 * removed and the tree is repaired.
	 * 
	 * @param valueToDelete
	 *            The value to find and remove.
	 */
	void delete(T valueToDelete);

	/**
	 * Finds a value in the tree and returns the node reference to it.
	 * 
	 * @param valueToFind
	 *            The value to find in the tree.
	 * @return The node reference containing the value. Optional.empty() if not
	 *         found.
	 */
	Optional<INode<T>> find(T valueToFind);

	/**
	 * 
	 * @return the length of the longest branch. Returns zero if the tree is
	 *         empty.
	 */
	default int getMaxDepth() {
		throw new UnsupportedOperationException("Not implemented yet.  Five bonus points for implementing.");
	}
}