package homework9.dao;


import homework9.entity.Family;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface FamilyDAO {
    List<Family>getAll();
    Family getFamilyByIndex(int index);
    boolean deleteFamily(int index);
    boolean deleteFamily(Family family);
    boolean saveFamily(Family family);
}
