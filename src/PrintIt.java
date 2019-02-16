import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
	PrintIt Traverses the phone directory and prints out the data entries in alphabetical order

	@author Tumelo Lephadi
	@version 29 March 2017
*/
public class PrintIt
{
	Tree tree;
	Scanner scanner;
	String temporary, fullEntry, fullName, fileName;


	//Create new PrintIt object and initialize variables
	public PrintIt()
	{
		tree = new Tree();
		scanner = null;
		temporary = "";
		fullEntry = "";
		fullName = "";
		fileName = "../yellow pages";
	}

	/**
		Open file
		*/
	public void open()
	{
		try
		{
			scanner = new Scanner(new FileInputStream(fileName));
		}
		catch (FileNotFoundException e)
		{
			System.out.println(e);
		}
	}

	//Add entries into the tree
	public void add()
	{
		while (scanner.hasNext())
		{
			temporary = scanner.nextLine();
			fullName = temporary.substring(temporary.lastIndexOf("|") + 1);
			fullEntry = temporary;
			tree.add(fullName, fullEntry);
		}

	}

	//Write the sorted tree on the screen
	public void write(Tree tree)
	{
		tree.traverse(tree.root);
	}

	/**
		Create main method that writes to screen using Tree and Node functions

		@param args args in array
	*/
	public static void main(String[] args)
	{
		PrintIt printIt = new PrintIt();
		printIt.open();
		printIt.add();
		printIt.write(printIt.tree);
	}
}
