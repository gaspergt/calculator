import React from 'react';
// import './Display.css';

function Display({ expression, result }) {
  return (
    <div className="display">
      <div className="expression">{expression}</div>
      <div className="result">
        {result === 'Calculando...' ? <div className="spinner"></div> : result}
      </div>
    </div>
  );
}

export default Display;
