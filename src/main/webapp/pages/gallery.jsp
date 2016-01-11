<%--suppress ALL --%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<html>
<head>
  <title>Галерея</title>
  <link   href="<c:url value="/pages/css/reset.css"/>" rel="stylesheet">
  <link   href="<c:url value="/pages/css/style.css"/>" rel="stylesheet">
  <link   href="<c:url value="/pages/css/authentication.css"/>" rel="stylesheet">
  <link   href="<c:url value="/pages/css/gallery.css"/>" rel="stylesheet">
  <link   href="<c:url value="/pages/css/lightbox.css"/>" rel="stylesheet">
  <link   href="<c:url value="/pages/css/jquery.scrollbar.css"/>" rel="stylesheet">
  <link   href="<c:url value="/pages/css/font-awesome.css"/>" rel="stylesheet">

  <script  src="<c:url value="/pages/script/jquery-1.11.3.min.js"/>">

  </script>

  <script  src="<c:url value="/pages/script/lightbox.js"/>">

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

    <div class="gal-space ">
      <div class="gal-border-t">
      </div>
      <div class="gal-border-d">
      </div>
      <div class="gal-border-l">
      </div>
      <div class="gal-border-r">
      </div>
      <div class="photos ">
        <div class="inside scrollbar-inner">
          <a href="<c:url value="/pages/images/ship2.jpg" />"  class="photo-link" data-lightbox="album">
            <div class="photo-preview">
              <div class="p-preview-border-t"></div>
              <div class="p-preview-border-b"></div>
              <div class="p-preview-border-l"></div>
              <div class="p-preview-border-r"></div>
              <img src="<c:url value="/pages/images/ship2.jpg" />">

            </div>
          </a>


          <a href="<c:url value="/pages/images/ship1.jpg" />" class="photo-link" data-lightbox="album">
            <div class="photo-preview">
              <div class="p-preview-border-t"></div>
              <div class="p-preview-border-b"></div>
              <div class="p-preview-border-l"></div>
              <div class="p-preview-border-r"></div>
              <img src="<c:url value="/pages/images/ship1.jpg" />">

            </div>
          </a>




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

          <li><a href="<c:url value="/aboutUs" />">О нас</a></li>
          <li><a href="<c:url value="/ourmenu" />">Наше меню</a></li>
          <li><a href="<c:url value="/reserve" />">Резерв столика</a></li>
          <li><a href="<c:url value="/comments" />">Отзывы</a></li>
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
