

import java.io.*;
import java.lang.Runtime;

public class Execute extends Command {
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
		// Check to make sure name isn't empty
		if (name.isEmpty())
		{
			System.out.println("exec: The java class name is missing.\n");
			return;
		}
		this.name = name;
	}

	protected void f() {
		// Check to make sure that the path given exists
//		if (!new File(name + ".class").exists()) {
//			// If the file doesn't exist, print an error
//			System.out.println("exec: File: " + name + " does not exist.\n");
//			return;
//		}

		// Attempt to execute the class given
		try {
			// Execute the process and create a new Process object
			Process execProcess = Runtime.getRuntime().exec("java -cp . " + name);
			// Get the error input stream
			InputStream errorInStream = execProcess.getErrorStream();
			// Get the standard input stream
			InputStream inputStream  = execProcess.getInputStream();
			// Create a buffered reader for the error stream as well as the input stream
			BufferedReader errorOutReader = new BufferedReader(new InputStreamReader(errorInStream));
			BufferedReader output = new BufferedReader(new InputStreamReader(inputStream));
			
			// Create strings to hold their values
			String errorLine = null;
			String outputLine = null;
			
			try
			{
				while ((errorLine = errorOutReader.readLine()) != null || (outputLine = output.readLine()) != null)
				{
					if (errorLine != null)
						System.out.println(errorLine);
					if (outputLine != null)
						System.out.println(outputLine);
				}
				errorOutReader.close();
				output.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		catch (IOException e)
		{
			System.out.println("Exception: " + e.getMessage());
		}
	}
}
