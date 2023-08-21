package com.driver;

import com.driver.BankAccount;

public class CurrentAccount extends BankAccount {
	String tradeLicenseId; // consists of Uppercase English characters only

	public CurrentAccount(String name, double balance, String tradeLicenseId)
			throws Exception {
		// minimum balance is 5000 by default. If balance is less than 5000,
		// throw "Insufficient Balance" exception
		super(name, balance, 5000);
		this.tradeLicenseId = tradeLicenseId;
		if (balance < 5000) {
			throw new Exception("Insufficient Balance");
		}
	}

	public String getTradeLicenseId() {
		return tradeLicenseId;
	}

	public void setTradeLicenseId(String tradeLicenseId) {
		this.tradeLicenseId = tradeLicenseId;
	}

	public void validateLicenseId() throws Exception {
		// A trade license Id is said to be valid if no two consecutive
		// characters are same
		// If the license Id is valid, do nothing
		// If the characters of the license Id can be rearranged to create any
		// valid license Id
		// If it is not possible, throw "Valid License can not be generated"
		// Exception
		if (!isValide(tradeLicenseId)) {
			if (!reArrange(tradeLicenseId)) {
				throw new Exception("Valid License can not be generated");
			}
		}
	}

	private boolean reArrange(String tradeLicenseId2) {
		// TODO Auto-generated method stub
		int[] arr = new int[26];
		for (int i = 0; i < tradeLicenseId2.length(); i++) {
			arr[tradeLicenseId2.charAt(i) - 'A']++;
		}
		int maxCharFreq = maxfreq(arr);
		if (maxCharFreq <= ((tradeLicenseId2.length() + 1) / 2)) {
			this.tradeLicenseId = setLicenceId(tradeLicenseId2, arr);
			return true;
		}
		return false;
	}

	private String setLicenceId(String tradeLicenseId2, int[] arr) {
		// TODO Auto-generated method stub

		return null;
	}

	private int maxfreq(int[] arr) {
		// TODO Auto-generated method stub
		int max = 0;
		for (int i = 0; i < 26; i++) {
			max = Math.max(arr[i], max);
		}
		return max;
	}

	private boolean isValide(String tradeLicenseId2) {
		// TODO Auto-generated method stub
		for (int i = 1; i < tradeLicenseId2.length(); i++) {
			if (tradeLicenseId2.charAt(i) == tradeLicenseId2.charAt(i - 1))
				return false;
		}
		return true;
	}

}
