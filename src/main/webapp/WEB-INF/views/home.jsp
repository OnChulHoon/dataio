<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
</head>
<body>

    <div align="center">
        <h1>Home</h1>
        <h5>Welcome Test Message: ${message}</h5>
        <br>
        <h6>네이버 API 테스트</h6>
        <button onclick="location.href='/blog-search'">네이버 블로그 검색하기</button>
        <br>
        <h6>정부 공공데이터 OpenAPI 테스트</h6>
        <button onclick="location.href='/workplace-search'">사업장 정보 검색하기</button>
    </div>

</body>
</html>