package com.example.creditapp.controller;

import com.example.creditapp.model.Client;
import com.example.creditapp.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/clients")
    public String getClients(Model model) {
        List<Client> clients = clientService.getAllClients();
        model.addAttribute("clients", clients); // Добавляем список клиентов в модель
        return "clients"; // Возвращаем имя шаблона
    }

    @GetMapping("/client-details/{id}")
    public String getClientDetails(@PathVariable Long id, Model model) {
        Client client = clientService.getClientById(id);
        model.addAttribute("client", client);
        return "client_details";
    }

    @PostMapping("/update")
    public Client updateClient(@RequestBody Client client) {
        return clientService.saveClient(client);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClientById(id);
    }

    @PostMapping
    public Client addClient(@RequestBody Client client) {
        return clientService.saveClient(client);
    }
}
