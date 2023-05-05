package com.company.service;

import com.company.dto.CabeleireiroDTO;
import com.company.dto.Mapper;
import com.company.models.Cabeleireiro;
import com.company.repository.FilesOperation;

public class CabeleireiroService {
    public static CabeleireiroDTO getCabeleireiroInfo(){
        Cabeleireiro cabeleireiro = FilesOperation.load();
        return Mapper.cabeleireiro2CabeleireiroDTO(cabeleireiro);
    }
    public static void updateCabeleireiro(CabeleireiroDTO arg){
        FilesOperation.save(Cabeleireiro.updateCabeleireiro(Mapper.cabeleireiroDTO2Cabeleireiro(arg)));
    }
}
