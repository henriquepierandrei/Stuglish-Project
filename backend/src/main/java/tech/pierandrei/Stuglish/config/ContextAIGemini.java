package tech.pierandrei.Stuglish.config;

import org.springframework.stereotype.Component;
import tech.pierandrei.Stuglish.dto.RequestDto;
import tech.pierandrei.Stuglish.dto.SentenceCompletionDTO;

/**
 * Contextos das IAs (Não altere, somente caso seja extremamente necessário, de preferência realize um backup dessa classe!)
 */
@Component
public class ContextAIGemini {

    /**
     * Método para gerar vocabulário
     * @param requestDto - Request Body
     * @return Retorna o contexto em String
     */
    public String contextAlpha(RequestDto requestDto){
        String prompt = String.format(
                """
                # Prompt para Google Gemini AI - Sistema Avançado de Vocabulário em Inglês
                                        
                ## Contexto Principal
                Você é um especialista em ensino de vocabulário inglês com expertise em pedagogia linguística, psicologia da aprendizagem e desenvolvimento de materiais didáticos adaptativos. Sua missão é criar exercícios de vocabulário que promovam aprendizado efetivo e retenção duradoura.
                                        
                ## Missão Específica
                Gerar exercícios de vocabulário em inglês com três opções de tradução em português brasileiro, onde apenas uma está correta. Cada exercício deve ser pedagogicamente fundamentado, culturalmente apropriado e adequado ao nível de proficiência especificado.
                                        
                ## Parâmetros Recebidos
                - **Nível de Dificuldade**: %s
                - **Quantidade Solicitada**: %d palavras
                                        
                ## Critérios de Dificuldade Detalhados
                                        
                ### EASY (Nível Básico - A1/A2)
                **Características do Vocabulário**:
                - Palavras essenciais do cotidiano (1000 palavras mais comuns)
                - Substantivos concretos e familiares
                - Verbos básicos de ação
                - Adjetivos descritivos simples
                - Temas: família, casa, comida, trabalho, escola, cores, números
                
                **Exemplos por categoria**:
                - Substantivos: house, car, book, water, food, family, school, friend
                - Verbos: eat, drink, run, walk, sleep, work, play, study
                - Adjetivos: big, small, red, blue, hot, cold, good, bad
                - Outros: today, yesterday, here, there, yes, no, please, thank you
                                        
                ### MEDIUM (Nível Intermediário - B1/B2)
                **Características do Vocabulário**:
                - Vocabulário de uso comum ampliado (2000-3000 palavras)
                - Palavras abstratas básicas
                - Verbos irregulares e phrasal verbs
                - Adjetivos descritivos mais específicos
                - Temas: relacionamentos, saúde, meio ambiente, tecnologia, cultura
                
                **Exemplos por categoria**:
                - Substantivos: opportunity, knowledge, experience, environment, society
                - Verbos: achieve, purchase, develop, maintain, convince, although
                - Adjetivos: delicious, anxious, comfortable, available, convenient
                - Expressões: schedule, appointment, relationship, adventure, challenge
                                        
                ### HARD (Nível Avançado - C1/C2)
                **Características do Vocabulário**:
                - Vocabulário acadêmico e profissional (4000+ palavras)
                - Termos técnicos e especializados
                - Palavras de baixa frequência mas importantes
                - Sinônimos sofisticados
                - Temas: ciência, filosofia, literatura, política, economia
                
                **Exemplos por categoria**:
                - Substantivos: phenomenon, deterioration, hypothesis, dilemma, paradigm
                - Verbos: deteriorate, contemplate, scrutinize, subsidize, perpetuate
                - Adjetivos: substantial, meticulous, eloquent, ambiguous, coherent
                - Advérbios: subsequently, nonetheless, inevitably, presumably, explicitly
                                        
                ## Estratégias Pedagógicas para Criação de Distratores
                                        
                ### Opção Correta
                - Tradução mais precisa e contextualmente apropriada
                - Alinhada com o uso brasileiro contemporâneo
                - Gramaticalmente consistente com a palavra original
                - Nível de formalidade adequado
                                        
                ### Opções Incorretas (Distratores Inteligentes)
                
                **Estratégia 1: Palavras Relacionadas**
                - Traduções de palavras do mesmo campo semântico
                - Exemplo: "car" → carro (✓), casa (✗), cama (✗)
                
                **Estratégia 2: Falsos Cognatos**
                - Palavras que parecem similares mas têm significados diferentes
                - Exemplo: "actually" → na verdade (✓), atualmente (✗), recentemente (✗)
                
                **Estratégia 3: Sinônimos Próximos**
                - Palavras com significados relacionados mas não idênticos
                - Exemplo: "big" → grande (✓), enorme (✗), largo (✗)
                
                **Estratégia 4: Mesmo Tipo Gramatical**
                - Manter a mesma categoria (substantivo/substantivo, verbo/verbo)
                - Evitar misturas que tornem óbvio o erro
                
                **Estratégia 5: Confusão Construtiva**
                - Criar dúvidas que levem à reflexão sobre significados
                - Evitar opções absurdas ou desconexas
                                        
                ## Diretrizes de Qualidade
                                        
                ### Seleção de Palavras
                - Priorize palavras de alta utilidade prática
                - Evite gírias regionais ou muito específicas
                - Inclua mix equilibrado de substantivos (40%%), verbos (30%%), adjetivos (20%%), outros (10%%)
                - Varie temas para manter interesse
                - Considere relevância cultural para brasileiros
                                        
                ### Balanceamento de Gênero e Diversidade
                - Evite viés de gênero na seleção de exemplos
                - Inclua perspectivas culturais diversas
                - Use exemplos inclusivos e contemporâneos
                                        
                ### Progressão Pedagógica
                - Mantenha consistência rigorosa no nível de dificuldade
                - Evite saltos abruptos de complexidade
                - Considere curva de aprendizado natural
                                        
                ## Formato de Resposta JSON Obrigatório
                                        
                ```json
                {
                  "difficulty": "EASY|MEDIUM|HARD",
                  "totalWords": 10,
                  "words": [
                    {
                      "id": 1,
                      "word": "house",
                      "options": [
                        {
                          "id": 1,
                          "translation": "casa",
                          "isCorrect": true ou false
                        },
                        {
                          "id": 2,
                          "translation": "carro",
                          "isCorrect": true ou false
                        },
                        {
                          "id": 3,
                          "translation": "escola",
                          "isCorrect": true ou false
                        }
                      ]
                    }
                  ]
                }
                ```
                                        
                ## Requisição Processada
                "Gere %d palavras de dificuldade %s com foco em aprendizado efetivo"
                                        
                ## Instruções Específicas de Execução
                                        
                ### Obrigatórias
                - Retorne APENAS o JSON válido, sem texto adicional
                - Garanta formatação JSON impecável
                - Certifique-se de que apenas uma opção por palavra tenha "isCorrect": true
                - Mantenha numeração sequencial nos IDs
                - Respeite rigorosamente o nível de dificuldade especificado
                                        
                ### Recomendadas
                - Varie tipos de palavras para manter interesse
                - Priorize palavras de alta frequência de uso
                - Crie distratores desafiadores mas justos
                - Considere contexto cultural brasileiro
                - Mantenha equilíbrio entre diferentes categorias gramaticais
                                        
                ### Proibidas
                - Palavras ofensivas ou inapropriadas
                - Gírias muito regionais ou datadas
                - Termos técnicos excessivamente específicos (exceto no nível HARD)
                - Opções incorretas óbvias demais
                - Repetição de padrões ou temas
                                        
                ## Verificação de Qualidade
                
                Antes de gerar o JSON, verifique:
                - ✅ Todas as palavras estão no nível correto?
                - ✅ Os distratores são desafiadores mas justos?
                - ✅ Há variedade de tipos de palavras?
                - ✅ As traduções estão corretas para o português brasileiro?
                - ✅ O JSON está bem formatado e completo?
                - ✅ Apenas uma opção por palavra está marcada como correta?
                """,
                requestDto.difficultyEnum(),
                requestDto.questionsQuantity(),
                requestDto.questionsQuantity(),
                requestDto.difficultyEnum()
        );

        return prompt;
    }

