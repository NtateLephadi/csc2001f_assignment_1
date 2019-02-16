import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
	SearchItLinear Traverses the phone directory and prints out the data entries linked to full name given but uses an array data structure

	@author Tumelo Lephadi
	@version 30 March 2017
*/
public class SearchItLinear
{

	Tree tree;
	Scanner scanner1, scanner2;
	String temporary, fullEntry, query, queryList, phoneDirectory;
	int max, min;
	String[] stringArray;

	//Create SearchItLinear object and initialize variables
	public SearchItLinear()
	{
		scanner1 = null;
		scanner2 = null;
		temporary = "";
		fullEntry = "";
		min = 0;
		max = 10000;
		stringArray = new String[max];
		query = "";
		queryList = "../names";
		phoneDirectory = "../yellow pages";
	}

	/**
		Open file
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

	public void openQuery()
	{
		try
		{
			scanner2 = new Scanner(new FileInputStream(queryList));
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e);
		}
	}

	//Add file entries to the tree
	public void addData()
	{
		while (scanner1.hasNext())
		{
			temporary = scanner1.nextLine();
			fullEntry = temporary;
			stringArray[min] = fullEntry;
			min++;
		}
	}

	/**
		Find full entries linked to full name queried
	*/
	public void find()
	{
		int count = 0;
		while (scanner2.hasNext())
		{
			query = scanner2.nextLine();
			for (String contactDetails: stringArray)
			{
				if (query.equals(contactDetails.substring(contactDetails.lastIndexOf("|") + 1)))
				{
					count++;
					System.out.println(contactDetails);
				}
			}
			if (count <= 0)
			{
				count = 0;
				System.out.println("Not found");
			}
			count = 0;
		}
	}
	/**
		Create main method that writes to screen

		@param args args of array
	*/
	public static void main(String[] args)
	{
		SearchItLinear searchItLinear = new SearchItLinear();
		searchItLinear.openPhone();
		searchItLinear.openQuery();
		searchItLinear.addData();
		searchItLinear.find();

	}
}
