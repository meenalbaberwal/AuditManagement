package com.mfpe.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AuditBenchmarkTest {
    @Test
    void testConstructor() {
        AuditBenchmark actualAuditBenchmark = new AuditBenchmark();
        actualAuditBenchmark.setAuditType("Audit Type");
        actualAuditBenchmark.setBenchmarkId(123);
        actualAuditBenchmark.setBenchmarkNoAnswers(1);
        assertEquals("Audit Type", actualAuditBenchmark.getAuditType());
        assertEquals(123, actualAuditBenchmark.getBenchmarkId());
        assertEquals(1, actualAuditBenchmark.getBenchmarkNoAnswers());
        assertEquals("AuditBenchmark(benchmarkId=123, auditType=Audit Type, benchmarkNoAnswers=1)",
                actualAuditBenchmark.toString());
    }
}

