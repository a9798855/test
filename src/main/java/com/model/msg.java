package com.model;

import java.util.Date;

public class msg {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_msgcontent.id
	 * @mbg.generated  Sun Apr 08 14:01:26 CST 2018
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_msgcontent.time
	 * @mbg.generated  Sun Apr 08 14:01:26 CST 2018
	 */
	private Date time;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_msgcontent.msg
	 * @mbg.generated  Sun Apr 08 14:01:26 CST 2018
	 */
	private String msg;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_msgcontent.id
	 * @return  the value of t_msgcontent.id
	 * @mbg.generated  Sun Apr 08 14:01:26 CST 2018
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_msgcontent.id
	 * @param id  the value for t_msgcontent.id
	 * @mbg.generated  Sun Apr 08 14:01:26 CST 2018
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_msgcontent.time
	 * @return  the value of t_msgcontent.time
	 * @mbg.generated  Sun Apr 08 14:01:26 CST 2018
	 */
	public Date getTime() {
		return time;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_msgcontent.time
	 * @param time  the value for t_msgcontent.time
	 * @mbg.generated  Sun Apr 08 14:01:26 CST 2018
	 */
	public void setTime(Date time) {
		this.time = time;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_msgcontent.msg
	 * @return  the value of t_msgcontent.msg
	 * @mbg.generated  Sun Apr 08 14:01:26 CST 2018
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_msgcontent.msg
	 * @param msg  the value for t_msgcontent.msg
	 * @mbg.generated  Sun Apr 08 14:01:26 CST 2018
	 */
	public void setMsg(String msg) {
		this.msg = msg == null ? null : msg.trim();
	}
}