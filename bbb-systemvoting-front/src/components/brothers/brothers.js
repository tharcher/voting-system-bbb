import React, {useEffect, useState} from 'react';
import { useNavigate  } from 'react-router-dom';
import './brothers.css';
import participante1 from '../../images/participante3.png';
import participante2 from '../../images/participante2.jpg';
import api from "../../services/api";

export default function Brothers() {

    const [participantes, setParticipantes] = useState(null);
    const [participanteSelecionado, setParticipanteSelecionado] = useState(null);
    let navigate = useNavigate();

    async function carregarParticipante() {
        const response = await api.get('/brothers/search/all', {headers: { 'Accept': '*/*' }});
        console.log(response.data)
        setParticipantes(response.data);

    }

    async function handleVotar () {
        const participante = participantes.find(part => part.id === participanteSelecionado);
        console.log(participante);

        const data = {
            id: participante.id,
            name: participante.name
        };

        const config = {
            headers: {
                'Content-Type': 'application/json'
            }
        };

        const url = 'http://localhost:8080/api/voting';

        await api.post(url, data, config)
            .then(response => {
                navigate('conclusao');
            })
            .catch(error => {
                console.error('Erro ao fazer a solicitação POST:', error);
            });
    }



    function handleSelecionarParticipante (participante) {
        setParticipanteSelecionado(participante);
    }

    useEffect( () => {
        const fetchData = async () => {
            try {
                await carregarParticipante();
            } catch (error) {
                console.log(error);
            }
        };

        fetchData();
    }, []);

    return (
        <div >
            <h1 className="titulo">Quem você quer que fique no BBB 24?</h1>
            <h1 className="sub-titulo">Vote em quem você acha que deve permanecer na casa!</h1>
            {participantes && (
                <div className="cards-container">
                    <div className={`card ${participanteSelecionado === participantes[0].id ? 'selecionado' : ''}`}
                         onClick={() => handleSelecionarParticipante(participantes[0].id)}>
                        <img src={participante1} alt="Participante 1"/>
                        <h3>{participantes[0].name}</h3>
                    </div>
                    <div className={`card ${participanteSelecionado === participantes[1].id ? 'selecionado' : ''}`}
                         onClick={() => handleSelecionarParticipante(participantes[1].id)}>
                        <img src={participante2} alt="Participante 2"/>
                        <h3>{participantes[1].name}</h3>
                    </div>

                </div>
            )}

            {participantes && (
                <button className="votar-btn" onClick={handleVotar}>Votar</button>
            )}
        </div>
    );
}

