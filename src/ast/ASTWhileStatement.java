package ast;
import java.util.*;
/**
 * @author GAO RISHENG A0101891L
 * This class is in charge of AST NODE construction of while statement in C/Java/Python programs
 * 
 */
public class ASTWhileStatement extends ASTBlockStatement {
	private static final String NODE_TYPE = "While Statement";
	protected ASTExpression condition;
	protected ArrayList<ASTStatement> statements;
	public ASTWhileStatement(){
		super();
		this.statements = new ArrayList<ASTStatement>();
	}
	public ASTWhileStatement(ASTExpression exp) {
		super();
		this.condition = exp;
		exp.addParent(this);
		this.statements = new ArrayList<ASTStatement>();
	}
	public void addStatement(ASTStatement s){
		this.statements.add(s);
		s.addParent(this);
	}
	public String toSyntax(){
		return this.result;
	}
	public String typeof(){
		return super.typeof()+"->"+NODE_TYPE;
	}
}
