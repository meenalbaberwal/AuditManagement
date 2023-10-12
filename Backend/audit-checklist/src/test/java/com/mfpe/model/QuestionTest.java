package com.mfpe.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class QuestionTest {
    @Test
    void testCanEqual() {
        assertFalse((new Question()).canEqual("Other"));
    }

    @Test
    void testCanEqual2() {
        Question question = new Question();

        Question question1 = new Question();
        question1.setQuestion("Question");
        question1.setQuestionId(123);
        question1.setAuditType("Audit Type");
        question1.setResponse("Response");
        assertTrue(question.canEqual(question1));
    }
    

    @Test
    void testConstructor() {
        Question actualQuestion = new Question();
        actualQuestion.setAuditType("Audit Type");
        actualQuestion.setQuestion("Question");
        actualQuestion.setQuestionId(123);
        actualQuestion.setResponse("Response");
        assertEquals("Audit Type", actualQuestion.getAuditType());
        assertEquals("Question", actualQuestion.getQuestion());
        assertEquals(123, actualQuestion.getQuestionId());
        assertEquals("Response", actualQuestion.getResponse());
        assertEquals("Question(questionId=123, question=Question, auditType=Audit Type, response=Response)",
                actualQuestion.toString());
    }

    @Test
    void testConstructor2() {
        Question actualQuestion = new Question(123, "Question", "Audit Type", "Response");
        actualQuestion.setAuditType("Audit Type");
        actualQuestion.setQuestion("Question");
        actualQuestion.setQuestionId(123);
        actualQuestion.setResponse("Response");
        assertEquals("Audit Type", actualQuestion.getAuditType());
        assertEquals("Question", actualQuestion.getQuestion());
        assertEquals(123, actualQuestion.getQuestionId());
        assertEquals("Response", actualQuestion.getResponse());
        assertEquals("Question(questionId=123, question=Question, auditType=Audit Type, response=Response)",
                actualQuestion.toString());
    }

    @Test
    void testEquals() {
        Question question = new Question();
        question.setQuestion("Question");
        question.setQuestionId(123);
        question.setAuditType("Audit Type");
        question.setResponse("Response");
        assertFalse(question.equals(null));
    }

    @Test
    void testEquals2() {
        Question question = new Question();
        question.setQuestion("Question");
        question.setQuestionId(123);
        question.setAuditType("Audit Type");
        question.setResponse("Response");
        assertFalse(question.equals("Different type to Question"));
    }

    @Test
    void testEquals3() {
        Question question = new Question();
        question.setQuestion("Question");
        question.setQuestionId(123);
        question.setAuditType("Audit Type");
        question.setResponse("Response");
        assertTrue(question.equals(question));
        int expectedHashCodeResult = question.hashCode();
        assertEquals(expectedHashCodeResult, question.hashCode());
    }

    @Test
    void testEquals4() {
        Question question = new Question();
        question.setQuestion("Question");
        question.setQuestionId(123);
        question.setAuditType("Audit Type");
        question.setResponse("Response");

        Question question1 = new Question();
        question1.setQuestion("Question");
        question1.setQuestionId(123);
        question1.setAuditType("Audit Type");
        question1.setResponse("Response");
        assertTrue(question.equals(question1));
        int expectedHashCodeResult = question.hashCode();
        assertEquals(expectedHashCodeResult, question1.hashCode());
    }

    @Test
    void testEquals5() {
        Question question = new Question();
        question.setQuestion("Audit Type");
        question.setQuestionId(123);
        question.setAuditType("Audit Type");
        question.setResponse("Response");

        Question question1 = new Question();
        question1.setQuestion("Question");
        question1.setQuestionId(123);
        question1.setAuditType("Audit Type");
        question1.setResponse("Response");
        assertFalse(question.equals(question1));
    }

    @Test
    void testEquals6() {
        Question question = new Question();
        question.setQuestion(null);
        question.setQuestionId(123);
        question.setAuditType("Audit Type");
        question.setResponse("Response");

        Question question1 = new Question();
        question1.setQuestion("Question");
        question1.setQuestionId(123);
        question1.setAuditType("Audit Type");
        question1.setResponse("Response");
        assertFalse(question.equals(question1));
    }

    @Test
    void testEquals7() {
        Question question = new Question();
        question.setQuestion("Question");
        question.setQuestionId(0);
        question.setAuditType("Audit Type");
        question.setResponse("Response");

        Question question1 = new Question();
        question1.setQuestion("Question");
        question1.setQuestionId(123);
        question1.setAuditType("Audit Type");
        question1.setResponse("Response");
        assertFalse(question.equals(question1));
    }

    @Test
    void testEquals8() {
        Question question = new Question();
        question.setQuestion("Question");
        question.setQuestionId(123);
        question.setAuditType("Question");
        question.setResponse("Response");

        Question question1 = new Question();
        question1.setQuestion("Question");
        question1.setQuestionId(123);
        question1.setAuditType("Audit Type");
        question1.setResponse("Response");
        assertFalse(question.equals(question1));
    }

    @Test
    void testEquals9() {
        Question question = new Question();
        question.setQuestion("Question");
        question.setQuestionId(123);
        question.setAuditType(null);
        question.setResponse("Response");

        Question question1 = new Question();
        question1.setQuestion("Question");
        question1.setQuestionId(123);
        question1.setAuditType("Audit Type");
        question1.setResponse("Response");
        assertFalse(question.equals(question1));
    }

    @Test
    void testEquals10() {
        Question question = new Question();
        question.setQuestion("Question");
        question.setQuestionId(123);
        question.setAuditType("Audit Type");
        question.setResponse("Question");

        Question question1 = new Question();
        question1.setQuestion("Question");
        question1.setQuestionId(123);
        question1.setAuditType("Audit Type");
        question1.setResponse("Response");
        assertFalse(question.equals(question1));
    }

    @Test
    void testEquals11() {
        Question question = new Question();
        question.setQuestion("Question");
        question.setQuestionId(123);
        question.setAuditType("Audit Type");
        question.setResponse(null);

        Question question1 = new Question();
        question1.setQuestion("Question");
        question1.setQuestionId(123);
        question1.setAuditType("Audit Type");
        question1.setResponse("Response");
        assertFalse(question.equals(question1));
    }

    @Test
    void testEquals12() {
        Question question = new Question();
        question.setQuestion(null);
        question.setQuestionId(123);
        question.setAuditType("Audit Type");
        question.setResponse("Response");

        Question question1 = new Question();
        question1.setQuestion(null);
        question1.setQuestionId(123);
        question1.setAuditType("Audit Type");
        question1.setResponse("Response");
        assertTrue(question.equals(question1));
        int expectedHashCodeResult = question.hashCode();
        assertEquals(expectedHashCodeResult, question1.hashCode());
    }

    @Test
    void testEquals13() {
        Question question = new Question();
        question.setQuestion("Question");
        question.setQuestionId(123);
        question.setAuditType(null);
        question.setResponse("Response");

        Question question1 = new Question();
        question1.setQuestion("Question");
        question1.setQuestionId(123);
        question1.setAuditType(null);
        question1.setResponse("Response");
        assertTrue(question.equals(question1));
        int expectedHashCodeResult = question.hashCode();
        assertEquals(expectedHashCodeResult, question1.hashCode());
    }

    @Test
    void testEquals14() {
        Question question = new Question();
        question.setQuestion("Question");
        question.setQuestionId(123);
        question.setAuditType("Audit Type");
        question.setResponse(null);

        Question question1 = new Question();
        question1.setQuestion("Question");
        question1.setQuestionId(123);
        question1.setAuditType("Audit Type");
        question1.setResponse(null);
        assertTrue(question.equals(question1));
        int expectedHashCodeResult = question.hashCode();
        assertEquals(expectedHashCodeResult, question1.hashCode());
    }
}

