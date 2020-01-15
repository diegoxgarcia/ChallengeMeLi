package ar.com.innovationdg.challengemeli.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface MLService {

    @Headers("Content-Type: application/json")
    @GET("search?q={item}")
    Call<SearchResult> getMLSearchResult(@Path("item") String item);
}
