package com.bms.admin.notice.service;

import java.util.List;

import com.bms.admin.notice.dto.NoticeDto;

public interface NoticeService {

	void addNotice(NoticeDto noticeDTO) throws Exception;

	List<NoticeDto> selectNoticeList() throws Exception;

}
