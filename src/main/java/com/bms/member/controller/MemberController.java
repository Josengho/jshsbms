package com.bms.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bms.member.dto.MemberDto;
import com.bms.member.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	@RequestMapping(value="/login.do" , method = RequestMethod.POST)
	public ModelAndView login(@RequestParam Map<String, String> loginMap, HttpServletRequest request) throws Exception {
			
		ModelAndView mv = new ModelAndView();
		
		// 파라미터로 받아온 맵 타입의 변수를 memberDto에 담음.
		MemberDto memberDto = memberService.login(loginMap);		
		
		// 담아온 memberDto 객체에 null이 담겨있지 않고 탈퇴된 회원이 아니면
		if (memberDto != null && memberDto.getDelYn().equals("N")) { 	
			HttpSession session = request.getSession();		
			session.setAttribute("isLogOn" , true);			
			session.setAttribute("memberInfo" , memberDto);		
			session.setMaxInactiveInterval(60 * 30);	// 세션 유지시간 설정(60초 * 30) = 30분
			mv.setViewName("redirect:/main/main.do");	
		}
		else { 
			// invalidMember를 true로 jsp에 넘김
			mv.addObject("invalidMember", true);
			mv.setViewName("/member/loginForm");
		}
		return mv;
		
	}
	
	
	@RequestMapping(value="/logout.do" , method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		
		session.setAttribute("isLogOn", false);
		session.removeAttribute("memberInfo");
		
		mv.setViewName("redirect:/main/main.do");
		
		return mv;
	
	}
	
	// 회원가입
	// 회원가입을 할 때 중복체크를 하지 않음
	// 아이디를 적지 않고 로그인을 시도하면 500에러가 발생함
	// 아이디가 중복된 상태로 회원가입 버튼을 눌러도 500에러가 발생함
	// 아이디가 중복되지 않은 상태로 중복확인 버튼을 누르지 않고 회원가입 버튼을 눌렀을 때 회원가입이 됨
	// 비밀번호 중복확인 기능이 작동안함
	// 비밀번호를 입력하지 않아도 회원가입이 가능함
	// 회원가입을 할 때 아이디와 비밀번호 외에 다른 정보를 입력하지 않아도 가입이 되는 부분도 고쳐야 함.
	@RequestMapping(value="/addMember.do" , method = RequestMethod.POST)
	public ResponseEntity<String> addMember(MemberDto memberDto , HttpServletRequest request) throws Exception {
		
		// 이메일과 핸드폰의 수신 여부 체크
		if (memberDto.getEmailstsYn() == null)  memberDto.setEmailstsYn("N");
		if (memberDto.getSmsstsYn() == null)    memberDto.setSmsstsYn("N");
		
		// 비밀번호의 암호화
		memberDto.setMemberPw(passwordEncoder.encode(memberDto.getMemberPw()));
		
		memberService.addMember(memberDto);

		
		String message  = "<script>";
			   message += " alert('회원가입되었습니다.');";
			   message += " location.href='" + request.getContextPath() + "/member/loginForm.do';";
			   message += " </script>";
	    
	    HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		return new ResponseEntity<String>(message, responseHeaders, HttpStatus.OK);
		
	}
	
	// 중복 체크
	@RequestMapping(value="/overlapped.do" , method = RequestMethod.POST)
	public ResponseEntity<String> overlapped(@RequestParam("id") String id) throws Exception{
		return new ResponseEntity<String>(memberService.overlapped(id), HttpStatus.OK);
	}
	
	// 로그인 페이지로 이동
	@RequestMapping(value="/loginForm.do" , method = RequestMethod.GET)
	public ModelAndView loginForm() throws Exception {
		return new ModelAndView("/member/loginForm");
	}
	
	// 아이디 찾기 페이지로 이동
	@RequestMapping(value="/findId.do" , method = RequestMethod.GET)
	public ModelAndView findId() throws Exception {
		return new ModelAndView("/member/findId");
	}
	
	// 아이디 찾기 페이지로 이동
	@RequestMapping(value="/findId.do" , method = RequestMethod.POST)
	@ResponseBody
	public Object findId(@RequestBody Map<String, String> findIdMap, HttpServletRequest request) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		// 파라미터로 받아온 맵 타입의 변수를 memberDto에 담음.
		MemberDto memberDto = memberService.findId(findIdMap);	

		// 담아온 memberDto 객체에 null이 담겨있지 않고 탈퇴된 회원이 아니면(이름과 이메일이 일치하면)
		if (memberDto != null && memberDto.getDelYn().equals("N")) { 	
			return memberDto.getMemberId();
		}
		else { 
			return null;
		}
	}
	

	// 회원가입 페이지로 이동
	@RequestMapping(value="/memberForm.do" , method = RequestMethod.GET)
	public ModelAndView memberForm() throws Exception {
		return new ModelAndView("/member/memberForm");
	}

}
