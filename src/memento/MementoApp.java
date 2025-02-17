package memento;

import java.util.Stack;

public class MementoApp {
    public static void main(String[] args) throws Exception {
        Stack<Memento> mementos = new Stack<>();
        
        Originator ori = new Originator();
        ori.setState("state 1");
        mementos.push(ori.createMemento());

        ori.setState("state 2");
        mementos.push(ori.createMemento());

        ori.setState("state 3");
        mementos.push(ori.createMemento());

        ori.setState("state final");
        mementos.push(ori.createMemento());

        ori.restoreMemento(mementos.pop());
        System.out.println(ori.getState());
        ori.restoreMemento(mementos.pop());
        System.out.println(ori.getState());
        ori.restoreMemento(mementos.pop());
        System.out.println(ori.getState());
        ori.restoreMemento(mementos.pop());
        System.out.println(ori.getState());
    }
}
