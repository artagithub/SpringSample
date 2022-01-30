package ir.dotin.dotinspringdemo.account;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class AuditCurrentUserListener {

    private static Log log = LogFactory.getLog(AuditCurrentUserListener.class);


    @PreUpdate
    @PrePersist
    private void beforeAnyModification(Object auditable){
//
        System.out.println("get current user and set to entity");
        ((Auditable) auditable).setUser(new User());

    }

    @PostLoad
    private void afterFetchOperation(Object auditable){
//log loading

    }
}
