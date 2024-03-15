import React from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';

import Brothers from './components/brothers/brothers';
import ConclusaoProcessoVotacao from "./components/confirmacao/conclusao";

export default function Rotas() {
    return(
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Brothers />}></Route>
                <Route path="/conclusao" element={<ConclusaoProcessoVotacao />}></Route>
            </Routes>
        </BrowserRouter>
    );
}