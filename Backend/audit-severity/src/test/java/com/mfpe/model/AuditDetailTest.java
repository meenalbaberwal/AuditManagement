package com.mfpe.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AuditDetail.class})
@ExtendWith(SpringExtension.class)
public class AuditDetailTest {
    @Autowired
    private AuditDetail auditDetail;

    @Test
    public void testCanEqual() {
        assertFalse(this.auditDetail.canEqual("Other"));
        assertTrue(this.auditDetail.canEqual(this.auditDetail));
    }

    @Test
    public void testConstructor() {
        AuditDetail actualAuditDetail = new AuditDetail();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.systemDefault()).toInstant());
        actualAuditDetail.setAuditDate(fromResult);
        ArrayList<AuditQuestion> auditQuestionList = new ArrayList<AuditQuestion>();
        actualAuditDetail.setAuditQuestions(auditQuestionList);
        actualAuditDetail.setAuditType("Audit Type");
        assertSame(fromResult, actualAuditDetail.getAuditDate());
        assertSame(auditQuestionList, actualAuditDetail.getAuditQuestions());
        assertEquals("Audit Type", actualAuditDetail.getAuditType());
        assertEquals("AuditDetail(auditType=Audit Type, auditDate=Thu Jan 01 00:00:00 IST 1970, auditQuestions=[])",
                actualAuditDetail.toString());
    }

    @Test
    public void testConstructor2() {
        Date auditDate = new Date(1L);
        AuditDetail actualAuditDetail = new AuditDetail("Audit Type", auditDate, new ArrayList<AuditQuestion>());
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.systemDefault()).toInstant());
        actualAuditDetail.setAuditDate(fromResult);
        ArrayList<AuditQuestion> auditQuestionList = new ArrayList<AuditQuestion>();
        actualAuditDetail.setAuditQuestions(auditQuestionList);
        actualAuditDetail.setAuditType("Audit Type");
        assertSame(fromResult, actualAuditDetail.getAuditDate());
        assertSame(auditQuestionList, actualAuditDetail.getAuditQuestions());
        assertEquals("Audit Type", actualAuditDetail.getAuditType());
        assertEquals("AuditDetail(auditType=Audit Type, auditDate=Thu Jan 01 00:00:00 IST 1970, auditQuestions=[])",
                actualAuditDetail.toString());
    }

    @Test
    public void testEquals() {
        assertFalse((new AuditDetail()).equals(null));
        assertFalse((new AuditDetail()).equals("Different type to AuditDetail"));
    }

    @Test
    public void testEquals2() {
        AuditDetail auditDetail = new AuditDetail();
        assertTrue(auditDetail.equals(auditDetail));
        int expectedHashCodeResult = auditDetail.hashCode();
        assertEquals(expectedHashCodeResult, auditDetail.hashCode());
    }

    @Test
    public void testEquals3() {
        AuditDetail auditDetail = new AuditDetail();
        AuditDetail auditDetail1 = new AuditDetail();
        assertTrue(auditDetail.equals(auditDetail1));
        int expectedHashCodeResult = auditDetail.hashCode();
        assertEquals(expectedHashCodeResult, auditDetail1.hashCode());
    }

    @Test
    public void testEquals4() {
        Date auditDate = new Date(1L);
        AuditDetail auditDetail = new AuditDetail("Audit Type", auditDate, new ArrayList<AuditQuestion>());
        assertFalse(auditDetail.equals(new AuditDetail()));
    }

    @Test
    public void testEquals5() {
        AuditDetail auditDetail = new AuditDetail();
        Date auditDate = new Date(1L);
        assertFalse(auditDetail.equals(new AuditDetail("Audit Type", auditDate, new ArrayList<AuditQuestion>())));
    }

    @Test
    public void testEquals6() {
        AuditDetail auditDetail = new AuditDetail();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        auditDetail.setAuditDate(Date.from(atStartOfDayResult.atZone(ZoneId.systemDefault()).toInstant()));
        assertFalse(auditDetail.equals(new AuditDetail()));
    }

    @Test
    public void testEquals7() {
        Date auditDate = new Date(1L);
        AuditDetail auditDetail = new AuditDetail("Audit Type", auditDate, new ArrayList<AuditQuestion>());
        Date auditDate1 = new Date(1L);
        AuditDetail auditDetail1 = new AuditDetail("Audit Type", auditDate1, new ArrayList<AuditQuestion>());

        assertTrue(auditDetail.equals(auditDetail1));
        int expectedHashCodeResult = auditDetail.hashCode();
        assertEquals(expectedHashCodeResult, auditDetail1.hashCode());
    }

    @Test
    public void testEquals8() {
        AuditDetail auditDetail = new AuditDetail();

        AuditDetail auditDetail1 = new AuditDetail();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        auditDetail1.setAuditDate(Date.from(atStartOfDayResult.atZone(ZoneId.systemDefault()).toInstant()));
        assertFalse(auditDetail.equals(auditDetail1));
    }

    @Test
    public void testEquals9() {
        ArrayList<AuditQuestion> auditQuestionList = new ArrayList<AuditQuestion>();
        auditQuestionList.add(new AuditQuestion(123, "Question", "Audit Type", "Response"));
        AuditDetail auditDetail = new AuditDetail("Audit Type", new Date(1L), auditQuestionList);
        Date auditDate = new Date(1L);
        assertFalse(auditDetail.equals(new AuditDetail("Audit Type", auditDate, new ArrayList<AuditQuestion>())));
    }
}

