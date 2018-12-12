package com.neo.dishathome.service.mapper;

import com.neo.dishathome.domain.*;
import com.neo.dishathome.service.dto.OrderPreparationDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity OrderPreparation and its DTO OrderPreparationDTO.
 */
@Mapper(componentModel = "spring", uses = {PersonMapper.class, DishMapper.class})
public interface OrderPreparationMapper extends EntityMapper<OrderPreparationDTO, OrderPreparation> {

    @Mapping(source = "person.id", target = "personId")
    @Mapping(source = "dish.id", target = "dishId")
    OrderPreparationDTO toDto(OrderPreparation orderPreparation);

    @Mapping(source = "personId", target = "person")
    @Mapping(target = "states", ignore = true)
    @Mapping(source = "dishId", target = "dish")
    OrderPreparation toEntity(OrderPreparationDTO orderPreparationDTO);

    default OrderPreparation fromId(Long id) {
        if (id == null) {
            return null;
        }
        OrderPreparation orderPreparation = new OrderPreparation();
        orderPreparation.setId(id);
        return orderPreparation;
    }
}
