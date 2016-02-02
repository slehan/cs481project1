

import java.io.*;
import java.util.StringTokenizer;
import java.lang.reflect.*;

public class Execute {
  /* Command::
         exec name word1 word2, ....   where name must the name of a java class and its paths
                                       and wordis are the arguments.
         Action:
         Executes the "main" of the name.class. Therefore this file must be the main file.
         Errors:
         The user enters:
         1. exec                 The class name is missing.
         2. exec name            But name.class does not exist.
         3. There are exceptions that you need to find them.
         When there is an error println a message and return (not exit).
    */

  public Execute(String name){
    f(name);
  }

  private void f(String s){
   }
}
