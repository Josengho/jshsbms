package com.bms.admin.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bms.admin.notice.dao.NoticeDao;
import com.bms.admin.notice.dto.NoticeDto;

@Service
@Transactional
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	private NoticeDao noticeDao;
	
	@Override
	public void addNotice(NoticeDto noticeDTO) throws Exception{
		noticeDao.insertNewNotice(noticeDTO);
	}
	
	@Override
	public List<NoticeDto> selectNoticeList() throws Exception{
		return noticeDao.noticeList();
	}
	
	@Override
	public NoticeDto selectNoticeOne(int noticeId) throws Exception{
		return noticeDao.selectNotice(noticeId);
	}
	
	@Override
	public void updateNotice(NoticeDto noticeDTO) throws Exception{
		noticeDao.updateNotice(noticeDTO);
	}

	@Override
	public void deleteNotice(int noticeId) throws Exception{
		noticeDao.deleteNotice(noticeId);
	}
}
