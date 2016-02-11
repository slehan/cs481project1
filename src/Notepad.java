import java.io.IOException;

public class Notepad extends Thread{
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

	private void f() {
		// Since OS X and Windows have two different text editors, we need to check what OS we're running first
		String osStr = System.getProperty("os.name");
		
		if (osStr.equals("Mac OS X")) {
			try {
				Process execProcess = Runtime.getRuntime().exec("open /Applications/TextEdit.app");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
