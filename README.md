<details>
<summary>Jelly 파트</summary>
<div markdown="1">

# 🟣 Jelly
### jelly 브랜치
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
  ✅ 1. 상점에서 평점 빼기 : 평점은 그때그때 리뷰테이블에서 계산해서 가져오는게 더 나음  
  ✅ 2. 찜 상태값 추가 필요 : 데이터에 대한 status 말고 찜 상태에 대한 likeStatus도 필요 → followStatus, favoriteStatus 추가함  
  ✅ 3. 주소는 위도 경도까지 저장 필요  
  ✅ 4. 채팅방에 누구있는지 멤버테이블 따로 빼서 저장  
  ✅ 5. API개발이 느린 편 : 생산성 향상 필요  
  ✅ 6. shop 테이블 삭제됐으니까 uri도 shops를 users로 수정 필요  
  ✅ 7. reviews/detail 삭제 : restful 하지않음  
  ✅ 8. shops/info 삭제 : restful 하지않음 <br>
  ✅ 9. 채팅방 api 필요  
  ✅ 10. Like 따로 follow 따로 → ERD에는 찜이 favorite으로 되어있는데 api 명세서에는 like로 되어있어서 favorite으로 변경  
  ✅ 11. Api 명세서에 누가 개발했는지 내용 추가<br>
  ✅ 12. 생산성 관련해서 신경써서 만들어야 할 듯. <br>
  ✅ 13. 채팅방 어떤 api인지 잘 모르겠어서 워딩을 정확하게 하는게 좋을 듯
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

## 2023-03-13 진행상황
### 전달사항
- 3월 17일 금요일 오후 12시까지 라이징 테스트 진행됨. 12시까지 5-10분정도발표 영상 제출
- 클라이언트가 연동하지 못한 api, 본인이 가장 열심히한 api의 쿼리랑 코드를 담기.
- 영상 포스트맨에서 직접 요청을 보내서 응답을 받아오는 것
- 요청을 보내는 서버는 배포 서버! prod 서버!
- 형식적 validation 하기

### 피드백
- 1번 api에서 후기 평점을 보면 int가 아니라 float나 더블로 바꾸기. ⭕️
- 회원용 api인데 헤더에 jwt 명세가 안되어 있음. 명세 하기. ⭕️
- 판매상품에서 최신순 조회, 판매중, 예약중, 판매완료 필터링 다 적용하기.
- 상점 상품 조회 보면 필터링이 되어있는데 최신순⇒ 사진에는 안나와있음. 브랜드, 카테고리, 동네 이것들도 필터링 적용하기
- validation 처리 다하기 ⭕️
- 7번 api 보면 userIdx ⇒ int형으로 변경 ⭕️
- 회원탈퇴 바디값에 들어가는거 명세 안함, 그리고 response에 이거 추가 ⇒ userIdx, deleteReasonContent ⭕️
- 21번 api에서 userIdx1, 2 ⇒ description 자세하게 적기 ⭕️
- updateAt ⇒ timestamp이지만 string임, updateDate → updateAt으로 변경하기 ⭕️
- 22번 api 채팅내역 조회 result→ object 아니고 리스트임. 읽음, 안읽음 표시 추가하기. ⭕️
- 22번 api 채팅내역 조회 result→ object 아니고 리스트임. 읽음, 안읽음 표시 추가하기. ⭕️
- 23번에서 method ⇒ post, 바디값 꼭 명세하기, update ⇒ String ⭕️
- 24번 PathVariable로 chatIDx 옮기기. userIdx1, userIdx2 확실히 명세, result ⇒ string으로 바꾸기 ⭕️
- 더미데이터를 실제 데이터처럼 작성해야됨. ⭕️
- 서버반영 되고 나서 ok ⇒ 하면 안됨. ⭕️
- api에 대한 명세서 퀄리티가 떨어짐. ⇒ 명세서 정확하게 하기. ⭕

## 2023-03-14 진행상황
- 채팅 삭제 시 채팅방, 채팅, 채팅멤버 모두 상태 변경되도록 수정
- API 명세서 수정

## 2023-03-15 진행상황
- 회원탈퇴 응답값 변경
- 회원 마이페이지 논리적 유효성 검사
- 상점 조회 시 논리적 유효성 검사 추가
- 상점 상품 조회 시 논리적 유효성 검사 구현
- 회원가입 시 형식적 유효성 검사 추가

