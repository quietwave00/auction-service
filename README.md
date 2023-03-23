# Auction-service
팀프로젝트 MZTALK 중 개인 서비스 auction-service의 소스 코드입니다.


## 1. 게시글 작성
<img width="800" alt="writeView" src="https://user-images.githubusercontent.com/51073778/227137074-475d54c0-1715-4e3b-ae72-6dcf938acaf9.png">

클라이언트는 게시글의 제목, 내용을 작성할 수 있고 카카오 API를 이용하여 책 제목을 검색하면 판매하는 책을 설정할 수 있게 하였습니다.<br>
다건의 이미지 첨부가 가능하며, 입찰을 받을 시작가, 경매가 진행되는 시간을 설정할 수 있습니다.

## 2. 게시글 수정
<img width="800" alt="image" src="https://user-images.githubusercontent.com/51073778/227138371-0ebd68a5-c207-482e-98ed-91c3059cd8bc.png">

게시글의 제목, 내용, 책, 첨부된 파일을 수정할 수 있고 시작가 탭에선<br>
'지금 마감시킬까요?'라는 문구를 누르면 작성자가 바로 마감시킬 수 있는 기능을 추가하였습니다.

## 3. 게시글 상세 내용
<img width="439" alt="detailView" src="https://user-images.githubusercontent.com/51073778/227137899-09d1e20f-a08d-480a-8650-d621e715668e.png">

글쓴이가 첨부한 이미지를 슬라이드를 통해 보여줍니다. 글 작성 당시 설정한 책의 키값을 통해 책의 상세 내용을 조회할 수 있도록 하였습니다.<br>
우측 하단의 버튼은 경매 상태에 따라 입찰하기, 거래 완료, 입찰자와 채팅 등의 기능을 수행합니다.

## 4. 입찰
<img width="505" alt="modalBtn" src="https://user-images.githubusercontent.com/51073778/227141384-bd8917a0-6773-4cc4-861d-77f219a27c47.png">
<img width="339" alt="chartView" src="https://user-images.githubusercontent.com/51073778/227141428-c491a35e-cd83-494c-87cc-fa138133b19f.png">

입찰하기 버튼을 누르면 모달창을 통해 금액을 입력하여 입찰을 진행할 수 있게 하였고,<br>
입찰 현황 보기를 통해 다수의 사용자가 입찰한 내역을 그래프로 조회할 수 있게 하였습니다.

## 5. 댓글
<img width="509" alt="comment" src="https://user-images.githubusercontent.com/51073778/227142233-43caef70-08c3-423b-ad35-b87c8919fb9f.png">

게시글 상세 페이지에서 댓글을 작성할 수 있습니다. 게시글의 수정 삭제 또한 가능합니다.

## 6. 메인 뷰
<img width="558" alt="mainView" src="https://user-images.githubusercontent.com/51073778/227142483-675d75cd-bb61-4f79-8d37-8e3f184c4cf8.png">

전체적인 메인의 모습입니다. 게시글은 무한 스크롤로 페이징을 구현했습니다.<br>
검색창을 이용하여 게시글 검색이 가능하고, 우측 상단의 토글 버튼을 이용하여 경매가 끝난 게시물은 제외하고 조회할 수 있게끔 구현하였습니다.
