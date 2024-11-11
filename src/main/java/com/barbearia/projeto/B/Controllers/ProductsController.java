package com.barbearia.projeto.B.Controllers;

import com.barbearia.projeto.B.produto.*;
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
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProdutoRepository rep;

    @Autowired
    private Gson gson;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhadosProduto> cadastrar(@RequestBody @Valid DadosCadastroProduto json, UriComponentsBuilder builder){
        var produto = new Produto(json);
        System.out.println(json.toString());
        rep.save(produto);
        var uri = builder.path("/products/{id}").buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhadosProduto(produto));
    }

    @GetMapping
    public ResponseEntity<String> listar(){
        var lista = rep.findAll().stream().map(DadosListagemProduto::new).toList();

        HashMap<String, JSONObject> mapa = new HashMap<String, JSONObject>();
        for (int i=0; i < lista.size(); i++){
            DadosListagemProduto index = lista.get(i);
            JSONObject json = new JSONObject();
            json.put("nome", index.nome());
            json.put("id", index.id());
            json.put("preco", index.preco());
            json.put("vendas", index.vendas());
            mapa.put(index.nome(), json);
        }
        System.out.println(mapa.toString());
        String jsonString = gson.toJson(mapa);
        return ResponseEntity.ok(jsonString);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhadosProduto> atualizar(@RequestBody @Valid DadosAtualizarProduto json){
        var produto = rep.getReferenceById(json.id());
        produto.atualizarInformacoes(json);
        return ResponseEntity.ok(new DadosDetalhadosProduto(produto));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        rep.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<DadosDetalhadosProduto> buscarPorId(@PathVariable Long id){
        var produto = rep.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhadosProduto(produto));
    }
}
