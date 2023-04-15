package com.nfeeds.data.subscriptions.repository;

import com.nfeeds.data.subscriptions.model.Subscription;
import org.springframework.data.repository.CrudRepository;

public interface SubscriptionRepository extends CrudRepository<Subscription, Integer> {
}
