import React from 'react'
import './SocialMedia.css';
import { FaGithub, FaLinkedin } from 'react-icons/fa';

const SocialMedia: React.FC = () => {
  return (
    <footer className="social-media">
      <a href="https://github.com/" className='github-link' target="_blank" rel="noopener noreferrer">
        <FaGithub className="footer-icon" />
      </a>
      <a href="https://www.linkedin.com/in/henrique-pierandrei/" className='linkedin-link' target="_blank" rel="noopener noreferrer">
        <FaLinkedin className="footer-icon" />
      </a>
      
    </footer>
  );
};

export default SocialMedia;
