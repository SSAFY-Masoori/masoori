package com.fintech.masoori.global.rabbitMQ.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.fintech.masoori.domain.card.service.CardService;
import com.fintech.masoori.domain.user.exception.UserNotFoundException;
import com.fintech.masoori.domain.user.repository.UserRepository;
import com.fintech.masoori.global.rabbitMQ.dto.GeneratedChallengeCard;
import com.fintech.masoori.global.sse.service.NotificationService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChallengeSubService {
	private final CardService cardService;
	private final UserRepository userRepository;
	private final NotificationService notificationService;

	@RabbitListener(queues = "challenge.res")
	public void subscribeChallengeQueue(GeneratedChallengeCard generatedChallengeCard) {
		log.info("생성되어 넘겨받은 챌린지 카드 등록");
		cardService.registerChallengeCard(generatedChallengeCard);
		String email = userRepository.findById(generatedChallengeCard.getUserId())
		                             .orElseThrow(() -> new UserNotFoundException("User is Not Found"))
		                             .getEmail();
		//sse 사용자 알리기.
		notificationService.notify(email, "ChallengeCard is generated");
	}
}