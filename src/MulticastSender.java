import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class MulticastSender {
  public void run() {
    try {
      String msg = "Hello";
      InetAddress group = InetAddress.getByName("239.22.22.114");
      MulticastSocket s = new MulticastSocket(2214);
      s.joinGroup(group);
      DatagramPacket hi = new DatagramPacket(msg.getBytes(), msg.length(), group, 2214);
      int counter = 0;
      while (counter < 300) {
        s.send(hi);
        System.out.println("Sending " + counter++ + " packet");
        Thread.sleep(1000);
      }
    } catch (UnknownHostException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
