package com.marqeta.converter;

import java.text.ParseException;

import com.marqeta.model.RecordType;
import com.marqeta.model.TransactionRecord;

public class TransactionRecordConverter {

	public static TransactionRecord convert(String[] parts) throws ParseException {
		if (RecordType.DETAIL_TRANSACTION_RECORD.equals(RecordType.getInstance(parts[0]))) {
			return DetailTransactionRecordConverter.convert(parts);
		} else {
			return SupplementaryDataRecordConverter.convert(parts);
		}
	}
}
