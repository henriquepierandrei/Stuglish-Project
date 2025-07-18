import React from 'react';
import './Message.css';
import { FaXmark } from 'react-icons/fa6';


interface MessageProps {
  message: string;
  onClose?: () => void;
}


const Message: React.FC<MessageProps> = ({ message, onClose }) => {
  return (
    <div className='message-overlay'>
      <div className="message-box">
      {message}
      {onClose && (
        <button className="message-close-btn" onClick={onClose}>
          <FaXmark className="message-close-icon" />
        </button>
      )}
    </div>
    </div>
  );
};


export default Message;
