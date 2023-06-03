package com.example.clase23s.services;

import com.example.clase23s.models.Paciente;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service
public class PacienteService {
private OdontoloService odontoloService= new OdontoloService();
List<Paciente> pacientes= new ArrayList();

public PacienteService(){
    pacientes.add(new Paciente(1L,"milanesa","Amado","silvaa@gmail.com","2323223", LocalDate.of(2023,6,2),odontoloService.getOdontologoById(1L)));
}
public void guardarPaciente(Paciente paciente){
    pacientes.add(paciente);
}
public List<Paciente> getAll(){
    return pacientes;
}

    public Paciente getPacientByEmail(String email) {
        for(int i = 0; i<pacientes.size();i++){
            if(pacientes.get(i).getMail().equals(email)){
                return pacientes.get(i);
            }
        }
        return null;
    }
}
