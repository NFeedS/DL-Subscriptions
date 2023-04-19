package com.nfeeds.data.subscriptions.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Subscription {

    /** Auto-generated identifier for the subscription. */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    /** Identifier of the user that has subscribed to some topic. */
    @Column(nullable = false)
    private String userId;

    /** The identifier of the topic to which the user has subscribed to. */
    @Column(nullable = false)
    private String topicId;

    /** Endpoint to which the system will send the new messages. */
    private String callback;
}
