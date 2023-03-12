# 🟣 Jelly
## jelly 브랜치
* https://github.com/mock-rc14/bunjang_server_jelly_rich/tree/jelly
* https://github.com/mock-rc14/bunjang_server_jelly_rich/tree/jelly2
## 2023-03-04 진행상황

* 노션 기획서 작성
* ERD 설계(수정중)
* dev/prod 서브도메인 구축중

## 2023-03-05 진행상황
* ERD 설계 완료
* dev/prod 서브도메인 구축 완료
* API 리스트업

## 2023-03-06 진행상황
* 금일 1차 피드백 진행 from 핀 => erd 피드백은 리치와 동일해서 생략
* 피드백 내용
  * 생산성 관련해서 신경써서 만들어야 할 듯.
  * 채팅방 어떤 api인지 잘 모르겠어서 워딩을 정확하게 하는게 좋을 듯
* 질문 및 답변
  * 이미지 더미데이터 어떻게 해야 하는지?
    * 상품 등록 전에 조회를 한다고 한다면 더미데이터 만들기
    * 상품 등록할때는 s3사용해서 이미지 넣기
  * 카카오 url 질문
    * 카카오의 url을 직접 쓰면 안됨.
    * /users/kakao or /oauth/kakao 이런식으로 받기
- User API - 회원가입 설계중
- User API - 회원탈퇴 설계중
- User API - 로그인 설계중
- User API - 유저조회 설계중

## 2023-03-07 진행상황
* User API => 쿼리가 너무 단순해서 좀 더 수정 해야 할 듯. 어플 화면을 좀 더 분석해야겠다.
  * 마이페이지 조회 구현 완료
  * 특정 상점 조회 구현 완료
  * 회원 가입 구현 완료
  - 회원 탈퇴 구현 완료
  - 로그인 구현 완료
  - 카카오 로그인 및 소셜로그인 유저 조회 구현중...!
- User API 명세서 작성 중
- 다른 API 설계 시작할 예정

## 2023-03-08 진행상황
* User API => 쿼리 수정
  * 마이페이지 조회 쿼리 수정
  * 특정 상점 조회 쿼리 수정
  * 회원 가입 구현 쿼리 수정
  - 회원 탈퇴 구현 쿼리 수정
  * 서버 연결 오류, 쿼리 오류 수정 하느라 시간을 너무 썼다...
  * 깃 버전관리 => 매우 어려움... 계속 충돌 해결하는 중

## 2023-03-09 진행상황
* Chat API
  * 채팅방 목록 조회 구현중
  * 채팅방 내역 조회 구현중
  * 채팅 등록 구현중
  * 채팅 삭제 구현중

## 2023-03-10 진행상황
* Chat API
  * 채팅방 목록 조회 로직 구현 완료 => 쿼리문 수정중
  * 채팅방 내역 조회 로직 구현 완료 => 쿼리문 수정중
  * 채팅 등록 로직 구현 완료 => 쿼리문 수정중
  * 채팅 삭제 로직 구현 완료 => 쿼리문 수정중
  * 포인트 내역 조회 API 구현중
  * API 명세서 수정
  * 기존 User API 코드 refactor

## 2023-03-11 진행상황
* Chat API
  * 채팅방 목록 조회 쿼리문 완료
  * 채팅방 내역 조회 쿼리문 완료
  * 채팅 등록 로직 쿼리문 완료
  * 채팅 삭제 로직 쿼리문 완료
* Point API
  * 포인트 조회 API 구현 완료
  * 포인트 사용 내역 조회 API 구현 완료
* 명세서 작성
  * Chat API, Point API 명세서 작성

## 2023-03-12 진행상황
* 카카오 로그인
  * 카카오 로그인 (로그인 시 회원가입 됨) 구현 완료
  * 로그인 시 기존의 user와 동일하게 회원가입 되도록 구현함.
* JWT 로그인 (비밀번호 x)
  * JWT 로그인 오류 해결 (로그인 안되는 오류 해결)
  * 조건문의 코드를 반대로 작성했었다.... => ㅠㅠ
* 명세서 작성
  * 카카오 로그인 명세서 작성 완료
* 👉🏻 2주차에 진행할 것
  * validation 처리 및 코드 정리 예정

---

# 🟠 Rich
## rich 브랜치
* https://github.com/mock-rc14/bunjang_server_jelly_rich/tree/rich
* https://github.com/mock-rc14/bunjang_server_jelly_rich/tree/rich_2
## 2023-03-04 진행상황

* 노션 기획서 작성
* ERD 설계(수정중)
* EC2 인스턴스 생성
* RDS 인스턴스 생성

## 2023-03-05 진행상황
* ERD 설계 완료
* dev/prod 서브도메인 구축 완료
* API 리스트업

## 2023-03-06 진행상황
* DB Dummy Data 입력 완료
* ERD 보수
* GET product api 개발중
* 금일 1차 피드백 진행 from 핀

* 피드백 내용  
  ✅ 1. 상점에서 평점 빼기 : 평점은 그때그때 리뷰테이블에서 계산해서 가져오는게 더 나음  
  ✅ 2. 찜 상태값 추가 필요 : 데이터에 대한 status 말고 찜 상태에 대한 likeStatus도 필요 → followStatus, favoriteStatus 추가함  
  ✅ 3. 주소는 위도 경도까지 저장 필요  
  ✅ 4. 채팅방에 누구있는지 멤버테이블 따로 빼서 저장  
  ✅ 5. API개발이 느린 편 : 생산성 향상 필요  
  ✅ 6. shop 테이블 삭제됐으니까 uri도 shops를 users로 수정 필요  
  ✅ 7. reviews/detail 삭제 : restful 하지않음  
  ✅ 8. shops/info 삭제 : restful 하지않음
  9. 채팅방 api 필요  
     ✅ 10. Like 따로 follow 따로 → ERD에는 찜이 favorite으로 되어있는데 api 명세서에는 like로 되어있어서 favorite으로 변경  
     ✅ 11. Api 명세서에 누가 개발했는지 내용 추가


## 2023-03-07
* [product] 상품 조회 api 구현, 명세서 작성 완료
* [product] 상품 수정 api 구현, 명세서 작성 완료
* [product] 상품 등록 api 구현, 명세서 작성 완료
* [product] 상품 키워드 검색 구현중
* AWS 인스턴스 서비스가 여러개 일 경우 과금될 수 있다고 하여 prod RDS는 가동 중지 설정
* 


## 2023-03-08
* [product] 상품 키워드 검색 구현 완료
* Product API 구현 완료
* Follow API 구현 완료
* Review API 구현 완료

## 2023-03-09
* [작업 중 DB 접속이 안되는 문제 발생 -> 원인을 알 수가 없어서, 초기 템플릿에 소스코드만 붙여넣는 방식으로 해결
* 그러나 깃 원격저장소와 내용이 달라져서 push 안됨
* 그래서 rich_2 로 브랜치를 새로 팠습니다.]
* Favorite API 구현 완료
* Product 카테고리, 서브카테고리 별 목록 조회 API (홈 화면 용) 추가
* 모든 API 구현 및 회원용 적용 완료
* Product API 형식적 validation 적용 완료 / 의미적 validation 작업중

## 2023-03-10
* 형식적 Validation의 대부분은 클라이언트 단에서 구현하기로 하여 형식적 validation 일부 삭제
* [모든 도메인] 의미적 validation 구현중

## 2023-03-11
* Product Validation 완료!! (눈물)
* Follow, Favorite Validation 완료 / 팔로우 취소 api 오류 (수정 예정)
* Review validation 완료
