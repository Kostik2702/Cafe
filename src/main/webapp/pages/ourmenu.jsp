<%--suppress ALL --%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<html>
<head>
  <title>Наше Меню</title>
  <link   href="<c:url value="/pages/css/reset.css"/>" rel="stylesheet">
  <link   href="<c:url value="/pages/css/style.css"/>" rel="stylesheet">
  <link   href="<c:url value="/pages/css/news.css"/>" rel="stylesheet">
  <link   href="<c:url value="/pages/css/full-news.css"/>" rel="stylesheet">
  <link   href="<c:url value="/pages/css/jquery.scrollbar.css"/>" rel="stylesheet">
  <link   href="<c:url value="/pages/css/font-awesome.css"/>" rel="stylesheet">
  <link   href="<c:url value="/pages/css/our-menu.css"/>" rel="stylesheet">

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
    <div class="news-content">
      <div id="news-full">
        <div class="border-h">
        </div>
        <div class="border-d">
        </div>
        <div class="border-l-b">
        </div>
        <div class="border-r-b">
        </div>
        <div class="preview-content">
          <h3>Заголовок</h3>
          <div class=" outer scrollbar-inner">
            <div class="menu-item">
              <h2>Напитки</h2>
              <ul>
                <li>Пиво<span>15 00 грн</span></li>
                <li>Коньяк<span>150 00 грн</span></li>
                <li>Сок<span>10 00 грн</span></li>
                <li>Минеральная вода<span>8 00 грн</span></li>
              </ul>
            </div>
            <div class="menu-item">
              <h2>Салаты</h2>
              <ul>
                <li>Цезарь<span>15 00 грн</span></li>
                <li>Крабовый<span>150 00 грн</span></li>
                <li>Овощной<span>10 00 грн</span></li>
                <li>Фруктовый<span>8 00 грн</span></li>
                <li>Диетический<span>8 00 грн</span></li>
              </ul>
            </div>
            <div class="menu-item">
              <h2>Пицца</h2>
              <ul>
                <li>Большая<span>150 00 грн</span></li>
                <li>Средняя<span>100 00 грн</span></li>
                <li>Маленькая<span>75 00 грн</span></li>
                <li>Екстра большая<span>180 00 грн</span></li>
              </ul>
            </div>

            <div class="menu-item">
              <h2>Суши</h2>
              <ul>
                <li>Большая<span>150 00 грн</span></li>
                <li>Средняя<span>100 00 грн</span></li>
                <li>Маленькая<span>75 00 грн</span></li>
                <li>Екстра большая<span>180 00 грн</span></li>
              </ul>
            </div>

          </div>
          <a href="<c:url value="/" />">На главную</a>
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

          <li><a href="<c:url value="/reserve" />">Резерв столика</a></li>
          <li><a href="#">Отзывы</a></li>
          <sec:authorize access="!isAuthenticated()">
            <li><a href="<c:url value="/loginpage" />">Авторизация</a></li>
          </sec:authorize>
          <sec:authorize access="isAuthenticated()">
            <li><a href="/logout">Выход</a></li>
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
