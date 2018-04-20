package com.marqeta.converter;

import java.text.ParseException;
import java.util.Date;

import com.marqeta.model.DetailTransactionRecord;
import com.marqeta.model.RecordType;
import com.marqeta.model.TransactionRecord;
import com.marqeta.util.ThreadSafeDateFormatter;

public class DetailTransactionRecordConverter {

	public static TransactionRecord convert(String[] parts) throws ParseException {
		Date transDate = new ThreadSafeDateFormatter().convertStringToDate(parts[5]);
		TransactionRecord transactionRecord = new DetailTransactionRecord(RecordType.getInstance(parts[0]),
				parts[1], parts[2], parts[3], getValueForTransactionAmount(parts[4]), transDate, null);
		return transactionRecord;
	}
	
	private static Double getValueForTransactionAmount(String transactionAmt) {
		boolean isNegative = false;
		if(Integer.valueOf(1).equals(Integer.valueOf(transactionAmt.substring(0,1)))) {
			isNegative = true;
		}
		Double main = Double.valueOf(transactionAmt.substring(1, 10));
		Double decimal = Double.valueOf(transactionAmt.substring(10, 12))/100;
		Double amount = main+decimal;
		if(isNegative) {
			amount = 0 - amount;
		}
		System.out.println(amount);
		return amount;
	}
}
