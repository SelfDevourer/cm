package org.cm.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class ChooseQuestion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String question;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @OneToOne
    private Answer rightAnswer;

    @OneToMany
    private List<Answer> answers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Answer getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(Answer rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public ChooseQuestion() {
    }

    public ChooseQuestion(String question, String description) {
        this.question = question;
        this.description = description;
    }

    @Override
    public String toString() {
        return "ChooseQuestion{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", description='" + description + '\'' +
                ", rightAnswer=" + rightAnswer +
                ", answers=" + answers +
                '}';
    }
}
