package memento;

public class Originator {
  // 상태를 나타냄
  String state;
  public Memento createMemento() {
      return new Memento(state);
  }

  public void restoreMemento(Memento memento) {
      this.state = memento.getState();
  }

  public String getState() {
      return state;
  }

  public void setState(String state) {
      this.state = state;
  }
}