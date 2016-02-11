import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Delete {
  /* Command::
     delet name           where name must be the name of a file and its paths.
     Action:
     delets name
     Errors:
     The user enters:
     1. delet                The user did not type the file name.
     2. delet name           The file name does not exist in the path.
     3. delete name          But the file name does is a directory.
     When there is an error println a message and return (not exit).
*/
  public Delete(String name){
      
      // Check to make sure a filename/path was given
      if (name.isEmpty())
      {
          // Print error message and return
          System.out.println("delete: No file/path given\n");
          return;
      }
    f(name);
  }

  private void f(String name)
  {
      // Get Path object from name
      Path path = Paths.get(name);
      // Make sure its not a directory
      File file = new File(name);
      // If it is, print the error message that it is a directory and return
      if (file.isDirectory())
      {
          System.out.println("delete: File path is a directory.\n");
          return;
      }
      // Else if it doesn't exist, print the error message
      else if (file.exists() == false)
      {
          System.out.println("delete: File does not exist.\n");
          return;
      }
      else
      {
    	  // Try to delete the file, otherwise print an error
    	  try {
    		  Files.delete(path);
    	  } catch (IOException e) {
    		  System.out.println("delete: There was an error deleting the file.\n");
    	  }
      }
  }
}
