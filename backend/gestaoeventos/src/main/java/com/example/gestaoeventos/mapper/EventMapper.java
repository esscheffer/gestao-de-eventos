package com.example.gestaoeventos.mapper;

import com.example.gestaoeventos.dto.EventDTO;
import com.example.gestaoeventos.entity.EventEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface EventMapper {
    EventDTO toDto(EventEntity event);
    EventEntity toEntity(EventDTO eventDTO);

    @Mapping(target = "id", ignore = true)
    void updateEventFromDto(EventDTO dto, @MappingTarget EventEntity entity);
}
