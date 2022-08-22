package br.com.jgfinance.service;

import br.com.jgfinance.entity.Receita;
import br.com.jgfinance.entity.form.ReceitaForm;
import br.com.jgfinance.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReceitaService {

    private final ReceitaRepository receitaRepository;

    public ReceitaService(ReceitaRepository receitaRepository) {
        this.receitaRepository = receitaRepository;
    }

    public Receita create(ReceitaForm form) {
        Receita receita = new Receita();
        receita.setData(form.getData());
        receita.setDescricao(form.getDescricao());
        receita.setValor(form.getValor());
        return receitaRepository.save(receita);
    }

    public Receita get(Long id) {
        Receita receita = receitaRepository.findById(id).get();
        return receita;
    }

    public
    List<Receita> getAll() {
        return receitaRepository.findAll();
    }

    public Receita update(Long id, ReceitaForm form) {
        Receita receita = get(id);
        receita.setData(form.getData());
        receita.setValor(form.getValor());
        receita.setDescricao(form.getDescricao());
        return receitaRepository.save(receita);
    }

    public void delete(Long id) {
    receitaRepository.deleteById(id);
    }
}
