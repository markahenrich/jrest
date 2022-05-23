package com.markahenrich.jrest.service;

import com.markahenrich.jrest.model.GenericModel;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GenericDataService<T> {
    private List<GenericModel> dataList;

    public GenericDataService() {
        dataList = new ArrayList<>();
    }

    public List<GenericModel> getDataList() {
        return dataList;
    }
    public void postData(T data) {
        GenericModel genericModel = new GenericModel<>(UUID.randomUUID(), data);
        dataList.add(genericModel);
    }

    public void updateData(UUID id, T data) {
        for (GenericModel i : dataList) {
            if (Objects.equals(i.getId(), id)) {
                int index = dataList.indexOf(i);
                dataList.get(index).setData(data);
            }
        }
    }

    public void deleteData(UUID id) {
        for(GenericModel i : dataList) {
            if(Objects.equals(i.getId(), id)) {
                dataList.remove(i);
            }
        }
    }
}
