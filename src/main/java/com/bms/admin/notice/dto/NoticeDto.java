package com.bms.admin.notice.dto;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class NoticeDto {
	
	private int    noticeId;
	private String noticeTitle;
	private String noticeContent;
	private Date   writeTime;
	
	public int getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public Date getWriteTime() {
		return writeTime;
	}
	public void setWriteTime(Date writeDate) {
		this.writeTime = writeDate;
	}
	
	
}
