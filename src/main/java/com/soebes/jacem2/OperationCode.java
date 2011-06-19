package com.soebes.jacem2;

public interface OperationCode {

	int getCycles();
	int getNumberOfBytes();

	String getMnemonic();
	String getOperators();

	void execute();

	void setOperationCode(int opc);
}
