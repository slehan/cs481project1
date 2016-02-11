

import java.io.*;

public class Mkdir {
	/* Command:
           mkdir name
           Action:
           make a directory in the path of the name.
           Errors:
           The user enters:
           1. mkdir                 The name is missing.
           2. mkdir name            But name is already exist.

           When there is an error println a message and return (not exit).
	 */

	public Mkdir(String name){
		// Make sure name isn't empty
		if (name.isEmpty()) {
			System.out.println("mkdir: No directory name was given.\n");
			return;
		}
		f(name);
	}

	private void f(String name) {
		// Create a File object with the name
		File newDir = new File(name);

		// Make sure it doesn't already exist
		if (newDir.exists()) {
			System.out.println("mkdir: Directory already exists.\n");
			return;
		}

		// Otherwise, create it
		newDir.mkdirs();
	}
}
