package com.java.learn.lock.readwritelock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 代码中，cache使用一个非线程安全的数据结构HashMap作为缓存的实现，并且使用读写锁来保证cache的线程安全。
 * 在执行get/set/clear操作都会先获取锁，执行完相应的逻辑后释放锁。
 *
 * 读写锁要确保写锁的操作对读锁是可见的，假如允许读锁在已被获取的情况下还能获取写锁，
 * 那么正在运行的其他的读线程就无法感知到写线程的操作。所以，只有等待其他的读线程都释放了读锁，
 * 写锁才能被当前线程获取，当然，写锁一旦被获取，其他的读写线程的后续访问都会被阻塞。
 *
 *
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2021/3/4 10:38
 */
public class ReadWriteLockDemo {
    private static final Map<String, Object> CACHE =  new HashMap<>();
    private static final ReadWriteLock READ_WRITE_LOCK = new ReentrantReadWriteLock();

    public static Object get(String key){
        READ_WRITE_LOCK.readLock().lock();
        try {
            return CACHE.get(key);
        }finally {
            READ_WRITE_LOCK.readLock().unlock();
        }
    }

    public static Object put(String key, Object value){
        READ_WRITE_LOCK.writeLock().lock();
        try {
            return CACHE.put(key, value);
        }finally {
            READ_WRITE_LOCK.writeLock().unlock();
        }
    }

    public static void clear(){
        READ_WRITE_LOCK.writeLock().lock();
        try {
            CACHE.clear();
        }finally {
            READ_WRITE_LOCK.writeLock().unlock();
        }
    }

    public static void main(String[] args) {
        CACHE.put("111", "222");
        System.out.println(CACHE.get("111"));
    }
}
