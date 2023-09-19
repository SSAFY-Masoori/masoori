package com.fintech.masoori.global.redis;

import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RedisServiceImpl implements RedisService {

	private final RedisTemplate<String, String> redisTemplate;

	@Override
	public void setEmailCode(String email, String code) {
		redisTemplate.opsForValue().set(email, code, 5, TimeUnit.MINUTES);
	}

	@Override
	public String getEmailCode(String email) {
		return redisTemplate.opsForValue().get(email);
	}

	@Override
	public void deleteEmailCode(String email) {
		redisTemplate.delete(email);
	}

	@Override
	public void setSmsCode(String phoneNumber, String code) {
		redisTemplate.opsForValue().set(phoneNumber, code, 5, TimeUnit.MINUTES);
	}

	@Override
	public String getSmsCode(String phoneNumber) {
		return redisTemplate.opsForValue().get(phoneNumber);
	}

	@Override
	public void deleteSmsCode(String phoneNumber) {
		redisTemplate.delete(phoneNumber);
	}

}