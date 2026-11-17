package br.com.etec.achadosperdidos.service;
import br.com.etec.achadosperdidos.model.*;
import br.com.etec.achadosperdidos.repository.ItemPerdidoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
@Service
public class ItemPerdidoService {
 private final ItemPerdidoRepository repository;

 public ItemPerdidoService(ItemPerdidoRepository repo){
  this.repo=repo;
 }

 public List<ItemPerdido> listar(StatusItem status){
  return status==null?repository.findAll():repo.findByStatus(status);
 }

 public ItemPerdido buscar(Long id){
  return repository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Item não encontrado"));
 }

 public ItemPerdido criar(ItemPerdido dados){
  dados.setId(null);dados.setStatus(StatusItem.PERDIDO);dados.setDescricaoDevolucao(null);return repository.save(dados);
 }

 public ItemPerdido editar(Long id,ItemPerdido dados){
  ItemPerdido atual=buscar(id);atual.setNomeItem(dados.getNomeItem());atual.setLocalEncontrado(dados.getLocalEncontrado());atual.setDataAchado(dados.getDataAchado());atual.setDescricaoDevolucao(dados.getDescricaoDevolucao());return repository.save(atual);
 }

 public void excluir(Long id){
  buscar(id);repo.deleteById(id);
 }
 public ItemPerdido atualizarStatus(Long id,StatusItem novo){
  ItemPerdido item=buscar(id);StatusItem anterior=item.getStatus();

  if(novo==null)throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Informe o status");

  if(anterior==StatusItem.DEVOLVIDO && novo!=StatusItem.DEVOLVIDO)throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Item já devolvido ao dono não pode ter o status alterado.");

  if(anterior!=novo && !(anterior==StatusItem.PERDIDO && novo==StatusItem.REIVINDICADO) && !(anterior==StatusItem.REIVINDICADO && novo==StatusItem.DEVOLVIDO))throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Transição inválida. Use PERDIDO → REIVINDICADO → DEVOLVIDO.");

  item.setStatus(novo);return repository.save(item);
 }
}
