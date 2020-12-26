package com.tcs.ilp.iquest.service;

import java.util.Random;


public class RandomGenerator {


	/*

	public ArrayList<Object> generateIntValues(String sampleConstructor) {
		// TODO Auto-generated method stub
		ArrayList<Object> intValues = new ArrayList<Object>();
		int countOfInt = StringUtils.countMatches(sampleConstructor, "int ");
		if (countOfInt > 0) {
			Random random = new Random();
			for (int index = 0; index < countOfInt; index++) {
				int randomInt = random.nextInt(100);
				intValues.add(randomInt);
			}
		}
		return intValues;
	}

	public ArrayList<Object> generateDoubleValues(String sampleConstructor) {
		// TODO Auto-generated method stub
		ArrayList<Object> doubleValues = new ArrayList<Object>();
		int countOfDouble = StringUtils.countMatches(sampleConstructor,
				"double ");
		if (countOfDouble > 0) {
			Random random = new Random();
			for (int index = 0; index < countOfDouble; index++) {
				double randomDouble = random.nextDouble();
				doubleValues.add(randomDouble);
			}
		}
		return doubleValues;
	}

	public ArrayList<Object> generateFloatValues(String sampleConstructor) {
		// TODO Auto-generated method stub
		ArrayList<Object> floatValues = new ArrayList<Object>();
		int countOfFloat = StringUtils
				.countMatches(sampleConstructor, "float ");
		if (countOfFloat > 0) {
			Random random = new Random();
			for (int index = 0; index < countOfFloat; index++) {
				float randomFloat = random.nextFloat();
				floatValues.add(randomFloat);
			}
		}
		return floatValues;
	}

	public ArrayList<Object> generateCharValues(String sampleConstructor) {
		// TODO Auto-generated method stub
		ArrayList<Object> charValues = new ArrayList<Object>();
		int countOfChar = StringUtils.countMatches(sampleConstructor, "char ");
		if (countOfChar > 0) {
			for (int index = 0; index < countOfChar; index++) {
				final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				final int length = alphabet.length();
				Random random = new Random();
				char randomChar = alphabet.charAt(random.nextInt(length));
				charValues.add(randomChar);

			}
		}
		return charValues;
	}

	public ArrayList<Object> generateBooleanValues(String sampleConstructor) {
		// TODO Auto-generated method stub
		ArrayList<Object> booleanValues = new ArrayList<Object>();
		int countOfBoolean = StringUtils.countMatches(sampleConstructor,
				"float ");
		if (countOfBoolean > 0) {
			Random random = new Random();
			for (int index = 0; index < countOfBoolean; index++) {
				boolean randomBoolean = random.nextBoolean();
				booleanValues.add(randomBoolean);
			}
		}
		return booleanValues;
	}

	public ArrayList<Object> generateStringValues(String sampleConstructor) {
		// TODO Auto-generated method stub
		ArrayList<Object> stringValues = new ArrayList<Object>();
		int countOfString = StringUtils.countMatches(sampleConstructor,
				"String ");
		if (countOfString > 0) {
			Random random = new Random();
			for (int index = 0; index < countOfString; index++) {
				char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
				StringBuilder strBuilder = new StringBuilder();
				for (int i = 0; i < 7; i++) {
					char tempChar = chars[random.nextInt(chars.length)];
					strBuilder.append(tempChar);
				}
				stringValues.add(strBuilder.toString());
			}
		}
		return stringValues;
	}

	public ArrayList<Object> generateStringBuilderValues(
			String sampleConstructor) {
		// TODO Auto-generated method stub
		ArrayList<Object> stringBuilderValues = new ArrayList<Object>();
		int countOfStringBuilder = StringUtils.countMatches(sampleConstructor,
				"StringBuilder ");
		if (countOfStringBuilder > 0) {
			Random random = new Random();
			for (int index = 0; index < countOfStringBuilder; index++) {
				char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
				StringBuilder strBuilder = new StringBuilder();
				for (int i = 0; i < 7; i++) {
					char tempChar = chars[random.nextInt(chars.length)];
					strBuilder.append(tempChar);
				}
				stringBuilderValues.add(strBuilder.toString());
			}
		}
		return stringBuilderValues;
	}
*/
	public CharSequence generateIntValue() {
		// TODO Auto-generated method stub
		Random random = new Random();
		int randomInt = random.nextInt(100);
		return String.valueOf(randomInt);
	}

	public CharSequence generateDoubleValue() {
		// TODO Auto-generated method stub
		double start = 30;
		double end = 1000;
		Random random = new Random();
		double randomDouble = random.nextDouble();
		double result = start + (randomDouble * (end - start));
		return String.valueOf((int)(result));
	}

	public CharSequence generateFloatValue() {
		// TODO Auto-generated method stub
		Random random = new Random();
		float randomFloat = random.nextFloat();
		return String.valueOf(randomFloat);
	}

	public CharSequence generateCharValue() {
		// TODO Auto-generated method stub
		final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		final int length = alphabet.length();
		Random random = new Random();
		char randomChar = alphabet.charAt(random.nextInt(length));
		return String.valueOf(randomChar);
	}

	public CharSequence generateBooleanValue() {
		// TODO Auto-generated method stub
		Random random = new Random();
		boolean randomBoolean = random.nextBoolean();
		return String.valueOf(randomBoolean);
	}

	public CharSequence generateStringValue() {
		// TODO Auto-generated method stub
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder strBuilder = new StringBuilder();
		for (int i = 0; i < 7; i++) {
			Random random = new Random();
			char tempChar = chars[random.nextInt(chars.length)];
			strBuilder.append(tempChar);
		}
		return strBuilder;
	}

	public CharSequence generateStringBuilderValue() {
		// TODO Auto-generated method stub
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder strBuilder = new StringBuilder();
		for (int i = 0; i < 7; i++) {
			Random random = new Random();
			char tempChar = chars[random.nextInt(chars.length)];
			strBuilder.append(tempChar);
		}
		return strBuilder;
	}

	public static int randBetween(int start, int end) {
		return start + (int) Math.round(Math.random() * (end - start));
	}
}