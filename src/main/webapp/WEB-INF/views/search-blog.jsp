<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Search - Blog</title>
    <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
</head>
<body>

    <div align="center">
        <a href="/home"><h3>Home</h3></a>
        <h1>Naver Blog Search</h1>

        <form id="keywordForm">
            검색어 입력: <input type="text" name="keyword"/>
        </form>
        <br>
        <button id="searchBtnBlog">검색</button>
    </div>
    <br>
    <div align="center">
        <h5>${defaultMessage}</h5>
    </div>
    <script>
        $(function () {
            $('button#searchBtnBlog').on('click', function () {
                $.ajax({
                    method:'post',
                    url: '/list-data/result',
                    dataType: 'json',
                    data: $('#keywordForm').serialize(),
                    success: function (data) {
                        alert('비동기 통신 성공!! data: ' + data);
                        console.log("data: ", data);

                    },
                    error: function (error) {
                        alert("data error!!");
                    }
                });
            });
        });

    </script>
</body>

</html>