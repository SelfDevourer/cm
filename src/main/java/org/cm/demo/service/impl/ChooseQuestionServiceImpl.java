package org.cm.demo.service.impl;

import org.cm.demo.dao.ChooseQuestionRepository;
import org.cm.demo.entity.ChooseQuestion;
import org.cm.demo.service.IChooseQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChooseQuestionServiceImpl implements IChooseQuestionService {
    @Autowired
    private ChooseQuestionRepository chooseQuestionRepository;

    @Override
    public List<ChooseQuestion> findAll() {
        return chooseQuestionRepository.findAll();
    }

    @Override
    @Cacheable("questions")
    public ChooseQuestion findById(Long id) {
        return chooseQuestionRepository.getOne(id);
    }
}