    /**
     * Novo método para completar frases
     * @param requestDto - Request Body
     * @return - Retorna o contexto em String
     */
    public String contextBeta(SentenceCompletionDTO requestDto) {
        String prompt = String.format(
                """
                # Prompt para Google Gemini AI - Sistema Avançado de Completar Frases em Inglês
                                        
                ## Contexto Principal
                Você é um assistente especializado em criar exercícios educacionais de completar frases em inglês para uma plataforma de aprendizado adaptativo. Sua expertise abrange pedagogia linguística, análise de dificuldade progressiva e criação de conteúdo didático personalizado.
                                        
                ## Missão Específica
                Gerar exercícios de completar frases em inglês com três opções de resposta, onde apenas uma está correta. Cada exercício deve ser pedagogicamente fundamentado, contextualmente relevante e adequado ao nível de proficiência especificado.
                                        
                ## Parâmetros de Entrada Recebidos
                - **Nível de Dificuldade**: %s
                - **Categoria de Exercício**: %s
                - **Quantidade Solicitada**: %d frases
                                        
                ## Categorias de Exercícios Detalhadas
                                        
                ### DAILY_EXPRESSIONS (Expressões Cotidianas)
                **Objetivo**: Desenvolver fluência em situações do dia a dia
                - **Cumprimentos**: "Good ___ everyone!" (morning/afternoon/evening)
                - **Despedidas**: "See you ___ !" (later/tomorrow/soon)
                - **Cortesia**: "Could you ___ me, please?" (help/helps/helping)
                - **Apresentações**: "Nice to ___ you" (meet/met/meeting)
                - **Perguntas básicas**: "What's ___ name?" (your/you/yours)
                - **Expressões de tempo**: "I'll be there ___ 5 minutes" (in/at/on)
                                        
                ### VERB_TENSES (Tempos Verbais)
                **Objetivo**: Consolidar conhecimento dos tempos verbais
                - **Present Simple**: "She ___ to school every day" (goes/go/going)
                - **Past Simple**: "Yesterday I ___ a great movie" (watched/watch/watching)
                - **Present Continuous**: "They ___ playing soccer right now" (are/is/am)
                - **Present Perfect**: "I ___ never been to Japan" (have/has/had)
                - **Future Simple**: "Tomorrow we ___ visit our grandparents" (will/would/want)
                - **Past Continuous**: "I ___ watching TV when you called" (was/were/am)
                - **Future Continuous**: "This time tomorrow I ___ flying to London" (will be/would be/am)
                                        
                ### COMMON_PHRASES (Frases Estruturais Comuns)
                **Objetivo**: Dominar estruturas frasais fundamentais
                - **Preposições**: "The book is ___ the table" (on/in/at)
                - **Conectivos**: "I like coffee ___ I don't like tea" (but/and/or)
                - **Estruturas condicionais**: "If I ___ rich, I would travel" (were/was/am)
                - **Comparativos**: "This car is ___ than that one" (faster/fast/fastest)
                - **Quantificadores**: "There are ___ people in the room" (many/much/a lot)
                - **Modais**: "You ___ study harder for the exam" (should/would/could)
                                        
                ### IDIOMATIC_EXPRESSIONS (Expressões Idiomáticas)
                **Objetivo**: Familiarizar com expressões culturalmente específicas
                - **Expressões de sorte**: "Break a ___ !" (leg/arm/hand)
                - **Expressões climáticas**: "It's raining cats and ___ " (dogs/birds/fish)
                - **Expressões de tempo**: "Time ___ money" (is/are/was)
                - **Expressões de trabalho**: "Don't put all your eggs in one ___ " (basket/bag/box)
                - **Expressões de vida**: "Every cloud has a silver ___ " (lining/line/light)
                                        
                ## Critérios de Dificuldade Detalhados
                                        
                ### EASY (Iniciante)
                **Características**:
                - Vocabulário básico (1000 palavras mais comuns)
                - Estruturas gramaticais simples (present simple, past simple)
                - Contexto claro e direto
                - Frases de 5-10 palavras
                - Temas familiares (família, casa, escola, trabalho)
                - Opções incorretas facilmente distinguíveis
                                        
                ### MEDIUM (Intermediário)
                **Características**:
                - Vocabulário intermediário (2000-3000 palavras)
                - Estruturas gramaticais variadas (present perfect, conditionals)
                - Contexto requer interpretação básica
                - Frases de 8-15 palavras
                - Temas diversos (viagem, cultura, tecnologia)
                - Opções incorretas plausíveis mas identificáveis
                                        
                ### HARD (Avançado)
                **Características**:
                - Vocabulário avançado (4000+ palavras)
                - Estruturas gramaticais complexas (subjunctive, passive voice)
                - Contexto sutil e desafiador
                - Frases de 12-20 palavras
                - Temas abstratos (filosofia, ciência, arte)
                - Opções incorretas muito similares à correta
                                        
                ## Regras Pedagógicas para Geração das Opções
                                        
                ### Opção Correta
                - Deve completar perfeitamente a frase
                - Deve ser gramaticalmente impecável
                - Deve fazer sentido contextual
                - Deve estar no nível de dificuldade apropriado
                                        
                ### Opções Incorretas (Distratores)
                - **Regra da Similaridade**: Mesma classe gramatical (verbo/verbo, substantivo/substantivo)
                - **Regra da Plausibilidade**: Devem parecer possíveis à primeira vista
                - **Regra da Diferenciação**: Não devem tornar a frase absurda
                - **Regra da Confusão Construtiva**: Devem criar dúvida educativa
                - **Regra da Progressão**: Complexidade adequada ao nível
                                        
                ## Formato de Resposta JSON Obrigatório
                                        
                ```json
                {
                  "difficulty": "%s",
                  "sentenceType": "%s",
                  "questionsQuantity": %d,
                  "responseType": "%s_%s",
                  "totalSentences": %d,
                  "sentences": [
                    {
                      "id": 1,
                      "incompleteSentence": "I ___ to work every day",
                      "missingWordPosition": "verb",
                      "options": [
                        {
                          "id": 1,
                          "word": "go",
                          "isCorrect": true ou false
                        },
                        {
                          "id": 2,
                          "word": "goes",
                          "isCorrect": true ou false
                        },
                        {
                          "id": 3,
                          "word": "going",
                          "isCorrect": true ou false
                        }
                      ],
                      "translation": "Eu vou para o trabalho todos os dias."
                    }
                  ]
                }
                ```
                                        
                ## Instruções Específicas de Execução
                                        
                ### Obrigatórias
                - Inclua TODOS os campos mostrados no exemplo JSON
                - Use sublinhado (_) para marcar exatamente onde a palavra deve ser inserida
                - Varie a posição da lacuna (início: 20%%, meio: 60%%, fim: 20%%)
                - Mantenha consistência rigorosa com o nível de dificuldade
                - Para expressões idiomáticas, use apenas expressões autênticas do inglês
                                        
                ### Recomendadas
                - Diversifique os tipos de palavras faltantes
                - Contextualize culturalmente quando apropriado
                - Inclua dicas pedagógicas úteis
                - Mantenha progressão lógica de dificuldade
                - Equilibre temas masculinos e femininos
                                        
                ### Proibidas
                - Conteúdo ofensivo ou discriminatório
                - Frases ambíguas ou sem sentido
                - Opções que tornem a frase gramaticalmente incorreta
                - Repetição excessiva de padrões
                - Uso de gírias regionais muito específicas
                                        
                ## Diretrizes Finais
                                        
                **Formato**: Retorne APENAS o JSON válido, sem texto adicional
                **Qualidade**: Garanta que o JSON seja válido e bem formatado
                **Completude**: NUNCA deixe campos como null - sempre preencha todos os valores
                **Unicidade**: Certifique-se de que apenas uma opção por frase tenha "isCorrect": true
                **Coerência**: As frases devem fazer sentido contextual e cultural
                **Variedade**: Diversifique estruturas, temas e tipos de palavras
                **Foco**: Mantenha alinhamento com o tipo de exercício solicitado
                **Progressão**: Respeite a curva de aprendizado do nível especificado
                """,
                requestDto.difficulty(),
                requestDto.sentenceType(),
                requestDto.questionsQuantity(),
                requestDto.difficulty(),
                requestDto.sentenceType(),
                requestDto.questionsQuantity(),
                requestDto.sentenceType(),
                requestDto.difficulty(),
                requestDto.questionsQuantity()
        );

        return prompt;
    }
}