package com.techfira.mapper;


import com.techfira.dto.AnswerDTO;
import com.techfira.entity.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AnswerMapper {
    AnswerMapper INSTANCE = Mappers.getMapper(AnswerMapper.class);


    AnswerDTO toDTO(Answer answer);
    Answer toEntity(AnswerDTO answerDTO);
    List<AnswerDTO> toDTOList(List<Answer> answers);
}
