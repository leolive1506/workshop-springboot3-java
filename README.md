# component registration
- quando tem obj que pode ser injetado pelo mecanismo de injeção de depencia do spring, a classe tem qeu estar registrada no mecanismo de injeção
- formas: @Service, @Component, @Repository

# Lazy loading
- para ter comportamento lazy loading adicionar @JsonIgnore no relacionamento

# service
- faz a regra de negocio do app para desacoplar a lógica dos controllers

# PathVariable x RequestBody
- PathVariable
  - pega o path variavel da url 
  - /users/{id} -> no caso seria id
- RequestBody
  - request json enviado na requisição

# @ControllerAdvice
- intercepta exceções que acontecerem para que esse obj possa executar um possível tratamento
# Pesquisar
- ResponseEntity
- Serializable
- ControllerAdvice