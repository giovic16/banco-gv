package com.banco.gv.service;

import com.banco.gv.model.ClienteModel;
import com.banco.gv.model.ContaModel;
import com.banco.gv.repository.ClienteRepository;
import com.banco.gv.repository.ContaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgenciaService {

    private final ClienteRepository clienteRepository;
    private final ContaRepository contaRepository;

    public ClienteModel criaCliente(ClienteModel clienteModel){
        ClienteModel model = clienteRepository.findByCpf(clienteModel.getCpf());
        if (model != null){
            throw new RuntimeException("Cliente já cadastrado");
        }
        return clienteRepository.save(clienteModel);
    }

    public void removeCliente(ClienteModel clienteModel){
        ClienteModel model = clienteRepository.findByCpf(clienteModel.getCpf());
        if (model != null){
            throw new RuntimeException("Cliente não cadastrado");
        }
        clienteRepository.deleteById(model.getIdCliente());
    }

    public void criarConta(ContaModel contaModel){
        ContaModel model = contaRepository.findByCliente(contaModel);
        if (model != null){
            throw new RuntimeException("Cliente não cadastrado");
        }
        contaRepository.save(contaModel);
    }
    public void listaContas(){
        List<ContaModel> contaModels = contaRepository.findAll();
        for (ContaModel contaModel :contaModels) {
            System.out.println(contaModel);
        }
    }

    public void listaClientes(){
        List<ClienteModel> clienteModels = clienteRepository.findAll();
        for (ClienteModel clienteModel:clienteModels) {
            System.out.println(clienteModel);
        }
    }
}
