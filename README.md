![Demo](./assets/stuglish-banner.gif)
[![Skills utilizadas](https://skillicons.dev/icons?i=java,react,html,css,ai,typescript,spring,vite&theme=dark)](https://skillicons.dev)


Uma aplicação completa para geração de exercícios de vocabulário e completar frases, desenvolvida com Spring Boot e React.

## 📋 Funcionalidades

- **Geração de Vocabulário**: Criação automática de exercícios de vocabulário
- **Completar Frases**: Geração de exercícios de completar frases
- **Interface Responsiva**: Frontend moderno e intuitivo

## 📋 Pré-requisitos

Antes de começar, certifique-se de ter instalado:

- **Java 21+** - [Download aqui](https://adoptium.net/)
- **Maven 3.6+** - [Download aqui](https://maven.apache.org/download.cgi)
- **Node.js 16+** - [Download aqui](https://nodejs.org/)
- **npm** ou **yarn** - Gerenciador de pacotes

## 🛠️ Instalação e Configuração

### Backend (Spring Boot)

1. **Clone o repositório**
   ```bash
   git clone https://github.com/henriquepierandrei/Stuglish-Project
   cd Stuglish-Project
   ```

2. **Crie um arquivo .env, de acordo com as variáveis incluídas no properties**
   

3. **Execute a aplicação**
   ```bash
   # Usando Maven
   mvn spring-boot:run
    ```
   
4. **Verificar se está funcionando**

   A aplicação estará disponível em: `http://localhost:8080`

### Frontend (React + Vite)

1. **Navegue para a pasta do frontend**
   ```bash
   cd frontend
    ```

2. **Instale as dependências**
   ```bash
   npm install
   # ou
   yarn install
   ```

4. **Execute o servidor de desenvolvimento**
   ```bash
   npm run dev
   ```

5. **Acesse a aplicação**

   O frontend estará disponível em: `http://localhost:5173`

## 📡 Endpoints da API

### Geração de Vocabulário
```http
POST /vocabulary/generate
Content-Type: application/json

{
    "difficulty": "HARD", -> [EASY, MEDIUM, HARD]
    "questions_quantity": 2 -> [0 < quantity <= 20]
}
```

### Geração de Frases
```http
POST /sentence/generate
Content-Type: application/json

{
  "difficulty": "MEDIUM",
  "sentenceType": "COMMON_PHRASES", -> [DAILY_EXPRESSIONS, VERB_TENSES, COMMON_PHRASES, IDIOMATIC_EXPRESSIONS]
  "questionsQuantity": 3
}
```
## 🤝 Contribuição

1. Fork o projeto
2. Crie uma branch para sua feature (`git checkout -b feature/MinhaFeature`)
3. Commit suas mudanças (`git commit -m 'Add some MinhaFeature'`)
4. Push para a branch (`git push origin feature/MinhaFeature`)
5. Abra um Pull Request


⭐ Se este projeto te ajudou, considere dar uma estrela no repositório!