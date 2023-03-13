package com.leileiluoluo.common.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class DateUtilTest {

    @Test
    void testGetCurrentTimeStr() {
        assertNotNull(DateUtil.getCurrentTimeStr());
    }

}
