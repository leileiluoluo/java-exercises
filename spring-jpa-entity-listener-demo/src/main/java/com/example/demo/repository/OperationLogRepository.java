package com.example.demo.repository;

import com.example.demo.model.OperationLog;
import org.springframework.data.repository.CrudRepository;

public interface OperationLogRepository extends CrudRepository<OperationLog, Long> {
}
