package com.neo.dishathome.service.mapper;

import com.neo.dishathome.domain.*;
import com.neo.dishathome.service.dto.DishDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Dish and its DTO DishDTO.
 */
@Mapper(componentModel = "spring", uses = {KitchenMapper.class})
public interface DishMapper extends EntityMapper<DishDTO, Dish> {

    @Mapping(source = "kitchen.id", target = "kitchenId")
    DishDTO toDto(Dish dish);

    @Mapping(source = "kitchenId", target = "kitchen")
    @Mapping(target = "orders", ignore = true)
    @Mapping(target = "comments", ignore = true)
    Dish toEntity(DishDTO dishDTO);

    default Dish fromId(Long id) {
        if (id == null) {
            return null;
        }
        Dish dish = new Dish();
        dish.setId(id);
        return dish;
    }
}
