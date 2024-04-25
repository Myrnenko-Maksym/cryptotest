package payments;

import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.Test;
import retrofit2.Response;
import setup.ConfigValues;

import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;
import static setup.RetrofitClient.getService;
import static setup.RetrofitClient.parseJson;

public class APITests {

    private static final ConfigValues cfg =
            ConfigFactory.create(ConfigValues.class);

    @Test
    public void testGenerateNewAddress() throws Exception {
        Response<Object> response = getService().getNewAddress(cfg.api_key(), "newTestLabel").execute().body();
        assert response != null;
        assertTrue(response.isSuccessful());
        assertNotNull(response.body());
    }

    @Test
    public void testBalanceUpdate() throws Exception {
        Response<Object> response = getService().getAddressBalance(cfg.api_key(), cfg.bc_address()).execute().body();
        assert response != null;
        assertTrue(response.isSuccessful());
        assertNotNull(response.body());

        Map<String, Object> responseBody = parseJson(response.body().toString());
        Map<String, Object> data = (Map<String, Object>) responseBody.get("data");
        double expectedBalance = 123.45;
        String actualBalance = data.get("available_balance").toString();
        assertNotNull("Data section should not be null", actualBalance);

        assertEquals("Balance should match expected value", expectedBalance, Double.parseDouble(actualBalance), 0.001);
    }

    @Test
    public void testRecentTransactions() throws Exception {
        Response<Object> response = getService().getTransactions(cfg.api_key(), "sent", cfg.bc_address()).execute().body();
        assert response != null;
        assertTrue(response.isSuccessful());
        assertNotNull(response.body());

        Map<String, Object> responseBody = parseJson(response.body().toString());
        List<Map<String, Object>> transactions = (List<Map<String, Object>>) responseBody.get("data");
        assertNotNull("Transactions list should not be null", transactions.get(1).toString());
        boolean transactionFound = transactions.stream()
                .anyMatch(tx -> "0.001".equals(tx.get("amount").toString()) && "sent".equals(tx.get("type").toString()));
        assertTrue(transactionFound, "Expected transaction should be found in the transactions list");
    }
}
