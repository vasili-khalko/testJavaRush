package by.vasili.khalko.services;


import by.vasili.khalko.datamodel.Part;

import java.util.List;

public interface PartService {

    Part get(Long id);

    void add(Part part);

    void update(Part part);

    void  delete(Long id);

    List<Part> getAllParts();

    List<Part> getAllPartsByName(String name);

    Integer getNumberPcCanBeAssembled();
}
