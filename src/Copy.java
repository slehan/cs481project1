

import java.io.*;
import java.nio.file.StandardCopyOption;
import java.nio.file.CopyOption;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Copy extends Command {
	/* Command::
   copy nameA nameB      where nameA and nameB must be the name of a files and their paths.
   Action:
   Copies file nameA to file nameB.
   Errors:
   The user enters:
   1. copy               Does not type the file names.
   2. copy name          Did not type a second file name.
   3. copy nameA nameB   but the file nameA does not exist.
   4. copy nameA nameB   but the file nameB already exist.
   5. copy nameA nameB   but nameA is a directory.
   6. copy nameA nameB   but the file is a directory.
   When there is an error println a message and return (not exit).
	 */
	
	public Copy(String name) {
		// Make sure a name was given
		if (name.isEmpty())
		{
			System.out.println("copy: No file path was given\n");
			return;
		}
		this.name = name;
	}

	protected void f() {
		//Split name into the source and the destination
		String[] fileNames = name.split(" ", 3);
		
		if(fileNames.length < 2)
		{
			System.out.println("copy: You must enter a destination file.\n");
			return;
		}
		
//		// Get the path from the destination and source file name
		Path src = FileSystems.getDefault().getPath(fileNames[0]);
		Path dest = FileSystems.getDefault().getPath(fileNames[1]);
		
		// Create a new File object with the new destination path
		File destFile = new File(fileNames[1]);
		File srcFile = new File(fileNames[0]);
		
		//error checking
		
		if(srcFile.isDirectory()){
			System.out.println("copy: The source file is a directoy\n");
			return;
		}
		if (!srcFile.exists())
		{
			System.out.println("copy: Your source is not a valid file.\n");
			return;
		}

		// If the destination file does not exist, create a new one
		if (destFile.exists()){
			System.out.println("copy: Destination file already exists.\n");
			return;
		}
			// Try to create the new file
			try {
				destFile.createNewFile();
			} catch (IOException e1) {
				System.out.println("copy: There was an issue creating the destination file to copy into.\n");
				return;
			}
		

		// Create an array of the copy options, in this case we're just going to replace the existing copy
		// of the file
		CopyOption[] options = {StandardCopyOption.REPLACE_EXISTING};

		// Try the copy
		try {
			Files.copy(src, dest, options);
		} catch (IOException e) {
			System.out.println("copy: There was an issue copying the file.\n");
			return;
		}
	}
}
