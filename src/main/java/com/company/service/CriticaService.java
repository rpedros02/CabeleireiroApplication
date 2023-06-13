package com.company.service;

import com.company.dto.*;
import com.company.models.*;
import com.company.repository.FilesOperation;

import java.util.List;

public class CriticaService {
    public static CriticaListDto getCriticas() {
        Cabeleireiro cabeleireiro = FilesOperation.load();
        List<Critica> list = cabeleireiro.getCriticas().getAll();
        CriticaListDto result = Mapper.criticaList2CriticaListDto(list);
        return result;
    }

    public static CriticaDto getCriticaInfo(int id) {
        Cabeleireiro cabeleireiro = FilesOperation.load();
        Critica item = cabeleireiro.getCriticas().get(id);
        CriticaDto result = Mapper.critica2CriticaDTO(item);
        return result;
    }

    public static void addCritica(CriticaDto arg) {
        Cabeleireiro cabeleireiro = FilesOperation.load();
        cabeleireiro.getCriticas().add(Mapper.criticaDTO2Critica(arg));
        FilesOperation.save(cabeleireiro);
    }

}
