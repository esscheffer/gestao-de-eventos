package com.example.gestaoeventos.mapper;

import com.example.gestaoeventos.dto.EventDTO;
import com.example.gestaoeventos.entity.EventEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EventMapper {
    EventDTO toDto(EventEntity event);
    EventEntity toEntity(EventDTO eventDTO);
}
