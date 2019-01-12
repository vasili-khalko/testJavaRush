package by.vasili.khalko.dataaccess;

import by.vasili.khalko.datamodel.Part;
import java.util.List;

public interface PartDao {

    List<Part> getAll();

    List<Part> getAllByName(String name);

    List<Part> getAllByNeed(Boolean isNeed);

    Part get(Long id);

    void add(Part part);

    void update(Part part);

    void delete(Long id);
}
