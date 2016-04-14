package classtest.util;

import classtest.pets.Pet;
import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cheng on 2016/4/1 0001.
 */
public class ForNameCreator extends PetCreator {
    private static List<Class<? extends Pet>> types = new ArrayList<>();

    private static String[] typeNames = {
            "classtest.pets.Mutt",
            "classtest.pets.Pug",
            "classtest.pets.EgyptianMau",
            "classtest.pets.Manx",
            "classtest.pets.Cymric",
            "classtest.pets.Rat",
            "classtest.pets.Mouse",
            "classtest.pets.Hamster"
    };

    private static void loader() {
        try {
            for (String name : typeNames) {
                types.add((Class<? extends Pet>) Class.forName(name));
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        loader();
    }

    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }
}
