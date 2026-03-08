package com.example.demo.repository;

import com.example.demo.entity.Order;
import com.example.demo.enums.OrderStates;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

    @Query(value = "SELECT state FROM Order WHERE id=:id")
    OrderStates getState(Long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Order SET state=:state, updatedAt=CURRENT_TIMESTAMP WHERE id=:id")
    void updateState(Long id, OrderStates state);

}
