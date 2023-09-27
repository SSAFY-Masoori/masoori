package com.fintech.masoori.global.rabbitMQ.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fintech.masoori.domain.card.service.CardService;
import com.fintech.masoori.global.rabbitMQ.dto.RealTimeRes;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class RealTimeSubService {

	private final CardService cardService;

	@RabbitListener(queues = "${rabbitmq.sub.realtime}")
	public void subscribeRealTimeQueue(RealTimeRes realTimeRes) {
		/**
		 * 실시간 타로카드 생성 후 생성 타로카드 관련 데이터를 받아서
		 * cardService를 주입 받아서 해당 데이터 삽입
		 */
		log.info("{}", realTimeRes);
	}
}