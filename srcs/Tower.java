package pack;

import java.util.Observer;
import java.util.ArrayList;


/**
 * Tower
 */
public class Tower {

    private ArrayList<Flyable> _observer = new ArrayList<Flyable>();
    private ArrayList<Flyable> _onLand = new ArrayList<Flyable>();

    public void register(Flyable flyable){
        this._observer.add(flyable);
        System.out.println("register");
    }

    public void unregister(Flyable flyable){
        this._observer.remove(flyable);
        this._onLand.add(flyable);
        System.out.println("unregister");
    }

    protected void conditionsChanged(){
        for (Flyable item : this._observer) {
            item.updateConditions();
        }
        System.out.println("changed");
    }

}