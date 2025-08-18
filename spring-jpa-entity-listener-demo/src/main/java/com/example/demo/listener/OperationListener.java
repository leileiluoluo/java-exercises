package com.example.demo.listener;

import com.example.demo.model.OperationLog;
import com.example.demo.model.User;
import com.example.demo.repository.OperationLogRepository;
import com.example.demo.util.SpringContextHolder;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;

import java.util.Date;

public class OperationListener {

    @PostPersist
    public void postSave(Object entity) {
        saveOperationLog(entity, "INSERT");
    }

    @PostUpdate
    public void postUpdate(Object entity) {
        saveOperationLog(entity, "UPDATE");
    }

    @PostRemove
    public void postDelete(Object entity) {
        saveOperationLog(entity, "DELETE");
    }

    private void saveOperationLog(Object entity, String operation) {
        String entityName = null;
        Long entityId = null;
        // filtering
        if (entity instanceof User user) {
            entityName = "User";
            entityId = user.getId();
        }

        if (null != entityName && null != entityId) {
            // get repository
            OperationLogRepository repository = SpringContextHolder.getBean(OperationLogRepository.class);

            // save
            OperationLog log = new OperationLog();
            log.setEntity(entityName);
            log.setEntityId(entityId);
            log.setOperation(operation);
            log.setOperatedAt(new Date());
            repository.save(log);
        }
    }

}
