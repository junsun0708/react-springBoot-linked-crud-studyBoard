package com.example.testBoard.testStudy.class7;
/*
참고자료
1. 비동기통신 - 아래의 내용을 참고로 axios를 사용하려고 하였으나 toast-ui4.0에서 자체적으로 DataSource라는 개념으로 벡엔드와 통신을 핳수 있다고 함.
https://lily-im.tistory.com/15

2. cors 오류
https://evan-moon.github.io/2020/05/21/about-cors/

3. json만들기
https://hello-bryan.tistory.com/330

4. toast-ui sandbox sample - 그외것도 있음.
https://codesandbox.io/examples/package/@toast-ui/react-grid

오류사항
1. ERROR in ./src/testStudy/class7/test.js 7:0-49
Module not found: Error: Can't resolve 'semantic-ui-react' in 'E:\workSpaceTest\source\testBoard\src\main\webapp\src\testStudy\class7'
resolve 'semantic-ui-react' in 'E:\workSpaceTest\source\testBoard\src\main\webapp\src\testStudy\class7'
-> semantic-ui di 추가

구현목표 
class7 m_user테이블 crud

1. 비동기통신 적용 - toast-ui Datasource활용
https://ui.toast.com/weekly-pick/ko_20190620 

2.  has been blocked by CORS policy: Response to preflight request doesn't pass access control check: No 'Access-Control-Allow-Origin' header is present on the requested resource.
-> app.js의 내용변경
readData: { url: 'http://localhost:8080/user/readData', method: 'GET', initParams: { param: 'param' } } 
readData: { url: '/user/readData', method: 'GET', initParams: { param: 'param' } }
간단히 말해서 같은 출처가 아닌건 막는건데 이미 class2할때 설정을 해줬으므로 앞에url은 필요없음

3. item.js:165 Uncaught TypeError: data.some is not a function
    at Object.createData (item.js:165:1)
    at Object.resetData (dropdown.js:269:1)
 -> 리턴 데이터 형식을 맞춰줌 json   

1-1.usercontroller생성 - userlist , 8080/user/readData 쳐서 데이터 나오는지 확인
1-2. app.js 에서 datasource추가 url변경
1-3.  https://github.com/nhn/tui.grid/blob/master/packages/toast-ui.grid/docs/en/data-source.md
json형식을 일반적인 데이터로 보내면 안됨.
{
  "result": true,
  "data": {
    "contents": [],
    "pagination": {
      "page": 1,
      "totalCount": 100
    }
  }
} 
위의 형식으로 만들기위해 di 추가
implementation group: 'com.google.code.gson', name: 'gson', version: '2.8.5'

controller의 return list 를 string으로 변경하고 리턴방식을 위의 json형식으로 만들어서 리턴

4.연동해서 toast-ui적용 끝났으면 아래의 페이지에서 다양한 기능들 적용해보기 - 단, react버전은 아니라 그대로 사용은 안됨.
https://nhn.github.io/tui.grid/latest/tutorial-example10-data-source

5. semantic-ui 적용해보기
1. class7/app1 및 추가파일들 생성
https://codesandbox.io/examples/package/@toast-ui/react-grid
2. di추가
npm install semantic-ui-react semantic-ui-css

*/

