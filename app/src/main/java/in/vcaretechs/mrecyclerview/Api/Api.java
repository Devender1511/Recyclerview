package in.vcaretechs.mrecyclerview.Api;

import in.vcaretechs.mrecyclerview.BasicResponse;
import retrofit2.Call;
import retrofit2.http.POST;

public interface Api
{


    @POST("show_course")
    Call<BasicResponse> getcourse();

}
