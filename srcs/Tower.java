package pack;

import java.util.Observer;
import java.util.ArrayList;

/**
 * Tower
 */

public class Tower {

    private ArrayList<Flyable> _observer = new ArrayList<Flyable>();

    public void register(Flyable flyable){
        if (this._observer.contains(flyable))
            System.err.println("Error: try to register the same aircraft multiple time");
        else
        {
            this._observer.add(flyable);
            Log.write("From Tower: " + flyable.toString() + " has registered");
        }
    }

    public void unregister(Flyable flyable){
        if (!this._observer.contains(flyable))
            System.err.println("Error: try to remove an aircraft non registered");
        else{
            this._observer.remove(flyable);
            Log.write("From Tower: " + flyable.toString() + "has unregistered");
        }
    }

    protected void conditionsChanged(){
        for (Flyable item : this._observer) {
            item.updateConditions();
        }
    }

}