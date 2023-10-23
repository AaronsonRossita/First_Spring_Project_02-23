package com.First_Spring_Project_023.repository.cache;

public interface CacheRepository {

    void createCacheEntity(String key,String value);
    String getCacheEntity(String key);
    void updateCacheEntity(String key, String value);
    void deleteCacheEntity(String key);

    Boolean isCacheEntityExists(String key);

}
