package classtest.util;

import classtest.pets.Pet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by cheng on 2016/4/1 0001.
 */
public abstract class PetCreator {
    private Random random=new Random(47);
    public abstract List<Class<? extends Pet>> types();
    public Pet randomPet(){
        int n =random.nextInt(types().size());
        try{
            return types().get(n).newInstance();
        }catch (InstantiationException e)
        {
            throw  new RuntimeException(e);
        }catch (IllegalAccessException e){
            throw  new RuntimeException(e);
        }
    }

    public Pet[] createArray(int size){
        Pet[] pets=new Pet[size];
        for(int i =0;i<size;i++){
            pets[i]=randomPet();
        }
        return pets;
    }

    public List<Pet> arrayList(int size){
        ArrayList<Pet> pets=new ArrayList<>();
        Collections.addAll(pets,createArray(size));
        return pets;
    }
}
