/**
	Class invariant Tree satisfies binary search tree storage rules

	@author Tumelo Lephadi
	@version 27 March 2017
*/

public class Tree
{
	public String key, data;
	public Node root;

	/**
		Make new Tree with root set to null
	*/
	public Tree()
	{
		root = null;
	}

	/**
		Returns the root node of a tree but with a new node added that contains key and data 
		
		@param key key in node to be added
		@param data data in node to be added
		@param node to be added at end of tree
		@return tree with added node
	*/
	private Node insert(String key, String data, Node node)
	{
		if (node == null)
		{
			return new Node(key, data, null, null);	
		}
		else if (key.compareTo(node.key) < 0)
		{
			node.left = insert(key, data, node.left);
			return node;
		}
		else
		{
			node.right = insert(key, data, node.right);
			return node;
		}
	}

	/**
		Searches for key in node within tree and returns the data of node if found or prints out "Not found"

		@param query query being searched
		@param node node being checked
		@return data the data of the key or "NOT FOUND"
	*/
	private String find(String query, Node node)
	{
		if (node == null)
		{
			return "Not found";
		}
		else if (node.key.equals(query))
		{
			return node.getData();
		}
		else if (query.compareTo(node.key) < 0)
		{
			return find(query, node.left);
		}
		else
			return find(query, node.right);
	}

	/**
		Traverse in order and print

		@param node node to be traversed from (starting point)
	*/
	public void traverse(Node node)
	{
		if (node != null)
		{
			traverse(node.getLeft());
			System.out.println(node.getKey());
			traverse(node.getRight());
		}
	}

	/**
		Print data to screen

		@param query name that is searched in phone directory
		@return data linked to key that's queried
	*/
	public String write(String query)
	{
		return find(query, root);
	}

	/**
		Add to tree

		@param key key added to node
		@param data data added to node
	*/
	public void add(String key, String data)
	{
		root = insert(key, data, root);
	}
}