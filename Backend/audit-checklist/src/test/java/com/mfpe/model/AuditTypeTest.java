package com.mfpe.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AuditTypeTest {
    @Test
    void testConstructor() {
        AuditType actualAuditType = new AuditType();
        actualAuditType.setAuditType("Audit Type");
        assertEquals("Audit Type", actualAuditType.getAuditType());
        assertEquals("AuditType(auditType=Audit Type)", actualAuditType.toString());
    }
}

