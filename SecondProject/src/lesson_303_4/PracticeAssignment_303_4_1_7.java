package lesson_303_4;

import java.util.Scanner;

import lesson_303_4.EnumSwitchExample.Cars;

/**
 * Create a program that lets the users input their filing status and income.
 * Display how much tax the user would have to pay according to status and
 * income. - The U.S. federal personal income tax is calculated based on the
 * filing status and taxable income. - There are four filing statuses: Single,
 * Married Filing Jointly, Married Filing Separately, and Head of Household. -
 * The tax rates for 2009 are shown below
 */
public class PracticeAssignment_303_4_1_7 {

	enum FillingStatus {
		SINGLE, MARRIED_FILLNG_JOINTLY, MARRIED_FILLNG_SEPARATLY, HEAD_OF_HOUSEHOLD
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("0) SINGLE");
		System.out.println("1) MARRIED_FILLNG_JOINTLY");
		System.out.println("2) MARRIED_FILLNG_SEPARATLY");
		System.out.println("3) HEAD_OF_HOUSEHOLD");
		System.out.print("Input filing status number: ");
		try {
			FillingStatus c = FillingStatus.values()[scanner.nextInt()];
			System.out.print("\nInput income: ");
			double income = scanner.nextDouble();
			int tax;
			switch (c) {
			case SINGLE:
				System.out.println("FOR SINGLE STATUS TAX IS " + isSingle(income));
				break;
			case MARRIED_FILLNG_JOINTLY:
				System.out.println("FOR  MARRIED FILLNG JOINTLY  STATUS TAX IS " + isMarriedJointly(income));
				break;
			case MARRIED_FILLNG_SEPARATLY:
				System.out.println("FOR  MARRIED FILLNG SEPARATLY  STATUS TAX IS " + isMarriedSeparratly(income));
				break;
			case HEAD_OF_HOUSEHOLD:
				System.out.println("FOR  HEAD OF HOUSEHOLD STATUS TAX IS " + isHeadHousehold(income));
				break;
			default:
				System.out.println("some error");
				break;
			}
			scanner.close();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("wrong status number");
		}

	}

	static int isSingle(double income) {
		int tax;
		if (income >= 0 && income <= 8350)
			return tax = 10;
		else if (income >= 8351 && income <= 33950)
			return tax = 15;
		else if (income >= 33951 && income <= 82250)
			return tax = 25;
		else if (income >= 82251 && income <= 171550)
			return tax = 28;
		else if (income >= 171551 && income <= 372950)
			return tax = 33;
		else
			return tax = 35;
	}

	static int isMarriedJointly(double income) {
		int tax;
		if (income >= 0 && income <= 16700)
			return tax = 10;
		else if (income >= 16701 && income <= 67900)
			return tax = 15;
		else if (income >= 67901 && income <= 137050)
			return tax = 25;
		else if (income >= 137051 && income <= 208850)
			return tax = 28;
		else if (income >= 208851 && income <= 372950)
			return tax = 33;
		else
			return tax = 35;
	}

	static int isMarriedSeparratly(double income) {
		int tax;
		if (income >= 0 && income <= 8350)
			return tax = 10;
		else if (income >= 8351 && income <= 33950)
			return tax = 15;
		else if (income >= 33951 && income <= 68525)
			return tax = 25;
		else if (income >= 68526 && income <= 104425)
			return tax = 28;
		else if (income >= 104426 && income <= 186475)
			return tax = 33;
		else
			return tax = 35;
	}

	static int isHeadHousehold(double income) {
		int tax;
		if (income >= 0 && income <= 11950)
			return tax = 10;
		else if (income >= 11951 && income <= 45500)
			return tax = 15;
		else if (income >= 45501 && income <= 117450)
			return tax = 25;
		else if (income >= 117451 && income <= 190200)
			return tax = 28;
		else if (income >= 190201 && income <= 372950)
			return tax = 33;
		else
			return tax = 35;
	}

}
