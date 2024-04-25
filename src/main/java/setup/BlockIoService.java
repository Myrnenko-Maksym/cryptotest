package setup;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BlockIoService {
    @GET("get_new_address/")
    Call<Response<Object>> getNewAddress(@Query("api_key") String apiKey, @Query("label") String label);

    @GET("get_address_balance/")
    Call<Response<Object>> getAddressBalance(@Query("api_key") String apiKey, @Query("addresses") String addresses);

    @GET("get_transactions/")
    Call<Response<Object>> getTransactions(@Query("api_key") String apiKey, @Query("type") String type, @Query("addresses") String addresses);
}
