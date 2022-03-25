package com.bms.admin.notice.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bms.admin.notice.dto.NoticeDto;

@Repository
public class NoticeDaoImpl implements NoticeDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insertNewNotice(NoticeDto noticeDto) throws Exception{
		sqlSession.insert("mapper.admin.notice.insertNewNotice" , noticeDto);
	}
	
	@Override
	public List<NoticeDto> noticeList() throws Exception{
		return sqlSession.selectList("mapper.admin.notice.selectNoticeList");
		
	}
	
	@Override
	public NoticeDto selectNotice(int noticeId) throws Exception{
		return sqlSession.selectOne("mapper.admin.notice.selectNoticeOne" , noticeId);
		
	}

	@Override
	public void updateNotice(NoticeDto noticeDto) throws Exception{
		sqlSession.update("mapper.admin.notice.updateNotice" , noticeDto);
	}
	
	@Override
	public void deleteNotice(int noticeId) throws Exception{
		sqlSession.delete("mapper.admin.notice.deleteNotice" , noticeId);
	}
}
