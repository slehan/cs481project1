

import java.io.*;
import java.util.StringTokenizer;
/*
  As we are going through the semester I will add more names to Token.java.
  The errors that I mentioned in any class are the ones that I could think of
  while I was writing the class. There may be more erros that I could not think
  of. Please inform me if there are more errors so that I inform other students.
*/
class Main {
    public static void main(String[] args) {
      while(true){
        System.out.print("PROMPT\\>");
        String command = "";
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        try {
          command = stdin.readLine();
        }
        catch (Exception e) {
          System.out.println(e);
          return;
        }
        StringTokenizer tok = new StringTokenizer(command);
        if (tok.hasMoreTokens()) {
          Token token = new Token(tok.nextToken());
          String s = "";
          while (tok.hasMoreTokens())
            s = s + " " + tok.nextToken();
          if (!s.equals(""))
            s = s.substring(1);
          switch (token.kind) {
            case Token.ATTRIB:
              new Attrib(s);
              break;
            case Token.COPY:
              new Copy(s);
              break;
            case Token.DATE:
              new MyDate();
              break;
            case Token.DELETE:
              new Delete(s);
              break;
            case Token.DIR:
              new Dir(s);
              break;
            case Token.EDIT:
              new Notepad();
              break;
            case Token.EXEC:
              new Execute(s);
              break;
            case Token.EXIT:
              System.exit(1);
            case Token.MKDIR:
              new Mkdir(s);
              break;
            case Token.RENAME:
              new Rename(s);
              break;
            case Token.RMDIR:
              new Rmdir(s);
              break;
            case Token.TIME:
              new MyTime();
              break;
            default:
              System.out.println("Wrong command.");
          }
        }
      }
    }
}
