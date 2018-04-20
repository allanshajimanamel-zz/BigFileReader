package com.marqeta.model;

public abstract class TransactionRecord {

	private RecordType recordType;
	private String transactionCode;
	private String cardNumber;

	public TransactionRecord(RecordType recordType, String transactionCode, String cardNumber) {
		this.recordType = recordType;
		this.transactionCode = transactionCode;
		this.cardNumber = cardNumber;
	}

	public RecordType getRecordType() {
		return recordType;
	}

	public void setRecordType(RecordType recordType) {
		this.recordType = recordType;
	}

	public String getTransactionCode() {
		return transactionCode;
	}

	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	@Override
	public String toString() {
		return "TransactionRecord [recordType=" + recordType + ", transactionCode=" + transactionCode + ", cardNumber="
				+ cardNumber + "]";
	}

}