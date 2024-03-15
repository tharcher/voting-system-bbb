import React from 'react';
import './conclusao.css'; // Importando o arquivo de estilos CSS
import { useNavigate  } from 'react-router-dom';

export default function ConclusaoProcessoVotacao() {
    let navigate = useNavigate();


    async function handleVoltar () {
        navigate("/")
    }


    return (
        <div className="container">
            <h1>Processo de Votação Concluído</h1>
            <div className="conclusion-message">
                O processo de votação foi concluído com sucesso. Obrigado por participar!
            </div>
            <div className="btn-container">
                <button className="btn" onClick={handleVoltar}>Voltar à Página Inicial</button>
            </div>
        </div>
    );
}