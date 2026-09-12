package com.nisholas.staybook.infrastructure.presentation;

import com.nisholas.staybook.core.entities.Acomodacao;

import com.nisholas.staybook.core.gateway.AcomodacaoGateway;
import com.nisholas.staybook.core.usecases.CriarAcomodacaoCase;
import com.nisholas.staybook.infrastructure.DTO.AcomodacaoDTO;
import com.nisholas.staybook.infrastructure.Mapper.AcomodacaoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class AcomodacaoController {

    private final CriarAcomodacaoCase criarAcomodacaoCase;

    private final AcomodacaoGateway acomodacaoGateway;

    private final AcomodacaoMapper acomodacaoMapper;

    public AcomodacaoController(CriarAcomodacaoCase criarAcomodacaoCase, AcomodacaoGateway acomodacaoGateway, AcomodacaoMapper acomodacaoMapper) {
        this.criarAcomodacaoCase = criarAcomodacaoCase;
        this.acomodacaoGateway = acomodacaoGateway;
        this.acomodacaoMapper = acomodacaoMapper;
    }

    @PostMapping("post")
    public ResponseEntity<AcomodacaoDTO> post(@RequestBody AcomodacaoDTO acomodacaoDTO){
        Acomodacao novaAcomodacao = criarAcomodacaoCase.execute(acomodacaoMapper.ToDomain(acomodacaoDTO));
        return ResponseEntity.ok(acomodacaoMapper.ToDTO(novaAcomodacao));
    }

    @GetMapping("{id}")
    public ResponseEntity<Acomodacao> getById(@PathVariable Long id){
        Acomodacao acomodacao = acomodacaoGateway.buscarPorId(id);

        return ResponseEntity.ok(acomodacaoMapper.ToDTO(acomodacao));
    }
}
