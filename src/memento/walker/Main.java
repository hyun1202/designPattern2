package memento.walker;

import java.util.Random;

public class Main {
  public static void main(String[] args) {
    Walker walker = new Walker(0, 0, 10, 10);
    String[] actions = {"UP", "RIGHT", "DOWN", "LEFT"};
    Random random = new Random();
    double minDistance = Double.MAX_VALUE;
    Walker.Memento memento = null;

    while(true) {
      String action = actions[random.nextInt(4)];
      // 워커 이동, 현재 위치에서 목표 위치까지의 거리 값 반환
      double distance = walker.walk(action);

      System.out.println(action + " " + distance);

      if(distance == 0.0) {
        break;
      }

      if(minDistance > distance) {
        minDistance = distance;
        memento = walker.createMemento();
      } else {
        if (memento != null) {
          walker.restoreMemento(memento);
        }
      }
    }
    System.out.println("walker's path: " + walker);
  }
}
