
### 1. 프로젝트 명: WMP Crawling Project

### 2. 프로젝트 설명 
</br><img src="https://user-images.githubusercontent.com/8253200/106138462-8399d500-61af-11eb-900c-96a6bc1d1b28.jpeg" width="60%">

위의 제시된 조건으로 웹페이지를 Crawling하여 주어진 조건을 기준으로 연산 결과를 반환한다.

a) URL 텍스트 입력란에 입력받은 URL의 웹페이지를 Crawling 한다
* 조건: 모든 문자 입력 가능

b) Type Drop Box로 Crawling 옵션을 선택한다.
* 조건: 1. HTML Tag 제외, 2.Text 전체

c) Crawling한 내용에서 영어와 숫자만 남긴다.

d) 영어와 숫자를 구분하여 오름차순 정렬을 한다.

e) 영어,숫자,영어,숫자..  순으로 교차시켜 정렬한다.

f) UI로 입력받은 '출력묶음단위'를 기준으로 나눗셈 연산을 한다.
* 조건: 출력묶음단위는 0보다 큰 자연수이다.

g) 연산결과를 UI에 몫과 나머지 필드로 구분하여 출력한다.


### 3. 테스트 예시
a) main 화면
</br><img src="https://user-images.githubusercontent.com/8253200/106139952-77167c00-61b1-11eb-8f2b-066f52d2effb.png" width="40%">

b) Reuqest
* URL: https://www.naver.com/
* Type: Remove HTML
* Bundle Unit: 1000
</br><img src="https://user-images.githubusercontent.com/8253200/106140077-9f9e7600-61b1-11eb-85fe-bde3f3156efd.png" width="40%">

c) Request 결과
</br><img src="https://user-images.githubusercontent.com/8253200/106140269-e2604e00-61b1-11eb-905c-a8b5b065c1bc.png" width="40%">

### 4. 예외처리
a) URL Parameter를 입력하지 않았을 경우
</br><img src="https://user-images.githubusercontent.com/8253200/106140472-2ce1ca80-61b2-11eb-833b-c85b6b4c806b.png" width="40%">

b) 유효하지 않은 URL Parameter를 입력했을 경우
</br><img src="https://user-images.githubusercontent.com/8253200/106140721-7a5e3780-61b2-11eb-96e5-4e815c38b7bb.png" width="40%">
</br><img src="https://user-images.githubusercontent.com/8253200/106140872-b0032080-61b2-11eb-9d68-e7b658ad2644.png" width="40%">

c) Bundle Unit을 입력하지 않았을 경우, 유효하지 않은 값을 입력했을 경우
</br><img src="https://user-images.githubusercontent.com/8253200/106140781-91048e80-61b2-11eb-99bc-9be83b4df3bc.png" width="40%">
</br><img src="https://user-images.githubusercontent.com/8253200/106140670-687c9480-61b2-11eb-8e65-72ef1470ce7e.png" width="40%">

d) 기타 HTTP 예외처리
</br><img src="https://user-images.githubusercontent.com/8253200/106140942-c6a97780-61b2-11eb-9bc3-6e8d36dd9764.png" width="40%">

