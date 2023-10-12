package com.mfpe.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.mfpe.model.AuditType;
import com.mfpe.model.Question;
import com.mfpe.repository.QuestionRepo;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {QuestionServiceImpl.class})
@ExtendWith(SpringExtension.class)
class QuestionServiceImplTest {
    @MockBean
    private QuestionRepo questionRepo;

    @Autowired
    private QuestionServiceImpl questionServiceImpl;

    @Test
    void testGetQuestionsByAuditType() {
        ArrayList<Question> questionList = new ArrayList<>();
        when(this.questionRepo.getQuestionsByAuditType((String) any())).thenReturn(questionList);
        List<Question> actualQuestionsByAuditType = this.questionServiceImpl
                .getQuestionsByAuditType(new AuditType("Audit Type"));
        assertSame(questionList, actualQuestionsByAuditType);
        assertTrue(actualQuestionsByAuditType.isEmpty());
        verify(this.questionRepo).getQuestionsByAuditType((String) any());
    }
}

