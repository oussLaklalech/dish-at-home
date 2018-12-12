package com.neo.dishathome.repository;

import com.neo.dishathome.domain.OrderPreparation;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the OrderPreparation entity.
 */
@SuppressWarnings("unused")
@Repository
public interface OrderPreparationRepository extends JpaRepository<OrderPreparation, Long> {

}
