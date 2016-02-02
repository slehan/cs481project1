

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

  private void f(String name){
  }
}
