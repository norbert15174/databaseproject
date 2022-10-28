package com.example.postgressqldb.core.circuit.service.cud;

import com.example.postgressqldb.model.Circuit;

public interface ICircuitCUDService {
    Circuit save(Circuit entity);
}
