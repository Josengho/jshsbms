package com.bms.admin.notice.service;

import java.util.List;

import com.bms.admin.notice.dto.NoticeDto;

public interface NoticeService {

	public void addNotice(NoticeDto noticeDTO) throws Exception;

	public List<NoticeDto> selectNoticeList() throws Exception;

	public NoticeDto selectNoticeOne(int noticeId) throws Exception;

	public void updateNotice(NoticeDto noticeDto) throws Exception;

	public void deleteNotice(int noticeId) throws Exception;

}
