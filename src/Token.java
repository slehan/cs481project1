

public class Token{
	public int kind;

	public Token(String spelling){
		kind = -1;
		for(int k = ATTRIB; k <= TIME; k++)
			if(spelling.equals(spellings[k])){
				this.kind = (byte)k;
				break;
			}
	}

	public final static byte
	ATTRIB      = 0,        //attrib
	COPY        = 1,        //copy
	DATE        = 2,        //date
	DELETE      = 3,        //delete
	DIR         = 4,        //dir
	EDIT        = 5,        //edit
	EXEC        = 6,        //exec
	EXIT        = 7,        //exit
	MKDIR       = 8,        //mkdir
	RENAME      = 9,        //rename
	RMDIR       = 10,       //rmdir
	TIME        = 11;       //time


	private final static String[] spellings = {
			"attrib", "copy", "date", "delete", "dir", "edit", "exec",
			"exit", "mkdir", "rename", "rmdir", "time"
	};
}
