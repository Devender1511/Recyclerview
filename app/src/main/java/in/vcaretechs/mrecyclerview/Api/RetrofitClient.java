package in.vcaretechs.mrecyclerview.Api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient
{
    private static final String BASE_URL="https://www.sparshclasses.in/Admin/Api/";

    private static RetrofitClient mInstance;
    private static Retrofit retrofit;
    OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private RetrofitClient()
    {
        retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static synchronized RetrofitClient getInstance()
    {
        if (mInstance==null)
        {
            mInstance=new RetrofitClient();

        }
        return mInstance;
    }

    public Api getApi()
    {
        return retrofit.create(Api.class);
    }

//dashbaord



    public static Retrofit getApiClient(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).
                    addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }

}
