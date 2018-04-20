package com.marqeta.processor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import com.marqeta.converter.TransactionRecordConverter;
import com.marqeta.model.DetailTransactionRecord;
import com.marqeta.model.RecordType;
import com.marqeta.model.SupplmentaryDataRecord;
import com.marqeta.model.TransactionRecord;
import com.marqeta.util.Parser;

public class Processor {

	private final ExecutorService executor;
	private final int             batchSize;
	
	private Map<String, TransactionRecord> batch;

	Processor(ExecutorService executor, int batchSize) {
		this.executor = executor;
		batch = new HashMap<>();
		this.batchSize = batchSize;
	}

	public void process(String fileName) throws IOException, InterruptedException {
		Files.lines(Paths.get(fileName)).map(line -> Parser.parse(line)).map(parts -> {
			try {
				return TransactionRecordConverter.convert(parts);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return null;
		}).forEach(transactionRecord -> {
			try {
				processRecord(transactionRecord);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		});

		if (batch.size() > 0) {
			executeBatch();
		}

		executor.shutdown();
		executor.awaitTermination(1000, TimeUnit.MILLISECONDS);
	}

	private void processRecord(TransactionRecord transactionRecord) throws ParseException {
		System.out.println(transactionRecord);
		if (RecordType.DETAIL_TRANSACTION_RECORD.equals(transactionRecord.getRecordType())) {
			if (batch.size() == batchSize) {
				executeBatch();
			}
			batch.put(transactionRecord.getTransactionCode(), transactionRecord);
		} else {
			DetailTransactionRecord detailTransactionRecord = (DetailTransactionRecord) batch
					.get(transactionRecord.getTransactionCode());
			detailTransactionRecord.setSupplmentaryDataRecord((SupplmentaryDataRecord) transactionRecord);
		}
	}

	private void executeBatch() {
		BatchProcessor batchProcessor = new BatchProcessor(batch);
		executor.execute(batchProcessor);
		batch = new HashMap<>();
	}

}
