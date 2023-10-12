package com.mfpe.model;

import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Test;

public class AuditResponseTest {
    @Test
    public void testConstructor() {
        AuditResponse actualAuditResponse = new AuditResponse();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.systemDefault()).toInstant());
        actualAuditResponse.setCreationDateTime(fromResult);
        assertSame(fromResult, actualAuditResponse.getCreationDateTime());
    }
}

