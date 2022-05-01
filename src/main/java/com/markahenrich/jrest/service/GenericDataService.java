package com.markahenrich.jrest.service;

import com.markahenrich.jrest.model.GenericModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GenericDataService<T> {
    private List<GenericModel> dataList;

    public GenericDataService() {
        dataList = new ArrayList<>();
    }

    public List<GenericModel> getDataList() {
        return dataList;
    }

    public Optional<GenericModel> getData(UUID id) {
        for (GenericModel i : dataList) {
            if (i.getId() == id) {
                return Optional.of(i);
            }
        }
        return null;
    }

    public void postData(T data) {
        GenericModel genericModel = new GenericModel<>(UUID.randomUUID(), data);
        dataList.add(genericModel);
    }

    public void updateData(UUID id, T data) {
        for (GenericModel i : dataList) {
            if (i.getId() == id) {
                int index = dataList.indexOf(i);
                dataList.get(index).setData(data);
            }
        }
    }

    public void deleteData(UUID id) {
        for (GenericModel i : dataList) {
            if (i.getId() == id) {
                dataList.remove(i);
            }
        }
    }
}
