import React, { useState } from 'react';
import Display from './Display';
import ButtonPanel from './ButtonPanel';
import './App.css';
import axios from 'axios';
function App() {
  const [expression, setExpression] = useState('');
  const [result, setResult] = useState('0');
  const [loading, setLoading] = useState(false);

  const handleClick = (buttonName) => {
    if (buttonName === '=') {
      calculateResult();
    } else if (buttonName === 'C') {
      reset();
    } else if (buttonName === '←') {
      backspace();
    } else {
      setExpression((prev) => prev + buttonName);
    }
  };

  const calculateResult = async () => {
    try {
      setLoading(true);

      // Hacemos la solicitud a la función Lambda
      const response = await axios.post(
        'https://obgirtk09l.execute-api.us-east-1.amazonaws.com/dev/calculate',
        {
          expression: expression,
        }
      );

      setResult(response.data.result.toString());
    } catch (error) {
      console.error('Error calculating result:', error);
      setResult('Error');
    } finally {
      setLoading(false);
    }
  };

  const reset = () => {
    setExpression('');
    setResult('0');
  };

  const backspace = () => {
    setExpression((prev) => prev.slice(0, -1));
  };

  return (
    <div className="calculator">
      <Display
        expression={expression}
        result={loading ? 'Calculando...' : result}
      />
      <ButtonPanel onClick={handleClick} />
    </div>
  );
}

export default App;
