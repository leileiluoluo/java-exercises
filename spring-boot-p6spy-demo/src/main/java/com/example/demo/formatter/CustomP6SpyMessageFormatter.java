package com.example.demo.formatter;

import com.p6spy.engine.spy.appender.MessageFormattingStrategy;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class CustomP6SpyMessageFormatter implements MessageFormattingStrategy {

    @Override
    public String formatMessage(int connId, String now, long elapsed, String category, String prepared, String sql, String url) {
        if (StringUtils.isBlank(sql)) {
            return "";
        }

        String caller = Arrays.stream(Thread.currentThread().getStackTrace())
                .filter(e -> e.getClassName().startsWith("com.example.demo"))
                .filter(e -> !e.getClassName().equals(CustomP6SpyMessageFormatter.class.getName()))
                .findFirst()
                .map(e -> String.format("%s#%s:%d", e.getClassName(), e.getMethodName(), e.getLineNumber()))
                .orElse("Unknown");

        String nowFormatted = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
                .format(new Date(Long.parseLong(now)));

        return String.format("%s - [Time elapsed: %d ms] [Caller: %s] [SQL: %s]", nowFormatted, elapsed, caller, sql.trim());
    }

}
