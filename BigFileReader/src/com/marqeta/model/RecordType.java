package com.marqeta.model;

public enum RecordType {
	DETAIL_TRANSACTION_RECORD("06"), SUPPLEMENTARY_TRANSACTION_RECORD("07");

	private String code;

	RecordType(String code) {
		this.code = code;
	}

	public static RecordType getInstance(String codeOrName) {
		for (RecordType recordType : values()) {
			if (recordType.getCode().equalsIgnoreCase(codeOrName)
					|| recordType.toString().equalsIgnoreCase(codeOrName)) {
				return recordType;
			}
		}
		throw new IllegalArgumentException("Unsupported Code or Name: " + codeOrName);
	}

	public String getCode() {
		return code;
	}
}
