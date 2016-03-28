package ast;

/**
 * @author Martin
 * This class is mainly in charge of AST node generation of arrays in different types
 * in C/Java programs
 */
public class ASTExpressionUnitTypesArray extends ASTExpressionUnitTypes {
	private int dimension;
	public ASTExpressionUnitTypesArray(){
		
	}

	public ASTExpressionUnitTypesArray(String type) {
		this.type = type;
		this.dimension = 1;
		
	}
	public ASTExpressionUnitTypesArray(String type,int dimension){
		this.type = type;
		this.dimension = dimension;
	}
	//syntax generation
	public String toSyntax(){
		this.result = this.type;
		for(int i = 0;i<this.dimension;i++){
			this.result+="[]";
		}
		return this.result;
	}
}
