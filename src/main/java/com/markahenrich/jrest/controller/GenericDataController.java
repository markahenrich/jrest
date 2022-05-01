package com.markahenrich.jrest.controller;

import com.markahenrich.jrest.model.GenericModel;
import com.markahenrich.jrest.service.GenericDataService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/data")
public class GenericDataController<T> {
    private GenericDataService genericDataService;

    public GenericDataController(GenericDataService genericDataService) {
        this.genericDataService = genericDataService;
    }

    @GetMapping
    public List<GenericModel> getDataList() {
        return genericDataService.getDataList();
    }

    @PostMapping
    public void postData(@RequestBody T data) {
        genericDataService.postData(data);
    }
}
