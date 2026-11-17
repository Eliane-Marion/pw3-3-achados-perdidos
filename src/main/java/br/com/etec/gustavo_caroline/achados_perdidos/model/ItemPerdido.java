package br.com.etec.achadosperdidos.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
@Entity @Table(name="itens_perdidos")

public class ItemPerdido {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
  @NotBlank private String nomeItem;
  @NotBlank private String localEncontrado;
  @NotNull private LocalDate dataAchado;

  @Enumerated(EnumType.STRING)
  @Column(nullable=false)
  private StatusItem status = StatusItem.PERDIDO;

  @Column(length=500)
  private String descricaoDevolucao;
  public Long getId(){
   return id;
  }
  public void setId(Long v){
   id=v;
  }
  public String getNomeItem(){
   return nomeItem;
  }
  public void setNomeItem(String v){
   nomeItem=v;
  }
  public String getLocalEncontrado(){
   return localEncontrado;
  }
 public void setLocalEncontrado(String v){
   localEncontrado=v;
  }
  public LocalDate getDataAchado(){
   return dataAchado;
  }
  public void setDataAchado(LocalDate v){
   dataAchado=v;
  }
  public StatusItem getStatus(){
   return status;
  }
  public void setStatus(StatusItem v){
   status=v;
  }
  public String getDescricaoDevolucao(){
   return descricaoDevolucao;
  }
  public void setDescricaoDevolucao(String v){
   descricaoDevolucao=v;
  }
}
