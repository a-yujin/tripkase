<img src="/resourcesReadme/main_original_tripkase.png">

## 프로젝트 소개
- KH정보교육원 종로지원 웹 개발자 양성과정 세미 프로젝트
- 여행카세는 주방장에게 요리를 맡긴다는 의미의 일본어 단어인 오마카세와 여행을 합성한 것으로 여행을 맡긴다는 의미를 담았습니다.
- 코스, 관광지, 맛집, 숙소 등 선별된 여행 정보를 제공하고 직접 관리할 수 있게 하며 사용자 간에 다양한 여행 정보를 주고 받으며 소통할 수 있는 웹 사이트입니다.

## 개발 기간
  ```
설계 <2022월 8월 16일 ~ 2022년 9월 12일>, 구현 <2022년 9월 13일 ~ 2022년 9월 26일>
  ```

## 멤버 및 역할
### 그때그조
- 권령익 : 관리자, 일정, Q&A
- 고종규 : 회원, 코스
- 김미소 : 소통, 숙소
- 양우석 : 보관함, 맛집
- 양유진 : 공지사항, 관광지

## 주요 기능
<h4>사용자</h4>
<ul>
  <li>코스, 관광지, 맛집, 숙소 검색 : 지역 및 사용자의 조건을 받아 컨텐츠를 추천 받습니다.</li>
  <li>보관함 : 추천받은 컨텐츠를 보관함에서 넣고 일정에 추가 할 수 있습니다. </li>
  <li>여행일정 관리 : 보관함에서 일정추가한 컨텐츠들이 하나의 여행일정이 되어 여행일정을 관리 할 수 있습니다.</li>
  <li>내 정보 관리 : 나의 정보를 관리합니다</li>
  <li>Q&A : 관리자에게 문의를 남길 수 있습니다.</li>
  <li>소통 게시판 : 여행을 다녀온 후 후기와 관련된 게시판입니다.</li>
  <li>공지 게시판 : 관리자가 공지사항을 남기는 게시판입니다.</li>
</ul>
<h4>관리자</h4>
<ul>
  <li>회원관리 : 전체회원, 개별회원을 조회하여 정보를 수정/삭제(탈퇴)할 수 있습니다</li>
  <li>공지관리 : 사용자들에게 보여줄 공지를 조회, 등록, 수정, 삭제가 가능합니다.</li>
  <li>신고관리 : 사용자들이 신고한 해당 게시글, 댓글을 삭제 할 수 있습니다.</li> 
  <li>문의관리 : 사용자들이 남긴 문의에 답변을 남길 수 있습니다.</li>
  <li>컨텐츠관리 : 코스, 관광지, 맛집, 숙소의 등록, 수정, 삭제가 가능합니다</li>
</ul>
<hr>

<h3>설계 주안점</h3>
<ul>
  <li>내 정보 수정 시 패스워드 일치 시 수정할 수 있도록 구현</li>
  <li>지역,이름,컨셉등 다양하게 필터링을 받아서 조겅네 맞는 컨텐츰만 제공되도록 구현</li>
  <li>다중파일 등록 구현</li>
  <li>관광지, 맛집, 숙소 3개의 테이블에서 컨텐츠 코드를 통해 1개의 보관함 테이블에 쌓이도록 구현</li>
  <li>소통 게시글, 소통 게시글 댓글, 공지 게시글 댓글 3개의 테이블에서 신고 코드를 통해 1개의 신고 테이블에 쌓이도록 구현</li>
  <li>보관함에 있는 컨텐츠들을 다수의 여행일정에서 원하는 일차에 쌓이도록 쿼리문 작성</li>
  <li>관리자 페이지를 따로 두어 해당 페이지에서 관리자의 기능을 모두 할 수 있도록 구현</li>
</ul>
<hr>

<h3>개발환경</h3>
<ul>
  <li>HTML</li>
  <li>CSS</li>
  <li>JavaScript</li>
  <li>jQuery</li>
  <li>Java</li>
  <li>spring</li>
  <li>Oracle</li>
  <li>mybatis</li>
  <li>apache tomcat</li>
  <li>github</li>
</ul>
<hr>

<h3>여행 탐색</h3>
<h4>코스</h4>
<img src="https://user-images.githubusercontent.com/97438483/194474173-26d422d1-776b-4f75-a523-c275ad11c573.JPG">
<h4>관광지</h4>
<img src="https://user-images.githubusercontent.com/97438483/194474522-7c1e6e84-a1a5-448e-ab6d-af3d670890a3.JPG">
<h4>맛집</h4>
<img src="https://user-images.githubusercontent.com/97438483/194474606-db122d65-2c5d-48c6-803f-7d09c12364c1.JPG">
<h4>숙소</h4>
<img src="https://user-images.githubusercontent.com/97438483/194474610-8c22cd77-19fc-468e-a1cf-4cfb790ba427.JPG">
<hr>

<h3>게시판</h3>
<img src="https://user-images.githubusercontent.com/97438483/194475419-14d7a1fc-48b6-48eb-8e36-3e9a7f1b49f4.JPG">
<img src="https://user-images.githubusercontent.com/97438483/194475425-bfd81b4b-ec06-4a2c-9269-455122579833.JPG">


<h3>마이페이지</h3>
<img src="https://user-images.githubusercontent.com/97438483/194475345-7b6626a0-343c-48df-a73e-d466202ba863.JPG">
<img src="https://user-images.githubusercontent.com/97438483/194475348-d6713810-415f-48a9-8220-e3f7bc1961c0.JPG">
<h4>보관함</h4>
<img src="https://user-images.githubusercontent.com/97438483/194475361-bf28b548-d502-4a4e-b3d0-6ba094379ddc.JPG">
<h4>여행일정</h4>
<img src="https://user-images.githubusercontent.com/97438483/194475367-10f0384a-d0dc-4818-a41c-358a788cadbc.JPG">
<h4>내정보 관리</h4>
<img src="https://user-images.githubusercontent.com/97438483/194476257-d6007d48-ccf4-41b7-8475-8b6109db075b.JPG">
<h4>Q&A</h4>
<img src="https://user-images.githubusercontent.com/97438483/194476269-77f924ec-82b5-43e5-9e34-cc203da0e0b3.JPG">
<hr>

<h3>관리자 페이지</h3>
<img src="https://user-images.githubusercontent.com/97438483/194475680-8ecf224e-b416-436f-8ec1-c706b56e20bc.JPG">
<img src="https://user-images.githubusercontent.com/97438483/194475704-5399e80a-d9e1-41f2-865e-a4c30dd0f340.JPG">
<img src="https://user-images.githubusercontent.com/97438483/194475706-d73aa065-e68f-4b7b-b1fe-23d410ab407b.JPG">
<img src="https://user-images.githubusercontent.com/97438483/194475718-964a6b03-50a9-45fb-bc29-f46f2172cc9f.JPG">
<img src="https://user-images.githubusercontent.com/97438483/194475726-7e5cc4df-ccdf-4d27-acdb-dff498a4da07.JPG">

