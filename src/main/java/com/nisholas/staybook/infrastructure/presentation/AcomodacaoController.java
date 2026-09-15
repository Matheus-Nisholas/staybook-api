package com.nisholas.staybook.infrastructure.presentation;

import com.nisholas.staybook.core.entities.Acomodacao;
import com.nisholas.staybook.core.enums.AcomodacaoTipos;
import com.nisholas.staybook.core.usecases.*;
import com.nisholas.staybook.infrastructure.DTO.AcomodacaoDTO;
import com.nisholas.staybook.infrastructure.Exception.ErrorResponse;
import com.nisholas.staybook.infrastructure.Mapper.AcomodacaoMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
@Tag(name = "Acomodações", description = "Operações para cadastro, consulta, atualização e remoção de acomodações")
public class AcomodacaoController {

    private final CriarAcomodacaoCase criarAcomodacaoCase;
    private final BuscarAcomodacaoCase buscarAcomodacaoCase;
    private final BuscarTodasAcomodacoesCase buscarTodasAcomodacoes;
    private final AcomodacaoMapper acomodacaoMapper;
    private final DeletarAcomodacaoCase deletarAcomodacaoCase;
    private final BuscarPorTipoDeAcomodacaoCase buscarPorTipoDeAcomodacaoCase;
    private final AtualizarAcomodacaoCase atualizarAcomodacaoCase;

    @PostMapping()
    @Operation(summary = "Criar acomodação", description = "Cadastra uma nova acomodação. Identificador, status e data de criação são definidos pela aplicação.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Acomodação criada com sucesso"),
            @ApiResponse(responseCode = "409", description = "Endereço já cadastrado",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    public ResponseEntity<AcomodacaoDTO> post(@RequestBody AcomodacaoDTO acomodacaoDTO) {
        Acomodacao novaAcomodacao = criarAcomodacaoCase.execute(acomodacaoMapper.ToDomain(acomodacaoDTO));
        return ResponseEntity.ok(acomodacaoMapper.ToDTO(novaAcomodacao));
    }

    @GetMapping("{id}")
    @Operation(summary = "Buscar acomodação por ID", description = "Retorna uma acomodação pelo seu identificador numérico.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Acomodação encontrada"),
            @ApiResponse(responseCode = "404", description = "Acomodação não encontrada",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    public ResponseEntity<AcomodacaoDTO> getById(
            @Parameter(description = "ID da acomodação", example = "1")
            @PathVariable Long id) {
        Acomodacao acomodacao = buscarAcomodacaoCase.execute(id);
        return ResponseEntity.ok(acomodacaoMapper.ToDTO(acomodacao));
    }

    @GetMapping()
    @Operation(summary = "Listar acomodações", description = "Retorna todas as acomodações cadastradas.")
    @ApiResponse(responseCode = "200", description = "Lista de acomodações retornada com sucesso")
    public ResponseEntity<List<AcomodacaoDTO>> getAll() {
        List<AcomodacaoDTO> acomodacao = buscarTodasAcomodacoes.excute()
                .stream()
                .map(acomodacaoMapper::ToDTO)
                .toList();

        return ResponseEntity.ok(acomodacao);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Excluir acomodação", description = "Remove uma acomodação existente pelo ID e retorna os dados da acomodação removida.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Acomodação removida com sucesso"),
            @ApiResponse(responseCode = "404", description = "Acomodação não encontrada",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    public ResponseEntity<AcomodacaoDTO> deleteById(
            @Parameter(description = "ID da acomodação", example = "1")
            @PathVariable Long id) {
        Acomodacao acomodacao = buscarAcomodacaoCase.execute(id);
        deletarAcomodacaoCase.execute(id);
        return ResponseEntity.ok(acomodacaoMapper.ToDTO(acomodacao));
    }

    @GetMapping("/search")
    @Operation(summary = "Buscar acomodações por tipo", description = "Filtra acomodações pelo tipo. A conversão do valor informado ignora diferenças entre maiúsculas e minúsculas.")
    @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso")
    public ResponseEntity<List<AcomodacaoDTO>> getAllByType(
            @Parameter(description = "Tipo da acomodação", example = "CASA")
            @RequestParam AcomodacaoTipos type) {
        List<Acomodacao> acomodacoes = buscarPorTipoDeAcomodacaoCase.execute(type);
        List<AcomodacaoDTO> acomodacoesDTO = acomodacoes.stream().map(acomodacaoMapper::ToDTO).toList();
        return ResponseEntity.ok(acomodacoesDTO);
    }

    @PutMapping("{id}")
    @Operation(summary = "Atualizar acomodação", description = "Atualiza os dados editáveis de uma acomodação existente.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Acomodação atualizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Acomodação não encontrada",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    public ResponseEntity<AcomodacaoDTO> update(
            @Parameter(description = "ID da acomodação", example = "1")
            @PathVariable Long id,
            @RequestBody AcomodacaoDTO acomodacaoDTO) {
        buscarAcomodacaoCase.execute(id);
        Acomodacao acomodacaoAtualizada = atualizarAcomodacaoCase.execute(id, acomodacaoMapper.ToDomain(acomodacaoDTO));
        return ResponseEntity.ok(acomodacaoMapper.ToDTO(acomodacaoAtualizada));
    }
}
