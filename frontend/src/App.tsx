import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
import NavBar from './components/navbar/NavBar';
import SentencePage from './pages/SentencePage';
import VocabularyPage from './pages/VocabularyPage';
import Body from './components/body/Body';

function App() {
  return (
    <Router>
      <Body />
      <NavBar />
      <Routes>
        <Route path="/completar" element={<SentencePage />} />
        <Route path="/vocabulario" element={<VocabularyPage />} />
        <Route path="*" element={<Navigate to="/vocabulario" />} />
      </Routes>
      
    </Router>
  );
}

export default App;
