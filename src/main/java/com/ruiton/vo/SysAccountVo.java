package com.ruiton.vo;

/**
 * 系统账号
 */
@SuppressWarnings("serial")
public class SysAccountVo extends BaseVo{
	private Long id;//主见 [id, bigint, 19]
	private String userName;// [userName, varchar, 50]
	private String pwd;//密码 [pwd, varchar, 64]
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the pwd
	 */
	public String getPwd() {
		return pwd;
	}
	/**
	 * @param pwd the pwd to set
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
