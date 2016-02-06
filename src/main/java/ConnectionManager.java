
/**
 * Created by willhorton on 1/22/16.
 */
public class ConnectionManager {

    private static Connection[] connections = new Connection[5];
    private static int connectionCount = 0;

    public static Connection openConnection() {

        // Check if already have max number of connections
        if(connections[4] != null) return null;

        // Create new connection
        Connection newCon = new Connection(++connectionCount);

        // Append to first free space in array
        for(int i = 0; i < connections.length; i++) {
            if(connections[i] == null) {
                connections[i] = newCon;
                break;
            }
        }

        return newCon;

    }

    public static void closeConnection(int ID) {

        int indexOfRemoved = -1;

        // Outer loop looks for target element and sets to null
        for(int i = 0; i < connections.length; i++) {
            if((connections[i] != null) && (connections[i].getID() == ID)) {
                System.out.println("Removing connection " + connections[i].getID());
                connections[i] = null;
                indexOfRemoved = i;
            }
        }

        // Second loop starts at position of removed element, shifts everything after to the left, and makes sure last element is null
        if(indexOfRemoved >= 0) {
            for (int j = indexOfRemoved; j < connections.length; j++) {
                if (j == connections.length - 1) {
                    connections[j] = null;
                } else {
                    connections[j] = connections[j + 1];
                }
            }
        }

    }

    public static String displayConnection(int ID) {

        Connection selectedConnection = null;

        for(int i = 0; i < connections.length; i++) {
            if(connections[i] != null && connections[i].getID() == ID) {
                selectedConnection = connections[i];
            }
        }

        if(selectedConnection == null) return "Sorry, connection " + ID + " was not found\n";

        return "connection_manager.Connection ID: " + selectedConnection.getID() + "\nconnection_manager.Connection port: " + selectedConnection.getPortNumber() + "\nconnection_manager.Connection IP address: " + selectedConnection.getIpAddress() + "\n";

    }

    public static void main(String[] args) {

        // Demonstration
        Connection connection1 = ConnectionManager.openConnection();
        Connection connection2 = ConnectionManager.openConnection();
        Connection connection3 = ConnectionManager.openConnection();
        Connection connection4 = ConnectionManager.openConnection();
        Connection connection5 = ConnectionManager.openConnection();

        ConnectionManager.closeConnection(3);
        System.out.println(ConnectionManager.displayConnection(4));

    }

}