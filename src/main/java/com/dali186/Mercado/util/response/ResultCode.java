package com.dali186.Mercado.util.response;

public interface ResultCode {
	
	/* common */
	String COMMON_FIND_SUCC = "조회가 완료되었습니다.";
	
	/* member */
	String MEMBER_JOIN_SUCC = "님 회원가입이 완료되었습니다."; 
	String MEMBER_UPD_SUCC = "님 정보 업데이트가 완료되었습니다.";
	String MEMBER_FIND_SUCC = "님 정보 조회가 완료되었습니다."; 
	String MEMBER_DEL_SUCC = "회원정보 삭제가 완료되었습니다.";

	String MEMBER_JOIN_ERR = "이미 가입된 사용자입니다.";
	String MEMBER_FIND_ERR = "해당 사용자 정보가 존재하지 않습니다.";

}
