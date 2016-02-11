

import java.io.*;

public class Dir {
	/* Command::
       dir name           where name must be null or the name of a directory and its paths.
       Action:
       List the file and directory names in this directory.
       Note that if the user enters "dir" it is OK and it means the current
       directory. In this case as you know a period (e,g .) means the current
       directory
       Errors:
       The user enters:
       1. dir name             The directory name does not exist.
       2. dir name             But the name does is not a directory name.
       When there is an error println a message and return (not exit).
	 */

	public Dir(String name){
		f(name);
	}

	private void f(String name) {
		// Create a File object with the name
		File directory = new File(name);

		// Check to make sure the file exists
		if (!directory.exists())
		{
			// Since the path doesn't exist as a file/directory, print an error
			System.out.println("dir: Given path does not exist.\n");
			return;
		}

		// Check if its not a directory
		if (!directory.isDirectory()) {
			// Since its not a directory, print an error
			System.out.println("dir: Given path is not a directory.\n");
			return;
		}

		// Create an array of the files in the directory
		File[] files = directory.listFiles();

		// Loop through the files and print them out
		for (int index = 0; index < files.length; index++)
		{
			// Print out the file name
			System.out.println(files[index].getName());
		}
	}
}
