

import java.io.*;
import java.nio.file.Files;

public class Rmdir extends Command {
	/* Command:
               rmdir name
               Action:
               Removes the directory name.
               Errors:
               The user enters:
               1. rmdir              The name is missing.
               2. rmdir name         But the name does not exist.
               3. rmdir name         But name is not a directory.
               4. rmdir name         But the directory name is not empty.
               When there is an error println a message and return (not exit).
	 */


	public Rmdir(String name){
		if (name.isEmpty())
		{
			System.out.println("copy: No directory was given\n");
			return;
		}
		this.name = name;
	}

	protected void f() {
		File deleteMe = new File(name);
		
		if(!deleteMe.exists())
		{
			System.out.println("copy: Directory does not exist.\n");
			return;
		}
		if(!deleteMe.isDirectory())
		{
			System.out.println("copy: Not a directory.\n");
			return;
		}
		if(deleteMe.list().length > 0)
		{
			System.out.println("copy: Directory is not empty.\n");
			return;
		}
		else
		{
			deleteMe.delete();
		}
	}
}
