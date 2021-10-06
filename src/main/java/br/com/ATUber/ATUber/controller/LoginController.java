package br.com.ATUber.ATUber.controller;

import br.com.ATUber.ATUber.jdbc.Conexao;
import br.com.ATUber.ATUber.model.auxiliar.LoginModel;
import br.com.ATUber.ATUber.model.domain.Solicitante;
import br.com.ATUber.ATUber.model.service.CorridaService;
import br.com.ATUber.ATUber.model.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

@SessionAttributes("solicitante")
@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @GetMapping(value="/login/CadastroSolicitante")
    public String CadastroSolicitanteGet(Model model, LoginModel loginModel)
    {
        return "CadastroSolicitante";
    }

    @PostMapping(value="/login/CadastroSolicitante")
    public String CadastroSolicitantePost(Model model, LoginModel loginModel)
    {
        var solicitante = loginService.CadastrarSolicitante(loginModel.getEmail(), loginModel.getSenha(), loginModel.getCpf(), loginModel.getNome());
        model.addAttribute("solicitante", solicitante);
        return "home";
    }

    @PostMapping(value = "/login")
    public String tela(Model model, LoginModel loginModel)
    {
        Solicitante solicitante =  loginService.autenticar(loginModel.getEmail(), loginModel.getSenha());
        if(solicitante == null){
            model.addAttribute("mensagem", "E-mail "+ loginModel.getEmail() + " não encontrado");
            return "index";
        }
        else{
            model.addAttribute("solicitante", solicitante);
            return "home";
        }
    }

    @GetMapping(value = "/logout")
    public String logout(HttpSession session, SessionStatus status) {
        status.setComplete();

        session.removeAttribute("solicitante");

        return "redirect:/";
    }
}
