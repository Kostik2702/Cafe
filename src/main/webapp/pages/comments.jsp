<%--suppress ALL --%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
  <title>Отзывы</title>
  <link   href="<c:url value="/pages/css/reset.css"/>" rel="stylesheet">
  <link   href="<c:url value="/pages/css/style.css"/>" rel="stylesheet">
  <link   href="<c:url value="/pages/css/news.css"/>" rel="stylesheet">
  <link   href="<c:url value="/pages/css/comments.css"/>" rel="stylesheet">
  <link   href="<c:url value="/pages/css/jquery.scrollbar.css"/>" rel="stylesheet">
  <link   href="<c:url value="/pages/css/font-awesome.css"/>" rel="stylesheet">

  <script  src="<c:url value="/pages/script/jquery-1.11.3.min.js"/>">

  </script>

  <script  src="<c:url value="/pages/script/jquery.scrollbar.js"/>">

  </script>

  <script type="text/javascript">
    $(document).ready(function(){
      /*
      $(".arrow").click(function(){

        $("#nav-menu").slideToggle("slow");
        $(this).toggleClass("active"); return false;
      });
  */
      jQuery('.scrollbar-inner').scrollbar();

    }	);
  </script>
</head>
<body>
<div class="sizer edge">
  <div class="border-block">

  </div>
  <div class="content-block">
    <div class="header">
      <h1>Палуба</h1>
    </div>
    <div class="nc-border-b"></div>
    <div class="news-content scrollbar-inner">


      <c:forEach items="${comments}" var="comment">

      <div id="news-preview">
        <div class="border-h">
        </div>
        <div class="border-d">
        </div>
        <div class="border-l">
        </div>
        <div class="border-r">
        </div>
        <div class="preview-content">
          <div class="user-info">
            <p class="nickname">${comment.author.name}${comment.author.surname}</p>
            <div class="avatar">
              <div class="a-border-t">
              </div>
              <div class="a-border-d">
              </div>
              <div class="a-border-l">
              </div>
              <div class="a-border-r">
              </div>
              <img src="<c:url value="/pages/images/av1.jpg" />"/>

            </div>
            <p class="date"><fmt:formatDate pattern="yyyy-MM-dd" value="${comment.date}" /></p>
          </div>
          <div class="comment">
            <p>
              ${comment.commentText}
            </p>
          </div>
        </div>
      </div>
      </c:forEach>









  </div>
  </div>

  <div id="sidebar-block">
    <div id="nav-menu">
      <h2>Меню</h2>
      <div class="menu">
        <ul>
          <li><a href="<c:url value="/" />">На главную</a></li>
          <li><a href="<c:url value="/news" />">Новости</a></li>
          <li><a href="<c:url value="/gallery" />">Галерея</a></li>
          <li><a href="<c:url value="/aboutUs" />">О нас</a></li>


          <sec:authorize access="!isAuthenticated()">
            <li><a href="<c:url value="/loginpage" />">Авторизация</a></li>
          </sec:authorize>
          <sec:authorize access="isAuthenticated()">
            <li><a href="<c:url value="/comments/addComment" />">Добавить отзыв</a></li>
            <li><a href="<c:url value="/logout" />">Выход</a></li>
          </sec:authorize>
        </ul>
      </div>
    </div>


  </div>
</div>

<div class="footer">

</div>

</body>
</html>
