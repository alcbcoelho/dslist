# DSList
## Sobre o projeto

**Link para implantação:** <a href="https://dslist-production-367e.up.railway.app/" target="_blank">https://dslist-production-367e.up.railway.app/</a>

Back-end com arquitetura em camadas para um sistema de listagem e exibição de jogos, feito com Spring Boot durante o Intensivão Java Spring da <a href="https://devsuperior.com/" target="_blank">DevSuperior</a>.

## Modelo conceitual

![image](https://github.com/user-attachments/assets/dc05ef81-0ca7-4f6a-91c7-52c5863b8c27)

## Endpoints
| Endpoint | Método HTTP envolvido | Descrição |
| - | - | - |
| `/games` | GET | Exibição de todos os jogos. |
| `/games/{id}` | GET | Exibição de jogo por ID. |
| `/lists` | GET | Exibição de todas as listas de jogos. |
| `/lists/{id}/games` | GET | Exibição dos jogos que compõem a lista com o ID especificado. |
| `/lists/{id}/replacement` | POST | Operação de troca de ordem dos elementos de uma lista. Deve ser especificado na requisição um corpo em JSON com o formato especificado abaixo. |

### /lists/{id}/replacement
```
{
  "originIndex": {Position1},
  "destinationIndex": {Position2}
}
```
- `Position1`: `Integer`: posição inicial do item na lista
- `Position2`: `Integer`: posição de destino do item na lista
