package com.barbearia.projeto.B.Controllers;

import com.barbearia.projeto.B.usuario.*;

import com.google.gson.Gson;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsuarioRepository rep;
    @Autowired
    private Gson gson;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhadosUsuario> cadastrar(@RequestBody @Valid DadosCadastroUsuario json, UriComponentsBuilder builder){
        var usuario = new Usuario(json);
        rep.save(usuario);
        var uri = builder.path("/users/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhadosUsuario(usuario));
    }

    @GetMapping
    public ResponseEntity<String> listar(){
       var lista = rep.findAll().stream().map(DadosListagemUsuarios::new).toList();
        HashMap<String, JSONObject> mapa = new HashMap<String, JSONObject>();
       for (int i=0; i < lista.size(); i++){
           DadosListagemUsuarios index = lista.get(i);
           JSONObject json = new JSONObject();
           json.put("nome", index.nome());
           json.put("id", index.id());
           mapa.put(index.nome(), json);
       }
       System.out.println(mapa.toString());
       String jsonString = gson.toJson(mapa);
       return ResponseEntity.ok(jsonString);
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

    @PostMapping(value = "/login")
    @Transactional
    public ResponseEntity<DadosDetalhadosUsuario> Login(@RequestBody @Valid DadosLoginUsuario json){
        try {
            List<Usuario> queryResult = rep.GetUserByNameAndPass(json.nome(), json.senha());
            System.out.println(queryResult.getFirst());
            if(queryResult.getFirst() != null) {
                return ResponseEntity.ok(new DadosDetalhadosUsuario(queryResult.getFirst()));
            }
        } catch (Exception e) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<DadosDetalhadosUsuario> buscarPorId(@PathVariable Long id){
        var usuario = rep.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhadosUsuario(usuario));
    }
}
