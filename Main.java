import pack.*;

public class Main{
    public static void main(String[] args){
        Coordinates coor = new Coordinates(10,10,10);
        Aircraft rogueOne = new Aircraft("rogueOne", coor );
        Aircraft roguetwo = new Aircraft("rogueTwo", coor );

        System.out.println(rogueOne.toString());
        System.out.println(roguetwo.toString());
    }
}