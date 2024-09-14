import React from 'react';
import Button from './Button';
// import './ButtonPanel.css';

function ButtonPanel({ onClick }) {
  const buttons = [
    ['C', '←', '/'],
    ['7', '8', '9', '×'],
    ['4', '5', '6', '−'],
    ['1', '2', '3', '+'],
    ['0', '.', '='],
  ];

  return (
    <div className="button-panel">
      {buttons.map((row, rowIndex) => (
        <div key={rowIndex} className="button-row">
          {row.map((btn) => (
            <Button
              key={btn}
              name={btn}
              onClick={onClick}
              type={btn === '0' ? 'zero' : isNaN(btn) ? 'operator' : 'number'}
            />
          ))}
        </div>
      ))}
    </div>
  );
}

export default ButtonPanel;
