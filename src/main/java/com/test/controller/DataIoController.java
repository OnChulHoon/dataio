package com.test.controller;

import com.test.api.GovernmentOpenAPI;
import com.test.api.NaverAPI;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DataIoController {

    // 메인 화면 출력
    @GetMapping(value = {"/", "/home"})
    public String showHome(Model model){
        System.out.println("Method Started!! => showHome()");
        model.addAttribute("message", "Hello~ SpringBoot with JSP! :)");
        return "home";
    }

    // 네이버 블로그 검색 화면 출력
    @GetMapping(value = "/blog-search")
    public String showBlogSearch(Model model){
        System.out.println("Method Started!! => showBlogSearch()");
        model.addAttribute("defaultMessage", "현재 검색된 데이터가 없습니다. 검색어를 입력 후 '검색'버튼을 눌러주세요.");

        return "search-blog";
    }

    // 네이버 블로그 검색 요청 비동기 통신의 결과 출력
    @ResponseBody
    @PostMapping(value = "/list-data/result-blog")
    public String getResultNaverBlogSearch(String keyword){
        System.out.println("Method Started!! => getResultNaverBlogSearch()");

        return NaverAPI.searchBlog(keyword);
    }

    // 정부 공공데이터(국민연금공단) 국내 사업장 정보 검색 화면 출력
    @GetMapping(value = "/workplace-search")
    public String showDomesticWorkplaceSearch(Model model){
        System.out.println("Method Started!! => showDomesticWorkplaceSearch()");
        model.addAttribute("defaultMessage", "현재 검색된 사업장이 없습니다. 사업장명을 입력 후 '검색'버튼을 눌러주세요.");

        return "search-workplace";
    }

    // 정부 공공데이터(국민연금공단) 국내 사업장 정보 검색 요청 비동기 통신의 결과 출력
    @ResponseBody
    @PostMapping(value = "/list-data/result-workplace")
    public String getResultDomesticWorkplaceSearch(String workplaceName){
        System.out.println("Method Started!! => getResultDomesticWorkplaceSearch()");

        return GovernmentOpenAPI.searchDomesticWorkplace(workplaceName);
    }
}