## 2023-03-16 진행상황
- [feat] 회원가입 시 형식적 유효성 검사 추가
- [feat] 상점 소개 편집 시 형식적, 논리적 유효성 검사 처리
- [fix] 마이페이지 상품 조회 시 최신순 정렬되도록 수정
- [fix] 회원가입 시 생년월일 format 변경
- [fix] 채팅시 상대방 상점과 채팅 내역이 보이도록 수정
- [feat] 채팅목록 조회 시 논리적 유효성 검사 추가
- [fix] 회원 탈퇴 코드 정리 및 변경
- [feat] 채팅 내역 조회 시 메세지 읽음 여부 추가
- [feat] 채팅 API 유효성 검사 추가
- [feat] 포인트 조회, 포인트 사용 내역 조회 논리적 유효성 검사 추가

---
</div>
</details>

# 🟠 Rich
## rich 브랜치
* https://github.com/mock-rc14/bunjang_server_jelly_rich/tree/rich
* https://github.com/mock-rc14/bunjang_server_jelly_rich/tree/rich_2

### API 명세서 (스프레드시트)
* https://docs.google.com/spreadsheets/d/17IACgoVHJp02sp9a8zlwbc5Ki6c_NUKmpPFjw3nY6Ys/edit#gid=0

### 프레젠테이션 영상
* https://drive.google.com/file/d/1s9-oimm9b-UDIEJUz-z7yBeb5sBUitMo/view?usp=sharing

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

## 2023-03-12
* 상품 조회 API에 description 누락되어 있어서 추가
* 팔로우 취소 api 오류 수정 완료

## 2023-03-13
* 2차 피드백 from 핀  
 <피드백 내용>
> #### 라이팅 테스트 영상 관련 
>  1. 영상 길이 5~10분
>  2. postman으로 api 기능 시연
>  3. 클라이언트가 엮지 못한 API 위주로 (api 만들었는데 클라이언트에 반영 못한거)
>  4. 신경 많이 쓴 api 코드 / 쿼리문 보여주고 설명
>  5. prod 서버 이용

> #### 명세서 관련
> 1. 회원용 API에 헤더에 JWT 전부 다 누락되어 있음 ✔︎
> 2. 형식적 validation 해야함 ✔︎
> 2. 9번 팔로우 상태, 찜 상태 추가 필요 ✔︎
> 3. 10번 정렬 (좋아요 순 등)
> 4. 10번 팔로우, 찜 상태 추가 필요 ✔︎
> 4. 14번 옵션 추가 ✔︎
> 5. 15번 옵션 추가 ✔︎
> 6. 18번 리뷰 별점 정수인지 실수인지 확인 ︎︎✔︎
> 7. 19번 리뷰 사진 여러개인거 반영해야됨 ✔︎
> 8. 더미데이터 실제 제품처럼 작성해야됨 ︎✔︎
> 9. 전반적으로 명세서 퀄리티 낮음 ✔︎
> → Type 맞는지, 결과 코드 누락 없는지, 파라미터/스트링 구분 정확히! ✔︎ 
> 10. 다 끝낸 이후 카카오페이도 도전해보면 좋음


## 2023-03-14
* validation시 exception 메시지 출력하는 법을 몰라서 RichException 만들어서 출력하고 난리였는데 제대로 된 방법을 깨달음. 다시 수정함.
* 상품 조회 류 api에 '찜 여부' 출력 추가
* 상점 조회 류 api에 '팔로우 여부' 출력 추가
* 상품 관련 api에 옵션(수량, 상태, 교환 가능 여부) 추가
* 리뷰 관련 api에 리뷰이미지 여러장 첨부 가능한 점 반영 (리뷰 작성 시 여러장 첨부 가능, 리뷰 조회 시 리뷰이미지 개수 출력됨)
* 형식적 validation 완료 : int형 필드의 존재 여부 검증 시 Bad Request 뜨는 부분 수정 예정

## 2023-03-15
* 명세서 검토 완료
* ERD 검토 완료
* 노션 대시보드 검토 완료
* postman에 API collection 정리 완료  
* 상품 목록 정렬(최신순, 저가순, 고가순) 구현 완료
* 이미지 사이즈 검증 구현 완료
* int형 필드 검증 구현 완료

## 2023-03-16
* prod 서버 오픈, DB Dummy Data 구축 완료
* prod 서버에서 상품 리스트 불러오기 API 오류 수정

## 2023-03-17
* prod 서버에서 최종 검수
* 제출


