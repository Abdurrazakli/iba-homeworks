package homework13.dao;


import homework13.entity.Family;
import homework13.exceptions.FamilyFileNotFoundException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDAO implements FamilyDAO {
    private List<Family> families = new ArrayList<>();
    String path = "C:\\Users\\Adil\\IdeaProjects\\iba-homeworks\\homeworks\\src\\main\\java\\homework13\\files\\family.txt";
    FileOperations<Family> familyData = new FileOperations<>(path);
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

    @Override
    public void loadData() {
        try {
            families = familyData.read();
        } catch (IOException | ClassNotFoundException e) {
          throw new FamilyFileNotFoundException("Family file problem",e);
        }
    }

    @Override
    public boolean saveData() {
        try {
            return familyData.write(families);
        } catch (IOException e) {
            throw new FamilyFileNotFoundException("Family file problem",e);
        }
    }
}
