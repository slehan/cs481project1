

import java.io.*;
import java.nio.file.StandardCopyOption;
import java.nio.file.CopyOption;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Copy {
  /* Command::
   copy nameA nameB      where nameA and nameB must be the name of a files and their paths.
   Action:
   Copies file nameA to file nameB.
   Errors:
   The user enters:
   1. copy               Does not type the file names.
   2. copy name          Did not type a second file name.
   3. copy nameA nameB   but the file nameA does not exist.
   4. copy nameA nameB   but the file nameB alreadyexist.
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
    f(name);
  }

  private void f(String name) {
	  // Get the source path from the file name
	  Path src = FileSystems.getDefault().getPath(name);
	  
	  // Split the source into file path/name then extension
	  String[] srcStrArray = src.toString().split("\\.(?=[^\\.]+$)");
	  // Add " copy" to the file, for example if we have ~/Desktop/File.txt as the source, this will change it to ~/Desktop/File_copy.txt
	  Path dest = FileSystems.getDefault().getPath(srcStrArray[0] + "_copy." + srcStrArray[1]);
	  // Create a new File object with the new destination path
	  File destFile = new File(dest.toString());
	  
	  // If the destination file does not exist, create a new one
	  if (!destFile.exists())
	  {
		  // Try to create the new file
		  try {
			  destFile.createNewFile();
		  } catch (IOException e1) {
			  System.out.println("copy: There was an issue creating the destination file to copy into.\n");
			  return;
		  }
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
