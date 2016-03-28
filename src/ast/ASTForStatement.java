package ast;

/**
 * @author GAO RISHENG A0101891L
 * this class is mainly in charge of construction AST nodes that represents a for loop in programs
 *
 */
public class ASTForStatement extends ASTBlockStatement{
	private static final String NODE_TYPE = "Block Statement";
	public ASTForStatement() {
	}
	//virtual method
	public String toSyntax(){
		this.result = "\n";
		return this.result;
	}
	public String typeof(){
		return super.typeof()+NODE_TYPE;
	}
}
