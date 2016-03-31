

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.StringTokenizer;

public class Rename extends Command {
	/* Command:
             rename nameA nameB
             Action:
             Renames the file nameA to the file nameB.
             Use your classes Copy and Delete for this.
             Errors:
             The user enters:
             1. rename              The names nameA and nameB are missing.
             When there is an error println a message and return (not exit).
	 */


	public Rename(String name) {
		if (name.isEmpty())
		{
			System.out.println("copy: No file path was given\n");
			return;
		}
		this.name = name;
	}

	protected void f() {
		Copy copy = new Copy(name);
		//Split name into the source and the destination
		String[] fileNames = name.split(" ", 2);
		//delete the original
		Delete delete = new Delete(fileNames[0]);
	}
}
