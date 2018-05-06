package org.cm.demo.dao;

import org.cm.demo.entity.ChooseQuestion;
import org.cm.demo.service.IChooseQuestionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ChooseQuestionRepositoryTests {
    @Autowired
    private ChooseQuestionRepository chooseQuestionRepository;

    @Autowired
    private IChooseQuestionService chooseQuestionService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test() {
        chooseQuestionRepository.deleteAll();
        chooseQuestionRepository.save(new ChooseQuestion("巴洛克时期的时间区间？", "巴洛克原意指形状不规则的珍珠，是一种艺术形式，由于这种艺术风格的盛行后人称之为巴洛克时期。这个时期出产的音乐作品就称为巴洛克音乐。"));
        chooseQuestionRepository.save(new ChooseQuestion("贝多芬属于以下那个乐派？", "路德维希·凡·贝多芬 （Ludwig van Beethoven） 1770年12月16日—1827年3月26日，享年57岁，德国杰出的音乐家，世界音乐史上最伟大的作曲家之一。他的作品对世界音乐的发展有着非常深远的影响，因此被尊称为“乐圣”和“交响乐之王”。 贝多芬的主要作品以九部交响曲占首要地位。代表作有降E大调第三交响曲《英雄》、c小调第五交响曲《命运》、F大调第六交响曲《田园》、A大调第七交响曲、d小调第九交响曲《合唱》（《欢乐颂》主旋律）、序曲《爱格蒙特》、《莱奥诺拉》、升c小调第十四钢琴奏鸣曲《月光》、F大调第五小提琴奏鸣曲《春天》、F大调第二浪漫曲。 他的9首交响曲对世界音乐发展有着举足轻重的作用，晚期作品则带有浪漫主义色彩。他的《月光》以传说的形式出现在人教版小学语文六年级上册课本上（题目为《26. 月光曲 》 )。 贝多芬在音乐史的地位是极其突出的，他不仅是古典主义风格的集大成者，同时又是浪漫主义风格的开创者。作为音乐大师，贝多芬对艺术歌曲同样予以相当程度的关注，他是德国艺术歌曲创造的先驱，毕生作有钢琴伴奏的艺术歌曲六十多首，他的艺术歌曲以极其丰富的表现手法和形式来展现，表达属于全人类的情感。在艺术歌曲的领域里取得了非凡成就。从1796年开始便已感到听觉日渐衰弱，1813—1817年贝多芬的创作也暂时呈现颓势；1818—1827年贝多芬左耳朵失聪、健康情况恶化，四十六岁的贝多芬听觉已完全丧失。"));

        List<ChooseQuestion> questions = chooseQuestionService.findAll();
        questions.forEach((question) -> {
            ChooseQuestion chooseQuestion = chooseQuestionService.findById(question.getId());
            System.out.println(chooseQuestion);
            Boolean hasKey = redisTemplate.hasKey("questions");
            System.out.println("has key: " + hasKey);
        });
    }
}
