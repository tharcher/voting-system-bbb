// src/App.js
import React from 'react';
import "./App.css"
import Rotas from './rota';

function App() {
        return (
            <div className="fundo-container {{fundo}}">
                    <div className="participantes-container">
                        <Rotas/>
                    </div>
            </div>
        );
}

export default App;
