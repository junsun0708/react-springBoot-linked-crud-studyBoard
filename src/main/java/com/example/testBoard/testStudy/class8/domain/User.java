package com.example.testBoard.testStudy.class8.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "m_user") 
public class User {
	
	@Id
	private String usid; // 01. id - auto increment
	private String name; // 02. name - 사용자명
	private String uspw; // 03. password - 패스워드
	private String dept; // 04. dept - 부서 정보(department)
	private String team; // 05. team - 해당 팀 정보
	private String email; // 06. email - email 정보
	private String role_type; // 07. role_type - 권한 정보
	private String usid_exp_dt; // 08. 사용자 계정 만료일
	private String uspw_chng_dt; // 09. 사용자 암호 변경일
	private String phone_number; // 10. 전화번호
	private String rank_c; // 11. 직급
	private String pos_c; // 12. 직위
	private String duty_c; // 13. 직책
	private int pwfailcnt;
	private String locked;

	private String outAdminUsid; // 외주 현장대리인, (한화손보)상위 사용자 아이디
	private String user_ip; // 신한 로그인아이피
	private String unused; // 신한 30일 미사용체크 컬럼 (default : N, Y면 30일미접속 체크 안함)
	private String otp_use_yn; // 농협 otp 사용여부
	private String user_type; // 입력구분 필드 (A: 자동(인사연동으로 추가시), M: 수동(화면에서 신규추가시,// default))
	private String outAdminCode; // (한화손보)상위 사용자 코드

	private String      proxy_usid;       //대결자ID
	private String      proxy_start_dt;   //대결시작일자
	private String		proxy_end_dt;     //대결종료일자

	//[국민은행] 2018.03.09 : KB자체 부서코드 4자리
	private String gl_cd;
}
