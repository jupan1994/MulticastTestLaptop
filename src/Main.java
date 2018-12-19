public class Main {
  private static final int M_SEND = 0;
  private static final int M_RECV = 1;
  private static final int U_SEND = 2;
  private static final int U_RECV = 3;

  public static void main(String[] args) {
    int mode = M_RECV;
    switch (mode) {
      case M_SEND:
        MulticastSender ms = new MulticastSender();
        ms.run();
        break;
      case M_RECV:
        MulticastReceiver mr = new MulticastReceiver();
        mr.run();
        break;
      case U_SEND:
        UnicastSender us = new UnicastSender();
        us.run();
        break;
      case U_RECV:
        UnicastReceiver ur = new UnicastReceiver();
        ur.run();
        break;
    }
  }
}
