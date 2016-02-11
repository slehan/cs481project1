

import java.io.*;
import java.io.File;
import java.nio.file.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.util.*;
import static java.nio.file.attribute.PosixFilePermission.OWNER_READ;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Attrib {
	/* Command::
     attrib name       where name must be the name of a file and its path.
     Action:
     Makes the file read only.
     Errors:
     The user enters:
     1. attrib             Does not type the file name.
     2. attrib name        but the file does not exist.
     3. attrib name        but the file is a directory.
     When there is an error println a message and return (not exit).

	 */
	public Attrib(String name){
		// Check input
		if (name.isEmpty())
		{
			System.out.println("Please enter a file name.\n");
			return;
		}
		f(name);
	}

	private void f(String name) {
		// Setup the set of permissions to use
		Set<PosixFilePermission> permissions = new HashSet<>();
		// Add read and only read to it
		permissions.add(OWNER_READ);

		// Get the path to the file
		Path path = Paths.get(name);

		// Make sure its not a directory
		File file = new File(name);
		// If it is, print the error message that it is a directory and return
		if (file.isDirectory())
		{
			System.out.println("attrib: File path is a directory.\n");
			return;
		}

		try 
		{
			// Try to set the permissions of read only
			Files.setPosixFilePermissions(path, permissions);
		}
		// If the file doesn't exist, catch the exception and print that it doesn't
		// exist
		catch (NoSuchFileException ex)
		{
			System.out.println("attrib: File: " + name + " not found.\n");
		} 
		catch (IOException ex)
		{
			Logger.getLogger(Attrib.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
