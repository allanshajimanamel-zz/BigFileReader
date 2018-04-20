package com.marqeta.converter;

import com.marqeta.model.RecordType;
import com.marqeta.model.SupplmentaryDataRecord;
import com.marqeta.model.TransactionRecord;

public class SupplementaryDataRecordConverter {
	public static TransactionRecord convert (String[] parts) {
		TransactionRecord transactionRecord = new SupplmentaryDataRecord(RecordType.getInstance(parts[0]), parts[1], parts[2], parts[3]);
		return transactionRecord;
	}
}
