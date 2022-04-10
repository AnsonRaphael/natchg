package com.nanos.natwest.repository;

import com.nanos.natwest.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QueueRepository extends JpaRepository<TransactionEntity,Long> {
}
