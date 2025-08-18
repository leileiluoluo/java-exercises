package com.example.demo.listener;

import com.example.demo.model.OperationLog;
import com.example.demo.model.User;
import com.example.demo.repository.OperationLogRepository;
import com.example.demo.util.SpringContextHolder;
import org.hibernate.event.spi.*;
import org.hibernate.persister.entity.EntityPersister;

import java.util.Date;

public class HibernateListener implements PostInsertEventListener, PostUpdateEventListener, PostDeleteEventListener {

    @Override
    public void onPostInsert(PostInsertEvent event) {
        Object entity = event.getEntity();
        Object entityId = event.getId();

        saveOperationLog(entity, entityId, "INSERT");
    }

    @Override
    public void onPostUpdate(PostUpdateEvent event) {
        Object entity = event.getEntity();
        Object entityId = event.getId();

        saveOperationLog(entity, entityId, "UPDATE");
    }

    @Override
    public void onPostDelete(PostDeleteEvent event) {
        Object entity = event.getEntity();
        Object entityId = event.getId();

        saveOperationLog(entity, entityId, "DELETE");
    }

    @Override
    public boolean requiresPostCommitHandling(EntityPersister entityPersister) {
        return false;
    }

    private void saveOperationLog(Object entity, Object entityId, String operation) {
        String entityName = null;
        // filtering
        if (entity instanceof User) {
            entityName = "User";
        }

        if (null != entityName) {
            Long entityIdLong = (Long) entityId;

            // get repository
            OperationLogRepository repository = SpringContextHolder.getBean(OperationLogRepository.class);

            // save
            OperationLog log = new OperationLog();
            log.setEntity(entityName);
            log.setEntityId(entityIdLong);
            log.setOperation(operation);
            log.setOperatedAt(new Date());
            repository.save(log);
        }
    }

}
