<%--suppress ALL --%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>Панель администратора</title>
  <link   href="<c:url value="/pages/css/reset.css"/>" rel="stylesheet">
  <link   href="<c:url value="/pages/css/admin.css"/>" rel="stylesheet">
  <link   href="<c:url value="/pages/css/jquery.scrollbar.css"/>" rel="stylesheet">
  <link   href="<c:url value="/pages/css/font-awesome.css"/>" rel="stylesheet">
  <link  href= "<c:url value="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css"/>" rel="stylesheet">




<script type="text/javascript" src="<c:url value="/pages/script/jquery-1.11.3.min.js"/>">

</script>
<script type="text/javascript" src="<c:url value="/pages/script/jquery.scrollbar.js"/>">

</script>



<script type="text/javascript">
  $(document).ready(function(){
    /*
    var hid = 1;
    $(".menu-item").click(function(){
      if(hid==1){
        $(this).find("ul").hide()

        hid = 0;
      } else {
        $(this).find("ul").show();

        hid = 1;
      }
    });
    */

    $(".buttonO").click(function(){

      $(this).parent().children("ul").slideToggle("slow");


    });
     /*
    $(".comments-button-open").click(function(){

      $(".comments-menu-list").slideToggle("slow");


    });

    $(".sends-button-open").click(function(){

      $(".sends-menu-list").slideToggle("slow");


    });

    $(".users-button-open").click(function(){

      $(".users-menu-list").slideToggle("slow");


    });

    $(".menus-button-open").click(function(){

      $(".menus-menu-list").slideToggle("slow");


    });

    $(".actions-button-open").click(function(){

      $(".actions-menu-list").slideToggle("slow");


    });
  */
    jQuery('.scrollbar-inner').scrollbar();

  }	);
</script>
</head>
<body>

<sec:authorize access="!isAuthenticated()">
  <p><a class="btn btn-lg btn-success" href="<c:url value="/login" />" role="button">Войти</a></p>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
<div class="sidebar">
  <h3>Вы авторизированы:<span><sec:authentication property="principal.username" /></span></h3>
  <div class="menu-item">
    <h3 class="news-button-open buttonO"><i class="fa fa-newspaper-o"></i>  Новости </h3>
    <ul class="menu-list news-menu-list ">
      <li><a href="<c:url value="/admin/addnews" />"><i class="fa fa-plus"></i>Добавить новость</a></li>

      <li><a href="<c:url value="/admin/news_list" />"><i class="fa fa-list"></i>Список</a></li>

    </ul>
  </div>
  <div class="menu-item">
    <h3 class="comments-button-open buttonO" ><i class="fa fa-comments-o"></i>  Отзывы  </h3>
    <ul class="menu-list comments-menu-list ">


      <li><a href="<c:url value="/admin/comments" />"><i class="fa fa-list"></i>Список</a></li>

    </ul>
  </div>

  <div class="menu-item">
    <h3 class="users-button-open buttonO" ><i class="fa  fa-users"></i>  Пользователи  </h3>
    <ul class="menu-list users-menu-list">

      <li><a href="<c:url value="/admin/users" />"><i class="fa fa-list"></i>Список</a></li>


    </ul>
  </div>





  <div class="menu-item">
    <h3 class="actions-button-open buttonO" ><i class="fa  fa-list-alt"></i>  Действия  </h3>
    <ul class="menu-list actions-menu-list ">
      <li><a class="btn" href="<c:url value="/admin/send_mail" />" ><i class="fa fa-mail-forward"></i>Отправить письмо</a></li>
      <li><a class="btn" href="<c:url value="/admin/addphoto" />" ><i class="fa fa-photo"></i>Добавить фото</a></li>
      <li><a class="btn" href="<c:url value="/admin/photos_list" />" ><i class="fa fa-list"></i>Список фото</a></li>
      <li><a class="btn" href="<c:url value="/logout" />" role="button"><i class="fa fa-sign-out"></i>Выход</a></li>



    </ul>
  </div>
</div>
<div class="wrap">
  <div class="work-window-space">
    <div class="head-space">
      <div class="left-corner"></div>
      <h3>Активное окно</h3>
      <div class="right-corner"></div>
    </div>
    <div class="workspace scrollbar-inner">
      <p>
      </p>
    </div>
  </div>
</div>


</div>
</sec:authorize>
</body>
</html>