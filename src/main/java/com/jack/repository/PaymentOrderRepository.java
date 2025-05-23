package com.jack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jack.model.PaymentOrder;

public interface PaymentOrderRepository extends JpaRepository<PaymentOrder, Long>{
	
	

}
