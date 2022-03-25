package com.bms.admin.notice.dao;

import java.util.List;

import com.bms.admin.notice.dto.NoticeDto;

public interface NoticeDao {

	public void insertNewNotice(NoticeDto noticeDto) throws Exception;
	public List<NoticeDto> noticeList() throws Exception;
	public NoticeDto selectNotice(int noticeId) throws Exception;
	public void updateNotice(NoticeDto noticeDto) throws Exception;
	public void deleteNotice(int noticeId) throws Exception;
	
}
