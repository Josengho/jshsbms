package com.bms.admin.notice.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bms.admin.notice.dto.NoticeDto;
import com.bms.admin.notice.service.NoticeService;

@Controller
@RequestMapping("/admin/notice")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value="/addNoticeForm.do" , method = RequestMethod.POST)
	public ResponseEntity<String> addNoticeForm(NoticeDto noticeDto , HttpServletRequest request) throws Exception {
		
		// 관리자 페이지에서만 추가 버튼을 만들어 놓을 것이기 때문에 굳이 비밀번호를 넣을 필요가 없음.
		noticeService.addNotice(noticeDto);

		String message  = "<script>";
			   message += " alert('추가 되었습니다.');";
			   message += " location.href='" + request.getContextPath() + "/admin/notice/main.do';";
			   message += " </script>";
	    
	    HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.add("Content-Type", "text/html; charset=utf-8");
	    
	    return new ResponseEntity<String>(message, responseHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(value="/addNoticeForm.do" , method = RequestMethod.GET)
	public String addNoticeForm() throws Exception {
		return "/admin/notice/addNoticeForm";
	}
	

	
	// boardList 만들고 뷰로 보내기
	@RequestMapping(value="/main.do" , method = RequestMethod.GET)
	public String noticeList(Model model) throws Exception {
		
		model.addAttribute("noticeList", noticeService.selectNoticeList());
		
		
		return "/admin/notice/main";
	}
}
