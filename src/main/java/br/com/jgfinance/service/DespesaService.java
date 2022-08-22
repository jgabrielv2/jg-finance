package br.com.jgfinance.service;


import br.com.jgfinance.entity.Despesa;
import br.com.jgfinance.entity.form.DespesaForm;
import br.com.jgfinance.repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DespesaService {

    @Autowired
    private DespesaRepository despesaRepository;

    public Despesa create(DespesaForm form) {
        Despesa despesa = new Despesa();
        despesa.setData(form.getData());
        despesa.setDescricao(form.getDescricao());
        despesa.setValor(form.getValor());
        return despesaRepository.save(despesa);
    }

    public Despesa get(Long id) {
        Despesa despesa = despesaRepository.findById(id).get();
        return despesa;
    }

    public List<Despesa> getAll() {
        return despesaRepository.findAll();
    }

    public Despesa update(Long id, DespesaForm form) {
        Despesa despesa = get(id);
        despesa.setData(form.getData());
        despesa.setValor(form.getValor());
        despesa.setDescricao(form.getDescricao());
        return despesaRepository.save(despesa);
    }

    public void delete(Long id) {
        despesaRepository.deleteById(id);
    }
}


