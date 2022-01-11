package com.xiaorui.common.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolUtils {

    /**
     * 上传扫码异步线程池
     */
    public static final ExecutorService UPLOAD_SCAN_THREAD_POOL = new ThreadPoolExecutor(8, 8, 0L, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(), new ThreadFactoryBuilder().setNameFormat("upload_scan_thread_pool-%d").build(), new ThreadPoolExecutor.CallerRunsPolicy());

    /**
     * 给公众号用户添加标签线程池
     */
    public static final ExecutorService ADD_TAGS_THREAD_POOL = new ThreadPoolExecutor(8, 8, 0L, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(), new ThreadFactoryBuilder().setNameFormat("add_tag_thread_pool-%d").build(), new ThreadPoolExecutor.CallerRunsPolicy());

    /**
     * 更新用户手机号异步
     */
    public static final ExecutorService UPDATE_PHONE_THREAD_POOL = new ThreadPoolExecutor(8, 8, 0L, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(), new ThreadFactoryBuilder().setNameFormat("update_phone_thread_pool-%d").build(), new ThreadPoolExecutor.CallerRunsPolicy());

    /**
     * 通用线程池
     */
    public static final ExecutorService GENERAL_THREAD_POOL = new ThreadPoolExecutor(2, 2, 0L, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(10000), new ThreadFactoryBuilder().setNameFormat("general_thread_pool-%d").build(), new ThreadPoolExecutor.CallerRunsPolicy());

    /**
     * 消息发送异步
     */
    public static final ExecutorService SMS_SEND_POOL = new ThreadPoolExecutor(2, 2, 0L, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(), new ThreadFactoryBuilder().setNameFormat("sms_send_thread_pool-%d").build(), new ThreadPoolExecutor.CallerRunsPolicy());

}
