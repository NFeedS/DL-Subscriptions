package com.nfeeds.data.subscriptions.controller;

import com.nfeeds.data.subscriptions.model.Subscription;
import com.nfeeds.data.subscriptions.repository.SubscriptionRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Log4j2
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/subscriptions")
public class SubscriptionsController {
	
	private final SubscriptionRepository subscriptionRepository;
	
	@PostMapping("/")
	public Subscription newSubscription(@RequestBody Subscription body){
		log.debug(this.getClass().getSimpleName() + " - newSubscription");
		return subscriptionRepository.save(body);
	}
	
	@GetMapping("/{id}")
	public Subscription getSubscription(@PathVariable("id") String sub_id){
		log.debug(this.getClass().getSimpleName() + " - getSubscription");
		return subscriptionRepository.findById(sub_id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Subscription " + sub_id + " not found"));
	}
	
	@GetMapping("/user/{id}")
	public List<Subscription> getSubscriptionByUser(@PathVariable("id") String user_id){
		log.debug(this.getClass().getSimpleName() + " - getSubscriptionByUser");
		return subscriptionRepository.getSubscriptionsByUserId(user_id);
	}
	
	@GetMapping("/topic/{id}")
	public List<Subscription> getSubscriptionByTopic(@PathVariable("id") String topic_id){
		log.debug(this.getClass().getSimpleName() + " - getSubscriptionByTopic");
		return subscriptionRepository.getSubscriptionsByTopicId(topic_id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteSubscription(@PathVariable("id") String sub_id){
		log.debug(this.getClass().getSimpleName() + " - deleteSubscription");
		subscriptionRepository.deleteById(sub_id);
	}
}
