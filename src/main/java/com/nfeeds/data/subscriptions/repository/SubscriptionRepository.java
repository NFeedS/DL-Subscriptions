package com.nfeeds.data.subscriptions.repository;

import com.nfeeds.data.subscriptions.model.Subscription;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * <p> Interface used by Spring Data Rest to create CRUD endpoints over the User table. </p>
 * <p> The base endpoints generated will have the form: </p>
 * <code>
 * <p><i> GET|POST : {basePath}/subscriptions </i></p>
 * <p><i> GET|POST|PUT|DELETE : {basePath}/subscriptions/{id} </i></p>
 * </code>
 * <p>(plus the /profile and OPTIONS endpoint to get the endpoints metadata and options) </p>
 * <p>
 * <p> Additional endpoint will be created based on the query functions of the interface: </p>
 * <code><p><i> GET : {basePath}/subscriptions/search/{specified_path|function_name}?{parameters} </i></p></code>
 * <p>
 * <p> The response of the endpoint will follow HATEOAS specifications. </p>
 */
public interface SubscriptionRepository extends CrudRepository<Subscription, String> {

    /**
     * <p> Search all the subscriptions of a certain user.</p>
     * <code><p><i> GET : {basePath}/subscriptions/search/user?id={user_id} </i></p></code>
     * <p>
     * @param user_id The id of the user of the subscriptions searched.
     * @return The list of subscriptions that belong to the user indicated by user_id.
     */
    @RestResource(path = "user" ,rel = "byUser")
    List<Subscription> findByUserId(@Param("id") String user_id);

    /**
     * <p> Search all the subscriptions to a certain topic.</p>
     * <code><p><i> GET : {basePath}/subscriptions/search/topic?id={topic_id} </i></p></code>
     * <p>
     * @param topic_id The id of the topic of the subscriptions searched.
     * @return The list of subscriptions that have to the topic indicated by topic_id.
     */
    @RestResource(path = "topic", rel = "byTopic")
    List<Subscription> findByTopicId(@Param("id") String topic_id);
}
