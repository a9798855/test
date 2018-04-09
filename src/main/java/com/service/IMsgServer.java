package com.service;

import java.util.Date;

import com.model.msg;

public interface IMsgServer {
	
	 public msg getMsgById(int id);
	 public int deleteMsgByid(int id);
	 public int updateMsg(msg msgInfo);
	 public int insertMsg(msg msgInfo);
	 public int insertMsgAndGitID(msg msgInfo);

}
