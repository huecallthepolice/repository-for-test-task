package com.testproject.rest.Repository;

import com.testproject.rest.Model.ItemSold;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemSoldRepository extends JpaRepository<ItemSold, Long> {
}
