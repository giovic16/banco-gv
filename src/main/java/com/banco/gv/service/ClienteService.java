package com.banco.gv.service;

import com.banco.gv.model.ClienteModel;
import com.banco.gv.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public void atualizaDados(ClienteModel clienteModel){
        if (clienteModel.getIdCliente() == null){
            throw new RuntimeException("Cliente não encontrado");
        }
        clienteRepository.save(clienteModel);
    }

    public void listarContas(ClienteModel clienteModel){
        List<ClienteModel> clienteModels = clienteRepository.findAll();
        for (ClienteModel cliente:clienteModels) {
            if (clienteModel.getIdCliente() == null){
                throw new RuntimeException("Cliente não encontrado");
            }
            System.out.println(cliente);
        }
    }
}
