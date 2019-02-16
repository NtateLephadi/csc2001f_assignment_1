/**
	Node class used by Tree to hold key and data

	@author Tumelo Lephadi
	@version 28 March 2017
*/
public class Node
{
	public String key, data;
	public Node left, right;

	/**
		Make new Node with key, data, left and right 

		@param key key in node
		@param data data in node
		@param left left link of node
		@param right right node of node
	*/	
	public Node(String key, String data, Node left, Node right)
	{
		this.key = key;
		this.data = data;
		this.left = left;
		this.right = right;
	}

	/**
		Return key

		@return key key of node
	*/
	public String getKey()
	{
		return key;
	}

	/**
		Return data

		@return key data of node
	*/
	public String getData()
	{
		return data;
	}
	
	/**
		Return left

		@return key left link of node
	*/
	public Node getLeft()
	{
		return left;
	}

	/**
		Return right

		@return key right link of node
	*/
	public Node getRight()
	{
		return right;
	}
}
