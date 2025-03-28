package com.techfira.service;

import com.techfira.dto.AnswerDTO;
import com.techfira.entity.Answer;
import com.techfira.exception.CustomException;
import com.techfira.mapper.AnswerMapper;
import com.techfira.repository.AnswerRepository;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {

    private final AnswerRepository answerRepository;

    private final AnswerMapper mapper = AnswerMapper.INSTANCE;

    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public AnswerDTO create(AnswerDTO answerDTO){

        Answer answer = mapper.toEntity(answerDTO);
       Answer savedAnswer = answerRepository.save(answer);
       return mapper.toDTO(savedAnswer);
    }

   public AnswerDTO getAnswerById(long id){
       return mapper.toDTO(answerRepository.findById(id).orElseThrow(
               () -> new CustomException("No such Answer by ID found!")));
    }

   public List<AnswerDTO> getAllAnswers(){
        List<Answer> allAnswers = answerRepository.findAll();
        return mapper.toDTOList(allAnswers);
    }

   public AnswerDTO updateAnswer(long id, AnswerDTO answerDTO){
        Answer existingAnswer = answerRepository.findById(id).orElseThrow(
                () -> new CustomException("No such Answer by ID found!"));
        if (answerDTO.getAnswer() != null && !answerDTO.getAnswer().isEmpty()){
            existingAnswer.setAnswer(answerDTO.getAnswer());
        }
        Answer answer = answerRepository.save(existingAnswer);
        return mapper.toDTO(answer);
    }

   public void deleteAnswer(long id){
        answerRepository.deleteById(id);
    }



}
