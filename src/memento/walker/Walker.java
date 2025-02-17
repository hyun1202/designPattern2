package memento.walker;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Walker {
  private int currentX, currentY;
  private int targetX, targetY;
  private ArrayList<String> actionList = new ArrayList<>();

  public Walker(int currentX, int currentY, int targetX, int targetY) {
    this.currentX = currentX;
    this.currentY = currentY;
    this.targetX = targetX;
    this.targetY = targetY;
  }

  public double walk(String action) {
    actionList.add(action);

    if(action.equals("UP")) {
      currentY++;
    } else if(action.equals("RIGHT")) {
      currentX++;
    } else if(action.equals("DOWN")) {
      currentY--;
    } else if(action.equals("LEFT")) {
      currentX--;
    }

    return Math.sqrt(Math.pow(currentX-targetX, 2) + Math.pow(currentY-targetY, 2));
  }

  // Walker 객체만 수정 가능하도록 하기 위함
  public class Memento {
    private int x, y;
    private ArrayList<String> actionList;
    private Memento() {}
  }

  public Memento createMemento() {
    Memento memento = new Memento();

    // memento의 필드 값을 walker의 필드 값으로 지정 
    memento.x = this.currentX;
    memento.y = this.currentY;
    memento.actionList = (ArrayList<String>) this.actionList.clone();

    return memento;
  }

  public void restoreMemento(Memento memento) {
    this.currentX = memento.x;
    this.currentY = memento.y;
    this.actionList = (ArrayList<String>)memento.actionList.clone();
  }

  @Override
  public String toString() {
    return actionList.toString();
  }
}
