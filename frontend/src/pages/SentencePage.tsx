import { useState } from 'react';
import axios from 'axios';
import './SentencePage.css';
import { FaCheck } from 'react-icons/fa';
import { FaX } from 'react-icons/fa6';
import Message from '../components/message/Message';
import logo from '../assets/logo.png'; // Importando o logo
import API_URL from '../api/api';
import audio from '../assets/audio.mp3'; // Importando o áudio

interface Option {
  id: number;
  word: string;
  isCorrect: boolean;
  explanation: string | null;
}

interface Sentence {
  id: number;
  incompleteSentence: string;
  missingWordPosition: string;
  options: Option[];
  translation: string;
}

interface ApiResponse {
  sentences: Sentence[];
}

const SentencePage: React.FC = () => {
  const [difficulty, setDifficulty] = useState('MEDIUM');
  const [sentenceType, setSentenceType] = useState('COMMON_PHRASES');
  const [questionsQuantity, setQuestionsQuantity] = useState(3);
  const [showCorrectAnswer, setCorrectAnswer] = useState(false);
  const [sentences, setSentences] = useState<Sentence[]>([]);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState<string | null>(null);


  const fetchSentences = async () => {
    if (questionsQuantity < 1 || questionsQuantity > 20) {
      setError("Deve conter de 1 a 20 frases");
      setSentences([]);
      return;
    }

    setLoading(true);
    setError(null);
    try {
      const { data } = await axios.post<ApiResponse>(
        API_URL + 'exercises/sentence/generate',
        { difficulty, sentenceType, questionsQuantity }
      );
      setSentences(data.sentences || []);
      const audioElement = new Audio(audio);
      audioElement.play(); // Reproduz o áudio ao carregar as sentenças
    } catch (error) {
      setError("Erro ao carregar os dados. Tente novamente mais tarde.");
      setSentences([]);
      console.error('Erro:', error);
    } finally {
      setLoading(false);
    }
  };

  // Controle de visibilidade do gabarito
  const [showAnswers, setShowAnswers] = useState<{ [key: number]: boolean }>({});

  const toggleAnswer = (sentenceId: number) => {
    setShowAnswers((prev) => ({
      ...prev,
      [sentenceId]: !prev[sentenceId],
    }));
  };

  return (
    <div className="container">
      {error && (
        <Message
          message={error}
          onClose={() => setError(null)} // fechar o erro limpa o estado

        />
      )}

      <img
        src={logo}
        alt="Logo"
        className="logo-image"
      />

      <h1 className="title">Gerador de Frases em Inglês</h1>

      <select
        value={difficulty}
        onChange={(e) => setDifficulty(e.target.value)}
        className="select-field"
      >
        <option value="EASY">Fácil</option>
        <option value="MEDIUM">Médio</option>
        <option value="HARD">Difícil</option>
      </select>

      <select
        value={sentenceType}
        onChange={(e) => setSentenceType(e.target.value)}
        className="select-field"
      >
        <option value="COMMON_PHRASES">Frases Comuns</option>
        <option value="VERB_TENSES">Tempos Verbais</option>
        <option value="DAILY_EXPRESSIONS">Expressões Cotidianas</option>
        <option value="IDIOMATIC_EXPRESSIONS">Expressões Idiomáticas</option>
      </select>


      <input
        type="number"
        min={1}
        max={20}
        value={questionsQuantity}
        onChange={(e) => setQuestionsQuantity(Number(e.target.value))}
        className="input-field"
      />

    
      <br /><br />
      <button
        onClick={fetchSentences}
        disabled={loading}
        className="btn-primary"
      >
        {loading ? <div className='spinner'></div> : 'Gerar Sentenças'}
      </button>

      {sentences.map((sentence) => (
        <div key={sentence.id} className="card">
          <p>{sentence.incompleteSentence}</p>

          <button
            onClick={() => toggleAnswer(sentence.id)}
            className="btn-secondary"
          >
            {showAnswers[sentence.id] ? 'Ocultar Gabarito' : 'Mostrar Gabarito'}
          </button>

          {showAnswers[sentence.id] && (
            <div className="gabarito">
              {sentence.options.map((opt) => (
                <div key={opt.id} style={{ display: 'flex', alignItems: 'center', gap: '8px' }}>
                  <input
                    type="checkbox"
                    onChange={(e) => {
                      e.target.checked && opt.isCorrect;
                    }}
                    disabled={showCorrectAnswer}
                    className='checkbox-custom'

                  />
                  <span
                    className={
                      showCorrectAnswer
                        ? opt.isCorrect
                          ? 'option-correct'
                          : 'option-incorrect'
                        : 'option-default'
                    }
                  >
                    {showCorrectAnswer ? (
                      <>
                        {opt.isCorrect ? <FaCheck /> : <FaX />} {opt.word}
                      </>
                    ) : (
                      opt.word
                    )}
                  </span>
                </div>
              ))}
              <p className="translation">{sentence.translation}</p>
            </div>
          )}
        </div>
      ))}
      <br /><br /><div style={{ display: 'flex', alignItems: 'center', gap: '8px', backgroundColor: '#1d1e1f', padding: '10px', borderRadius: '5px' }}>
        <input
          type="checkbox"
          checked={showCorrectAnswer}
          onChange={(e) => setCorrectAnswer(e.target.checked)}
          className="checkbox-custom"
        />
        <label htmlFor="" style={{ color: "#d1d5db" }}>Mostrar Respostas</label>
      </div>
    </div>
  );
};

export default SentencePage;
