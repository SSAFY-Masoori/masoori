package com.fintech.masoori.domain.card.service;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fintech.masoori.domain.card.dto.Basic;
import com.fintech.masoori.domain.card.dto.BasicCardRes;
import com.fintech.masoori.domain.card.dto.CardType;
import com.fintech.masoori.domain.card.dto.Challenge;
import com.fintech.masoori.domain.card.dto.ChallengeCardRes;
import com.fintech.masoori.domain.card.dto.UserCardListRes;
import com.fintech.masoori.domain.card.entity.Card;
import com.fintech.masoori.domain.card.repository.CardRepository;
import com.fintech.masoori.domain.user.entity.User;
import com.fintech.masoori.domain.user.exception.UserNotFoundException;
import com.fintech.masoori.domain.user.repository.UserRepository;
import com.fintech.masoori.global.util.CalcDate;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class CardServiceImpl implements CardService {

	private final CardRepository cardRepository;
	private final UserRepository userRepository;

	@Override
	public UserCardListRes selectRangeBasicCard(String email, LocalDateTime start, LocalDateTime end) {
		User user = userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("존재하지 않는 유저입니다."));

		CalcDate.StartEndDate calcDate = CalcDate.calcDate(start, end);

		List<Card> cardList = cardRepository.findRangeCard(user.getId(), CardType.BASIC, calcDate.getStartDate(),
			calcDate.getEndDate());

		List<UserCardListRes.UserCard> userBasicCardList = cardList.stream()
																   .map(
																	   card -> UserCardListRes.UserCard.builder()
																									   .name(
																										   card.getName())
																									   .cardType(
																										   card.getCardType())
																									   .id(card.getId())
																									   .createdDate(
																										   card.getCreatedDate())
																									   .imagePath(
																										   card.getImagePath())
																									   .build())
																   .toList();

		return UserCardListRes.builder().userCardList(userBasicCardList).build();
	}

	@Override
	public BasicCardRes.BasicCard selectBasicCard(String email, long cardId) {
		User user = userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("존재하지 않는 유저입니다."));
		Card card = cardRepository.findCard(user.getId(), CardType.BASIC, cardId);
		return BasicCardRes.BasicCard.builder()
									 .card(new com.fintech.masoori.domain.card.dto.Card(card))
									 .basicList(card.getBasicList().stream().map(Basic::new).toList())
									 .build();
	}

	@Override
	public UserCardListRes selectRangeChallengeCard(String email, LocalDateTime start, LocalDateTime end) {
		User user = userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("존재하지 않는 유저입니다."));

		CalcDate.StartEndDate calcDate = CalcDate.calcDate(start, end);

		List<Card> cardList = cardRepository.findRangeCard(user.getId(), CardType.SPECIAL, calcDate.getStartDate(),
			calcDate.getEndDate());

		List<UserCardListRes.UserCard> userChallengeCardList = cardList.stream()
																	   .map(
																		   card -> UserCardListRes.UserCard.builder()
																										   .name(
																											   card.getName())
																										   .cardType(
																											   card.getCardType())
																										   .id(card.getId())
																										   .createdDate(
																											   card.getCreatedDate())
																										   .imagePath(
																											   card.getImagePath())
																										   .build())
																	   .toList();

		return UserCardListRes.builder().userCardList(userChallengeCardList).build();
	}

	@Override
	public ChallengeCardRes.ChallengeCard selectChallengeCard(String email, long cardId) {
		User user = userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("존재하지 않는 유저입니다."));
		Card card = cardRepository.findCard(user.getId(), CardType.SPECIAL, cardId);
		return ChallengeCardRes.ChallengeCard.builder()
											 .card(new com.fintech.masoori.domain.card.dto.Card(card))
											 .challengeList(
												 card.getChallengeList().stream().map(Challenge::new).toList())
											 .build();
	}

	@Override
	public BasicCardRes.BasicCard selectUserRecentBasicCard(String email, LocalDateTime time) {
		User user = userRepository.findUserByEmail(email);
		LocalDateTime monday = time.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
		LocalDateTime sunday = time.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
		LocalDateTime startDate = LocalDateTime.of(monday.getYear(), monday.getMonth(), monday.getDayOfMonth(), 0, 0, 0);
		LocalDateTime endDate = LocalDateTime.of(sunday.getYear(), sunday.getMonth(), sunday.getDayOfMonth(), 23, 59, 59);
		Card recentCard = cardRepository.findRecentCard(user.getId(), CardType.BASIC, startDate, endDate);
		if(recentCard == null){
			return null;
		}
		return BasicCardRes.BasicCard.builder().card(new com.fintech.masoori.domain.card.dto.Card(recentCard)).build();
	}
}
