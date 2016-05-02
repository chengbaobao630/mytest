package enumTest;

/**
 * Created by cheng on 2016/4/27 0027.
 */
public enum OZWitch {
    WEST("Miss Gulch,aka the witcked witch of the west"),
    NORTH("Glinde,the good witch of the north");

    private String description;

    OZWitch(String description) {
        this.description = description;
    }

    public  static  void main(String[] args){
        for (OZWitch witch:OZWitch.values()){
            System.out.println(witch.description);
            System.out.println(witch.ordinal());
        }
    }
}
