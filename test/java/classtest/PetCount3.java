package classtest;

import classtest.pets.Pet;
import classtest.util.LiteralPetCreator;
import classtest.util.MapData;
import classtest.util.Pets;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by cheng on 2016/4/1 0001.
 */
public class PetCount3 {
    static class PetCountor extends LinkedHashMap<Class<? extends Pet>,Integer>{
        public PetCountor(){
        super(MapData.map(LiteralPetCreator.allTypes,0));
        }
        public void count(Pet pet){
            for(Map.Entry<Class<? extends Pet>,Integer> pair: entrySet())
                if (pair.getKey().isInstance(pet))
                    put(pair.getKey(),pair.getValue()+1);
        }

        @Override
        public String toString() {
            StringBuilder result=new StringBuilder("{");
            for(Map.Entry<Class<?extends Pet>,Integer> pair:entrySet()){
                result.append(pair.getKey().getSimpleName());
                result.append("=");
                result.append(pair.getValue());
                result.append(", ");
            }
            result.delete(result.length()-2,result.length());
            result.append("}");
            return  result.toString();
        }
    }
    public static void main(String[] args){
    PetCountor petCountor=new PetCountor();
        for(Pet pet: Pets.createArray(20)){
            System.out.print(pet.getClass().getSimpleName()+" ");
            petCountor.count(pet);
        }
        System.out.println();
        System.out.println(petCountor);
    }

}
