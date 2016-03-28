package ast;

/**
 * @author GAO RISHENG
 * this class is in charge of AST Node construction of return statement 
 * in C/Java/Python programs
 *
 */
public class ASTReturnStatement extends ASTSimpleStatement {
	private static final String NODE_TYPE = "Block Statement";
	public ASTReturnStatement() {
	}
	public String toSyntax(){
		return this.result;
	}
	public String typeof(){
		return super.typeof()+NODE_TYPE;
	}
}
