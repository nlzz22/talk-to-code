package ast;

import java.util.ArrayList;

/**
 * @author GAO RISHENG A0101891L
 * this class is main in charge of construction of AST node that represents a function declaration
 * (including signature and body) of C/JAVA/PYTHON programs
 *
 */
public class ASTFunction extends ASTBlockStatement{
	private static final String NODE_TYPE = "Function Statement";
	protected ASTExpressionUnitIdentifier name;
	protected ArrayList<ASTStatement> statements;
	public ASTFunction(String name){
		ASTExpressionUnitIdentifier functionName = new ASTExpressionUnitIdentifier(name);
		this.name = functionName;
		functionName.addParent(this);
		this.statements = new ArrayList<ASTStatement>();
	}
	public void addStatement(ASTStatement s){
		this.statements.add(s);
		s.addParent(this);
	}
	public String toSyntax()
	{
		return this.result;
	}
	
}
