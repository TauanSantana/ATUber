package br.com.ATUber.ATUber.controller;

import br.com.ATUber.ATUber.model.auxiliar.CorridaModel;
import br.com.ATUber.ATUber.model.domain.Corrida;
import br.com.ATUber.ATUber.model.domain.Produto;
import br.com.ATUber.ATUber.model.domain.Solicitante;
import br.com.ATUber.ATUber.model.service.CorridaService;
import br.com.ATUber.ATUber.model.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
public class CorridaController {
    @Autowired
    private CorridaService corridaService;

    @GetMapping(value="/Corrida")
    public String homeCorrida(Model model, @SessionAttribute("solicitante") Solicitante solicitante) {

        model.addAttribute("lista", (List<Corrida>)corridaService.obterCorridas(solicitante.getId()));
        model.addAttribute("solicitante", solicitante);
        return "Produto/CorridaHome";
    }

    @PostMapping(value="/Corrida")
    public String Incluir(Model model, CorridaModel corridaModel, @SessionAttribute("solicitante") Solicitante solicitante)
    {
        corridaService.Incluir(corridaModel,solicitante);
        model.addAttribute("mensagem", "Corrida incluída com sucesso!");
        model.addAttribute("solicitante", solicitante);
        return homeCorrida(model, solicitante);
    }
    @GetMapping(value="/Corrida/Cadastro")
    public String Incluir()
    {
        return "Produto/CorridaCadastro";
    }

    @GetMapping(value="/Corrida/{id}/excluir")
    public String Excluir(Model model, @PathVariable Integer id, @SessionAttribute("solicitante") Solicitante solicitante)
    {
        corridaService.Excluir(id);
        model.addAttribute("mensagem", "Corrida excluída com sucesso!");
        model.addAttribute("solicitante", solicitante);
        return homeCorrida(model, solicitante);
    }
}
