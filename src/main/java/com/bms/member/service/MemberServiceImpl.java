package com.bms.member.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bms.member.dao.MemberDao;
import com.bms.member.dto.MemberDto;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	@Override
	public MemberDto login(Map<String,String> loginMap) throws Exception{
		
		MemberDto memberDto = memberDao.login(loginMap);

		if (memberDto != null) {
			
			// 사용자가 작성한 암호와 등록된 암호를 비교해서 같으면 memberDto를, 같지 않으면 null로 리턴한다.
			if (passwordEncoder.matches(loginMap.get("memberPw") , memberDto.getMemberPw())) {
				return memberDto;
			}
		}
		
		return null;
		
	}
	
	
	@Override
	public void addMember(MemberDto memberDTO) throws Exception{
		memberDao.insertNewMember(memberDTO);
	}
	
	
	@Override
	public String overlapped(String id) throws Exception{
		return memberDao.selectOverlappedID(id);
	}


	@Override
	public MemberDto findId(Map<String, String> findIdMap) throws Exception {
		
		MemberDto memberDto = memberDao.findId(findIdMap);

		return memberDto;

	}
	
}
