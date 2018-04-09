package com.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.Dao.msgMapper;
import com.model.msg;
import com.service.IMsgServer;

@Service("msgService")  
public class msgServerImpl implements IMsgServer{

	private msgMapper MsgDao;
	@Override
	public msg getMsgById(int id) {
		// TODO 自动生成的方法存根
		return MsgDao.selectByPrimaryKey(id);
	}

	@Override
	public int deleteMsgByid(int id) {
		// TODO 自动生成的方法存根
		return MsgDao.deleteByPrimaryKey(id);
	}

	@Override
	public int updateMsg(msg msgInfo) {
		// TODO 自动生成的方法存根
		return MsgDao.updateByPrimaryKey(msgInfo);
	}

	@Override
	public int insertMsg(msg msgInfo) {
		// TODO 自动生成的方法存根
		return MsgDao.insertSelective(msgInfo);
	}
	
	@Override
	public int insertMsgAndGitID(msg msgInfo) {
		return MsgDao.insertAndGetId(msgInfo);
	}



}
