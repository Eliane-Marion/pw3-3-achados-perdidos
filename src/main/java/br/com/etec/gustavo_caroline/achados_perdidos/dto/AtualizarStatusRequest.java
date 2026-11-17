package br.com.etec.achadosperdidos.dto;
import br.com.etec.achadosperdidos.model.StatusItem;
import jakarta.validation.constraints.NotNull;
public record AtualizarStatusRequest(@NotNull StatusItem status) {}
