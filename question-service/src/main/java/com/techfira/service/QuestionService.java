package com.techfira.service;

import com.techfira.dto.QuestionDTO;
import com.techfira.entity.Question;
import com.techfira.exception.CustomException;
import com.techfira.mapper.QuestionMapper;
import com.techfira.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import java.util.NoSuchElementException;

@Service
public class QuestionService {


    private final QuestionRepository questionRepository;

    private final QuestionMapper mapper = QuestionMapper.INSTANCE;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public QuestionDTO createQuestion(QuestionDTO questionDTO) {
        Question question = mapper.toEntity(questionDTO);
        question = questionRepository.save(question);
        return mapper.toDTO(question);
    }

    public List<QuestionDTO> getAllQuestions() {
        List<Question> questions = questionRepository.findAll();
        return mapper.toDTOList(questions);
    }

    public QuestionDTO getQuestionById(Long id) {
        return questionRepository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new CustomException("Question not found with id: " + id));
    }

    public QuestionDTO updateQuestion(Long id, QuestionDTO questionDTO) {
        Question existingQuestion = questionRepository.findById(id)
                .orElseThrow(() -> new CustomException("Question not found with id: " + id));

        // Update only non-null fields from DTO
        if (questionDTO.getTitle() != null && !questionDTO.getTitle().isEmpty()) {
            existingQuestion.setTitle(questionDTO.getTitle());
        }
        Question updatedQuestion = questionRepository.save(existingQuestion);
        return mapper.toDTO(updatedQuestion);

    }

    public void deleteQuestion(Long id) {
        if (!questionRepository.existsById(id)) {
            throw new CustomException("Question not found with id: " + id);
        }
        questionRepository.deleteById(id);
    }
}
