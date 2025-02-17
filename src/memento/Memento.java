package memento;

public class Memento {
  String state;

  public Memento() {}

  protected Memento(String state) {
      this.state = state;
  }

  protected String getState() {
      return state;
  } 
}
