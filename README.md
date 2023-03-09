<img src="/resourcesReadme/main_original_tripkase.png">

## 프로젝트 소개
- KH정보교육원 종로지원 웹 개발자 양성과정 세미 프로젝트
- 여행카세는 주방장에게 요리를 맡긴다는 의미의 일본어 단어인 오마카세와 여행을 합성한 것으로 여행을 맡긴다는 의미를 담았습니다.
- 코스, 관광지, 맛집, 숙소 등 선별된 여행 정보를 제공하고 직접 관리할 수 있게 하며 사용자 간에 다양한 여행 정보를 주고 받으며 소통할 수 있는 웹 사이트입니다.

## 개발 기간
  ```
설계 <2022.8.16 ~ 2022.9.12>, 구현 <2022.9.13 ~ 2022.9.26>
  ```

## 팀 소개
### 그때그조
- 권령익 : 관리자 페이지, 일정 관리, Q&A
- 고종규 : 회원 관리, 코스
- 김미소 : 소통 게시판, 숙소
- 양우석 : 보관함, 맛집
- 양유진 : 공지사항 게시판, 관광지

## 개발 환경
- Java
- HTML5
- CSS
- JavaScript
- jQuery
- Spring
- Oracle
- MyBatis
- Apache Tomcat
- GitHub

## 주요 기능
### 사용자
- [마이 페이지](#마이페이지)
  - [보관함](#보관함) : 보관된 컨텐츠를 조회하거나 여행 일정에 추가 할 수 있습니다.
  - [여행 일정 관리](#여행일정관리) : 여행 일정을 등록하거나 수정, 삭제할 수 있습니다.
  - [내 정보 관리](#내정보관리) : 회원 정보를 조회하거나 수정할 수 있고 회원탈퇴를 할 수 있습니다.
  - [Q&A](#1대1문의) : 관리자에게 문의를 남기거나 등록된 문의를 조회하고 삭제할 수 있습니다.
- 여행 탐색 : 지역을 포함한 다양한 조건으로 컨텐츠를 선별 조회하고 보관함 또는 일정에 추가할 수 있습니다. 
  - [코스 검색](#코스검색)
  - [관광지 검색](#관광지검색)
  - [맛집 검색](#맛집검색)
  - [숙소 검색](#숙소검색)
- [소통 게시판](#소통게시판) : 사용자가 서로 여행 정보를 공유하는 공간이며 게시글과 댓글을 등록, 삭제할 수 있습니다.
- [공지 게시판](#공지게시판) : 관리자가 등록한 공지 게시물을 조회하고 댓글을 등록할 수 있습니다.

### 관리자
- [관리자 페이지](#관리자페이지)
  - [회원 관리](#회원관리) : 전체회원, 개별회원을 조회하여 정보를 수정/삭제(탈퇴)할 수 있습니다.
  - [공지 관리](#공지관리) : 사용자들에게 보여줄 공지를 조회, 등록, 수정, 삭제가 가능합니다.
  - [신고 관리](#신고관리) : 사용자들이 신고한 해당 게시글, 댓글을 삭제 할 수 있습니다.
  - [문의 관리](#문의관리) : 사용자들이 남긴 문의에 답변을 남길 수 있습니다.
  - [컨텐츠 관리](#컨텐츠관리) : 코스, 관광지, 맛집, 숙소의 등록, 수정, 삭제가 가능합니다.

## 설계 주안점
<ul>
  <li>내 정보 수정 시 패스워드 일치 시 수정할 수 있도록 구현</li>
  <li>지역,이름,컨셉등 다양하게 필터링을 받아서 조겅네 맞는 컨텐츰만 제공되도록 구현</li>
  <li>다중파일 등록 구현</li>
  <li>관광지, 맛집, 숙소 3개의 테이블에서 컨텐츠 코드를 통해 1개의 보관함 테이블에 쌓이도록 구현</li>
  <li>소통 게시글, 소통 게시글 댓글, 공지 게시글 댓글 3개의 테이블에서 신고 코드를 통해 1개의 신고 테이블에 쌓이도록 구현</li>
  <li>보관함에 있는 컨텐츠들을 다수의 여행일정에서 원하는 일차에 쌓이도록 쿼리문 작성</li>
  <li>관리자 페이지를 따로 두어 해당 페이지에서 관리자의 기능을 모두 할 수 있도록 구현</li>
</ul>

<img src="/resourcesReadme/">

## 실행 화면
### 코스검색
<hr>
<img src="/resourcesReadme/list_course_tripkase.png">
<img src="/resourcesReadme/detail_course_tripkase.png">

### 관광지검색
<hr>
<img src="/resourcesReadme/search_attraction_tripkase.png">
<img src="/resourcesReadme/list_attraction_tripkase.png">
<img src="/resourcesReadme/detail_attraction_tripkase.png">

### 맛집검색
<hr>
<img src="/resourcesReadme/search_restaurant_tripkase.png">
<img src="/resourcesReadme/list_restaurant_tripkase.png">
<img src="/resourcesReadme/detail_restaurant_tripkase.png">

### 숙소검색
<hr>
<img src="/resourcesReadme/search_room_tripkase.png">
<img src="/resourcesReadme/list_room_tripkase.png">
<img src="/resourcesReadme/detail_room_tripkase.png">

### 소통게시판
<hr>
<img src="/resourcesReadme/list_community_tripkase.png">
<img src="/resourcesReadme/detail_community_tripkase.png">
<img src="/resourcesReadme/write_community_tripkase.png">

### 공지게시판
<hr>
<img src="/resourcesReadme/list_notice_tripkase.png">
<img src="/resourcesReadme/detail_notice_tripkase.png">

### 마이페이지
<hr>
<img src="/resourcesReadme/mypage_tripkase.png">

### 보관함
<hr>
<img src="/resourcesReadme/mystorage_tripkase.png">

### 여행일정관리
<hr>
<img src="/resourcesReadme/myschedule_tripkase.png">
<img src="/resourcesReadme/detail_schedule_tripkase.png">

### 내정보관리
<hr>
<img src="/resourcesReadme/myinfo_tripkase.png">

### 1대1문의
<hr>
<img src="/resourcesReadme/list_qna_tripkase.png">
<img src="/resourcesReadme/detail_qna_tripkase.png">
<img src="/resourcesReadme/write_qna_tripkase.png">

### 관리자페이지
<hr>
<img src="/resourcesReadme/main_admin_tripkase.png">

### 회원관리
<hr>
<img src="/resourcesReadme/list_member_tripkase.png">
<img src="/resourcesReadme/detail_member_tripkase.png">
<img src="/resourcesReadme/search_member_tripkase.png">

### 공지관리
<hr>
<img src="/resourcesReadme/list_notice_admin_tripkase.png">
<img src="/resourcesReadme/detail_notice_admin_tripkase.png">

### 신고관리
<hr>
<img src="/resourcesReadme/list_report_admin_tripkase.png">

### 문의관리
<hr>
<img src="/resourcesReadme/list_qna_admin_tripkase.png">
<img src="/resourcesReadme/detail_qna_admin_tripkase.png">

### 컨텐츠관리
<hr>
<img src="/resourcesReadme/register_attraction_admin_tripkase.png">
<img src="/resourcesReadme/list_attraction_admin_tripkase.png">
<img src="/resourcesReadme/detail_attraction_admin_tripkase.png">
