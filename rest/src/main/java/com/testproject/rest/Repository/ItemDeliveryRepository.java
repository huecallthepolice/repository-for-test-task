package com.testproject.rest.Repository;

import com.testproject.rest.Model.ItemDelivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDeliveryRepository extends JpaRepository<ItemDelivery, Long> {
}
