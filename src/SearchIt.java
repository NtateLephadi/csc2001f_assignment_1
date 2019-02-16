import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
	Searcht Traverses the phone directory and prints out the data entries linked to full name queried

*/
public class SearchIt
{
	Tree tree;
	Scanner scanner1, scanner2;
	String temporary, fullEntry, fullName, queryList, query, phoneDirectory;

	//Create SearchIt instance and initialize variables
	public SearchIt()
	{
		tree = new Tree();
		scanner1 = null;
		scanner2 = null;
		temporary = "";
		fullName = "";
		fullEntry = "";
		queryList = "../names";
		query = "";
		phoneDirectory = "../yellow pages";

	}
	/**
		Open opens a query file
	*/
	public void openQuery()
	{
		try
		{
			scanner2 = new Scanner(new FileInputStream(queryList));
		}
		catch (FileNotFoundException e)
		{
			System.out.println(e);
		}
	}

	/**
		Open opens the phone directory
	*/
	public void openPhone()
	{
		try
		{
			scanner1 = new Scanner(new FileInputStream(phoneDirectory));
		}
		catch (FileNotFoundException e)
		{
			System.out.println(e);
		}
	}

	//add names and full entry to the tree
	public void addData()
	{
		while (scanner1.hasNext())
		{
			temporary = scanner1.nextLine();
			fullName = temporary.substring(temporary.lastIndexOf("|") + 1);
			fullEntry = temporary;
			tree.add(fullName, fullEntry);
		}
	}

	/**
		Search query in the phone directory
	*/
	public void search()
	{
		while (scanner2.hasNext())
		{
			query = scanner2.nextLine();
			System.out.println(tree.write(query));
		}
	}

	/**
		Create main method that writes to screen

		@param args args in array
	*/
	public static void main(String[] args)
	{
		SearchIt searchIt = new SearchIt();
		searchIt.openPhone();
		searchIt.openQuery();
		searchIt.addData();
		searchIt.search();
	}
}
