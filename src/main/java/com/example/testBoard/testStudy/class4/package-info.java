package com.example.testBoard.testStudy.class4;

/*

참고자료


오류사항


구현목표
화면연결
1. 컴퍼넌트 스캔과 자동의존관계 설정 (스피링빈)
MemberController 생성 후 @Controller @Service @Repository
@Autowired - 생성자에 붙여두면 가령 service 클래스를 가져올때repository를 호출하면 repo객체에서 해당하는 메서드만 가져와 관리해줌

2. 서비스 , 레포지토리 연결
@Service @Repository

3. 스프링빈에 등록하는 2가지 방법
3-1. 컴퍼넌트 스캔과 자동의존관계 설정 -> 편함
	@controller @service @repository
3-2. 환경변수로 등록 (자바코드로) -> 정형화가 되어있지 않은(한패키지가 아니거나), 상황에 따라 변경 가능성이 있을때 
	SpringConfig.java 생성후 등록, 단 controller 등록 안됨
	
4. DI에는 필드주입, setter주입, 생성자 주입 3개 가 있지만 생성자주입만 쓰자

	private final MemberService memberService;
	
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
 
5. 홈화면 호출 - index.html 대신
HomeController.java, home.html 생성

6. 회원가입, 조회, 저장
createMemberForm.html, memberlist.html, memberform.java 생성
*/