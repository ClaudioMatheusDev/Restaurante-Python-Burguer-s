package com.example.demo.controller;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Conexao;
import com.example.demo.model.Email;
import com.example.demo.model.Cliente;
import com.example.demo.model.Cardapio;
import com.example.demo.model.Encomenda;

@Controller
public class HomeController {
@GetMapping("/")
public ModelAndView rotaBase(){
    ModelAndView mv = new ModelAndView("index");
    return mv;
}

@GetMapping("/hello/{name}/{age}")
@ResponseBody
public void RotaHello(@PathVariable("name") String name,@PathVariable("age") int age) {
    System.out.println(name);
    System.out.println(age);
    }

@GetMapping("/contato")
    public ModelAndView RotaFormularioContato(){
        ModelAndView mv = new ModelAndView("contato");
        return mv;
    }

@PostMapping("/contact")
public ModelAndView RotaEnviaContato(
        @RequestParam String name,
        @RequestParam String email,
        @RequestParam(required = false) String phone,
        @RequestParam String subject,
        @RequestParam String message
) throws SQLException {

    Conexao conn = new Conexao();

    System.out.println("Contato recebido de: " + name + " <" + email + ">");
    System.out.println("Telefone: " + phone);
    System.out.println("Assunto: " + subject);
    System.out.println("Mensagem: " + message);

    Email contato = new Email(name, email, phone, subject, message);
    contato.persistirEmail(conn);

    ModelAndView mv = new ModelAndView("sucessoemailenviado");
    mv.addObject("name", name);
    mv.addObject("email", email);
    mv.addObject("phone", phone);
    mv.addObject("subject", subject);
    mv.addObject("message", message);

    return mv;
}

@GetMapping("/cliente")
    public ModelAndView RotaCliente(){
        ModelAndView mv = new ModelAndView("cliente");
        return mv;
    }

    @PostMapping("/client")
public ModelAndView RotaEnviaCliente(
        @RequestParam String name,
        @RequestParam String email,
        @RequestParam(required = false) String phone
) throws SQLException {

    Conexao conn = new Conexao();

    System.out.println("Cadastrando novo cliente: " + name + " <" + email + ">");
    System.out.println("Telefone: " + phone);

    Cliente novoCliente= new Cliente(name, email, phone);
    novoCliente.persistirCliente(conn);

    ModelAndView mv = new ModelAndView("sucessoemailenviado");
    // Passando dados para a view
    mv.addObject("name", name);
    mv.addObject("email", email);
    mv.addObject("phone", phone);

    return mv;

    
}

@GetMapping("/Cadastrocardapio")
    public ModelAndView RotaCardapio(){
        ModelAndView mv = new ModelAndView("Cadastrocardapio");
        return mv;
    }

    @PostMapping("/card")
public ModelAndView RotaEnviaCardapio(
        @RequestParam String name,
        @RequestParam String composicao,
        @RequestParam double preco
) throws SQLException {

    Conexao conn = new Conexao();

    System.out.println("Cadastrando novo de lanche: " + name);

    Cardapio novoLanche = new Cardapio(name, composicao, preco);
    novoLanche.persistirCardapio(conn);

    ModelAndView mv = new ModelAndView("sucessocardapio");
    // Passando dados para a view
    mv.addObject("name", name);
    mv.addObject("email", composicao);
    mv.addObject("number", preco);

    return mv; 
}

@GetMapping("/cardapio")
    public ModelAndView RotaListarCardapio() throws SQLException {

        ModelAndView mv = new ModelAndView("cardapio"); 

        Conexao conn = new Conexao();

        List<Cardapio> listaDeLanches = Cardapio.buscarTodos(conn);

        mv.addObject("listaDeLanches", listaDeLanches);

        return mv;
    }

@GetMapping("/Encomenda")
    public ModelAndView RotaEncomenda() throws SQLException {
        ModelAndView mv = new ModelAndView("encomenda");
        
        Conexao conn = new Conexao();
        List<Cliente> listaClientes = Cliente.buscarTodos(conn);
        List<Cardapio> listaLanches = Cardapio.buscarTodos(conn);
        
        mv.addObject("listaClientes", listaClientes);
        mv.addObject("listaLanches", listaLanches);
        
        return mv;
    }

    @PostMapping("/enco")
    public ModelAndView RotaEnviaEncomenda(
            @RequestParam int clienteId,
            @RequestParam int cardapioId,
            @RequestParam int quantidade,
            @RequestParam(required = false) String observacoes
    ) throws SQLException {

        Conexao conn = new Conexao();

        Encomenda novaEncomenda = new Encomenda(clienteId, cardapioId, quantidade, observacoes);
        novaEncomenda.persistirEncomenda(conn);

        System.out.println("Encomenda cadastrada com sucesso!");

        ModelAndView mv = new ModelAndView("sucessoencomenda");
        mv.addObject("message", "Encomenda realizada com sucesso!");

        return mv;
    }

    @GetMapping("/encomendas")
    public ModelAndView RotaListarEncomendas() throws SQLException {
        ModelAndView mv = new ModelAndView("listaencomendas");

        Conexao conn = new Conexao();
        List<Encomenda> listaEncomendas = Encomenda.buscarTodas(conn);

        mv.addObject("listaEncomendas", listaEncomendas);

        return mv;
    }

    @GetMapping("/sobre")
    public ModelAndView RotaSobre() {
        ModelAndView mv = new ModelAndView("sobre");
        return mv;
    }
}