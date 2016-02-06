
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by willhorton on 1/22/16.
 */
public class ConnectionTest {


    Connection testConnection = new Connection(2, 45, "12.12.35.35");

    @Test
    // Test port number getter
    public void getPortNumberTest() {
        assertEquals(45, testConnection.getPortNumber());
    }

    @Test
    // Test port number setter
    public void setPortNumberTest() {
        testConnection.setPortNumber(50);
        assertEquals(50, testConnection.getPortNumber());
    }

    @Test
    // Test IP address getter
    public void getIpAddressTest() {
        assertEquals("12.12.35.35", testConnection.getIpAddress());
    }

    @Test
    // Test IP address setter
    public void setIpAddressTest() {
        testConnection.setIpAddress("13.13.45.45");
        assertEquals("13.13.45.45", testConnection.getIpAddress());
    }

}