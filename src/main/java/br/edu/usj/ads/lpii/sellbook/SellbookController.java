package br.edu.usj.ads.lpii.sellbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class SellbookController {

    @Autowired
    SellbookRepository sellbookRepository;
    @GetMapping(value="/")
    public ModelAndView getListar() {
        List<Livros> lista = sellbookRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("lista", lista);
        return modelAndView;
    }
    @GetMapping(value="mostrar/{id}")
    public ModelAndView getMostrar(@PathVariable Long id) {
        Livros livros = sellbookRepository.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("mostrar");
        modelAndView.addObject("livros", livros);
        return modelAndView;
    }

    @GetMapping(value="/cadastrar")
        public ModelAndView getCadastrar() {
            Livros livros = new Livros();
            ModelAndView modelAndView = new ModelAndView("cadastrar");
            modelAndView.addObject("livros", livros);
        return modelAndView;
    }

    @PostMapping(value="/cadastrar")
    public ModelAndView postCadastrar(Livros livros) {
        sellbookRepository.save(livros);
        ModelAndView modelAndView = new ModelAndView("mostrar");
        modelAndView.addObject("livros", livros);
        return modelAndView;
    }


    @GetMapping(value="/deletar/{id}")
    public ModelAndView getDeletar(@PathVariable Long id) {
        sellbookRepository.deleteById(id);

        List<Livros> lista = sellbookRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("lista", lista);
        return modelAndView;
    }

    @GetMapping(value="/editar/{id}")
    public ModelAndView getEditar(@PathVariable Long id) {
        Livros livros = sellbookRepository.findById(id).get();

        ModelAndView modelAndView = new ModelAndView("cadastrar");
        modelAndView.addObject("livros", livros);
        return modelAndView;
    }
}



