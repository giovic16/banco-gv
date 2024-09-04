package com.banco.gv.service;

import com.banco.gv.model.ContaModel;
import com.banco.gv.repository.ContaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContaService {
    private final ContaRepository contaRepository;

    public void depositar(ContaModel contaModel, float valor){
        if (contaModel.getIdConta() == null){
            throw new RuntimeException("Conta não encontrada");
        }
        contaModel.setSaldo(contaModel.getSaldo() + valor);
        contaRepository.save(contaModel);
    }

    public void sacar(ContaModel contaModel, float saque){
        if (contaModel.getSaldo() < 0){
            throw new RuntimeException("Não foi possível realizar saque");
        }
        contaModel.setSaldo(contaModel.getSaldo() - saque);
        contaRepository.save(contaModel);
    }

    public void transferir(ContaModel idOrigem, ContaModel idDestino, float valor){
        if (idOrigem.getIdConta() == null){
            throw new RuntimeException("Conta origem não encontrada");
        }
        if (idDestino.getIdConta() == null){
            throw new RuntimeException("Conta destino não encontrada");
        }

        idOrigem.setSaldo(idOrigem.getSaldo() - valor);
        idDestino.setSaldo(idDestino.getSaldo() + valor);

        contaRepository.save(idOrigem);
        contaRepository.save(idDestino);
    }

    public void consultar(ContaModel contaModel){
        if (contaModel.getIdConta() == null){
            throw new RuntimeException("Conta não encontrada");
        }
        System.out.println(contaModel);
    }
}
