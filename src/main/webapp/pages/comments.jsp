<%--suppress ALL --%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
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
      $(".arrow").click(function(){

        $("#nav-menu").slideToggle("slow");
        $(this).toggleClass("active"); return false;
      });

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
            <p class="nickname">Анджелина Джоли</p>
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
            <p class="date">5.12.2015</p>
          </div>
          <div class="comment">
            <p>
              Отличный отзыв отзывается отлично отличненько для отличного отзыва отличному заведению отзывавшемуся отзывами об отзывах отозвавшихся на отзывы отзывов
            </p>
          </div>
        </div>


      </div>

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
            <p class="nickname">Хоббит Бильбо</p>
            <div class="avatar">
              <div class="a-border-t">
              </div>
              <div class="a-border-d">
              </div>
              <div class="a-border-l">
              </div>
              <div class="a-border-r">
              </div>
              <img src="<c:url value="/pages/images/av2.jpg" />"/>

            </div>
            <p class="date">5.12.2015</p>
          </div>
          <div class="comment">
            <p>
              Отличный отзыв отзывается отлично отличненько для отличного отзыва отличному заведению отзывавшемуся отзывами об отзывах отозвавшихся на отзывы отзывов
            </p>
          </div>
        </div>


      </div>

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
            <p class="nickname">Петро Порошенко</p>
            <div class="avatar">
              <div class="a-border-t">
              </div>
              <div class="a-border-d">
              </div>
              <div class="a-border-l">
              </div>
              <div class="a-border-r">
              </div>
              <img src="<c:url value="/pages/images/av3.jpg" />"/>

            </div>
            <p class="date">5.12.2015</p>
          </div>
          <div class="comment">
            <p>
              Отличный отзыв отзывается отлично отличненько для отличного отзыва отличному заведению отзывавшемуся отзывами об отзывах отозвавшихся на отзывы отзывов
            </p>
          </div>
        </div>


      </div>





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
          <li><a href="<c:url value="/ourmenu" />">Наше меню</a></li>
          <li><a href="<c:url value="/reserve" />">Резерв столика</a></li>
          <li><a href="<c:url value="/comments/addComment" />">Добавить отзыв</a></li>

          <sec:authorize access="!isAuthenticated()">
            <li><a href="<c:url value="/loginpage" />">Авторизация</a></li>
          </sec:authorize>
          <sec:authorize access="isAuthenticated()">
            <li><a href="<c:url value="/logout" />">Выход</a></li>
          </sec:authorize>
        </ul>
      </div>
    </div>
    <div class="arrow">

    </div>

  </div>
</div>

<div class="footer">

</div>

</body>
</html>
