package com.soebes.jacem2;

public interface OperationCode {

	int getCycles();
	int getNumberOfBytes();

	String getMnemonic();
	String getOperators();
	boolean hasOperators();

	void execute();

	void setOperationCode(int opc);
}
