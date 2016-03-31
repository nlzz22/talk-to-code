package ast;
import java.util.*;

/**
 * @author GAO RISHENG A0101891L
 * This class is mainly of constructing AST Nodes that represent a do-while statement in program
 * Since python does not support do-while statement and the Syntax of do_while statement
 * is the same for both C and Java programs. Therefore it would not be necessary to have subclass
 * to customize syntax for C and Java. 
 */
public class ASTDoWhileStatement extends ASTBlockStatement {
	private static final String NODE_TYPE = "Do while Statement";
	protected ASTExpression exp;
	protected ArrayList<ASTStatement> statements;
	public ASTDoWhileStatement() {
		super();
		this.exp = null;
		this.statements = new ArrayList<ASTStatement>();
	}
	public ASTDoWhileStatement(ASTExpression exp){
		this();
		this.exp = exp;
		exp.addParent(this);
	}
	public void addStatement(ASTStatement s){
		this.statements.add(s);
		s.addParent(this);
	}
	public String typeof(){
		return super.typeof()+"->"+NODE_TYPE;
	}
	//code construction
	public String toSyntax(){
		this.result = "do {\n";
		for(ASTStatement s:this.statements){
			this.result+="\t";
			this.result+=s.toSyntax();
			this.result+="\n";
		}
		this.result+="} while (";
		this.result += this.exp.toSyntax();
		this.result+= ");\n";
		return this.result;
	}
}
