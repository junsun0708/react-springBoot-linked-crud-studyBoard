package com.example.testBoard.testStudy.class3;

/*

참고자료


오류사항
1. Assertions.assertThat 자동완성 안되는 이유
 import org.junit.jupiter.api.Assertions; 삭제하면 됨

구현목표
1. 회원관리 예제 - 백엔드 개발 (단 repo 는 어떤 디비를 사용할지 모름)
domain - Member
repo - MemberRepository
repo - MemoryMemberRepository
service = MemberService

2. 설명
Optional - null이 나올수도 있으면
store.values().stream().filter(member -> member.getName().equals(name)).findAny(); - 람다식 for
ifPresent - 널이 아닌 값이 있으면

3. 디버그
//System.out.println("" + (result == member));
//Assertions.assertThat(member).isEqualTo(result);
//Assertions.assertEquals(member, result);
assertThat(member).isEqualTo(result);

4. Junit테스트 (TDD)
IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

5. 메모리 리포지토리 문제 (먼저 테스트한 메서드 때문에 repo 중복발생) 	        
5-1. repo -> afterEach() 로 클리어
5-2. service -> 마찬가지로  afterEach() 로 클리어 해도되지만 new로 인해 다른 인스턴스임 -> 생성자로 주입받는게 낫다.(DI)
그럴때는 메인클래스에서 주입받게 설계함(컨스트럭터를 만들고 외부에서는 new로 하는게 아니라 그에 맞게 받도록) ->di dependency injection

*/