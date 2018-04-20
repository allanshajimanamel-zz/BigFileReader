package com.marqeta.model;

import java.util.Date;

public class DetailTransactionRecord extends TransactionRecord {
	private String merchantCategoryCode;
	private Double transactionAmount;
	private Date OriginalTransactionDate;
	private SupplmentaryDataRecord supplmentaryDataRecord;

	public DetailTransactionRecord(RecordType recordType, String transactionCode, String cardNumber,
			String merchantCategoryCode, Double transactionAmount, Date originalTransactionDate,
			SupplmentaryDataRecord supplmentaryDataRecord) {
		super(recordType, transactionCode, cardNumber);
		this.merchantCategoryCode = merchantCategoryCode;
		this.transactionAmount = transactionAmount;
		this.OriginalTransactionDate = originalTransactionDate;
		this.supplmentaryDataRecord = supplmentaryDataRecord;
	}

	public void setSupplmentaryDataRecord(SupplmentaryDataRecord supplmentaryDataRecord) {
		this.supplmentaryDataRecord = supplmentaryDataRecord;
	}

	public String getMerchantCategoryCode() {
		return merchantCategoryCode;
	}

	public void setMerchantCategoryCode(String merchantCategoryCode) {
		this.merchantCategoryCode = merchantCategoryCode;
	}

	public Double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public Date getOriginalTransactionDate() {
		return OriginalTransactionDate;
	}

	public void setOriginalTransactionDate(Date originalTransactionDate) {
		OriginalTransactionDate = originalTransactionDate;
	}

	public SupplmentaryDataRecord getSupplmentaryDataRecord() {
		return supplmentaryDataRecord;
	}

	@Override
	public String toString() {
		return "DetailTransactionRecord [merchantCategoryCode=" + merchantCategoryCode + ", transactionAmount="
				+ transactionAmount + ", OriginalTransactionDate=" + OriginalTransactionDate
				+ ", supplmentaryDataRecord=" + supplmentaryDataRecord + ", getRecordType()=" + getRecordType()
				+ ", getTransactionCode()=" + getTransactionCode() + ", getCardNumber()=" + getCardNumber() + "]";
	}

}
