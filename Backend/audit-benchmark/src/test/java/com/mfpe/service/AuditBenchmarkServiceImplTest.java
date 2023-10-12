package com.mfpe.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.mfpe.model.AuditBenchmark;
import com.mfpe.repository.AuditBenchmarkRepo;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AuditBenchmarkServiceImpl.class})
@ExtendWith(SpringExtension.class)
class AuditBenchmarkServiceImplTest {
    @MockBean
    private AuditBenchmarkRepo auditBenchmarkRepo;

    @Autowired
    private AuditBenchmarkServiceImpl auditBenchmarkServiceImpl;

    @Test
    void testGetAuditBenchmarkList() {
        ArrayList<AuditBenchmark> auditBenchmarkList = new ArrayList<>();
        when(this.auditBenchmarkRepo.findAll()).thenReturn(auditBenchmarkList);
        List<AuditBenchmark> actualAuditBenchmarkList = this.auditBenchmarkServiceImpl.getAuditBenchmarkList();
        assertSame(auditBenchmarkList, actualAuditBenchmarkList);
        assertTrue(actualAuditBenchmarkList.isEmpty());
        verify(this.auditBenchmarkRepo).findAll();
    }
}

