package homework12.dao;


import homework12.entity.Family;

import java.util.List;

public interface FamilyDAO {
    List<Family>getAll();
    Family getFamilyByIndex(int index);
    boolean deleteFamily(int index);
    boolean deleteFamily(Family family);
    boolean saveFamily(Family family);
}
