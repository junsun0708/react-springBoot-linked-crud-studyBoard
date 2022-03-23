package com.example.testBoard.testStudy.class1;
/*

참고자료
1. 리액트가 빠른 이유
https://ssungkang.tistory.com/entry/React-React-%EC%8B%9C%EC%9E%91%ED%95%98%EA%B8%B0-create-react-app
2. 스프링부트 기본템플릿
https://start.spring.io
3. 스프링, 리액트 연동
https://kth990303.tistory.com/210
4. 스프링, 리액트 프로젝트 빌드
https://7942yongdae.tistory.com/136

오류사항
1. 엣지 실행안됨
2. com.example.testBoard 아래에 있는 파일만 스프링컨테이너가 가지고 옮
3. build 실패
3-1.
  build file 'E:\workSpaceTest\source\testBoard\build.gradle': 43: Unsupported command argument: "$frontendDir"group=BasePlugin.BUILD_GROUP @ line 43, column 93.
     Dir "$frontendDir" inputs.dir "$frontend
 -> frontend -> webapp , 스크립트 줄바꿈

3-2.
 > startup failed:
  build file 'E:\workSpaceTest\source\testBoard\build.gradle': 71: The current scope already contains a variable of the name webappDir
   @ line 71, column 5.
     def webappDir = "$projectDir/webapp";
     -> 중복 코드 제거
    
     3-3.
 > Task :installReact FAILED

FAILURE: Build failed with an exception.

* What went wrong:
A problem was found with the configuration of task ':installReact' (type 'Exec').
  - Type 'org.gradle.api.tasks.Exec' property '$1' specifies directory 'E:\workSpaceTest\source\testBoard\webapp' which doesn't exist.

    Reason: An input file was expected to be present but it doesn't exist.
    -> def webappDir = "$projectDir/src/main/webapp";    

구현목표
1. 스프링부트 시작
https://start.spring.io
2. 리액트 시작
src/main/webapp 폴더로 만듬
npx create-react-app webapp
3. 폴더구조 구성
src/main
	src/main/java
		com.example.testBoard
			testStudy //테스트폴더는 밖으로 둘려고 했으나 오류가 나서 일단 여기에 생성
	src/main/resources
	src/main/webapp
		src/testBoard //최종소스
		src/testStudy //스터디하며 class폴더로 나눠서 생성할예정
4. react + spring boot 연동
package.json 추가 "proxy": "http://localhost:8080"		
5. react + spring boot 빌드
build.gradle에 아래의 내용추가
def webappDir = "$projectDir/src/main/webapp";

sourceSets{
	main{
		resources{
			srcDirs = ["$projectDir/src/main/resources"]
		}
	}
}

processResources{
	dependsOn "copyReactBuildFiles"
}

task installReact(type:Exec){
	workingDir "$webappDir"
	inputs.dir "$webappDir"
	group = BasePlugin.BUILD_GROUP
	
	if(System.getProperty('os.name').toLowerCase(Locale.ROOT).contains('windows')){
		commandLine "npm.cmd", "audit", "fix"
		commandLine 'npm.cmd', 'install'
	}else{
		commandLine "npm", "audit", "fix"
		commandLine 'npm', 'install'
	}
}

task buildReact(type:Exec){
	dependsOn "installReact"
	workingDir "$webappDir"
	inputs.dir "$webappDir"
	group = BasePlugin.BUILD_GROUP
	
	if(System.getProperty('os.name').toLowerCase(Locale.ROOT).contains('windows')){
		commandLine "npm.cmd", "run-script", "build"
	}else{
		commandLine "npm", "run-script", "build"
	}
}

task copyReactBuildFiles(type:Copy){
	dependsOn "buildReact"
	from "$webappDir/build"
	into "$projectDir/src/main/resources/static"
}

gradlew build
build/libs java -jar testBoard-0.0.1-SNAPSHOT.jar
*/