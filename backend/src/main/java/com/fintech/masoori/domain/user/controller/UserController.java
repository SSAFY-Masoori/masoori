package com.fintech.masoori.domain.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fintech.masoori.domain.user.dto.EmailCheckReq;
import com.fintech.masoori.domain.user.dto.InfoRes;
import com.fintech.masoori.domain.user.dto.LoginReq;
import com.fintech.masoori.domain.user.dto.SendEmailReq;
import com.fintech.masoori.domain.user.dto.SendSmsReq;
import com.fintech.masoori.domain.user.dto.SignUpReq;
import com.fintech.masoori.domain.user.dto.SmsCheckReq;
import com.fintech.masoori.domain.user.entity.User;
import com.fintech.masoori.domain.user.service.EmailService;
import com.fintech.masoori.domain.user.service.SmsService;
import com.fintech.masoori.domain.user.service.UserService;
import com.fintech.masoori.global.config.jwt.TokenInfo;
import com.fintech.masoori.global.error.exception.InvalidValueException;
import com.fintech.masoori.global.redis.RedisService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/user")
@Tag(name = "user", description = "회원 API")
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;
	private final EmailService emailService;
	private final RedisService redisService;
	private final SmsService smsService;

	@Operation(summary = "회원가입 시 이메일 인증코드 발송 API")
	@PostMapping("/email/signup")
	public ResponseEntity<?> sendSignupEmailCode(
		@Parameter(description = "회원 이메일", required = true)
		@RequestBody @Validated SendEmailReq sendEmailReq, BindingResult bindingResult) {
		validateRequest(bindingResult);
		userService.sendSignupEmailCode(sendEmailReq.getEmail());
		return ResponseEntity.ok().build();
	}

	@Operation(summary = "비밀번호 재설정 시 이메일 인증코드 발송 API")
	@PostMapping("/email/password")
	public ResponseEntity<?> sendPasswordEmailCode(
		@Parameter(description = "회원 이메일", required = true)
		@RequestBody @Validated SendEmailReq sendEmailReq, BindingResult bindingResult) {
		validateRequest(bindingResult);
		userService.sendPasswordEmailCode(sendEmailReq.getEmail());
		return ResponseEntity.ok().build();
	}

	@Operation(summary = "이메일 인증코드 검증 API")
	@PostMapping("/email/check")
	public ResponseEntity<?> verifyEmailCode(
		@Parameter(description = "회원 이메일, 인증 코드", required = true)
		@RequestBody @Validated EmailCheckReq emailCheckReq, BindingResult bindingResult) {
		validateRequest(bindingResult);
		userService.verifyEmailCode(emailCheckReq);
		return ResponseEntity.ok().build();
	}

	@Operation(summary = "회원가입 API")
	@PostMapping("/signup")
	public ResponseEntity<?> signup(
		@Parameter(description = "이메일, 패스워드", required = true)
		@RequestBody @Validated SignUpReq signUpReq, BindingResult bindingResult) {
		validateRequest(bindingResult);
		userService.signUp(signUpReq);
		return ResponseEntity.ok().build();
	}

	@Operation(summary = "로그인 API")
	@PostMapping("/login")
	public ResponseEntity<?> login(
		@Parameter(description = "이메일, 패스워드", required = true)
		@RequestBody @Validated LoginReq loginReq, BindingResult bindingResult) {
		validateRequest(bindingResult);
		TokenInfo tokenInfo = userService.login(loginReq);
		return ResponseEntity.ok().body(tokenInfo);
	}

	@Operation(summary = "로그아웃 API")
	@PostMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		userService.logout(request, response);
		return "redirect:https://masoori.site/";
	}

	//    @Operation(summary = "휴대폰 인증코드 발송 API")
	//    @PostMapping("/sms")
	//    public ResponseEntity<?> sendSms(
	//            @Parameter(description = "회원")
	//            @RequestBody @Validated SendSmsReq sendSmsReq, BindingResult bindingResult, Authentication authentication) {
	//        validateRequest(bindingResult);
	//        User loginUser = loginUser(authentication);
	//        userService.updateInfoAndSendSms(sendSmsReq, loginUser);
	//        return ResponseEntity.ok().build();
	//    }

	@Operation(summary = "휴대폰 인증코드 발송 API")
	@PostMapping("/sms")
	public ResponseEntity<?> sendSms(
		@Parameter(description = "회원")
		@RequestBody @Validated SendSmsReq sendSmsReq, BindingResult bindingResult) {
		validateRequest(bindingResult);
		User loginUser = userService.findByEmail(sendSmsReq.getEmail()).get();
		userService.updateInfoAndSendSms(sendSmsReq, loginUser);
		return ResponseEntity.ok().build();
	}

	@Operation(summary = "휴대폰 인증코드 검증 API")
	@PostMapping("/sms/check")
	public ResponseEntity<?> verifySmsCode(
		@Parameter(description = "회원 전화번호, 인증 코드", required = true)
		@RequestBody @Validated SmsCheckReq smsCheckReq, BindingResult bindingResult) {
		validateRequest(bindingResult);
		userService.verifySmsCode(smsCheckReq);
		return ResponseEntity.ok().build();
	}

	@Operation(summary = "마이페이지 유저 정보 조회 API")
	@GetMapping("/info")
	public ResponseEntity<?> userInfo(Authentication authentication) {
		InfoRes infoRes = null;
		return ResponseEntity.ok().body(infoRes);
	}

	private void validateRequest(BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			throw new InvalidValueException("Invalid Input Value");
	}

	// 현재 로그인한 유저 정보를 찾아온다.
	public User loginUser(Authentication authentication) {
		return userService.findByEmail(authentication.getPrincipal().toString()).get();
	}

}
