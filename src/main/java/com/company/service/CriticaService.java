package com.company.service;

import com.company.dto.*;
import com.company.models.*;
import com.company.repository.FilesOperation;

public class CriticaService {
    public static CriticaListDTO getCriticas() {
        Cabeleireiro cabeleireiro = FilesOperation.load();
        CriticaContainer list = cabeleireiro.getCriticas();
        return Mapper.criticaContainer2CriticaListDTO(list);
    }

    public static CriticaListDTO getCriticaInfo(long id) {
        Cabeleireiro cabeleireiro = FilesOperation.load();
        CriticaContainer container = new CriticaContainer();
        for (Critica c : cabeleireiro.getCriticas().getCriticas()) {
            if (c.getCliente() == id) {
                container.getCriticas().add(c);
            }
        }
        return Mapper.criticaContainer2CriticaListDTO(container);
    }

    public static void addCritica(CriticaDTO arg) {
        Cabeleireiro cabeleireiro = FilesOperation.load();
        cabeleireiro.getCriticas().add(Mapper.criticaDTO2Critica(arg));
        FilesOperation.save(cabeleireiro);
    }

}
