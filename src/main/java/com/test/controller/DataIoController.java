package com.test.controller;

import com.test.vo.DataIo;

import org.springframework.boot.json.GsonJsonParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;

@Controller
public class DataIoController {

    @GetMapping(value = {"/", "/home"})
    public String showHome(Model model){
        System.out.println("Method Started!! => showHome()");
        model.addAttribute("message", "Hello~ SpringBoot! :)");
        return "home";
    }

    @GetMapping(value = "/blog-search")
    public String showBlogSearch(Model model){
        System.out.println("Method Started!! => showBlogSearch()");

        model.addAttribute("defaultMessage", "현재 검색된 데이터가 없습니다. 검색어를 입력 후 버튼을 눌러주세요.");

        return "search-blog";
    }

    @ResponseBody
    @PostMapping(value = "/list-data/result")
    public String showBlogSearchResult(String keyword){

        System.out.println("Method Started!! => showBlogSearchResult()");
        String resultList = null;
        String clientId = "vAGaUzy40Y5xHQn2ragH";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "o7eKtHT_Wf";//애플리케이션 클라이언트 시크릿값";
        try {
            String text = URLEncoder.encode(keyword, "UTF-8");
            String apiURL = "https://openapi.naver.com/v1/search/blog?query="+ text; // json 결과
            //String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // xml 결과
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;

            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();


            System.out.println(responseCode);
            System.out.println();
            //System.out.println(response.toString());
            System.out.println();
            resultList = response.toString();
            System.out.println(resultList);

//            HashMap<String, Object> resultDatas = new HashMap<>();
//            resultDatas.put("data", resultList);
//            System.out.println(resultDatas);


        } catch (Exception e) {
            System.out.println(e);
        }

        return resultList;
    }
}
