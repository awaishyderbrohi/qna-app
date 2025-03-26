package com.techfira.mapper;


import com.techfira.dto.QuestionDTO;
import com.techfira.entity.Question;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface QuestionMapper {
    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);


    QuestionDTO toDTO(Question question);

    Question toEntity(QuestionDTO questionDTO);

    List<QuestionDTO> toDTOList(List<Question> questions);
}

