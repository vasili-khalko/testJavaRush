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


    @RequestMapping("/addPart")
    public ModelAndView addPart(@ModelAttribute Part part){

        return new ModelAndView("partForm");
    }

    @RequestMapping("/editPart")
    public ModelAndView editPart(@RequestParam Long id, @ModelAttribute Part part){
        return new ModelAndView("partForm", "partObject", partService.get(id));
    }

    @RequestMapping("/savePart")
    public ModelAndView savePart(@ModelAttribute Part part) {
        if (part.getId() == 0) {
            partService.add(part);
        } else {
            partService.update(part);
        }

        return new ModelAndView("redirect:/");
    }

    @RequestMapping("/removePart")
    public ModelAndView removePart(@RequestParam Long id){
        partService.delete(id);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping("/searchPart")
    public ModelAndView searchPart(@RequestParam("searchName") String searchName){
        List<Part> partsList = partService.getAllPartsByName(searchName);
        return new ModelAndView("partsList", "partsList", partsList);
    }

//    @RequestMapping(value = "/viewByType")
//    public ModelAndView viewByType(@RequestParam("selectView") String selectView, Integer page){
//        List<Part> partsList;
//        switch (selectView){
//            case "isNeed":
//                partsList = partService.getAllPartsByNeed(true);
//                break;
//
//            case "optional":
//                partsList = partService.getAllPartsByNeed(false);
//                break;
//
//            default:
//                partsList = partService.getAllParts();
//                break;
//        }
//        ModelAndView modelAndView = new ModelAndView("partsList", "partsList", partsList);
//
//        pagination(modelAndView, partsList, page);
//        return modelAndView;
//    }

    @RequestMapping(value = "/")
    public ModelAndView listOfParts(@RequestParam(required = false) Integer page, String selectView){
        ModelAndView modelAndView = new ModelAndView("partsList");

        //List<Part> parts = partService.getAllParts();

        List<Part> parts;
        if (selectView == null){
            selectView = "all";
        }
        switch (selectView){
            case "isNeed":
                parts = partService.getAllPartsByNeed(true);
                break;

            case "optional":
                parts = partService.getAllPartsByNeed(false);
                break;

            default:
                parts = partService.getAllParts();
                break;
        }

        Integer numberPcCanBeAssembled = partService.getNumberPcCanBeAssembled();
        modelAndView.addObject("numberPcCanBeAssembled", numberPcCanBeAssembled);

        pagination(modelAndView, parts, page);

        return modelAndView;
    }

    private void pagination(ModelAndView modelAndView, List<Part> parts, Integer page){
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
    }

}
