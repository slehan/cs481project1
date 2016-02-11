

import java.io.*;

public class Rmdir {
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
		f(name);
	}

	private void f(String name){
	}
}
