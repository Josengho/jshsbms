package com.bms.admin.notice.dao;

import java.util.List;

import com.bms.admin.notice.dto.NoticeDto;

public interface NoticeDao {

	void insertNewNotice(NoticeDto noticeDto) throws Exception;
	List<NoticeDto> noticeList() throws Exception;
	
}
