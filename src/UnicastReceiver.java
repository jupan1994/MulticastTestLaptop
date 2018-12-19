import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UnicastReceiver extends Thread {
  @Override
  public void run() {
    byte[] buffer = new byte[1024];
    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
    try {
      DatagramSocket socket = new DatagramSocket(7777);
      int counter = 0;
      while (counter < 300) {
        socket.receive(packet);
        String received = new String(packet.getData(), 0, packet.getLength());
        if ("Hello".equals(received)) {
          System.out.println("Received packet: " + received + " [ " + (counter++) +  " ]");
        }
      }
    } catch (SocketException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
