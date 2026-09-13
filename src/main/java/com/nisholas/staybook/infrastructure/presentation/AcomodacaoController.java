package com.nisholas.staybook.infrastructure.presentation;

import com.nisholas.staybook.core.entities.Acomodacao;

import com.nisholas.staybook.core.usecases.BuscarAcomodacaoCase;
import com.nisholas.staybook.core.usecases.BuscarTodasAcomodacoesCase;
import com.nisholas.staybook.core.usecases.CriarAcomodacaoCase;
import com.nisholas.staybook.infrastructure.DTO.AcomodacaoDTO;
import com.nisholas.staybook.infrastructure.Mapper.AcomodacaoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class AcomodacaoController {

    private final CriarAcomodacaoCase criarAcomodacaoCase;

    private final BuscarAcomodacaoCase buscarAcomodacaoCase;

    private final BuscarTodasAcomodacoesCase buscarTodasAcomodacoes;

    private final AcomodacaoMapper acomodacaoMapper;

    @PostMapping("post")
    public ResponseEntity<AcomodacaoDTO> post(@RequestBody AcomodacaoDTO acomodacaoDTO){
        Acomodacao novaAcomodacao = criarAcomodacaoCase.execute(acomodacaoMapper.ToDomain(acomodacaoDTO));
        return ResponseEntity.ok(acomodacaoMapper.ToDTO(novaAcomodacao));
    }

    @GetMapping("{id}")
    public ResponseEntity<AcomodacaoDTO> getById(@PathVariable Long id){
        Acomodacao acomodacao = buscarAcomodacaoCase.execute(id);
        return ResponseEntity.ok(acomodacaoMapper.ToDTO(acomodacao));
    }

    @GetMapping()
    public ResponseEntity<List<AcomodacaoDTO>> getAll(){
        List<AcomodacaoDTO> acomodacao = buscarTodasAcomodacoes.excute()
                .stream()
                .map(acomodacaoMapper::ToDTO)
                .toList();

        return  ResponseEntity.ok(acomodacao);
    }


}
