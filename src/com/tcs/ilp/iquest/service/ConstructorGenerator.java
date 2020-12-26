package com.tcs.ilp.iquest.service;

import java.math.BigInteger;

public class ConstructorGenerator {

	private int[] arrayOfVariables;
	private int numberOfVariables;
	private int rConstant;
	private BigInteger numLeft;
	private BigInteger total;

	// ------------
	// Constructor
	// ------------

	public ConstructorGenerator(int numberOfVariables, int rConstant) {
		if (rConstant > numberOfVariables) {
			throw new IllegalArgumentException();
		}
		if (numberOfVariables < 1) {
			throw new IllegalArgumentException();
		}
		this.numberOfVariables = numberOfVariables;
		this.rConstant = rConstant;
		arrayOfVariables = new int[rConstant];
		BigInteger nFact = getFactorial(numberOfVariables);
		BigInteger rFact = getFactorial(rConstant);
		BigInteger nminusrFact = getFactorial(numberOfVariables - rConstant);
		total = nFact.divide(rFact.multiply(nminusrFact));
		reset();
	}

	// ------
	// Reset
	// ------

	public void reset() {
		for (int i = 0; i < arrayOfVariables.length; i++) {
			arrayOfVariables[i] = i;
		}
		numLeft = new BigInteger(total.toString());
	}

	// ------------------------------------------------
	// Return number of combinations not yet generated
	// ------------------------------------------------

	public BigInteger getNumLeft() {
		return numLeft;
	}

	// -----------------------------
	// Are there more combinations?
	// -----------------------------

	public boolean hasMore() {
		return numLeft.compareTo(BigInteger.ZERO) == 1;
	}

	// ------------------------------------
	// Return total number of combinations
	// ------------------------------------

	public BigInteger getTotal() {
		return total;
	}

	// ------------------
	// Compute factorial
	// ------------------

	private static BigInteger getFactorial(int number) {
		BigInteger fact = BigInteger.ONE;
		for (int index = number; index > 1; index--) {
			fact = fact.multiply(new BigInteger(Integer.toString(index)));
		}
		return fact;
	}

	// --------------------------------------------------------
	// Generate next combination
	// --------------------------------------------------------

	public int[] getNext() {

		if (numLeft.equals(total)) {
			numLeft = numLeft.subtract(BigInteger.ONE);
			return arrayOfVariables;
		}

		int index = rConstant - 1;
		while (arrayOfVariables[index] == numberOfVariables - rConstant + index) {
			index--;
		}
		arrayOfVariables[index] = arrayOfVariables[index] + 1;
		for (int counter = index + 1; counter < rConstant; counter++) {
			arrayOfVariables[counter] = arrayOfVariables[index] + counter
					- index;
		}

		numLeft = numLeft.subtract(BigInteger.ONE);
		return arrayOfVariables;

	}
}
