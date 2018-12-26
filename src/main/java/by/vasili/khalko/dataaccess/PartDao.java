package by.vasili.khalko.dataaccess;

import by.vasili.khalko.datamodel.Part;

import java.util.List;

public interface PartDao {

    List<Part> getAllParts();

    List<Part> getAllPartsByName(String name);

    Part get(Long id);

    void saveOrUpdate(Part part);

    void delete(Long id);
}
