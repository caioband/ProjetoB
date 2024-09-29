package com.barbearia.projeto.B.Controllers;

import com.barbearia.projeto.B.usuario.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsuarioRepository rep;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhadosUsuario> cadastrar(@RequestBody @Valid DadosCadastroUsuario json, UriComponentsBuilder builder){
        var usuario = new Usuario(json);
        rep.save(usuario);
        var uri = builder.path("/users/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhadosUsuario(usuario));
    }

    @GetMapping
    public ResponseEntity<List<DadosListagemUsuarios>> listar(){
       var lista = rep.findAllByBanidoFalse().stream().map(DadosListagemUsuarios::new).toList();
       return ResponseEntity.ok(lista);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhadosUsuario> atualizar(@RequestBody @Valid DadosAtualizarUsuario json){
        var usuario = rep.getReferenceById(json.id());
        usuario.atualizarInformacoes(json);

        return ResponseEntity.ok(new DadosDetalhadosUsuario(usuario));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        rep.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("banir/{id}")
    @Transactional
    public ResponseEntity<Void> banir(@PathVariable Long id){
        var usuario = rep.getReferenceById(id);
        System.out.println(usuario.getId());
        usuario.banir();
        return ResponseEntity.noContent().build();
    }

    @PutMapping("desbanir/{id}")
    @Transactional
    public ResponseEntity<DadosDetalhadosUsuario> desbanir(@PathVariable Long id){
        var usuario = rep.getReferenceById(id);
        usuario.desbanir();
        return ResponseEntity.ok(new DadosDetalhadosUsuario(usuario));
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<DadosDetalhadosUsuario> buscarPorId(@PathVariable Long id){
        var usuario = rep.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhadosUsuario(usuario));
    }
}
