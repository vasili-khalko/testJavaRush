package by.vasili.khalko.services;


import by.vasili.khalko.datamodel.Part;

import java.util.List;

public interface PartService {

    Part get(Long id);

    void saveOrUpdate(Part part);

    void  delete(Part part);

    List<Part> getAllParts();
}
