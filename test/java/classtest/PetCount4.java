package classtest;

import classtest.pets.Pet;
import classtest.util.Pets;

/**
 * Created by cheng on 2016/4/1 0001.
 */
public class PetCount4 {
    public static void main(String[] args){
    TypeCounter counter=new TypeCounter(Pet.class);
        for(Pet pet: Pets.createArray(20)){
            System.out.print(pet.getClass().getSimpleName()+" ");
            counter.count(pet);
        }
        System.out.println();
        System.out.println(counter);
    }
}
