

import java.io.*;
import java.util.StringTokenizer;

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
          System.out.println("No file path was given");
          return;
      }
    f(name);
  }

  private void f(String name) {
  }
}
