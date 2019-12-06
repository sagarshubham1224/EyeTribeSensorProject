package commandPack;

public class Commands {
	
	private String commandInstruction ;
	
	private CommandAttribute commandAttribute ;

	public Commands(String commandInstruction, CommandAttribute commandAttribute) {
		super();
		this.commandInstruction = commandInstruction;
		this.commandAttribute = commandAttribute;
	}

	@Override
	public String toString() {
		return "Commands {commandInstruction=" + commandInstruction + ", commandAttribute=" + commandAttribute + "}";
	}
}
