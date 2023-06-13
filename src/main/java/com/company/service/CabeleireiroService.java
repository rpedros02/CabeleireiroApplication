package com.company.service;

import com.company.dto.CabeleireiroDto;
import com.company.dto.Mapper;
import com.company.models.Cabeleireiro;
import com.company.repository.FilesOperation;

public class CabeleireiroService {
    public static CabeleireiroDto getCabeleireiroInfo(){
        Cabeleireiro cabeleireiro = FilesOperation.load();
        CabeleireiroDto cabeleireiroDTO = Mapper.cabeleireiro2CabeleireiroDTO(cabeleireiro.getNome());
        return cabeleireiroDTO;
    }

}
