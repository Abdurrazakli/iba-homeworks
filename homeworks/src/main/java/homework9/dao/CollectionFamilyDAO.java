package homework9.dao;


import homework9.entity.Family;

import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDAO implements FamilyDAO {
    private List<Family> families = new ArrayList<>();

    @Override
    public List<Family> getAll() {
        return families;
    }

    @Override
    public Family getFamilyByIndex(int index) {
           try {
               return families.get(index);
           }catch (IndexOutOfBoundsException e){
               return null;
           }
    }

    @Override
    public boolean deleteFamily(int index) {
        try {
            families.remove(index);
            return true;
        }
        catch (IndexOutOfBoundsException e){
            return false;
        }
    }

    @Override
    public boolean deleteFamily(Family family) {
        try {
            families.remove(family);
            return true;
        }
        catch (IndexOutOfBoundsException e){
            return false;
        }
    }



    /**
     * if family exists updates it else creates new one*/
    @Override
    public boolean saveFamily(Family family) {
        if(families.contains(family)){
            families.set(families.indexOf(family),family);
        }else {
            families.add(family);
        }
        return true;
    }
}
