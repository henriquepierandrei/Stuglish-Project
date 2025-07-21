import React from 'react';
import { Link, useLocation } from 'react-router-dom';
import './NavBar.css';
import SocialMedia from '../socialmedia/SocialMedia';


const NavBar: React.FC = () => {
  const location = useLocation();

  return (
    <div className="navbar-container">
      <nav className="navbar">
        <ul className="navbar-list">
          <li className="navbar-item">
            <Link
              to="/completar"
              className={`navbar-link ${location.pathname === '/completar' ? 'active' : ''}`}
            >
              Completar
            </Link>
          </li>
          <li className="navbar-item">
            <Link
              to="/vocabulario"
              className={`navbar-link ${location.pathname === '/vocabulario' ? 'active' : ''}`}
            >
              Vocabulário
            </Link>
          </li>
        </ul>
      </nav>
      <SocialMedia />
    </div>
  );
};

export default NavBar;