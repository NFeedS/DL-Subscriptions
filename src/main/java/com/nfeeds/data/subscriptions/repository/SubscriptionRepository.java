package com.nfeeds.data.subscriptions.repository;

import com.nfeeds.data.subscriptions.model.Subscription;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface SubscriptionRepository extends CrudRepository<Subscription, String> {

    @RestResource(path = "user" ,rel = "byUser")
    List<Subscription> findByUserId(@Param("id") String user_id);

    @RestResource(path = "topic", rel = "byTopic")
    List<Subscription> findByTopicId(@Param("id") String topic_id);
}
