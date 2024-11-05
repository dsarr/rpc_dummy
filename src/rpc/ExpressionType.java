package rpc;


/**
 * represents either a function argument type or return type 
 */
public enum ExpressionType {
	VOID,
	INT,
	STRING;

	boolean isIntegralType() {
		return this.equals(INT);
	}
	
	boolean isStringType() {
		return this.equals(STRING);
	}
	
	boolean isVoidType() {
		return this.equals(VOID);
	}

}
