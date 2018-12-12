package com.neo.dishathome.service.mapper;

import com.neo.dishathome.domain.*;
import com.neo.dishathome.service.dto.CommentDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Comment and its DTO CommentDTO.
 */
@Mapper(componentModel = "spring", uses = {PersonMapper.class, DishMapper.class})
public interface CommentMapper extends EntityMapper<CommentDTO, Comment> {

    @Mapping(source = "person.id", target = "personId")
    @Mapping(source = "dish.id", target = "dishId")
    CommentDTO toDto(Comment comment);

    @Mapping(source = "personId", target = "person")
    @Mapping(source = "dishId", target = "dish")
    Comment toEntity(CommentDTO commentDTO);

    default Comment fromId(Long id) {
        if (id == null) {
            return null;
        }
        Comment comment = new Comment();
        comment.setId(id);
        return comment;
    }
}
