package homework11.dao;


import homework11.entity.Family;

import java.util.List;

public interface FamilyDAO {
    List<Family>getAll();
    Family getFamilyByIndex(int index);
    boolean deleteFamily(int index);
    boolean deleteFamily(Family family);
    boolean saveFamily(Family family);
}
