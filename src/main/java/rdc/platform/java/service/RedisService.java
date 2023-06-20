package rdc.platform.java.service;

public  interface RedisService {
    /*
     * 存储数据
     * */
    void set(String key, String value);

    /*
     * 获取数据
     * */
    String get(String key);

    /*
    * 超时时间
    * */
    boolean expire(String key, long seconds);

    /*
    *  删除数据
    * */
    void remove(String key);

    /*
    * 自增操作
    *  @param delta 自增步长
    * */
    Long increment(String key, long delta);
}
