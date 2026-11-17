package br.com.etec.achadosperdidos.controller;
import br.com.etec.achadosperdidos.dto.AtualizarStatusRequest;
import br.com.etec.achadosperdidos.model.*;
import br.com.etec.achadosperdidos.service.ItemPerdidoService;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/itens") @CrossOrigin(origins="http://localhost:4200")
public class ItemPerdidoController {
 private final ItemPerdidoService service;

 public ItemPerdidoController(ItemPerdidoService service){this.service=service;}

 @GetMapping public List<ItemPerdido>
 listar(@RequestParam(required=false) StatusItem status){
  return service.listar(status);
 }
 @GetMapping("/{id}")
 public ItemPerdido buscar(@PathVariable Long id){
  return service.buscar(id);
 }
 @PostMapping
 public ResponseEntity<ItemPerdido> criar(@Valid @RequestBody ItemPerdido item){
  return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(item));
 }
 @PutMapping("/{id}")
 public ItemPerdido editar(@PathVariable Long id,@Valid @RequestBody ItemPerdido item){
  return service.editar(id,item);
 }
 @DeleteMapping("/{id}")
 public ResponseEntity<Void> excluir(@PathVariable Long id){
  service.excluir(id);return ResponseEntity.noContent().build();
 }
 @PatchMapping("/{id}/status")
 public ItemPerdido status(@PathVariable Long id,@Valid @RequestBody AtualizarStatusRequest req){
  return service.atualizarStatus(id,req.status());
 }
}
