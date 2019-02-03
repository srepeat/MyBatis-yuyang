package com.atguigu.mybatis.bean;

public enum EmpsStatus {

	LOGIN(100,"�û���¼"),LOGOUT(200,"�û��˳�"),ROMVER(300,"�û�������");
	
	private Integer code;
	private String message;
	
	private EmpsStatus() {
		// TODO Auto-generated constructor stub
	}
	
	private EmpsStatus(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public static EmpsStatus getEmpStatusByCode(Integer code) {
		switch (code) {
		case 100:
			return EmpsStatus.LOGIN;
		case 200:
			return EmpsStatus.LOGOUT;
		case 300:
			return EmpsStatus.ROMVER;
		default:
			return EmpsStatus.LOGOUT;
		}
		
	}
	
}