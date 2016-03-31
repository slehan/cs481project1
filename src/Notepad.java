import java.io.IOException;

public class Notepad extends Command {
	/*
      Command:
      edit
      Action:
      The notepad editor shows up on the screen.

      Use the java Runtime class to execute the notepad.exe. With this approch
      you do not need notepad.h, notepad.c, and notepad.exe.
      This approach is easier than one I posted last week. You do not
      need the java native interface (JNI) or Microsoft visual C++.
	 */
	public Notepad(){
		f();
	}

	protected void f() {
		// Since OS X and Windows have two different text editors, we need to check what OS we're running first
		String osStr = System.getProperty("os.name");
		
		if (osStr.equals("Mac OS X")) {
			// Attempt to open TextEdit.app
			try {
				Runtime.getRuntime().exec("open /Applications/TextEdit.app");
			} catch (IOException e) {
				System.out.println("edit: There was an issue opening TextEdit.");
			}
		} else if (osStr.contains("Windows")) {
			try {
				Runtime.getRuntime().exec("cmd /c start Notepad.exe");
			} catch (IOException e) {
				System.out.println("edit: There was an issue opening Notepad.");
			}
		}
	}
}
