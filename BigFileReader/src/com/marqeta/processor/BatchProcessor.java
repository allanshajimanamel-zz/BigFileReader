package com.marqeta.processor;

import java.util.Map;

import com.marqeta.model.TransactionRecord;
import com.marqeta.util.TransactionalProcessor;

public class BatchProcessor implements Runnable {

	private Map<String, TransactionRecord> batch;

	public BatchProcessor(Map<String, TransactionRecord> batch) {
		this.batch = batch;
	}

	@Override
	public void run() {
		for (Map.Entry<String, TransactionRecord> entry : batch.entrySet()) {
			System.out.println("Result of transaction " + entry.getKey() + " is "
					+ TransactionalProcessor.process(entry.getValue()).getResult());
		}
	}

}
