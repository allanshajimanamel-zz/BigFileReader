package com.marqeta.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ExecutorUtil {
	public static final ExecutorService FIXED_THREAD_POOL_EXECUTOR = Executors.newFixedThreadPool(2);
	public static final ExecutorService CACHED_THREAD_POOL_EXECUTOR = Executors.newCachedThreadPool();
}
