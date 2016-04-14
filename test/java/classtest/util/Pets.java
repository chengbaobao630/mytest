package classtest.util;

import classtest.pets.Pet;

import java.util.List;

/**
 * Created by cheng on 2016/4/1 0001.
 */
public class Pets {
    public static final PetCreator creator=new LiteralPetCreator();
    public  static Pet randomPet(){
        return creator.randomPet();
    }
    public  static  Pet[] createArray(int size){
        return creator.createArray(size);
    }
    public  static List<Pet> arrayList(int size){
        return creator.arrayList(size);
    }
}
