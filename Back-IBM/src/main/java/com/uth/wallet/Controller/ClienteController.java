package com.uth.wallet.Controller;

import com.uth.wallet.Entity.ClienteLegacy;
import com.uth.wallet.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/legacy")
@CrossOrigin(origins = "*")
public class ClienteController {

    @Autowired
    private ClienteRepository repositorio;

    // Cuando entres a esta URL, Spring irá al AS400 y te traerá los datos
    @GetMapping("/clientes")
    public List<ClienteLegacy> obtenerClientes() {
        return repositorio.findAll();
    }
}