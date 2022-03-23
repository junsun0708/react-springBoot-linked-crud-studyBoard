package com.example.testBoard.testStudy.class6;
/*
참고자료
1. 스프링데이터 JPA
https://sundries-in-myidea.tistory.com/91
2. toast-ui 샘플페이지
https://nhn.github.io/tui.grid/latest/tutorial-example01-basic
3. toast-ui react 버전
https://github.com/nhn/tui.grid/tree/master/packages/toast-ui.react-grid

오류사항
1. Error creating bean with name 'entityManagerFactory' defined in class path resource [org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaConfiguration.class]: Invocation of init method failed; nested exception is org.hibernate.AnnotationException: No identifier specified for entity: com.example.testBoard.sample.userManagement.domain.User
-> usid @Id 추가

2. 2022-02-23 15:54:06.035  WARN 20880 --- [           main] o.h.engine.jdbc.spi.SqlExceptionHelper   : SQL Error: 1048, SQLState: 23000
2022-02-23 15:54:06.036 ERROR 20880 --- [           main] o.h.engine.jdbc.spi.SqlExceptionHelper   : Column 'locked' cannot be null
-> locked, pwfailcnt 값 넣기

3. ce\UserService.java:27: error: incompatible types: Long cannot be converted to String
		return userRepository.findById(ID);
-> userservice @Service 어노테이션 설정을 안했음에도 컴파일 에러는 잡아내는듯? 컴파일 에러 제거후 기동		

4. toast-ui 설치시 에러
E:\workSpaceTest\source\testBoard\src\main\webapp>npm install --save @toast-ui/react-grid
npm ERR! code ERESOLVE
...
npm ERR! this command with --force, or --legacy-peer-deps
npm ERR! to accept an incorrect (and potentially broken) dependency resolution.
-> 종속성 에러 npm install --save --legacy-peer-deps @toast-ui/react-grid 로 설치

구현목표 - class6 (react에 대한 기본 공부를 하였기 때문에 바로 연동으로 들어간것. class9부터 react 기본내용 추가 할 예정. 9부터 하고 6는 추후)
class5까지 정리한 내용으로 mariadb m_user테이블로 스프링 연동

1. mysql 연동
1-0. config,controller, domain, repository, service 패키지 생성
1-1. user생성 - lombok,jpa 설정 추가
@Entity
@Data
@ID

1-2. mysql연동
# Jpa 설정
# true 설정시 JPA 쿼리문 확인 가능 
spring.jpa.show-sql=true
# DDL(create, alter, drop) 정의시 DB의 고유 기능을 사용할 수 있다. 
spring.jpa.hibernate.ddl-auto=update
# JPA의 구현체인 Hibernate가 동작하면서 발생한 SQL의 가독성을 높여준다. 
spring.jpa.properties.hibernate.format_sql=true

# MySQL 설정
# Driver
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
# DB Source URL 
spring.datasource.url=jdbc:mysql://192.168.10.99:3306/dbgen?useSSL=false&useUnicode=true&serverTimezone=Asia/Seoul
# DB username
spring.datasource.username=dbgen
# DB password
spring.datasource.password=dbgen

build.gradle
implementation'mysql:mysql-connector-java'

2. test로 crud해보기
2-1. userRepository -> 스프링데이터jpa
2-2. userServiceTest -> crud테스트
2-3. userService -> 2.2를 바탕으로 생성

3. toast-ui react버전 샘플 붙이기 (vscode로 진행)
3-1. 설치 npm install --save @toast-ui/react-grid
3-2. class6/appp.js 생성

4. sample.userManageMent에다 만든 자바소스 class6로 변경
*/

