package com.starmk95.navermovieapi;

import java.net.URL;

import retrofit2.Call;
import retrofit2.http.*;

// retrofit은 인터페이스에 기술된 내용을 Http APT로 전환해준다.
// 해당 예시에서는 요청할 API인 네이버 영화 검색 API에 대한 내용을 인터페이스에 기록해준다.
public interface SearchMovieService {
    // @GET - HTTP 통신에 사용되는 GET 메소드 요청을 하겠다고 명시하는 Annotation
    // GET 방식으로 url를 맵핑한다.
    @Headers({"X-Naver-Client-Id: y7IE673fixXsvPWXKycA", "X-Naver-Client-Secret: IR38gFFCnF"})
    @GET("v1/search/{type}")
    /*
    @Path - 구체적인 API URI로 이동할 수 있게 해준다. (path 변수를 통해 url에 접근)
    URL 중 일부의 경로가 필요에 따라 동적으로 바인딩되어야 하는 경우에 어노테이션을 통해 문자열을 정의 해주면,
    해당 문자열을 URL 부분 일부에 바인딩하여 동적으로 URL을 만들도록 도와주는 어노테이션이다.
    @Header - 이 어노테이션을 통해 각종 값을 전송할 수 있다.
    @Query - 이 어노테이션을 통해 웹에 쿼리를 한다. (찾으려는 키워드를 이를 통해 검색)
     */
    Call<Movie> getMovies(@Path("type") String type, @Query("query") String query, @Query("display") int displaySize, @Query("start") int startPosition);
}
