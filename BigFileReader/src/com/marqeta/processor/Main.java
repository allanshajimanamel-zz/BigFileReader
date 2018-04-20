package com.marqeta.processor;

import java.io.IOException;

import com.marqeta.util.ExecutorUtil;

public class Main {
	public static void main(String[] args) {
		Processor processor = new Processor(ExecutorUtil.CACHED_THREAD_POOL_EXECUTOR, 100);
		try {
			processor.process("mytest.txt");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
