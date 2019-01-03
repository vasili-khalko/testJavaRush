package by.vasili.khalko.controller;

import by.vasili.khalko.datamodel.Part;
import by.vasili.khalko.services.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PartController {

    private static final int MAX_ROWS_PER_PAGE = 10;

    @Autowired
    private PartService partService;

    @Qualifier(value = "partService")
    public void setPartService(PartService partService){
        this.partService = partService;
    }


    @RequestMapping("addPart")
    public ModelAndView addPart(@ModelAttribute Part part){

        return new ModelAndView("partForm");
    }

    @RequestMapping("editPart")
    public ModelAndView editPart(@RequestParam Long id, @ModelAttribute Part part){
        part = partService.get(id);
        return new ModelAndView("partForm", "partObject", part);
    }

    @RequestMapping("savePart")
    public ModelAndView savePart(@ModelAttribute Part part) {
        if (part.getId() == 0) {
            partService.add(part);
        } else {
            partService.update(part);
        }

        return new ModelAndView("redirect:/");
    }

    @RequestMapping("removePart")
    public ModelAndView removePart(@RequestParam Long id){
        partService.delete(id);
        return new ModelAndView("redirect:/");
    }

    public ModelAndView searchPart(@RequestParam("searchName") String searchName){
        List<Part> partsList = partService.getAllPartsByName(searchName);
        return new ModelAndView("partsList", "partsList", partsList);
    }

    @RequestMapping(value = "/")
    public ModelAndView listOfParts(@RequestParam(required = false) Integer page){
        ModelAndView modelAndView = new ModelAndView("partsList");

        List<Part> parts = partService.getAllParts();
        PagedListHolder<Part> pagedListHolder = new PagedListHolder<Part>(parts);
        pagedListHolder.setPageSize(MAX_ROWS_PER_PAGE);
        modelAndView.addObject("maxPages", pagedListHolder.getPageCount());

        if(page == null || page < 1 || page > pagedListHolder.getPageCount()){
            page = 1;
        }
        modelAndView.addObject("page", page);

        if (page == 1 || page < 1 || page > pagedListHolder.getPageCount()){
            pagedListHolder.setPage(0);
            modelAndView.addObject("partsList", pagedListHolder.getPageList());
        } else if (page <= pagedListHolder.getPageCount()){
            pagedListHolder.setPage(page - 1);
            modelAndView.addObject("partsList", pagedListHolder.getPageList());
        }
        return modelAndView;
    }
}
