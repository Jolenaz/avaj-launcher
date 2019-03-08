package pack;

import java.util.Observer;

/**
 * Tower
 */
public class Tower {

    private LinkedList<Flyable> _observer = new LinkedList<Flyable>();

    public void register(Flyable flyable){
        this._observer.add(flyable);
        System.out.println("register");
    }

    public void unregister(Flyable flyable){
        this._observer.remove(flyable);
        System.out.println("unregister");
    }

    protected void conditionsChanged(){
        System.out.println("changed");
    }

}