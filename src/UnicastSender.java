import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class UnicastSender extends Thread {
  @Override
  public void run() {
    String msg = "Hello";
    DatagramPacket hi = new DatagramPacket(msg.getBytes(), msg.length(),
                                          new InetSocketAddress("192.168.0.23", 7777));
    try {
      DatagramSocket socket = new DatagramSocket(7777);
      int counter = 0;
      while (counter < 300) {
        socket.send(hi);
        System.out.println("Sending " + counter++ + " packet");
        Thread.sleep(1000);
      }
    } catch (SocketException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
