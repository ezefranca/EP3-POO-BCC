### EP3-POO-BCC

EP3 da disciplina de Linguaguem de Programação Orientada a Objetos

### Declaração anti-plágio

```
O GRUPO DECLARA SEREM OS ÚNICOS AUTORES E RESPONSÁVEIS POR ESSE PROGRAMA. TODAS AS PARTES ORIGINAIS DESSE EXERCÍCIO PROGRAMA (EP) FORAM DESENVOLVIDAS E IMPLEMENTADAS POR NÓS SEGUINDO AS INSTRUÇÕES DESSE EP E QUE PORTANTO NÃO CONSTITUEM PLÁGIO. 

DECLARAMOS TAMBÉM QUE SOMOS RESPONSÁVEIS POR TODAS AS CÓPIAS DESSE PROGRAMA E QUE NÃO DISTRIBUIMOS OU FACILITAMOS A SUA DISTRIBUIÇÃO. ESTAMOS CIENTES QUE OS CASOS DE PLÁGIO SÃO PUNIDOS COM NOTA ZERO OU REPROVAÇÃO DIRETA NA DISCIPLINA.
```

### Normas do Aluno

```
O Centro Universitário Senac considera uma infração disciplinar inadmissível qualquer forma de plágio. Na ocorrência de tais casos, recomenda-se a reprovação do aluno na disciplina, e que o ocorrido seja relatado à Coordenação de Graduação para as devidas providências.
```


### Desenvolvedores

[Ezequiel França](https://github.com/ezefranca) | [Paulo Henrique](https://github.com/paulo-http)

### Instruções

### Como posso rodar o projeto localmente?

[![NetBeans](http://www.revista.espiritolivre.org/wp-content/uploads/2013/10/netbeans.png)](https://netbeans.org/)

Primeiramente é necessário que tenha instalado o Netbeans em seu computador, recomendado em ambiente windows.

Após a instalação, suponhamos que já tenha os conhecimentos necessários com a IDE, deve-se abrir o projeto e executa-lo.

Cada usuário possui um login e senha. Existem alguns usuários previamente cadastrados. Para fins de testes temos os seguintes usuários:

<table class="js-csv-data csv-data">
      <thead>
        <tr id="LC1" class="line">
          <td class="blob-line-nums csv-row-num">
            <span id="L1" rel="#L1>">1</span>
          </td>
          <th>Type</th>
          <th>User</th>
          <th>Password</th>
          <th>Name</th>
        </tr>
      </thead>
      <tbody>
        <tr id="LC2" class="line">
          <td class="blob-line-nums csv-row-num">
            <span id="L2">2</span>
          </td>
          <td>Medico</td>
          <td>takeo1</td>
          <td>1</td>
          <td>Medico Takeo</td>
        </tr>
        <tr id="LC3" class="line">
          <td class="blob-line-nums csv-row-num">
            <span id="L3">3</span>
          </td>
          <td>Medico</td>
          <td>ueda1</td>
          <td>1</td>
          <td>Medico Ueda</td>
        </tr>
        <tr id="LC4" class="line">
          <td class="blob-line-nums csv-row-num">
            <span id="L4">4</span>
          </td>
          <td>Dentista</td>
          <td>takeo2</td>
          <td>2</td>
          <td>Dentista Takeo</td>
        </tr>
        <tr id="LC5" class="line">
          <td class="blob-line-nums csv-row-num">
            <span id="L5">5</span>
          </td>
          <td>Dentista</td>
          <td>ueda2</td>
          <td>2</td>
          <td>Dentista Ueda</td>
        </tr>
        <tr id="LC6" class="line">
          <td class="blob-line-nums csv-row-num">
            <span id="L6">6</span>
          </td>
          <td>Enfermeiro</td>
          <td>takeo3</td>
          <td>3</td>
          <td>Enfermeiro Takeo</td>
        </tr>
        <tr id="LC7" class="line">
          <td class="blob-line-nums csv-row-num">
            <span id="L7">7</span>
          </td>
          <td>Enfermeiro</td>
          <td>ueda3</td>
          <td>3</td>
          <td>Enfermeiro Ueda</td>
        </tr>
        <tr id="LC8" class="line">
          <td class="blob-line-nums csv-row-num">
            <span id="L8">8</span>
          </td>
          <td>Paciente</td>
          <td>takeo4</td>
          <td>4</td>
          <td>Paciente Takeo</td>
        </tr>
        <tr id="LC9" class="line">
          <td class="blob-line-nums csv-row-num">
            <span id="L9">9</span>
          </td>
          <td>Paciente</td>
          <td>ueda4</td>
          <td>4</td>
          <td>Paciente Ueda</td>
        </tr>
      </tbody>
    </table>

#### Login Paciente

Fazendo o login com um paciente por exemplo, podemos agendar consultas e ver o portuário. Digamos que escolha marcar com um médicos, todos médicos serão listados, basta escolher uma data e horário.

Se o horário estiver ocupado o sistema emite um alerta, se o horário estiver disponível, o sistema marca a consulta.

#### Login Medico

Após o login o médico pode ver se o paciente tem consulta marcada com ele, pode ver o histórico de enfermaria, o histórico de consultas e o histórico de questionários médicos.

Se o paciente tiver consulta marcada com este médico, é liberado o acesso ao preenchimento do questionário.

#### Login Dentista

Após o login o dentista pode ver os pacientes e marcar que operação foi feita, obturação ou limpeza, esta operação será armazenada e pode ser vista no protuário.

#### Login Enfermeiro

Após o login o enfermeiro pode ver os pacientes e CASO ESTE PACIENTE TENHA CONSULTA MARCADA, é liberado o preenchimento de informações adicionais, se o paciente não tiver consultas marcadas, não será liberado.


