package com.marqeta.model;

public class SupplmentaryDataRecord extends TransactionRecord {
	private String description;

	public SupplmentaryDataRecord(RecordType recordType, String transactionCode, String cardNumber,
			String description) {
		super(recordType, transactionCode, cardNumber);
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
