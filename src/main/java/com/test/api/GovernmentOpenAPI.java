package com.test.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class GovernmentOpenAPI {

    public static String searchDomesticWorkplace(String workplaceName) {

        String resultList = "";

        try{
            // 입력 받은 데이터 값 URL 값으로 인코딩
            String param_wkpl_nm = URLEncoder.encode(workplaceName, "UTF-8");
            // 서비스 인증키
            String serviceKey = "%2BRywIM2mRvNE6qxeHrABCH%2Fvj3NmtFxD%2BZFE9MLyJXBzi0Z3sFzskbswbJ%2Fk0gLyXLhlPPoF9sPlqcES2gLTvw%3D%3D";
            String apiURL = "http://apis.data.go.kr/B552015/NpsBplcInfoInqireService/getBassInfoSearch?serviceKey="
                    + serviceKey
                    + "&wkpl_nm=" + param_wkpl_nm;

            URL url = new URL(apiURL);
            System.out.println(url);

            // 요청받은 URL 주소로 이동하여 요청한 데이터의 결과를 받는다.
            HttpURLConnection urlconn = (HttpURLConnection)url.openConnection();
            urlconn.setRequestMethod("GET");
            // 받은 결과값을 읽어 result 변수에 저장한다.
            BufferedReader br = new BufferedReader(new InputStreamReader(urlconn.getInputStream(),"UTF-8"));
            String result = "";
            String line;
            while((line = br.readLine()) != null){
                result = result + line + "\n";
            }
            br.close();

            System.out.println(result);
            resultList = result;

        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        return resultList;
    }
}
