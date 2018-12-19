import java.io.IOException;
import java.net.*;

public class MulticastReceiver extends Thread {
  protected MulticastSocket multicastSocket;
  protected byte[] buf = new byte[256];

  public void run() {
    try {
      multicastSocket = new MulticastSocket(2214);
      InetAddress group = InetAddress.getByName("239.22.22.114");
      multicastSocket.joinGroup(group);
      int counter = 0;
      while (counter < 300) {
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        multicastSocket.receive(packet);
        String received = new String(packet.getData(), 0, packet.getLength());
        if ("Hello".equals(received)) {
          System.out.println("Received packet: " + received + " [ " + (counter++) + " ]");
        }
      }
      multicastSocket.leaveGroup(group);
      multicastSocket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
