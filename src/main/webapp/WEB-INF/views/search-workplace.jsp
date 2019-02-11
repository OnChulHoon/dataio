<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Search - Workplace</title>
    <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
</head>
<body>

    <div align="center">
        <a href="/home"><h3>Home</h3></a>
        <h1>국내 사업장 정보 검색</h1>
        <h4>정부 공공데이터(국민연금공단 데이터) 활용</h4>
        <form id="keywordForm">
            사업장명 입력:&nbsp;<input type="text" name="workplaceName"/>
        </form>
        <br>
        <button id="searchBtnWkp">검색</button>
    </div>
    <br>
    <div align="center">
        <h5>${defaultMessage}</h5>
    </div>
    <script>
        $(function () {
            $('button#searchBtnWkp').on('click', function () {
                $.ajax({
                    method:'post',
                    url: '/list-data/result-workplace',
                    dataType: 'xml',
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