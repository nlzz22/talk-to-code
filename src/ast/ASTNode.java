package ast;

import java.util.ArrayList;

/**
 * @author GAO RISHENG A0101891L
 * This class is the super class of all kinds of AST nodes
 */
public class ASTNode{
	private static final String type = "ASTNode";
	protected int usability;
	protected static final int INDEX_C = 0;
	protected static final int INDEX_JAVA = 1;
	protected static final int INDEX_PYTHON = 2;
	protected static final String LAN_C = "C";
	protected static final String LAN_JAVA = "JAVA";
	protected static final String LAN_PYTHON = "PYTHON";
	protected ASTNode parent;
	protected String language;
	protected String result;
	public ASTNode()
	{
		parent = null;
		this.result = "";
		
	}
	
	protected void addParent(ASTNode p){
		this.parent = p;
	}
	
	/**
	 * @deprecated methods to check whether a node is supported in specific programming language
	 * This is handled in parser level.
	 */
	protected boolean isApplicable(int programmingLanguageIndex){
		return (this.usability&(1<<programmingLanguageIndex))==0;
	}
	
	
	//virtual methods
	public String toSyntax()
	{
		return this.result;
	}
	public String typeof(){
		return type;
	}
	
	
}
