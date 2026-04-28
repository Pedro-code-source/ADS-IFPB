import React, { useState } from "react";

export default function Form(){

    const [nome, setNome] = useState("");
    const [assunto, setAssunto] = useState("");
    const [mensagem, setMensagem] = useState("");
    const [confirmacao, setConfirmacao] = useState(false);

    return (
        <div>

            <h2>Entre em contato</h2>
            <input id="nome" type="text" placeholder="Nome do Aluno" value={nome} onChange={e => {setNome(e.target.value)}}/>
            <input id="assunto" type="text" placeholder="Assunto" value={assunto} onChange={e => {setAssunto(e.target.value)}}/>
            <input id="mensagem" type="text" placeholder="Mensagem" value={mensagem} onChange={e => {setMensagem(e.target.value)}}/>

            <button id="button-enviar" onClick={e => {
                setConfirmacao(true)
            }}>Enviar</button>
            {confirmacao && (
                <div>

                    <h2> Mensagem Enviada ✅</h2>
                    <p>Nome: {nome}</p>
                    <p>Assunto: {assunto}</p>
                    <p>Mensagem: {mensagem}</p>
                </div>
            )}
        </div>
    )
}