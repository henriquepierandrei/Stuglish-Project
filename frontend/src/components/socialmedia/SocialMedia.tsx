import React from 'react'
import './SocialMedia.css';
import { FaGithub, FaLinkedin } from 'react-icons/fa';
import Lottie from 'lottie-react';
import flagAnimation from '../../animations/flag.json'; // Importando a animação Lottie

const SocialMedia: React.FC = () => {
  return (
    <footer className="social-media">
      <a href="https://github.com/henriquepierandrei/Stuglish-Project/" className='github-link' target="_blank" rel="noopener noreferrer">
        <FaGithub className="footer-icon" />
      </a>
      <a href="https://www.linkedin.com/in/henrique-pierandrei/" className='linkedin-link' target="_blank" rel="noopener noreferrer">
        <FaLinkedin className="footer-icon" />
      </a>
      <Lottie
          animationData={flagAnimation}
          loop={false}
          autoplay={true}
          className="footer-icon"
          style={{marginBottom: "5px"}}
        />

    </footer>
  );
};

export default SocialMedia;
