<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Shopping!</title>
    <link href="/resources/css/style.css" rel="stylesheet" type="text/css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<header>
  <jsp:include page="../../layout/header.jsp"/>
</header>
<main>
  <div class="sidebar">
    <div class="privateSide">
      <ul>
        <li>userName</li>
        <li>point</li>
        <li></li>
      </ul>
    <div class="shoppingMy">
      <ul>
        <li class="shoppingMyTop"><a href="#">쇼핑 My</a></li>
        <li><a href="#">작성 가능한 리뷰</a></li>
        <li><a href="#">내가 찜한 상품</a></li>
        <li><a href="#">정기구독</a></li>
        <li class="shoppingMyFoot"><a href="#">선물함</a></li>
      </ul>
    </div>
      <div class="sidebarsetting">
        <ul>
          <li><a href="#">기본설정</a></li>
          <li><a href="#">알림수신 설정</a></li>
          <li><a href="#">카드/계좌 관리</a></li>
          <li><a href="#">보안/인증</a></li>
          <li><a href="#">배송지 관리</a></li>
          <li><a href="#">정기/예약 결제</a></li>
        </ul>
      </div>
    </div>
  </div>
  <div class="mainTop">

  </div>
</main>
<footer></footer>
</body>
</html>
