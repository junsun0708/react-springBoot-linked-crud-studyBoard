package com.example.testBoard.testStudy.class2;

/*

참고자료
1. RestController와 Controller의 차이
https://mangkyu.tistory.com/49

오류사항
1. Circular view path [hello]: would dispatch back to the current handler URL [/hello] again. Check your ViewResolver setup! (Hint: This may be the result of an unspecified view, due to default view name generation.)
ViewResolver 셋팅이 필요 -> 타임리프 미설정 -> 프로젝트 우클릭 리프레시 그레이들
 

구현목표
1. 백엔드 프로트엔드 별개로 개발
2. 스프링 타임리프, devtools
HelloWorldContoroller -> mvc 변경

타임리프 의존성 주입
build.gradle implementation 'org.springframework.boot:spring-boot-starter-thymeleaf' 추가 - 타임리프 템플릿 사용
runtimeOnly('org.springframework.boot:spring-boot-devtools') 추가 - html서버 재시작없이 컴파일
templates/hello.html작성

3. 웹개발방식3가지
3-1. 정적 - staitc폴더에 html생성시 controller없어도 자동적으로 정적페이지 호출
3-2. mvc와 템플릿엔진 - controller 찾아서 화면의 값을 받아서 템플릿엔진이 동적으로 처리해서 화면에 넘겨줌
3-3. api (json구조) - string, 객체 - 문자 그대로 넘겨줌
HelloController.java , hello-static.html, hello-templete.html 추가

*/