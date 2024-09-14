import React from 'react';
// import './Button.css';

function Button({ name, onClick, type }) {
  return (
    <button
      className={`button ${type}`}
      onClick={() => onClick(name)}
      aria-label={`Botón ${name}`}
      tabIndex="0"
    >
      {name}
    </button>
  );
}

export default Button;
