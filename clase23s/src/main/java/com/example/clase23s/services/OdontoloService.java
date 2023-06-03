package com.example.clase23s.services;

import com.example.clase23s.models.Odontologo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class OdontoloService {
    private List<Odontologo> odontologoList= new ArrayList<>();
    public  OdontoloService(){
        odontologoList.add(new Odontologo(1L,"Juan","Silva","4rrr"));
    }
    public List<Odontologo> getall(){
        return odontologoList;
    }
    //retorna el odonto dado su id
    public Odontologo getOdontologoById(long id) {
        return odontologoList.stream().filter(x -> x.getId() == (id)).findFirst().orElse(null);
    }

}
