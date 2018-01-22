package gcprework;

import java.util.Scanner;

/**
 *
 *
 * @Zachariah Zatina
 *
 *
 */

public class Deliverable2 {

	public static void main(String args[]) {

		Scanner scnr = new Scanner(System.in);
		String dateFirst;
		String dateSecond;
		char mFirstOne;
		char mFirstTen;
		char mSecondOne;
		char mSecondTen;
		char dFirstOne;
		char dFirstTen;
		char dSecondOne;
		char dSecondTen;
		char yFirstThous;
		char yFirstHund;
		char yFirstTen;
		char yFirstOne;
		char ySecondThous;
		char ySecondHund;
		char ySecondTen;
		char ySecondOne;
		int monthOne;
		int monthTwo;
		int dayOne;
		int dayTwo;
		int yearOne;
		int yearTwo;
		int dayDiff = 0;
		int monthDiff = 0;
		int yearDiff = 0;

		System.out.print("Please enter the first date in MM-DD-YYYY or MM/DD/YYYY format: ");
		dateFirst = scnr.nextLine();
		System.out.print("Please enter the second date in that same format: ");
		dateSecond = scnr.nextLine();

		//To make sure that the two date entered are correct length to reflect the correct format
		if (dateFirst.length() != 10 || dateSecond.length() != 10) {
			System.out.println("The date you entered is not in the correct format please try again");
		} else {

			//Taking the string and making the month of the first date
			mFirstTen = dateFirst.charAt(0);
			mFirstOne = dateFirst.charAt(1);
			monthOne = ((mFirstTen - 48) * 10) + (mFirstOne - 48);

			//Making the day of the first date from input
			dFirstTen = dateFirst.charAt(3);
			dFirstOne = dateFirst.charAt(4);
			dayOne = ((dFirstTen - 48) * 10) + (dFirstOne - 48);

			//making the year of the first date from input
			yFirstThous = dateFirst.charAt(6);
			yFirstHund = dateFirst.charAt(7);
			yFirstTen = dateFirst.charAt(8);
			yFirstOne = dateFirst.charAt(9);
			yearOne = ((yFirstThous - 48) * 1000) + ((yFirstHund - 48) * 100) + ((yFirstTen - 48) * 10)
					+ (yFirstOne - 48);

			//making the month of the second date from input
			mSecondTen = dateSecond.charAt(0);
			mSecondOne = dateSecond.charAt(1);
			monthTwo = ((mSecondTen - 48) * 10) + (mSecondOne - 48);

			//making the day of the second date from input
			dSecondTen = dateSecond.charAt(3);
			dSecondOne = dateSecond.charAt(4);
			dayTwo = ((dSecondTen - 48) * 10) + (dSecondOne - 48);

			//making tbe year of the second date from input
			ySecondThous = dateSecond.charAt(6);
			ySecondHund = dateSecond.charAt(7);
			ySecondTen = dateSecond.charAt(8);
			ySecondOne = dateSecond.charAt(9);
			yearTwo = ((ySecondThous - 48) * 1000) + ((ySecondHund - 48) * 100) + ((ySecondTen - 48) * 10)
					+ (ySecondOne - 48);

			//first part of statement makes sure that no day or month is less than 0
			if (monthOne < 1 || monthTwo < 0 || dayOne < 0 || dayTwo < 0 || monthOne > 12 || monthTwo > 12) {
				System.out.println("One of the two dates is not valid, sorry.");
			} else {
				/*
				 * uses the months with 31 days to A) make sure that the months have less than 31 days
				 * and B) find the difference between days for these months.
				 */
				if (monthOne == 1 || monthOne == 3 || monthOne == 5 || monthOne == 7 || monthOne == 8 || monthOne == 10
						|| monthOne == 12 || monthTwo == 1 || monthTwo == 3 || monthTwo == 5 || monthTwo == 7
						|| monthTwo == 8 || monthTwo == 10 || monthTwo == 12) {
					if (dayOne > 31 || dayTwo > 31) {
						System.out.print("One of the two dates is invalid, sorry");
					} else if (dayOne > dayTwo) {
						dayDiff = (31 - dayOne) + dayTwo;
					} else {
						dayDiff = dayTwo - dayOne;
					}
					//Same as above but for the months with 30 days
				} else if (monthOne == 4 || monthOne == 6 || monthOne == 9 || monthOne == 11 || monthTwo == 4
						|| monthTwo == 6 || monthTwo == 9 || monthTwo == 11) {
					if (dayOne > 30 || dayTwo > 30) {
						System.out.print("One of the two dates is invalid, sorry.");
					} else if (dayOne > dayTwo) {
						dayDiff = (30 - dayOne) + dayTwo;
					} else {
						dayDiff = dayTwo - dayOne;
					}
					//same as above but for February, accounts for whether or not it is a leap year or not.
				} else if (monthOne == 2 && yearTwo % 4 == 0) {
					if (yearTwo % 100 == 0) {
						if (yearTwo % 400 == 0) {
							if (dayOne > dayTwo) {
								dayDiff = (29 - dayOne) + dayTwo;
							} else {
								dayDiff = dayTwo - dayOne;
							}
						} else {
							if (dayOne > dayTwo) {
								dayDiff = (28 - dayOne) + dayTwo;
							} else {
								dayDiff = dayTwo - dayOne;
							}
						}
					} else {
						if (dayOne > dayTwo) {
							dayDiff = (29 - dayOne) + dayTwo;
						} else {
							dayDiff = dayTwo - dayOne;
						}
					}
				} else {
					if (dayOne > dayTwo) {
						dayDiff = (28 - dayOne) + dayTwo;
					} else {
						dayDiff = dayTwo - dayOne;
					}
				}
				
				//this part is to find the difference between months. Part one is for if the months are 1 apart
				if ((monthOne == 12 && monthTwo == 1) || (monthOne + 1 == monthTwo)) {
					monthDiff = 0;
					//month and year difference if the month from the first date is more than the month of the second.
				} else if (monthOne > monthTwo) {
					monthDiff = (11 - monthOne) + monthTwo;
					yearDiff = Math.abs(yearTwo - yearOne - 1);
					//same as the section before but for when the month of the second date is more than the month of the first date.
				} else {
					monthDiff = monthTwo - monthOne;
					yearDiff = yearTwo - yearOne;
				}
				
			}
			//output of the year, month, and day difference between the inputed dates.
			System.out.println("The difference between the two dates is: " + yearDiff + " years, " + monthDiff
					+ " months, and " + dayDiff + " days.");

		}
	}
}