package henu.exam.util;

import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class CntValueCache {

	private static LoadingCache<String, Object> cache;

	static {
		cache = CacheBuilder.newBuilder().maximumSize(5000)
				.expireAfterWrite(30, TimeUnit.MINUTES)
				.build(new CacheLoader<String, Object>() {
					@Override
					public Object load(String key) throws Exception {
						return get(key);
					}
				});
	}

	private CntValueCache() {
	}

	public static void put(String key, Object value) {
		cache.put(key, value);
	}

	public static void del(String key) {
		cache.invalidate(key);
	}

	public static Object get(String key) {
		try {
			return cache.get(key);
		} catch (Exception e) {
			return null;
		}
	}

	public static void flush() {
		cache.invalidateAll();
	}

}
