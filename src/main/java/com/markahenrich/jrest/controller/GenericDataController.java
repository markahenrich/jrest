package com.markahenrich.jrest.controller;

import com.markahenrich.jrest.model.GenericModel;
import com.markahenrich.jrest.service.GenericDataService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("/api/v1/data")
@CrossOrigin
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

    @PutMapping("/{id}")
    public void updateData(@PathVariable UUID id, @RequestBody T data) {
        genericDataService.updateData(id, data);
    }

    @DeleteMapping("/{id}")
    public void deleteData(@PathVariable UUID id) {
        genericDataService.deleteData(id);

        // TODO: Works but returns error response. Need to return correct response.
    }
}
