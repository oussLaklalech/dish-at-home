package com.neo.dishathome.repository;

import com.neo.dishathome.domain.Dish;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Dish entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {

}
