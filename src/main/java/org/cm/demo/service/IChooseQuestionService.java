package org.cm.demo.service;

import org.cm.demo.entity.ChooseQuestion;

import java.util.List;

public interface IChooseQuestionService {
    List<ChooseQuestion> findAll();

    ChooseQuestion findById(Long id);
}
