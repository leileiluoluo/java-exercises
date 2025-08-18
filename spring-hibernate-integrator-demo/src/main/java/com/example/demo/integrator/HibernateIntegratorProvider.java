package com.example.demo.integrator;

import com.example.demo.listener.HibernateListener;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.spi.BootstrapContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.integrator.spi.Integrator;
import org.hibernate.jpa.boot.spi.IntegratorProvider;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;

import java.util.List;

public class HibernateIntegratorProvider implements IntegratorProvider {

    @Override
    public List<Integrator> getIntegrators() {
        return List.of(new HibernateIntegrator());
    }

    static class HibernateIntegrator implements Integrator {

        @Override
        public void integrate(Metadata metadata, BootstrapContext bootstrapContext, SessionFactoryImplementor sessionFactory) {
            EventListenerRegistry registry = sessionFactory.getServiceRegistry().getService(EventListenerRegistry.class);
            if (null != registry) {
                registry.appendListeners(EventType.POST_INSERT, new HibernateListener());
                registry.appendListeners(EventType.POST_UPDATE, new HibernateListener());
                registry.appendListeners(EventType.POST_DELETE, new HibernateListener());
            }
        }

        @Override
        public void disintegrate(SessionFactoryImplementor implementor, SessionFactoryServiceRegistry registry) {

        }
    }

}
