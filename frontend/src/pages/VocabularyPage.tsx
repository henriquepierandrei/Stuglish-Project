import { useState } from 'react';
import axios from 'axios';
import './SentencePage.css';
import logo from '../assets/logo.png'; // Importando o logo
import { FaCheck } from 'react-icons/fa';
import { FaX } from 'react-icons/fa6';
import Message from '../components/message/Message';
import API_URL from '../api/api';
import audio from '../assets/audio.mp3'; // Importando o áudio


interface Option {
    id: number;
    translation: string;
    isCorrect: boolean;
}

interface Word {
    id: number;
    word: string;
    options: Option[];
}

interface ApiResponse {
    difficulty: string;
    totalWords: number;
    words: Word[];
}

const VocabularyPage: React.FC = () => {
    const [difficulty, setDifficulty] = useState('MEDIUM');
    const [questionsQuantity, setQuestionsQuantity] = useState(3);
    const [showCorrectAnswer, setCorrectAnswer] = useState(false);
    const [error, setError] = useState<string | null>(null);
    const [words, setWords] = useState<Word[]>([]);
    const [loading, setLoading] = useState(false);

    const [showAnswers, setShowAnswers] = useState<{ [key: number]: boolean }>({});

    const fetchVocabulary = async () => {
        if (questionsQuantity < 1 || questionsQuantity > 20) {
            setError("Deve conter de 1 a 20 palavras.");
            setWords([]);
            return;
        }
        setLoading(true);
        try {
            const { data } = await axios.post<ApiResponse>(
                API_URL + 'exercises/vocabulary/generate',
                {
                    difficulty,
                    questions_quantity: questionsQuantity
                }
            );
            setWords(data.words || []);
            const audioElement = new Audio(audio);
            audioElement.play(); // Reproduz o áudio ao carregar as sentenças
        } catch (error) {
            setError("Erro ao carregar os dados. Tente novamente mais tarde.");

            console.error('Erro:', error);
        } finally {
            setLoading(false);
        }
    };

    const toggleAnswer = (wordId: number) => {
        setShowAnswers((prev) => ({
            ...prev,
            [wordId]: !prev[wordId],
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
            <img src={logo} alt="" className='logo-image' />

            <h1 className="title">Treinador de Vocabulário</h1>

            <select
                value={difficulty}
                onChange={(e) => setDifficulty(e.target.value)}
                className="select-field"
            >
                <option value="EASY">Fácil</option>
                <option value="MEDIUM">Médio</option>
                <option value="HARD">Difícil</option>
            </select>

            <input
                type="number"
                min={1}
                max={10}
                value={questionsQuantity}
                onChange={(e) => setQuestionsQuantity(Number(e.target.value))}
                className="input-field"
            />



            <button
                onClick={fetchVocabulary}
                disabled={loading}
                className="btn-primary"
            >
                {loading ? <div className='spinner'></div> : 'Gerar Palavras'}
            </button>

            {words.map((word) => (
                <div key={word.id} className="card">
                    <p className="word">{word.word}</p>

                    <button
                        onClick={() => toggleAnswer(word.id)}
                        className="btn-secondary"
                    >
                        {showAnswers[word.id] ? 'Ocultar Traduções' : 'Mostrar Traduções'}
                    </button>

                    {showAnswers[word.id] && (
                        <div className="gabarito">

                            {word.options.map((opt) => (
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
                                                {opt.isCorrect ? <FaCheck /> : <FaX />} {opt.translation}
                                            </>
                                        ) : (
                                            opt.translation
                                        )}
                                    </span>
                                </div>
                            ))}

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

export default VocabularyPage;
