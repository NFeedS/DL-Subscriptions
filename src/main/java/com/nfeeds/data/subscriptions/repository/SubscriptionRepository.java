package com.nfeeds.data.subscriptions.repository;

import com.nfeeds.data.subscriptions.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface SubscriptionRepository extends JpaRepository<Subscription, String> {
    
    List<Subscription> getSubscriptionsByUserId(String user_id);
    
    List<Subscription> getSubscriptionsByTopicId(String topic_id);
}
